package edu.softwarica.MeetingAttendence.View;

import edu.softwarica.MeetingAttendence.Controller.ControllereventList;
import edu.softwarica.MeetingAttendence.Controller.Controllerregister;
import edu.softwarica.MeetingAttendence.Model.Modelmeetings;
import edu.softwarica.MeetingAttendence.Model.Modelregister;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class invitations implements ActionListener {

    JLabel id[];
    JButton invite[];
    JFrame frame;
    String e_id, u_id;

    public void inviteFriend(String e_id, String u_id) {
        this.e_id = e_id;
        this.u_id = u_id;
        frame = new JFrame("Invite Meetings");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JScrollPane scroll = new JScrollPane();
        Container contentPane = frame.getContentPane();

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setBounds(10, 20, 50, 40);
        id = new JLabel[30];
        invite = new JButton[30];
        int j = 25;
        int i = 0;
        int count = 0;
        ArrayList<Modelregister> ob = Controllerregister.getUser();
        for (Modelregister e : ob) {

            JLabel label1 = new JLabel();
            JLabel label3 = new JLabel();
            JLabel label4 = new JLabel();
            JLabel label2 = new JLabel();
            label2.setBounds(10, 10, 180, 100);

            invite[i] = new JButton("Invite");
            invite[i].setFont(new Font("Calibri", Font.BOLD, 12));
            invite[i].setBounds(360, 135, 60, 25);
            invite[i].setBackground(Color.LIGHT_GRAY);
            invite[i].setForeground(Color.WHITE);
            id[i] = new JLabel();
            id[i].setText(e.getUserid());

            /////Setting value avtime,unavtime
            label1.setText(e.getFname() + " " + e.getLname());
            label3.setText("Available Time:       " + e.getAvtime());
            label4.setText("UnAvailable Time:     " + e.getUnavtime());

            ImageIcon image = new ImageIcon(e.getImg1());
            Image im = image.getImage();
            Image myImg = im.getScaledInstance(label2.getWidth(), label2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImage = new ImageIcon(myImg);
            label2.setIcon(newImage);

            label1.setBounds(20, 110, 300, 30);
            label3.setBounds(20, 150, 400, 30);
            label4.setBounds(20, 190, 400, 30);

            label1.setForeground(Color.BLACK);
            label1.setFont(new Font("Calibri", Font.BOLD, 20));
            label3.setFont(new Font("Calibri", Font.BOLD, 15));
            label4.setFont(new Font("Calibri", Font.BOLD, 15));

            invite[i].setBounds(40, 230, 100, 40);

            JPanel p[] = new JPanel[80];
            p[i] = new JPanel();
            p[i].setBounds(10, j, 450, 300);
            p[i].setBorder(BorderFactory.createMatteBorder(
                    3, 3, 3, 3, Color.DARK_GRAY));
            p[i].setBackground(Color.WHITE);

            p[i].add(label1);
            p[i].add(label3);
            p[i].add(label4);
            p[i].add(label2);

            p[i].add(invite[i]);

            p[i].setLayout(null);
            invite[i].addActionListener(this);
            if (u_id.equals(e.getUserid())) {

            } else {

                mainPanel.add(p[i]);
                j = j + 310;

            }
            i = i + 1;
            count = count + 1;

        }

        mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), 15000));
        mainPanel.setLayout(null);

        scroll.setViewportView(mainPanel);
        contentPane.add(scroll);

        frame.setBounds(100, 100, 400, 450);
        ArrayList<Modelregister> list = ControllereventList.getInvitedListId(e_id);
        for (Modelregister e1 : list) {

            String a = e1.getUserid();
            for (int i1 = 0; i1 < count; i1++) {
                String b = id[i1].getText();
                if (a.equals(b)) {

                    invite[i1].setText("Invited");
                    invite[i1].setBackground(Color.GRAY);
                    invite[i1].setForeground(Color.white);
                }

            }

        }
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < invite.length; i++) {
            if (e.getSource() == invite[i]) {

                String a = id[i].getText();////this gives id of inviter people
                String b = invite[i].getText();
                if (b.equals("Invite")) {

                    invite[i].setText("Invited");
                    invite[i].setBackground(Color.GRAY);
                    invite[i].setForeground(Color.white);

                    ArrayList<Modelregister> list1 = ControllereventList.getUserSender(u_id);/////sender is sent
                    ArrayList<Modelregister> list2 = ControllereventList.getUserReceiever(a);////receiever

                    ArrayList<Modelmeetings> list3 = ControllereventList.getUserEvent(e_id);
                    boolean status1 = ControllereventList.createEventList(list1, list2, list3);
                    if (status1 == true) {
                        System.out.println("Sucesss");
                    } else {
                        System.out.println("Fail");
                    }

                } else {

                }
            }
        }

    }

}
