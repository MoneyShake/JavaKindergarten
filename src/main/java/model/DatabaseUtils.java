package model;

import java.sql.*;

public class DatabaseUtils {

    private static DatabaseUtils instance;

    private static final String URL = "jdbc:postgresql://localhost/kindergarten";
    private static final String USER = "postgres";
    private static final String PASSWORD = "qwerty123";

    private DatabaseUtils () {
    }

    public static DatabaseUtils getInstance(){
        if (instance == null){
            instance = new DatabaseUtils();
        }
        return instance;
    }

    public ResultSet query(String sql) {
        loadPostgresql();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = connection.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(String sql) {
        loadPostgresql();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadPostgresql() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
