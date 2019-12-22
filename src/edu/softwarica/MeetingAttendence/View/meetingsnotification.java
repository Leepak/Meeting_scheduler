package edu.softwarica.MeetingAttendence.View;

import edu.softwarica.MeetingAttendence.Controller.Controllermeetings;
import edu.softwarica.MeetingAttendence.Controller.Controllernotification;
import edu.softwarica.MeetingAttendence.Model.Modelnotification;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class meetingsnotification extends JFrame implements ActionListener {

    Container container;
    JPanel panel;
    JScrollPane scrollPane;
    JLabel id[], id1[];
    JButton update[], delete[], invite[];
    String userid;

    public meetingsnotification(String userid) {
        setTitle("Meetings Notification");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        scrollPane = new JScrollPane();
        container = getContentPane();
        setLocation(400, 90);
        ;
        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(10, 20, 10, 40);
        id = new JLabel[30];
        id1 = new JLabel[30];
        update = new JButton[30];
        delete = new JButton[30];
        invite = new JButton[30];
        int j = 25;
        int i = 0;
        int q = 300;
        this.userid = userid;

        ArrayList<Modelnotification> ob = Controllernotification.getNotification(userid);
        for (Modelnotification e : ob) {
            JLabel lbleventsname = new JLabel();
            JLabel lbldate = new JLabel();
            JLabel lbltime = new JLabel();
            JLabel lbllocation = new JLabel();
            JLabel lblnoofatt = new JLabel();
            JLabel lblnoofinvited = new JLabel();
            JLabel lbldescription = new JLabel();
            JLabel lbleventscreated = new JLabel();
            JLabel lblphone = new JLabel();
            JLabel lbllike = new JLabel();

            if (Integer.parseInt(e.getStatus()) == 0) {
                invite[i] = new JButton("Approve");
                invite[i].setFont(new Font("Calibri", Font.BOLD, 12));
                invite[i].setBackground(Color.lightGray);
                invite[i].setForeground(Color.white);;
            } else {
                invite[i] = new JButton("Aproved");
                invite[i].setFont(new Font("Calibri", Font.BOLD, 12));
                invite[i].setBackground(Color.lightGray);
                invite[i].setForeground(Color.white);;

            }
            id[i] = new JLabel();
            id1[i] = new JLabel();
            id[i].setText(e.getE_id());
            id1[i].setText(e.getList_id());

            update[i] = new JButton("Show");
            update[i].setFont(new Font("Calibri", Font.BOLD, 12));
            update[i].setBackground(Color.lightGray);
            update[i].setForeground(Color.white);;

            delete[i] = new JButton("Delete");
            delete[i].setFont(new Font("Calibri", Font.BOLD, 12));
            delete[i].setBackground(Color.lightGray);
            delete[i].setForeground(Color.white);;

            int lcount = Controllernotification.count(e.getE_id());
            System.out.println("Lcount=" + lcount);
            lbleventsname.setText(e.getEname());
            lbldate.setText("Date:  " + e.getEdate());
            lbltime.setText("Time:  " + e.getEtime());
            lbllocation.setText("Location:  " + e.getElocation());
            lblnoofatt.setText("Min No. of attendies:  " + e.getEminatt());
            lblnoofinvited.setText("No. of invited attendies:  " + e.getEinvitatten());
            lbldescription.setText("Description:  " + e.getEdesc());
            lbleventscreated.setText("Event Created by:  " + e.getS_fname() + " " + e.getS_lname());
            lblphone.setText("Phone:  " + e.getS_phone());
            lbllike.setText("Aprroved:  " + lcount);

            lbleventsname.setBounds(20, 10, 300, 50);
            lbleventsname.setForeground(Color.DARK_GRAY);
            lbleventsname.setFont(new Font("calibri", Font.BOLD, 15));
            lbldate.setBounds(20, 50, 300, 50);
            lbldate.setFont(new Font("calibri", Font.BOLD, 12));
            lbltime.setBounds(20, 70, 300, 50);
            lbltime.setFont(new Font("calibri", Font.BOLD, 12));
            lbllocation.setBounds(20, 90, 300, 50);
            lbllocation.setFont(new Font("calibri", Font.BOLD, 12));
            lblnoofatt.setBounds(20, 110, 300, 50);
            lblnoofatt.setFont(new Font("calibri", Font.BOLD, 12));
            lblnoofinvited.setBounds(20, 130, 300, 50);
            lblnoofinvited.setFont(new Font("calibri", Font.BOLD, 12));
            lbleventscreated.setBounds(20, 150, 300, 50);
            lbleventscreated.setFont(new Font("calibri", Font.BOLD, 12));
            lblphone.setBounds(20, 170, 300, 50);
            lblphone.setFont(new Font("calibri", Font.BOLD, 12));
            lbllike.setBounds(20, 190, 300, 50);
            lbllike.setFont(new Font("calibri", Font.BOLD, 12));
            lbldescription.setBounds(20, 210, 300, 50);
            lbldescription.setFont(new Font("calibri", Font.BOLD, 12));
            invite[i].setBounds(20, 280, 80, 35);
            invite[i].setFont(new Font("calibri", Font.BOLD, 11));
            update[i].setBounds(120, 280, 80, 35);
            update[i].setFont(new Font("calibri", Font.BOLD, 11));
            delete[i].setBounds(220, 280, 80, 35);
            delete[i].setFont(new Font("calibri", Font.BOLD, 11));
            JPanel p[] = new JPanel[80];
            p[i] = new JPanel();
            p[i].setBounds(10, j, 550, 310);

            p[i].setBackground(Color.white);

            p[i].add(lbleventsname);
            p[i].add(lbldate);
            p[i].add(lbltime);
            p[i].add(lbllocation);
            p[i].add(lblnoofatt);
            p[i].add(lblnoofinvited);
            p[i].add(lbldescription);
            p[i].add(lbleventscreated);
            p[i].add(lblphone);
            p[i].add(lbllike);
            p[i].add(invite[i]);
            p[i].add(update[i]);
            p[i].add(delete[i]);

            p[i].setLayout(null);
            invite[i].addActionListener(this);
            update[i].addActionListener(this);
            delete[i].addActionListener(this);

            panel.add(p[i]);

            j = j + 320;
            i = i + 1;
            q = q + 300;

        }
        panel.setPreferredSize(new Dimension(panel.getWidth(), q));
        panel.setLayout(null);

        scrollPane.setViewportView(panel);
        container.add(scrollPane);

        setSize(600, 600);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < invite.length; i++) {
            if (e.getSource() == invite[i]) {
                System.out.print("vote=" + invite[i].getText());
                System.out.println("vote=" + id[i].getText());
                System.out.println("vote" + id1[i].getText());
                System.out.println("vote=" + userid);
                System.out.println(id1[i].getText());
                if (invite[i].getText().equals("Like")) {
                    invite[i] = new JButton("Like");
                    invite[i].setBackground(Color.LIGHT_GRAY);
                    invite[i].setForeground(Color.white);
                    Controllernotification.notificationStatusUpdate(id1[i].getText(), id[i].getText(), userid);
                    new meetingsnotification(userid);
                    setVisible(false);
                }
            }
        }
        for (int i = 0; i < update.length; i++) {
            if (e.getSource() == update[i]) {
                System.out.print(invite[i].getText());
                System.out.println(id[i].getText());
                viewuser ob = new viewuser();
                ob.inviteFriend(id[i].getText(), userid);
            }
        }
        for (int i = 0; i < delete.length; i++) {
            if (e.getSource() == delete[i]) {
                Controllermeetings.deleteEvent(Integer.parseInt(id[i].getText()));
                setVisible(false);
                new viewmeetings(userid);
            }
        }
    }
}
