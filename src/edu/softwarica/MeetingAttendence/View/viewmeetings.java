package edu.softwarica.MeetingAttendence.View;

import edu.softwarica.MeetingAttendence.Controller.Controllermeetings;
import edu.softwarica.MeetingAttendence.Model.Modelmeetings;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class viewmeetings extends JFrame implements ActionListener {

    JLabel id[];
    JButton[] btnUpdate, btnDelete, btnInvite, btnShow;
    JScrollPane scroll;
    JPanel mainPanel;
    String userid;
    Font font, font1, font2;

    public viewmeetings(String userid) {
        setTitle("Meetings");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        scroll = new JScrollPane();
        Container contentPane = getContentPane();
        setLocation(400, 90);
        setTitle("Meetings Show");
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setBounds(10, 20, 50, 40);
        id = new JLabel[30];
        btnUpdate = new JButton[30];
        btnDelete = new JButton[30];
        btnInvite = new JButton[30];
        btnShow = new JButton[30];
        int j = 25;
        int i = 0;
        this.userid = userid;
        ArrayList<Modelmeetings> ob = Controllermeetings.getEvent(userid);
        for (Modelmeetings e : ob) {
            JLabel label1 = new JLabel();
            JLabel label2 = new JLabel();
            JLabel label3 = new JLabel();
            JLabel label4 = new JLabel();
            JLabel label5 = new JLabel();
            JLabel label6 = new JLabel();
            JLabel label7 = new JLabel();
            JLabel label8 = new JLabel();
            btnInvite[i] = new JButton("Invite");
            id[i] = new JLabel();
            id[i].setText(e.getE_id());
            btnUpdate[i] = new JButton("Update");
            btnDelete[i] = new JButton("Delete");
            btnShow[i] = new JButton("Show");
            int count = Controllermeetings.getEventCountForShowEvent(e.getE_id());
            label1.setText(e.getEname());
            label2.setText("Date:" + e.getEdate());
            label3.setText("Time:" + e.getEtime());
            label4.setText("Location:" + e.getElocation());
            label5.setText("Min No. of attendies:" + e.getEminatt());
            label6.setText("No. of invited attendies:" + e.getEinvitatten());
            label7.setText("Description:" + e.getEdesc());
            label8.setText("Like:" + Integer.toString(count));
            label1.setBounds(210, 10, 300, 50);
            label1.setForeground(Color.BLACK);
            label1.setFont(new Font("Times New Roman", Font.ITALIC, 17));
            label2.setBounds(30, 20, 300, 50);
            label2.setFont(new Font("Times New Roman", Font.ITALIC, 17));
            label3.setBounds(30, 40, 300, 50);
            label3.setFont(new Font("Times New Roman", Font.ITALIC, 17));
            label4.setBounds(30, 60, 300, 50);
            label4.setFont(new Font("Times New Roman", Font.ITALIC, 17));
            label5.setBounds(30, 80, 300, 50);
            label5.setFont(new Font("Times New Roman", Font.ITALIC, 17));
            label6.setBounds(30, 100, 300, 50);
            label6.setFont(new Font("Times New Roman", Font.ITALIC, 17));
            label8.setBounds(30, 120, 300, 50);
            label8.setFont(new Font("Times New Roman", Font.ITALIC, 17));
            label7.setBounds(30, 140, 300, 50);
            label7.setFont(new Font("Times New Roman", Font.ITALIC, 17));
            btnInvite[i].setBounds(230, 220, 80, 25);
            btnUpdate[i].setBounds(10, 220, 100, 25);
            btnDelete[i].setBounds(120, 220, 80, 25);

            btnDelete[i].setFont(new Font("Times New Roman", Font.ITALIC, 17));
            btnShow[i].setBounds(340, 220, 80, 25);

            btnUpdate[i].setFont(new Font("Times New Roman", Font.ITALIC, 17));

            btnUpdate[i].setBackground(Color.white);

            btnDelete[i].setBackground(Color.white);

            btnInvite[i].setBackground(Color.white);
            btnInvite[i].setFont(new Font("Times New Roman", Font.ITALIC, 17));

            btnShow[i].setBackground(Color.white);
            btnShow[i].setFont(new Font("Times New Roman", Font.ITALIC, 17));

            JPanel p[] = new JPanel[80];
            p[i] = new JPanel();
            p[i].setBounds(10, j, 550, 270);
            p[i].setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
            p[i].setBackground(Color.WHITE);

            p[i].add(label1);
            p[i].add(label2);
            p[i].add(label3);
            p[i].add(label4);
            p[i].add(label5);
            p[i].add(label6);
            p[i].add(label7);
            p[i].add(label8);
            p[i].add(btnInvite[i]);
            p[i].add(btnUpdate[i]);
            p[i].add(btnDelete[i]);
            p[i].add(btnShow[i]);
            p[i].setLayout(null);
            btnInvite[i].addActionListener(this);
            btnUpdate[i].addActionListener(this);
            btnDelete[i].addActionListener(this);
            btnShow[i].addActionListener(this);
            mainPanel.add(p[i]);
            j = j + 280;
            i = i + 1;
        }
        mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), 15000));
        mainPanel.setLayout(null);

        scroll.setViewportView(mainPanel);
        contentPane.add(scroll);
        setSize(600, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < btnInvite.length; i++) {
            if (e.getSource() == btnInvite[i]) {
                invitations ob = new invitations();
                ob.inviteFriend(id[i].getText(), userid);
            }
        }
        for (int i = 0; i < btnUpdate.length; i++) {
            if (e.getSource() == btnUpdate[i]) {
                new updatemeetings(id[i].getText());
                setVisible(false);
            }
        }
        for (int i = 0; i < btnDelete.length; i++) {
            if (e.getSource() == btnDelete[i]) {
                Controllermeetings.deleteEvent(Integer.parseInt(id[i].getText()));
                setVisible(false);
                new viewmeetings(userid);
            }
        }
        for (int i = 0; i < btnShow.length; i++) {
            if (e.getSource() == btnShow[i]) {
                viewuser ob = new viewuser();
                ob.inviteFriend(id[i].getText(), userid);
            }
        }
    }
}
