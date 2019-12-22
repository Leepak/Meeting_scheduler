package edu.softwarica.MeetingAttendence.View;

import edu.softwarica.MeetingAttendence.Controller.Controllerlogins;
import edu.softwarica.MeetingAttendence.Model.Modelregister;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener {

    private JTextField textEmail;
    private JPasswordField passwordField;
    JButton btnSignup;
    JButton btnLogin;
    Font font, font1, font2;

    public login() {
        setTitle("Login Form");
        setBounds(500, 160, 700, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);
        font = new Font("Times New Roman", Font.ITALIC, 20);
        font2 = new Font("Times New Roman", Font.ITALIC, 30);
        font1 = new Font("Times New Roman", Font.ITALIC, 15);
        JPanel panel = new JPanel();
        panel.setBounds(5, 25, 700, 388);

        getContentPane().add(panel);

        panel.setLayout(null);

        JLabel lblWelcome = new JLabel("Login In Form");
        lblWelcome.setBounds(60, 10, 190, 40);
        lblWelcome.setFont(font2);
        panel.add(lblWelcome);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(60, 80, 57, 20);
        lblEmail.setFont(font1);
        panel.add(lblEmail);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(330, 80, 90, 20);
        lblPassword.setFont(font1);

        panel.add(lblPassword);

        textEmail = new JTextField();
        textEmail.setBounds(60, 103, 240, 25);
        panel.add(textEmail);
        textEmail.setFont(font1);
        textEmail.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(330, 103, 200, 25);
        panel.add(passwordField);
        passwordField.setFont(font1);

        btnLogin = new JButton("Sign Up");
        btnLogin.setBounds(330, 140, 130, 25);

        btnLogin.setBackground(Color.white);
        btnLogin.setFont(font);
        panel.add(btnLogin);

        btnSignup = new JButton("Register");
        btnSignup.setBounds(60, 140, 130, 25);

        btnSignup.setBackground(Color.white);
        btnSignup.setFont(font);
        panel.add(btnSignup);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(5, 420, 535, 95);
        getContentPane().add(panel_2);
        panel_2.setBackground(Color.LIGHT_GRAY);
        panel_2.setLayout(null);
        btnSignup.addActionListener(this);
        btnLogin.addActionListener(this);

        setVisible(true);
    }

    public static void main(String args[]) {
        new login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSignup) {
            new registration();
        } else if (e.getSource() == btnLogin) {
            int count = 0;
            ArrayList<Modelregister> list = Controllerlogins.login();
            for (Modelregister m : list) {
                if (passwordField.getText().equals(m.getPass())) {
                    byte[] img = null;
                    img = m.getImg1();
                    String fname = m.getFname();
                    String lname = m.getLname();
                    String email = m.getEmail();
                    String phone = m.getPhone();
                    String availableTime = m.getAvtime();
                    String unavailableTime = m.getUnavtime();
                    String address = m.getAddress();
                    String gender = m.getGender();
                    String uid = m.getUserid();
                    new dashboards(fname, lname, email, address, phone, gender, availableTime, unavailableTime, img, uid);
                    count = count + 1;
                    dispose();
                    break;
                }
            }
            if (count == 0) {
                JOptionPane.showMessageDialog(this, "          Try Again!!");
            }
        }
    }
}
