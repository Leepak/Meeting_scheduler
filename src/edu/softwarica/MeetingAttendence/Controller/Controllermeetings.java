package edu.softwarica.MeetingAttendence.Controller;

import edu.softwarica.MeetingAttendence.Model.Modelmeetings;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Controllermeetings {

    private static Connection con = null;

    Controllermeetings() {
        if (con == null) {
            con = DBconnect.getConnection();
        }
    }

    public static boolean registerEvent(Modelmeetings ob, String uid) {
        new Controllermeetings();
        int id = Integer.parseInt(uid);
        try {
            PreparedStatement ps = con.prepareStatement("insert into crevent values(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2, ob.getEname());
            ps.setString(3, ob.getEdate());
            ps.setString(4, ob.getEtime());
            ps.setString(5, ob.getElocation());
            ps.setString(6, ob.getEdesc());
            ps.setString(7, ob.getEminatt());
            ps.setString(8, ob.getEinvitatten());
            ps.setString(9, ob.getEthresmin());
            ps.setInt(10, id);
            int i = ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Modelmeetings> getEvent(String userid) {
        new Controllermeetings();
        ArrayList<Modelmeetings> list;
        int id = Integer.parseInt(userid);
        list = new ArrayList<Modelmeetings>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from crevent where u_id=" + id + "");
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

    public static boolean deleteEvent(int id) {
        new Controllermeetings();
        try {
            PreparedStatement ps = con.prepareStatement("delete from crevent where e_id=?");
            ps.setInt(1, +id);
            int i = ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateEvent(Modelmeetings ob, String id1) {
        new Controllermeetings();
        int id = Integer.parseInt(id1);
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE crevent SET ename ='" + ob.getEname() + "', edate='" + ob.getEdate() + "' ,etime='" + ob.getEtime() + "', elocation ='" + ob.getElocation() + "', edesc='" + ob.getEdesc() + "' ,eminatt=" + ob.getEinvitatten() + " ,einvitatten='" + ob.getEinvitatten() + "', ethresmin='" + ob.getEthresmin() + "' where e_id=" + id + " ");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Modelmeetings> getEventUpdate(String userid) {
        new Controllermeetings();
        ArrayList<Modelmeetings> list;
        int id = Integer.parseInt(userid);
        list = new ArrayList<Modelmeetings>();
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

    public static int getEventCountForShowEvent(String eventid) {
        new Controllermeetings();
        int id = Integer.parseInt(eventid);
        int count = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from eventlist where e_id=" + id + " and stat=1");
            while (rs.next()) {
                count = count + 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

}
