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

public class createmeetings implements ActionListener {

    private JFrame frame;
    private JTextField eventName;
    private JTextField eventDate;
    private JTextField eventTime;
    private JTextField EventLocation;
    private JTextField MinAtt;
    private JTextField InvitedAtt;
    private JTextField PerOfInvAtt;
    private JTextArea textArea;
    private JButton btnEventDate;
    private JButton btnEventTime;
    JButton btnCreate, btnExit, btnClear;
    int count = 0;
    String uid;

    public createmeetings(String uid) {
        frame = new JFrame();
        frame.setTitle("Create Meetings");

        frame.setBounds(400, 100, 480, 480);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        JLabel lblEventCreateForm = new JLabel("Insert Meetings");
        lblEventCreateForm.setBounds(30, 0, 300, 25);
        lblEventCreateForm.setFont(new Font("Times New Roman", Font.ITALIC, 17));

        frame.getContentPane().add(lblEventCreateForm);

        JLabel lblNameOfEvent = new JLabel("Name of Meetings:");
        lblNameOfEvent.setBounds(30, 30, 120, 25);
        lblNameOfEvent.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        frame.getContentPane().add(lblNameOfEvent);

        eventName = new JTextField();
        eventName.setBounds(210, 30, 150, 25);
        frame.getContentPane().add(eventName);
        eventName.setColumns(10);

        JLabel lblDateOfEvent = new JLabel("Date of Meetings:");
        lblDateOfEvent.setBounds(30, 70, 120, 25);
        lblDateOfEvent.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        frame.getContentPane().add(lblDateOfEvent);

        eventDate = new JTextField();
        eventDate.setBounds(210, 70, 150, 25);
        frame.getContentPane().add(eventDate);
        eventDate.setColumns(10);

        btnEventDate = new JButton("Date");
        btnEventDate.setBounds(370, 70, 60, 25);
        btnEventDate.addActionListener(this);
        btnEventDate.setFont(new Font("Times New Roman", Font.ITALIC, 13));

        btnEventDate.setBackground(Color.white);
        frame.getContentPane().add(btnEventDate);

        JLabel lblTimeOfEvent = new JLabel("Time of Meetings:");
        lblTimeOfEvent.setBounds(30, 110, 120, 25);
        lblTimeOfEvent.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        frame.getContentPane().add(lblTimeOfEvent);

        eventTime = new JTextField();
        eventTime.setBounds(210, 110, 150, 25);
        frame.getContentPane().add(eventTime);
        eventTime.setColumns(10);

        btnEventTime = new JButton("Time");
        btnEventTime.setBounds(370, 110, 60, 25);
        btnEventTime.addActionListener(this);
        btnEventTime.setFont(new Font("Times New Roman", Font.ITALIC, 13));

        btnEventTime.setBackground(Color.white);
        frame.getContentPane().add(btnEventTime);

        JLabel lblLocationOfEvent = new JLabel("Location of Meetings:");
        lblLocationOfEvent.setBounds(30, 150, 140, 25);
        lblLocationOfEvent.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        frame.getContentPane().add(lblLocationOfEvent);

        EventLocation = new JTextField();
        EventLocation.setBounds(210, 150, 150, 25);
        frame.getContentPane().add(EventLocation);
        EventLocation.setColumns(10);

        JLabel lblDescriptionOfEvent = new JLabel("Description of Meetings:");
        lblDescriptionOfEvent.setBounds(30, 190, 140, 25);
        lblDescriptionOfEvent.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        frame.getContentPane().add(lblDescriptionOfEvent);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(210, 190, 250, 30);
        frame.getContentPane().add(scrollPane);

        JLabel lblMinNoOf = new JLabel("Min no. of attendies:");
        lblMinNoOf.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        lblMinNoOf.setBounds(30, 230, 140, 25);
        frame.getContentPane().add(lblMinNoOf);

        MinAtt = new JTextField();
        MinAtt.setBounds(210, 230, 50, 25);
        frame.getContentPane().add(MinAtt);
        MinAtt.setColumns(10);

        JLabel lblNoOfInvited = new JLabel("No. of invited attendies:");
        lblNoOfInvited.setBounds(30, 270, 140, 25);
        lblNoOfInvited.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        frame.getContentPane().add(lblNoOfInvited);

        InvitedAtt = new JTextField();
        InvitedAtt.setBounds(210, 270, 50, 25);
        frame.getContentPane().add(InvitedAtt);
        InvitedAtt.setColumns(10);

        JLabel lblThreshholdForInvitation = new JLabel("Precentage of invited attendies:");
        lblThreshholdForInvitation.setBounds(30, 310, 220, 25);
        lblThreshholdForInvitation.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        frame.getContentPane().add(lblThreshholdForInvitation);

        PerOfInvAtt = new JTextField();
        PerOfInvAtt.setBounds(210, 310, 100, 25);
        frame.getContentPane().add(PerOfInvAtt);
        PerOfInvAtt.setColumns(10);

        btnCreate = new JButton("Create");
        btnCreate.setBounds(70, 370, 90, 30);
        btnCreate.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        btnCreate.setBackground(Color.white);
        frame.getContentPane().add(btnCreate);

        btnClear = new JButton("Reset");
        btnClear.setBounds(170, 370, 90, 30);
        btnClear.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        btnClear.setBackground(Color.white);
        frame.getContentPane().add(btnClear);

        btnExit = new JButton("Exit");
        btnExit.setBounds(270, 370, 70, 30);
        btnExit.setBackground(Color.white);
        btnExit.setFont(new Font("Times New Roman", Font.ITALIC, 13));

        frame.getContentPane().add(btnExit);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        btnCreate.addActionListener(this);
        btnExit.addActionListener(this);

        this.uid = uid;

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnEventDate) {
            eventDate.setText(new timeslotdates(frame).setPickedDate());
        } else if (e.getSource() == btnEventTime) {
            JFrame frame1 = new JFrame();
            frame1.setBounds(830, 290, 0, 68);
            frame1.setFont(new Font("calibri", Font.BOLD, 20));
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
        Controllermeetings.getEvent(uid);
        if (e.getSource() == btnExit) {
            frame.dispose();
        } else if (eventName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please insert Event's Name ");

        } else if (eventDate.getText().isEmpty() && eventDate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please insert Event's Date and Time");

        } else if (e.getSource() == btnCreate) {
            Modelmeetings ob = new Modelmeetings();
            ob.setEname(eventName.getText());
            ob.setEdate(eventDate.getText());
            ob.setEtime(eventTime.getText());
            ob.setElocation(EventLocation.getText());
            ob.setEdesc(textArea.getText());
            ob.setEminatt(MinAtt.getText());
            ob.setEinvitatten(InvitedAtt.getText());
            ob.setEthresmin(PerOfInvAtt.getText());

            boolean status = Controllermeetings.registerEvent(ob, uid);
            if (status == true) {
                JOptionPane.showMessageDialog(frame, "Event Created Successfully");
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "try Again");
            }

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
