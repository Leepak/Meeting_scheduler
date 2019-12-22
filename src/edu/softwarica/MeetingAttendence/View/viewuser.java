package edu.softwarica.MeetingAttendence.View;

import edu.softwarica.MeetingAttendence.Controller.Controllernotification;
import edu.softwarica.MeetingAttendence.Model.Modelnotification;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class viewuser extends JFrame {

    Container contentPane;
    JScrollPane scroll;
    JPanel mainPanel;
    String eventId, userId;

    public void inviteFriend(String eventId, String userId) {
        this.eventId = eventId;
        this.userId = userId;
        setTitle("Meetings");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        scroll = new JScrollPane();
        contentPane = getContentPane();

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setBounds(10, 20, 50, 40);
        int j = 25;
        int i = 0;
        int c1 = 60;

        ArrayList<Modelnotification> ob = Controllernotification.showUser(eventId);
        for (Modelnotification e : ob) {
            JLabel label1 = new JLabel();
            JLabel label2 = new JLabel();
            label1.setText("Name:   " + e.getR_fname() + " " + e.getR_lname());
            label2.setText("Phone:   " + e.getR_phone());
            label1.setBounds(10, 20, 500, 50);
            label1.setForeground(Color.DARK_GRAY);
            label1.setFont(new Font("Calibri", Font.BOLD, 20));
            label2.setBounds(10, 30, 180, 100);
            label2.setFont(new Font("Calibri", Font.BOLD, 20));

            JPanel p[] = new JPanel[80];
            p[i] = new JPanel();
            p[i].setBounds(10, j, 400, 100);
            // p[i].setBorder(BorderFactory.createMatteBorder(
            // 3, 3, 3, 3, Color.DARK_GRAY));
            p[i].setBackground(Color.WHITE);
            p[i].add(label1);
            p[i].add(label2);
            p[i].setLayout(null);
            mainPanel.add(p[i]);
            j = j + 110;
            i = i + 1;
            c1 = c1 + 60;
        }

        mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), c1));
        mainPanel.setLayout(null);

        scroll.setViewportView(mainPanel);
        contentPane.add(scroll);

        setBounds(400, 90, 350, 350);
        setVisible(true);
    }
}
