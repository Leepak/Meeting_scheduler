package edu.softwarica.MeetingAttendence.Controller;

import edu.softwarica.MeetingAttendence.Model.Modelregister;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
public class Controllerregister {
    private static Connection con = null;
    Controllerregister() {
        if (con == null) {
            con = DBconnect.getConnection();
        }
    }
    public static boolean reisterUser(Modelregister ob) {
        new Controllerregister();
        try {
            PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2, ob.getFname());
            ps.setString(3, ob.getLname());
            ps.setString(4, ob.getEmail());
            ps.setString(5, ob.getPass());
            ps.setString(6, ob.getAddress());
            ps.setString(7, ob.getGender());
            ps.setString(8, ob.getPhone());
            ps.setString(9, ob.getAvtime());
            ps.setString(10, ob.getUnavtime());
            ps.setInt(12, 0);

            FileInputStream fin = new FileInputStream(ob.getImg());
            ps.setBinaryStream(11, fin, fin.available());
            int i = ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Modelregister> getUser() {
        new Controllerregister();
        ArrayList<Modelregister> list = new ArrayList<Modelregister>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                Modelregister e = new Modelregister();
                e.setUserid(rs.getString(1));
                e.setFname(rs.getString(2));
                e.setLname(rs.getString(3));
                e.setImg1(rs.getBytes(11));
                e.setAvtime(rs.getString(9));
                e.setUnavtime(rs.getString(10));
                e.setStatus(rs.getInt(12));
                list.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    public static void userStatusUpdate(int i, String id) {
        new Controllerregister();
        int id1 = Integer.parseInt(id);
        try {
            PreparedStatement ps = con.prepareStatement(
                    "update user set stat=? where u_id=?");
            ps.setInt(1, i);
            ps.setInt(2, id1);
            int i1 = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
