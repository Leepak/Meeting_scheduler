package edu.softwarica.MeetingAttendence.View;

import edu.softwarica.MeetingAttendence.Controller.Controllerregister;
import edu.softwarica.MeetingAttendence.Model.Modelregister;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class registration extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    public JFrame frame;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField address;
    private JTextField phone;
    private JPasswordField password;
    private JTextField availableTime;
    private JTextField unavailableTime;
    JRadioButton rdbtnFemale, rdbtnMale;
    String filepath;

    JButton btnAvDay;
    JButton btnUnavDay;
    JButton btnImage;
    JButton btnAvTime;
    JButton btnUnavTime;
    JButton btnRegister;
    JButton btnReset;
    JButton btnExit;
    JLabel label;
    Font font, font1, font2;
    int count = 0;
    private JLabel lblDay;
    private JLabel lblTim;

    public registration() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Registration");

        frame.setBounds(400, 100, 820, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        font = new Font("Times New Roman", Font.ITALIC, 20);
        font2 = new Font("Times New Roman", Font.ITALIC, 30);
        font1 = new Font("Times New Roman", Font.ITALIC, 15);
        frame.setResizable(false);

        JLabel lblRegister = new JLabel("Registration Form");
        lblRegister.setForeground(Color.BLACK);
        lblRegister.setFont(font);

        lblRegister.setBounds(30, 40, 329, 30);
        frame.getContentPane().add(lblRegister);

        JLabel lblFname = new JLabel("First Name:");
        lblFname.setBounds(30, 85, 100, 25);
        frame.getContentPane().add(lblFname);
        lblFname.setFont(font1);

        firstname = new JTextField();
        firstname.setBounds(30, 110, 235, 25);
        frame.getContentPane().add(firstname);
        firstname.setFont(font1);
        firstname.setColumns(10);

        JLabel lblLname = new JLabel("Last Name:");
        lblLname.setBounds(290, 85, 79, 25);
        frame.getContentPane().add(lblLname);
        lblLname.setFont(font1);

        lastname = new JTextField();
        lastname.setBounds(290, 110, 235, 25);
        frame.getContentPane().add(lastname);
        lastname.setFont(font1);
        lastname.setColumns(10);

        JLabel lblEmail = new JLabel("Email Address:");
        lblEmail.setBounds(550, 85, 120, 25);
        frame.getContentPane().add(lblEmail);
        lblEmail.setFont(font1);

        email = new JTextField();
        email.setBounds(550, 110, 235, 25);
        frame.getContentPane().add(email);
        email.setFont(font1);
        email.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(290, 140, 79, 25);
        frame.getContentPane().add(lblPassword);
        lblPassword.setFont(font1);

        password = new JPasswordField();
        password.setBounds(290, 165, 235, 25);
        password.setFont(font1);
        frame.getContentPane().add(password);

        JLabel lblAddress = new JLabel("Location:");
        lblAddress.setBounds(30, 140, 79, 25);
        frame.getContentPane().add(lblAddress);
        lblAddress.setFont(font1);

        address = new JTextField();
        address.setBounds(30, 165, 235, 25);
        frame.getContentPane().add(address);
        address.setFont(font1);
        address.setColumns(10);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(550, 140, 60, 25);
        frame.getContentPane().add(lblGender);
        lblGender.setFont(font1);

        rdbtnMale = new JRadioButton("Male");

        rdbtnMale.setBackground(Color.white);
        rdbtnMale.setBounds(550, 165, 70, 25);
        rdbtnMale.setFont(font1);
        frame.getContentPane().add(rdbtnMale);

        rdbtnFemale = new JRadioButton("Female");
        rdbtnFemale.setBounds(630, 165, 79, 25);
        rdbtnFemale.setFont(font1);

        rdbtnFemale.setBackground(Color.white);
        frame.getContentPane().add(rdbtnFemale);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbtnMale);
        bg.add(rdbtnFemale);

        JLabel lblPhone = new JLabel("Pay Grade:");
        lblPhone.setBounds(30, 200, 80, 25);
        frame.getContentPane().add(lblPhone);
        lblPhone.setFont(font1);

        phone = new JTextField();
        phone.setBounds(30, 230, 235, 25);
        frame.getContentPane().add(phone);
        phone.setFont(font1);
        phone.setColumns(10);

        JLabel lblImage = new JLabel("Image:");
        lblImage.setBounds(290, 200, 56, 25);
        lblImage.setFont(font1);
        frame.getContentPane().add(lblImage);

        btnImage = new JButton("Image");
        btnImage.setBounds(290, 230, 100, 25);

        btnImage.setBackground(Color.white);
        frame.getContentPane().add(btnImage);
        btnImage.setFont(font1);

        label = new JLabel("");
        label.setBounds(344, 421, 190, 14);
        label.setFont(font1);
        frame.getContentPane().add(label);

        JLabel lblAvailableTimeSlots = new JLabel("Available time slots:");
        lblAvailableTimeSlots.setBounds(30, 270, 151, 25);
        frame.getContentPane().add(lblAvailableTimeSlots);
        lblAvailableTimeSlots.setFont(font1);

        availableTime = new JTextField();
        availableTime.setBounds(30, 300, 220, 25);
        availableTime.setFont(font1);
        frame.getContentPane().add(availableTime);
        availableTime.setColumns(10);

        JLabel lblUnavailableTimeSlots = new JLabel("Unavailable time slots:");
        lblUnavailableTimeSlots.setBounds(430, 270, 200, 25);
        frame.getContentPane().add(lblUnavailableTimeSlots);
        lblUnavailableTimeSlots.setFont(font1);

        unavailableTime = new JTextField();
        unavailableTime.setBounds(430, 300, 200, 25);
        frame.getContentPane().add(unavailableTime);
        unavailableTime.setColumns(10);

//        JMenuBar menuBar = new JMenuBar();
//        menuBar.setBounds(0, 0, 546, 25);
//        frame.getContentPane().add(menuBar);
//
//        JMenu mnMenu = new JMenu("Menu");
//        menuBar.add(mnMenu);
//
//        JMenuItem mntmExit = new JMenuItem("Exit");
//        mnMenu.add(mntmExit);
        btnRegister = new JButton("Register");
        btnRegister.setBounds(70, 340, 89, 25);

        btnRegister.setBackground(Color.white);
        frame.getContentPane().add(btnRegister);
        btnRegister.setFont(font1);

        btnReset = new JButton("Reset");
        btnReset.setBounds(170, 340, 89, 25);

        btnReset.setBackground(Color.white);
        frame.getContentPane().add(btnReset);
        btnReset.setFont(font1);

        btnExit = new JButton("Exit");
        btnExit.setBounds(270, 340, 89, 25);

        btnExit.setBackground(Color.white);
        frame.getContentPane().add(btnExit);
        btnExit.setFont(font1);

        /////Two button for accessing Jpanel		
        btnAvDay = new JButton("Day");
        btnAvDay.setBounds(270, 300, 60, 25);
        btnAvDay.setFont(new Font("Calibri", Font.BOLD, 12));
        frame.getContentPane().add(btnAvDay);

        btnAvDay.setBackground(Color.white);
        btnAvDay.addActionListener(this);

        btnUnavDay = new JButton("Day");
        btnUnavDay.setBounds(650, 300, 60, 25);
        btnUnavDay.setFont(new Font("Calibri", Font.BOLD, 12));

        btnUnavDay.setBackground(Color.white);
        frame.getContentPane().add(btnUnavDay);

        btnAvTime = new JButton("Time");
        btnAvTime.setBounds(350, 300, 65, 25);
        btnAvTime.setFont(new Font("Calibri", Font.BOLD, 12));

        btnAvTime.setBackground(Color.white);
        frame.getContentPane().add(btnAvTime);

        btnUnavTime = new JButton("Time");
        btnUnavTime.setBounds(730, 300, 65, 25);
        btnUnavTime.setFont(new Font("Calibri", Font.BOLD, 12));

        btnUnavTime.setBackground(Color.white);
        frame.getContentPane().add(btnUnavTime);

//        lblDay = new JLabel("Day");
//        lblDay.setBounds(420, 310, 46, 25);
//        lblDay.setFont(new Font("Calibri", Font.BOLD, 12));
//        frame.getContentPane().add(lblDay);
//
//        lblTim = new JLabel("Time");
//        lblTim.setBounds(485, 310, 46, 25);
//        frame.getContentPane().add(lblTim);
//        lblTim.setFont(new Font("Calibri", Font.BOLD, 12));
        btnImage.addActionListener(this);
        btnUnavDay.addActionListener(this);
        btnAvTime.addActionListener(this);
        btnUnavTime.addActionListener(this);
        btnRegister.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);
        btnRegister.setFont(new Font("Calibri", Font.BOLD, 12));
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAvDay) {
            JFrame frame1 = new JFrame();
            frame1.setBounds(700, 450, 111, 68);
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame1.getContentPane().setLayout(null);
            String time[] = new String[]{"Sunday", "Monday", "Tuesday",
                "Wednesday", "Thurusday", "Friday", "Saturday"};

            JComboBox cb = new JComboBox(time);
            cb.setBounds(0, 0, 102, 33);
            frame1.getContentPane().add(cb);
            frame1.setVisible(true);
            String data = "Programming language Selected: "
                    + cb.getItemAt(cb.getSelectedIndex());

            ///String data1=null;
            if (data != null) {
                ///textField_2.setText("");

                cb.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub

                        String data1 = (String) cb.getItemAt(cb.getSelectedIndex());

                        if (e.getSource() == cb && count == 0) {
                            ///count=count+1;
                            availableTime.setText("" + availableTime.getText().concat(data1) + ":");
                            System.out.println("Count=" + count);

                        }

                    }
                });
            }

        } else if (e.getSource() == btnUnavDay) {
            JFrame frame1 = new JFrame();
            frame1.setBounds(700, 450, 111, 68);
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame1.getContentPane().setLayout(null);
            String time[] = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thurusday",
                "Friday", "Saturday"};

            JComboBox cb = new JComboBox(time);
            cb.setBounds(0, 0, 102, 33);
            frame1.getContentPane().add(cb);
            frame1.setVisible(true);
            String data = "Programming language Selected: "
                    + cb.getItemAt(cb.getSelectedIndex());

            ///String data1=null;
            if (data != null) {
                ///textField_2.setText("");

                cb.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub

                        String data1 = (String) cb.getItemAt(cb.getSelectedIndex());

                        if (e.getSource() == cb && count == 0) {
                            ///count=count+1;
                            unavailableTime.setText("" + unavailableTime.getText().concat(data1) + ":");
                            System.out.println("Count=" + count);

                        }

                    }
                });
            }
        } else if (e.getSource() == btnAvTime) {
            JFrame frame1 = new JFrame();
            frame1.setBounds(700, 450, 111, 68);
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame1.getContentPane().setLayout(null);
            String time[] = new String[]{"1:00pm", "1:30pm", "2:00pm", "2:30pm", "3:00pm", "3:30pm", "4:00pm", "4:30pm", "5:00pm", "5:30pm", "6:00pm", "6:30pm", "7:00pm",
                "7:30pm", "8:00pm", "8:30pm", "9:00pm", "9:30pm", "10:00pm", "10:30pm", "11:00pm", "11:30pm", "12:00pm", "-------"};

            JComboBox cb = new JComboBox(time);
            cb.setBounds(0, 0, 102, 33);
            frame1.getContentPane().add(cb);
            frame1.setVisible(true);
            String data = "Programming language Selected: "
                    + cb.getItemAt(cb.getSelectedIndex());

            /////String data1=null;
            if (data != null) {
                ///textField_2.setText("");

                cb.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub

                        String data1 = (String) cb.getItemAt(cb.getSelectedIndex());

                        if (e.getSource() == cb && count == 0) {
                            count = count + 1;
                            availableTime.setText(availableTime.getText().concat(data1));
                            System.out.println("Count=" + count);

                        } else if (e.getSource() == cb && count != 0) {
                            availableTime.setText(availableTime.getText().concat("---" + data1 + ";"));
                            System.out.println("Count1=" + count);
                            count = count - 1;

                        }

                    }
                });
            }

        } else if (e.getSource() == btnUnavTime) {
            JFrame frame1 = new JFrame();
            frame1.setBounds(700, 450, 111, 68);
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame1.getContentPane().setLayout(null);
            String time[] = new String[]{"1:00pm", "1:30pm", "2:00pm", "2:30pm", "3:00pm", "3:30pm", "4:00pm", "4:30pm", "5:00pm",
                "5:30pm", "6:00pm", "6:30pm", "7:00pm",
                "7:30pm", "8:00pm", "8:30pm", "9:00pm", "9:30pm", "10:00pm", "10:30pm", "11:00pm", "11:30pm",
                "12:00pm", "-------"};

            JComboBox cb = new JComboBox(time);
            cb.setBounds(0, 0, 102, 33);
            frame1.getContentPane().add(cb);
            frame1.setVisible(true);
            String data = "Programming language Selected: "
                    + cb.getItemAt(cb.getSelectedIndex());

            if (data != null) {

                cb.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String data1 = (String) cb.getItemAt(cb.getSelectedIndex());

                        if (e.getSource() == cb && count == 0) {
                            count = count + 1;
                            unavailableTime.setText(unavailableTime.getText().concat(data1));
                            System.out.println("Count=" + count);

                        } else if (e.getSource() == cb && count != 0) {
                            unavailableTime.setText(unavailableTime.getText().concat("---" + data1 + ";"));
                            System.out.println("Count1=" + count);
                            count = count - 1;

                        }

                    }
                });
            }

        } else if (e.getSource() == btnImage) {
            JFileChooser fc = new JFileChooser();
            int i = fc.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                filepath = f.getPath();
                label.setText(filepath);

            }
        } else if (e.getSource() == btnRegister) {

            boolean b = Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email.getText());
            boolean c = firstname.getText().equals("") && lastname.getText().equals("")
                    && email.getText().equals("") && address.getText().equals("")
                    && password.getText().equals("") && availableTime.getText().equals("")
                    && unavailableTime.getText().equals("");
            if (c == true) {
                JOptionPane.showMessageDialog(frame, "Empty field ");
            }

            if (b == false) {
                JOptionPane.showMessageDialog(frame, "Please enter valid email");
            }

            if (b && c == false) {
                getDataCheck();
                System.out.println("Hello");
            }
        } else if (e.getSource() == btnReset) {

            firstname.setText("");
            lastname.setText("");
            email.setText("");
            address.setText("");
            phone.setText("");
            password.setText("");
            availableTime.setText("");
            unavailableTime.setText("");

        } else if (e.getSource() == btnExit) {
            frame.dispose();
        }

    }

    public void getDataCheck() {

        String gender;
        if (rdbtnMale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        Modelregister ob = new Modelregister();
        ob.setFname(firstname.getText());
        ob.setLname(lastname.getText());
        ob.setEmail(email.getText());
        ob.setPass(password.getText());
        ob.setAddress(address.getText());
        ob.setGender(gender);
        ob.setPhone(phone.getText());
        ob.setAvtime(availableTime.getText());
        ob.setUnavtime(unavailableTime.getText());
        ob.setImg(filepath);
        ///
        boolean status = Controllerregister.reisterUser(ob);
        if (status == true) {
            JOptionPane.showMessageDialog(frame, "Registration sucessfull");
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(frame, "Registration Unsucessfull");

        }
    }
}
