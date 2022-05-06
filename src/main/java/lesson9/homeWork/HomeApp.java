package lesson9.homeWork;

import lesson9.homeWork.handlers.AnnotationHandler;
import lesson9.homeWork.handlers.RepostoryHandler;
import lesson9.homeWork.tables.Student;
import lesson9.homeWork.tables.Teacher;
import lesson9.homeWork.utils.FindAllClassesForList;

import java.sql.*;
import java.util.List;

public class HomeApp {
    private static final String PACKAGE = "lesson9.homeWork.tables";


    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) throws SQLException {
        connect();
        List<Class<?>> classList = FindAllClassesForList.find(PACKAGE);
        // создали в ДБ пустые таблицы согласно анотациям
        AnnotationHandler.useAnnotation(statement,classList);
        // сохраняем обьекты в уже созданные таблицы для этих обьектов
        Student student = new Student(33,"E",22);
        Teacher teacher = new Teacher(1,"A","Math",44);
        RepostoryHandler.save(statement,student);
        disconnect();
    }


    public static void connect() throws SQLException {
        // Это инициализирует драйвер(загружается в память и иници статик конструктор)
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/lesson9/home.db");  // через запятую порт и пароль
            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }

    private static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
