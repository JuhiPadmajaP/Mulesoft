package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class inserttable {

    private Connection connect() {
        String url = "jdbc:sqlite:C://sqlite/db/newdb.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void insert(String moviename, String leadactor,String actress,int yearofrelease,String directorname) {
        String sql = "INSERT INTO Movies(moviename,leadactor,actress,yearofrelease,directorname) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, moviename);
            pstmt.setString(2, leadactor);
            pstmt.setString(3, actress);
            pstmt.setInt(4,yearofrelease);
            pstmt.setString(5,directorname);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        inserttable app = new inserttable();
        app.insert("Mahaan","Vikram","Simran",2022,"Karthick Subbaraj");
        app.insert("Kalank","Varun Dhawan","Alia Bhatt",2019 ,"Abhishek Varman");
         app.insert("Jeans","Prashanth","Aishwarya Rai",1998 ,"Shankar");
         app.insert("Thalaivii","Arvind Swamy","Kangana Ranaut",2021 ,"AL Vijay");
         app.insert("Kushi","Vijay","Jyothika",2001,"SJ Surya");
    }

}