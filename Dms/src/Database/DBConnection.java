package Database;

import java.sql.*;

public class DBConnection {

    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attorney_dms", "root", "noahjon21");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}