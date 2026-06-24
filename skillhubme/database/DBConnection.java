package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {

        try {

            if (con == null || con.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/skillhub",
                        "root",
                        "Rediet1999." // your password
                );
            }

        } catch (Exception e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        return con;
    }
}
