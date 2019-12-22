package edu.softwarica.MeetingAttendence.View;

import edu.softwarica.MeetingAttendence.Controller.Controllermeetings;
import edu.softwarica.MeetingAttendence.Model.Modelmeetings;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class updatemeetings extends JFrame implements ActionListener {

    private final JTextField eventName;
    private final JTextField eventDate;
    private final JTextField eventTime;
    private final JTextField EventLocation;
    private final JTextField MinAtt;
    private final JTextField InvitedAtt;
    private final JTextField PerOfInvAtt;
    private final JTextArea textArea;
    private final JButton btnEventDate;
    private final JButton btnEventTime;
    JButton btnUpdate, btnExit, btnClear;
    int count = 0;
    String eid;

    public updatemeetings(String uid) {
        setBounds(400, 100, 456, 500);
        setTitle("Update Meetings");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);

        JLabel lblEventCreateForm = new JLabel("Update Meetings");
        lblEventCreateForm.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        lblEventCreateForm.setBounds(30, 30, 300, 25);

        getContentPane().add(lblEventCreateForm);

        JLabel lblNameOfEvent = new JLabel("Name of event:");

        lblNameOfEvent.setBounds(100, 100, 120, 25);
        lblNameOfEvent.setFont(new Font("Times New Roman", Font.ITALIC, 13));

        getContentPane().add(lblNameOfEvent);

        eventName = new JTextField();
        eventName.setBounds(200, 100, 150, 25);
        getContentPane().add(eventName);
        eventName.setColumns(10);

        JLabel lblDateOfEvent = new JLabel("Date of Meetings:");

        lblDateOfEvent.setBounds(100, 135, 120, 25);
        lblDateOfEvent.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        getContentPane().add(lblDateOfEvent);

        eventDate = new JTextField();
        eventDate.setBounds(200, 135, 150, 25);
        getContentPane().add(eventDate);
        eventDate.setColumns(10);

        btnEventDate = new JButton("Date");
        btnEventDate.setBounds(360, 135, 60, 25);
        btnEventDate.addActionListener(this);
        btnEventDate.setFont(new Font("Times New Roman", Font.ITALIC, 13));

        btnEventDate.setBackground(Color.white);
        getContentPane().add(btnEventDate);

        JLabel lblTimeOfEvent = new JLabel("Time of Meetings:");

        lblTimeOfEvent.setBounds(100, 170, 120, 25);
        lblTimeOfEvent.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        getContentPane().add(lblTimeOfEvent);

        eventTime = new JTextField();
        eventTime.setBounds(200, 170, 150, 25);
        getContentPane().add(eventTime);
        eventTime.setColumns(10);

        btnEventTime = new JButton("Time");
        btnEventTime.setBounds(360, 170, 60, 25);
        btnEventTime.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        btnEventTime.addActionListener(this);
        btnEventTime.setBackground(Color.white);
        getContentPane().add(btnEventTime);

        JLabel lblLocationOfEvent = new JLabel("Location of Meetings:");
        lblLocationOfEvent.setBounds(60, 205, 140, 25);
        lblLocationOfEvent.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        getContentPane().add(lblLocationOfEvent);

        EventLocation = new JTextField();
        EventLocation.setBounds(200, 205, 150, 25);
        getContentPane().add(EventLocation);
        EventLocation.setColumns(10);

        JLabel lblDescriptionOfEvent = new JLabel("Description of Meetings:");
        lblDescriptionOfEvent.setBounds(60, 260, 140, 25);
        lblDescriptionOfEvent.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        getContentPane().add(lblDescriptionOfEvent);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(200, 245, 250, 50);
        getContentPane().add(scrollPane);

        JLabel lblMinNoOf = new JLabel("Min no. of attendies");
        lblMinNoOf.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        lblMinNoOf.setBounds(80, 310, 140, 25);
        getContentPane().add(lblMinNoOf);

        MinAtt = new JTextField();
        MinAtt.setBounds(200, 310, 50, 25);
        getContentPane().add(MinAtt);
        MinAtt.setColumns(10);

        JLabel lblNoOfInvited = new JLabel("No. of invited attendies");
        lblNoOfInvited.setBounds(60, 345, 140, 25);
        lblNoOfInvited.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        getContentPane().add(lblNoOfInvited);

        InvitedAtt = new JTextField();
        InvitedAtt.setBounds(200, 345, 50, 25);
        getContentPane().add(InvitedAtt);
        InvitedAtt.setColumns(10);

        JLabel lblThreshholdForInvitation = new JLabel("Precentage of invited attendies");
        lblThreshholdForInvitation.setBounds(20, 380, 220, 25);
        lblThreshholdForInvitation.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        getContentPane().add(lblThreshholdForInvitation);

        PerOfInvAtt = new JTextField();
        PerOfInvAtt.setBounds(200, 380, 100, 25);
        getContentPane().add(PerOfInvAtt);
        PerOfInvAtt.setColumns(10);

        btnUpdate = new JButton("Update");
        //btnUpdate.setBounds(85, 449, 99, 25);
        btnUpdate.setBounds(85, 430, 75, 25);
        btnUpdate.setFont(new Font("Times New Roman", Font.ITALIC, 13));

        btnUpdate.setBackground(Color.white);
        getContentPane().add(btnUpdate);

        btnClear = new JButton("Reset");
        btnClear.setBounds(232, 430, 65, 25);
        btnClear.setFont(new Font("Times New Roman", Font.ITALIC, 13));

        btnClear.setBackground(Color.white);
        getContentPane().add(btnClear);

        btnExit = new JButton("Exit");
        btnExit.setBounds(374, 430, 60, 25);
        btnExit.setBackground(Color.white);
        btnExit.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        getContentPane().add(btnExit);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        btnUpdate.addActionListener(this);
        btnExit.addActionListener(this);

        this.eid = uid;

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnEventDate) {
            eventDate.setText(new timeslotdates(this).setPickedDate());
        } else if (e.getSource() == btnEventTime) {
            JFrame this1 = new JFrame();
            this1.setBounds(350, 350, 111, 68);
            this1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this1.getContentPane().setLayout(null);
            String time[] = new String[]{"1:00pm", "1:30pm", "2:00pm", "2:30pm",
                "3:00pm", "3:30pm", "4:00pm", "4:30pm", "5:00pm", "5:30pm", "6:00pm", "6:30pm", "7:00pm",
                "7:30pm", "8:00pm", "8:30pm", "9:00pm", "9:30pm", "10:00pm", "10:30pm", "11:00pm",
                "11:30pm", "12:00pm", "-------"};

            JComboBox cb = new JComboBox(time);
            cb.setBounds(0, 0, 102, 33);
            this1.getContentPane().add(cb);
            this1.setVisible(true);
            String data = "Programming language Selected: "
                    + cb.getItemAt(cb.getSelectedIndex());

            String data1 = null;
            if (data != null) {
                eventTime.setText("");

                cb.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String data1 = (String) cb.getItemAt(cb.getSelectedIndex());

                        if (e.getSource() == cb && count == 0) {
                            count = count + 1;
                            eventTime.setText(eventTime.getText().concat(data1));
                            System.out.println("Count=" + count);

                        } else if (e.getSource() == cb && count != 0) {
                            eventTime.setText(eventTime.getText().concat("---" + data1));
                            System.out.println("Count1=" + count);
                        }
                    }
                });
            }
        }

        if (e.getSource() == btnUpdate) {
            Modelmeetings ob = new Modelmeetings();
            ob.setEname(eventName.getText());
            ob.setEdate(eventDate.getText());
            ob.setEtime(eventTime.getText());
            ob.setElocation(EventLocation.getText());
            ob.setEdesc(textArea.getText());
            ob.setEminatt(MinAtt.getText());
            ob.setEinvitatten(InvitedAtt.getText());
            ob.setEthresmin(PerOfInvAtt.getText());

            boolean status = Controllermeetings.updateEvent(ob, eid);
            if (status == true) {
                System.out.println("Data succesfully updated");
                JOptionPane.showMessageDialog(this, "Data SUccesfully Updated");

                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Data SUccesfully not Updated");
            }
        } else if (e.getSource() == btnExit) {
            dispose();
        } else if (e.getSource() == btnClear) {

            eventName.setText("  ");
            eventDate.setText("  ");
            eventTime.setText("  ");
            EventLocation.setText("  ");
            textArea.setText("  ");
            MinAtt.setText("  ");
            InvitedAtt.setText("  ");
            PerOfInvAtt.setText("  ");
        }
    }
}
