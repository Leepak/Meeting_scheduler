package edu.softwarica.MeetingAttendence.Controller;

import edu.softwarica.MeetingAttendence.Model.Modelregister;
import java.sql.*;
import java.util.ArrayList;

public class Controllerlogins {
    
    private static Connection con = null;

    Controllerlogins() {
        if (con == null) {
            con = DBconnect.getConnection();
        }
    }

    public static ArrayList<Modelregister> login() {
        new Controllerlogins();
        ArrayList<Modelregister> list = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from user");
            while (rs.next()) {
                Modelregister e = new Modelregister();
                e.setUserid(rs.getString(1));
                e.setFname(rs.getString(2));
                e.setLname(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPass(rs.getString(5));
                e.setAddress(rs.getString(6));
                e.setGender(rs.getString(7));
                e.setPhone(rs.getString(8));
                e.setAvtime(rs.getString(9));
                e.setUnavtime(rs.getString(10));
                e.setImg1(rs.getBytes(11));
                list.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
