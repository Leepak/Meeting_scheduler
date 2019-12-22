package edu.softwarica.MeetingAttendence.Controller;

import edu.softwarica.MeetingAttendence.Model.Modelnotification;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Controllernotification {

    private static Connection con = null;

    Controllernotification() {
        if (con == null) {
            con = DBconnect.getConnection();
        }
    }

    public static ArrayList<Modelnotification> getNotification(String sid) {
        new Controllernotification();
        int id = Integer.parseInt(sid);
        ArrayList<Modelnotification> list = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from eventlist where r_id=" + id + "");
            while (rs.next()) {
                Modelnotification e = new Modelnotification();
                e.setList_id(rs.getString(1));
                e.setS_fname(rs.getString(3));
                e.setS_lname(rs.getString(4));
                e.setS_phone(rs.getString(6));
                ///////For event
                e.setE_id(rs.getString(12));
                e.setEname(rs.getString(13));
                e.setEdate(rs.getString(14));
                e.setEtime(rs.getString(15));
                e.setElocation(rs.getString(16));
                e.setEdesc(rs.getString(17));
                e.setEminatt(rs.getString(18));
                e.setEinvitatten(rs.getString(19));
                e.setEthresmin(rs.getString(20));
                e.setStatus(rs.getString(21));
                list.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;

    }

    public static void notificationStatusUpdate(String sid, String eid, String uid) {
        new Controllernotification();
        int id1 = Integer.parseInt(sid);
        int id2 = Integer.parseInt(eid);
        int id3 = Integer.parseInt(uid);
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE eventlist SET stat=1 where  list_id=" + id1 + " and e_id=" + id2 + " and r_id=" + id3 + " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int count(String eid) {
        new Controllernotification();
        int id1 = Integer.parseInt(eid);
        int a = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(stat) from eventlist where stat=1 and e_id=" + id1 + " ");
            while (rs.next()) {
                a = Integer.parseInt(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public static ArrayList<Modelnotification> showUser(String eid) {
        new Controllernotification();
        int id1 = Integer.parseInt(eid);
        ArrayList<Modelnotification> list = new ArrayList<Modelnotification>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select r_fname,r_lname,r_phone from eventlist where e_id=" + id1 + " and stat=1");
            while (rs.next()) {
                Modelnotification e = new Modelnotification();
                e.setR_fname(rs.getString(1));
                e.setR_lname(rs.getString(2));
                e.setR_phone(rs.getString(3));
                list.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
