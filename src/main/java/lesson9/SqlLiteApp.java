package lesson9;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.*;

public class SqlLiteApp {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;


    public static void main(String[] args) {
        try {
            connect();
//            preparedStatement.setString(1, "PSa");
//            preparedStatement.setInt(2, 33);
//            preparedStatement.executeUpdate();
            long time = System.currentTimeMillis();
            bathExample();
            System.out.println(System.currentTimeMillis() - time);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void bathExample() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 0; i < 1000; i++) {

            preparedStatement.setObject(1, "Obj" + i);
            preparedStatement.setObject(2, 1 + i);
            System.out.println("i - " + i);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.commit();
    }


    private static void selectExample() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM wow");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getInt("score"));
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public static void connect() throws SQLException {
        // Это инициализирует драйвер(загружается в память и иници статик конструктор)
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/lesson9/wtf.db");  // через запятую порт и пароль
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("INSERT INTO wow (name,score) VALUES (?,?);");

        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }

    public static void disconnect() {
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }






}




