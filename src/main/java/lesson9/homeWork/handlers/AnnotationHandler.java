package lesson9.homeWork.handlers;

import lesson9.homeWork.anotations.Column;
import lesson9.homeWork.anotations.Id;
import lesson9.homeWork.anotations.Table;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnnotationHandler {

    public static void useAnnotation(Statement statement, List<Class<?>> classList) {
        for (Class classForAnnotation : classList) {
            makeAnnotation(statement, classForAnnotation);
        }
    }

    private static void makeAnnotation(Statement statement, Class classForAnnotation) {
        System.out.println("makeAnnotation");
        Table annotationTable = (Table) classForAnnotation.getAnnotation(Table.class);
        if (annotationTable != null) {
            String tableName = annotationTable.name();
            if (tableName.isEmpty()) {
                tableName = classForAnnotation.getName();
            }
            String primaryKey = null;
            Field[] fields = classForAnnotation.getDeclaredFields();
            Map<String, String> columns = new LinkedHashMap<>();
            for (Field field : fields) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                String columnName;
                if (columnAnnotation != null) {
                    columnName = columnAnnotation.name();
                    if (columnName.isEmpty()) {
                        columnName = field.getName().toLowerCase();
                    }
                    Class<?> type = field.getType();
                    String columnType;
                    switch (type.getSimpleName()) {
                        case "long":
                            columnType = "BIGINT";
                            break;
                        case "int":
                            columnType = "int4";
                            break;
                        case "String":
                            columnType = "text";
                            break;
                        default:
                            throw new RuntimeException("Unknown field type");
                    }
                    columns.put(columnName, columnType);

                    Id idAnnotation = field.getAnnotation(Id.class);
                    if (idAnnotation != null) {
                        // условно допустим, что PK может быть только один
                        if (primaryKey == null) {
                            primaryKey = columnName;
                        } else {
                            throw new RuntimeException("More than one primary key");
                        }
                    }
                }
            }
            createTable(statement, tableName, columns, primaryKey);
        }
    }

    private static void createTable(
            Statement statement, String tableName, Map<String, String> columns,
            String primaryKey) {
        // начинаю писать SQL запрос
        StringBuilder queryToBD = new StringBuilder("CREATE TABLE IF NOT EXISTS " + tableName + " (");
        int sizeMap = columns.size();
        int countStroke = 0;
        for (Map.Entry<String, String> entry : columns.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            queryToBD.append(key).append(" ").append(value);
            if (key.equals(primaryKey)) {
                queryToBD.append(" PRIMARY KEY");
            }

            countStroke++;
            if (countStroke < sizeMap) {
                queryToBD.append(" ,");
            }
        }
//        Iterator<Map.Entry<String, String>> columnIterator = columns.entrySet().iterator();
//        while (columnIterator.hasNext()) {
//            // пробегаем по columns
//            // и вставляем всё в текстовый запрос
//            Map.Entry<String, String> column = columnIterator.next();
//
//        }
//      добавляем закрытие SQL запроса
        queryToBD.append(");");
        System.out.println(queryToBD);
        writeInSQLDB(statement, queryToBD);
    }


    private static void writeInSQLDB(Statement statement, StringBuilder query) {
        try {
            statement.executeUpdate(String.valueOf(query));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
