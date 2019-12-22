package edu.softwarica.MeetingAttendence.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBconnect {

    private static Connection con = null;

    public static Connection getConnection() {
        if (con == null) {
            connectDB();
        }
        return con;
    }

    private static void connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adi_meetings", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex, "Error", 1);
        }
    }
}
