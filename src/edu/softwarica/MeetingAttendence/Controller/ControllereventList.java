package edu.softwarica.MeetingAttendence.Controller;

import edu.softwarica.MeetingAttendence.Model.Modelmeetings;
import edu.softwarica.MeetingAttendence.Model.Modelregister;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControllereventList {

    private static Connection con = null;

    ControllereventList() {
        if (con == null) {
            con = DBconnect.getConnection();
        }
    }

    public static ArrayList<Modelregister> getUserSender(String sid) {
        new ControllereventList();
        int id = Integer.parseInt(sid);
        ArrayList<Modelregister> list = new ArrayList<Modelregister>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from user where u_id=" + id + "");
            while (rs.next()) {
                Modelregister e = new Modelregister();
                e.setUserid(rs.getString(1));
                e.setFname(rs.getString(2));
                e.setLname(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPhone(rs.getString(8));
                list.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static ArrayList<Modelregister> getUserReceiever(String rid) {
        new ControllereventList();
        int id = Integer.parseInt(rid);
        ArrayList<Modelregister> list = new ArrayList<Modelregister>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from user where u_id=" + id + "");
            while (rs.next()) {
                Modelregister e = new Modelregister();
                e.setUserid(rs.getString(1));
                e.setFname(rs.getString(2));
                e.setLname(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setPhone(rs.getString(8));
                list.add(e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static ArrayList<Modelmeetings> getUserEvent(String eid) {
        new ControllereventList();
        int id = Integer.parseInt(eid);
        System.out.println("Hello");
        ArrayList<Modelmeetings> list = new ArrayList<Modelmeetings>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from crevent where e_id=" + id + "");
            while (rs.next()) {
                Modelmeetings e = new Modelmeetings();
                e.setE_id(rs.getString(1));
                e.setEname(rs.getString(2));
                e.setEdate(rs.getString(3));
                e.setEtime(rs.getString(4));
                e.setElocation(rs.getString(5));
                e.setEdesc(rs.getString(6));
                e.setEminatt(rs.getString(7));
                e.setEinvitatten(rs.getString(8));
                e.setEthresmin(rs.getString(9));
                list.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static boolean createEventList(ArrayList<Modelregister> list1, ArrayList<Modelregister> list2, ArrayList<Modelmeetings> list3) {
        new ControllereventList();
        try {
            PreparedStatement ps = con.prepareStatement("insert into eventlist values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, 0);
            for (Modelregister e : list1) {
                ps.setString(2, e.getUserid());
                ps.setString(3, e.getFname());
                ps.setString(4, e.getLname());
                ps.setString(5, e.getEmail());
                ps.setString(6, e.getPhone());
            }
            for (Modelregister e : list2) {
                ps.setString(7, e.getUserid());
                ps.setString(8, e.getFname());
                ps.setString(9, e.getLname());
                ps.setString(10, e.getEmail());
                ps.setString(11, e.getPhone());
            }
            for (Modelmeetings e : list3) {
                ps.setInt(12, Integer.parseInt(e.getE_id()));
                ps.setString(13, e.getEname());
                ps.setString(14, e.getEdate());
                ps.setString(15, e.getEtime());
                ps.setString(16, e.getElocation());
                ps.setString(17, e.getEdesc());
                ps.setString(18, e.getEminatt());
                ps.setString(19, e.getEinvitatten());
                ps.setString(20, e.getEthresmin());
                ps.setInt(21, 0);
            }

            int i = ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Modelregister> getInvitedListId(String rid) {
        new ControllereventList();
        int id = Integer.parseInt(rid);
        ArrayList<Modelregister> list = new ArrayList<Modelregister>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT c.u_id FROM user AS c INNER JOIN eventlist AS p ON c.u_id = p.r_id where e_id=" + id + "");
            while (rs.next()) {
                Modelregister e = new Modelregister();
                e.setUserid(rs.getString(1));
                list.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }
}
