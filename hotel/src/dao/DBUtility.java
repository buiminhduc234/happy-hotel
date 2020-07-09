package dao;

import java.io.File;
import java.sql.*;

public class DBUtility {
    private static String DB_PATH = new File("").getAbsolutePath().concat("\\db\\demo.db");
    public static Connection connect() {
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+DB_PATH);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createNewDatabase() {
        try (Connection conn = connect()) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable() {
        String sql = "CREATE TABLE IF NOT EXISTS folio (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
