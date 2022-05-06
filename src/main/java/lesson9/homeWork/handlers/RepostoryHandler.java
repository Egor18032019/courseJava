package lesson9.homeWork.handlers;

import lesson9.homeWork.anotations.Column;
import lesson9.homeWork.anotations.Table;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RepostoryHandler {
    /**
     * добавляеть объект размеченного класса в полученную таблицу
     *
     * @param statement подключение в БД
     * @param object     то что добавляем в БД
     */
    public static void save(Statement statement, Object object) {
        Class classForAnnotation = object.getClass();
        Table annotationTable = (Table) classForAnnotation.getAnnotation(Table.class);
        String tableName = "";
        if (annotationTable != null) {
            tableName = annotationTable.name();
        } else {
            tableName = classForAnnotation.getName();
            System.out.println(" или ошибку тут выбрасывать?");
            //TODO обудмать!
        }
        System.out.println("tableName " + tableName);

        Field[] fields = classForAnnotation.getDeclaredFields();
        StringBuilder listColumnForDB = new StringBuilder("(");
        StringBuilder listPointForDB = new StringBuilder("(");
        StringBuilder valueForDB = new StringBuilder("");

        int sizeMap = fields.length;
        int countStroke = 0;
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                // пробегаем по полям обьекта и даем каждому полю доступ
                field.setAccessible(true);
            }
// вытаскиваем названия
            Column columnAnnotation = field.getAnnotation(Column.class);
            if (columnAnnotation != null) {
                if (!columnAnnotation.name().isEmpty()) {
                    listColumnForDB.append(columnAnnotation.name().toLowerCase());
                } else {
                    listColumnForDB.append(field.getName().toLowerCase());
                }
                listPointForDB.append("?");
            }

            // вытаскиваем значения
            Object valueField = null;
            try {
                valueField = field.get(object);
                // Вытаскиваем из поля обьекта значение( так как незнаем что там то Object)
            } catch (IllegalAccessException e) {
                System.out.println("Написать обработку ошибку !");
                e.printStackTrace();
            }
            if (valueField instanceof String) {
                valueForDB.append("'").append(valueField).append("'");
            } else {
                valueForDB.append(valueField);
            }
            countStroke++;
            if (countStroke < sizeMap) {
                valueForDB.append(",");
                listColumnForDB.append(",");
            }
        }
        listColumnForDB.append(")");
        valueForDB.append(")");
        // собираем SQL запрос
        StringBuilder queryToBD = new StringBuilder(
                "INSERT INTO " +
                        tableName +
                        " " +
                        listColumnForDB +
                        " VALUES (" +
                        valueForDB +
                        ";");

        System.out.println(queryToBD);

        writeInSQLDB(queryToBD,statement);
    }

    private static void writeInSQLDB(StringBuilder queryToBD,Statement statement) {

        try   {
            statement.execute(queryToBD.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
