package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static Connection con = null;
    private static DataBase instance = new DataBase();

    private DataBase() {
        connect();  // Initialize connection when the instance is created
    }

    public static Connection getConnection() {
        return con;
    }

    public static DataBase getInstance() {
        return instance;
    }

    private void connect() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLStore";  // Corrected parameter name
        String user = "sa";
        String password = "123";

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
