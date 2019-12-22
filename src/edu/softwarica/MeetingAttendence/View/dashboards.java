package edu.softwarica.MeetingAttendence.View;

import edu.softwarica.MeetingAttendence.Controller.Controllerregister;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class dashboards implements ActionListener {

    private JFrame frame;
    JButton btnCreateEvent;
    JButton btnAllCreatedEvent;
    JLabel userid;
    JButton btnSeeEvent;
    JButton btnCreateTimeSlot;
    JButton btnVote;
    JButton btnBestTimeSlot;
    Font ft, ft1;
    Font font, font1, font2;
    private JButton btnRefresh;

    public dashboards(String fname, String lname, String email, String address, String phone, String gender,
            String availableTime, String unavailableTime, byte[] img, String uid) {
        initialize(fname, lname, email, address, phone, gender, availableTime, unavailableTime, img, uid);
    }

    private void initialize(String fname, String lname, String email, String address, String phone, String gender,
            String availableTime, String unavailableTime, byte[] img, String uid) {
        frame = new JFrame();
        frame.setBounds(400, 100, 320, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        font = new Font("Times New Roman", Font.ITALIC, 20);
        font2 = new Font("Times New Roman", Font.ITALIC, 30);
        font1 = new Font("Times New Roman", Font.ITALIC, 15);
//        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setResizable(false);
        font = new Font("Consolas", Font.BOLD, 17);
        font1 = new Font("calibri", Font.BOLD, 17);
        frame.setLocation(400, 0);
        JPanel paneldown = new JPanel();
        frame.setTitle("Dashboard");
        paneldown.setBounds(10, 90, 301, 750);
        frame.getContentPane().add(paneldown);
//        paneldown.setBackground(Color.LIGHT_GRAY);
        paneldown.setLayout(null);

        JLabel lblPic = new JLabel();
        lblPic.setBounds(0, 10, 120, 120);
        lblPic.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        paneldown.add(lblPic);

        JLabel lblProfile = new JLabel("Profile");
        lblProfile.setBounds(130, 50, 100, 70);
        lblProfile.setForeground(Color.black);
        ft = new Font("Times New Roman", Font.ITALIC, 20);
        lblProfile.setFont(ft);
        paneldown.add(lblProfile);

        JLabel lblFname = new JLabel("");
        lblFname.setBounds(0, 140, 300, 20);
        lblFname.setText("First Name:                     " + fname);
        lblFname.setForeground(Color.black);
        ft = new Font("Times New Roman", Font.ITALIC, 17);
        lblFname.setFont(ft);
        paneldown.add(lblFname);

        JLabel lblLname = new JLabel("");
        lblLname.setBounds(0, 170, 300, 20);
        lblLname.setText("Last Name:                      " + lname);
        lblLname.setForeground(Color.black);
        ft = new Font("Times New Roman", Font.ITALIC, 17);
        lblLname.setFont(ft);
        paneldown.add(lblLname);

        JLabel lblEmail = new JLabel("");
        lblEmail.setBounds(0, 200, 300, 20);
        lblEmail.setText("Email:                              " + email);
        lblEmail.setForeground(Color.black);
        ft = new Font("Times New Roman", Font.ITALIC, 17);
        lblEmail.setFont(ft);
        paneldown.add(lblEmail);

        JLabel lblAddress = new JLabel("");
        lblAddress.setBounds(0, 230, 300, 20);
        lblAddress.setText("Address:                         " + address);
        lblAddress.setForeground(Color.black);
        ft = new Font("Times New Roman", Font.ITALIC, 17);
        lblAddress.setFont(ft);
        paneldown.add(lblAddress);

        JLabel lblPhone = new JLabel("");
        lblPhone.setBounds(0, 260, 300, 20);
        lblPhone.setText("Phone:                            " + phone);
        lblPhone.setForeground(Color.black);
        ft = new Font("Times New Roman", Font.ITALIC, 17);
        lblPhone.setFont(ft);
        paneldown.add(lblPhone);

        JLabel lblGender = new JLabel("");
        lblGender.setBounds(0, 290, 300, 20);
        lblGender.setText("Gender:                          " + gender);
        lblGender.setForeground(Color.black);
        ft = new Font("Times New Roman", Font.ITALIC, 17);
        lblGender.setFont(ft);
        paneldown.add(lblGender);

        JLabel lblAvailableTime = new JLabel("");
        lblAvailableTime.setBounds(0, 320, 350, 20);
        lblAvailableTime.setText("Available Time:             " + availableTime);
        lblPhone.setForeground(Color.black);
        ft = new Font("Times New Roman", Font.ITALIC, 17);
        lblAvailableTime.setFont(ft);
        paneldown.add(lblAvailableTime);

        JLabel lblunavailableTime = new JLabel("");
        lblunavailableTime.setBounds(0, 350, 350, 20);
        lblunavailableTime.setText("UnAvailable Time:        " + unavailableTime);
        lblunavailableTime.setForeground(Color.black);
        ft = new Font("Times New Roman", Font.ITALIC, 17);
        lblunavailableTime.setFont(ft);
        paneldown.add(lblunavailableTime);

        ImageIcon image = new ImageIcon(img);
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        lblPic.setIcon(newImage);

        userid = new JLabel();
        userid.setText(uid);

        JPanel panelright = new JPanel();
        panelright.setBounds(306, 150, 500, 300);
        frame.getContentPane().add(panelright);
        panelright.setLayout(null);

        JPanel paneltop = new JPanel();
        paneltop.setBounds(0, 0, 300, 300);
        frame.getContentPane().add(paneltop);

        paneltop.setLayout(null);

//        JLabel lblName = new JLabel();
//        lblName.setBounds(0, 0, 300, 100);
//        lblName.setText("Welcome,  " + fname + " " + lname);
//        lblName.setForeground(Color.white);
//        ft = new Font("Calibri", Font.BOLD, 16);
//        lblName.setFont(ft);
//        paneltop.add(lblName);
        btnCreateEvent = new JButton("Create Meetings");
        btnCreateEvent.setBounds(10, 390, 220, 26);
        ft1 = new Font("Times New Roman", Font.ITALIC, 15);
        btnCreateEvent.setFont(ft1);

        btnCreateEvent.setBackground(Color.white);
        paneldown.add(btnCreateEvent);

        btnAllCreatedEvent = new JButton("View Created Meetings");
        btnAllCreatedEvent.setBounds(10, 430, 220, 26);
        btnAllCreatedEvent.setFont(ft1);

        btnAllCreatedEvent.setBackground(Color.white);
        paneldown.add(btnAllCreatedEvent);

        btnSeeEvent = new JButton("See Event Notification");
        btnSeeEvent.setBounds(10, 470, 220, 26);
        btnSeeEvent.setBackground(Color.white);
        btnSeeEvent.setFont(ft1);

        paneldown.add(btnSeeEvent);

        btnCreateTimeSlot = new JButton("Create Time slot");
        btnCreateTimeSlot.setBounds(10, 510, 220, 26);
        btnCreateTimeSlot.setBackground(Color.white);
        btnCreateTimeSlot.setFont(ft1);

        paneldown.add(btnCreateTimeSlot);

        btnVote = new JButton("Vote on time slot");
//        btnVote.setBounds(10, 90, 180, 20);
        btnVote.setForeground(Color.black);
        btnVote.setFont(ft1);
        btnVote.setBackground(Color.LIGHT_GRAY);
        paneldown.add(btnVote);

        btnBestTimeSlot = new JButton("Best Time Slot");
//        btnBestTimeSlot.setBounds(220, 90, 180, 20);
        btnBestTimeSlot.setForeground(Color.black);
        btnBestTimeSlot.setFont(ft1);
        btnBestTimeSlot.setBackground(Color.LIGHT_GRAY);
        panelright.add(btnBestTimeSlot);

        btnRefresh = new JButton("Refresh Voting");
//        btnRefresh.setBounds(10, 130, 180, 20);
        btnRefresh.setForeground(Color.black);
        btnRefresh.setFont(ft1);
        btnRefresh.setBackground(Color.LIGHT_GRAY);
        panelright.add(btnRefresh);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(ft1);

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                frame.dispose();
            }
        });

        btnLogout.setBounds(10, 550, 220, 26);

        btnLogout.setBackground(Color.white);
        paneldown.add(btnLogout);

        btnCreateEvent.addActionListener(this);
        btnAllCreatedEvent.addActionListener(this);
        btnSeeEvent.addActionListener(this);
        btnCreateTimeSlot.addActionListener(this);
        btnVote.addActionListener(this);
        btnBestTimeSlot.addActionListener(this);
        btnRefresh.addActionListener(this);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == btnCreateEvent) {
            new createmeetings(userid.getText());
            System.out.println("Hello login sucess");
        }
        if (e.getSource() == btnAllCreatedEvent) {
            new viewmeetings(userid.getText());
        }
        if (e.getSource() == btnSeeEvent) {
            new meetingsnotification(userid.getText());
        }
        if (e.getSource() == btnCreateTimeSlot) {
            new createtimeslots(userid.getText());
        }

        if (e.getSource() == btnRefresh) {
            Controllerregister.userStatusUpdate(0, userid.getText());
        }

    }
}
