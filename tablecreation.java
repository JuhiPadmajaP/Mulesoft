package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class tablecreation {

  
    public static void createNewTable() {
        String url = "jdbc:sqlite:C://sqlite/db/newdb.db";
        String sql = "CREATE TABLE IF NOT EXISTS Movies (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	moviename text NOT NULL,\n"
                + "	leadactor text,\n"
                + "     actress text,\n"
                + "     yearofrelease INTEGER, \n"
                + "     directorname text\n"   
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
           
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        createNewTable();
    }

}
