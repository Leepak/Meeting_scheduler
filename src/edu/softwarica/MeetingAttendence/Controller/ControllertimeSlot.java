package edu.softwarica.MeetingAttendence.Controller;

import edu.softwarica.MeetingAttendence.Model.Modeltimeslot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControllertimeSlot {

    private static Connection con = null;

    ControllertimeSlot() {
        if (con == null) {
            con = DBconnect.getConnection();
        }
    }

    public static boolean createSlot(Modeltimeslot ob) {
        new ControllertimeSlot();
        try {
            PreparedStatement ps = con.prepareStatement("insert into slots values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2, ob.getEname());
            ps.setString(3, ob.getSlot1());
            ps.setString(4, ob.getSlot2());
            ps.setString(5, ob.getSlot3());
            ps.setString(6, ob.getSlot4());
            ps.setString(7, ob.getSlot5());
            ps.setInt(8, 0);
            ps.setInt(9, 0);
            ps.setInt(10, 0);
            ps.setInt(11, 0);
            ps.setInt(12, 0);
            ps.setInt(13, ob.getUserid());
            int i = ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Modeltimeslot> getSlots() {
        new ControllertimeSlot();
        ArrayList<Modeltimeslot> list = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from slots");
            while (rs.next()) {
                Modeltimeslot e = new Modeltimeslot();
                e.setId(rs.getString(1));
                e.setEname(rs.getString(2));
                e.setSlot1(rs.getString(3));
                e.setSlot2(rs.getString(4));
                e.setSlot3(rs.getString(5));
                e.setSlot4(rs.getString(6));
                e.setSlot5(rs.getString(7));
                e.setStatus1(rs.getInt(8));
                e.setStatus2(rs.getInt(9));
                e.setStatus3(rs.getInt(10));
                e.setStatus4(rs.getInt(11));
                e.setStatus5(rs.getInt(12));
                e.setUserid(rs.getInt(13));
                list.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static void updateSlot(String code) {
        new ControllertimeSlot();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(code);
            System.out.println("Succesffully updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
