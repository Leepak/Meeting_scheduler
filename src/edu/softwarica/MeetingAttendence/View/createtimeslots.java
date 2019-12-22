package edu.softwarica.MeetingAttendence.View;

import edu.softwarica.MeetingAttendence.Controller.ControllertimeSlot;
import edu.softwarica.MeetingAttendence.Model.Modeltimeslot;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class createtimeslots extends JFrame implements ActionListener {

    private final JTextField txt, txt_1, txt_2, txt_3, txt_4, txt_5;
    private final JLabel lblEventName;
    private final String userid;
    private final JButton btnCreate, btnTime_1, btnTime_2, btnTime_3, btnTime_4, btnTime_5, btnClear, btnExit;
    private int cnt, cnt1, cnt2, cnt3, cnt4 = 0;

    public createtimeslots(String userid) {
        setBounds(500, 100, 370, 450);

        setTitle("Create Timeslots");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setVisible(true);
        this.userid = userid;

        JLabel lblTimeSlots = new JLabel("Slot1:");
        lblTimeSlots.setBounds(10, 101, 90, 14);
        lblTimeSlots.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        getContentPane().add(lblTimeSlots);

        txt = new JTextField();
        txt.setBounds(80, 98, 173, 20);
        getContentPane().add(txt);
        txt.setColumns(10);

        JLabel lblTimeSlots_1 = new JLabel("Slot2:");
        lblTimeSlots_1.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        lblTimeSlots_1.setBounds(10, 138, 90, 14);
        getContentPane().add(lblTimeSlots_1);

        txt_1 = new JTextField();
        txt_1.setBounds(80, 135, 174, 20);
        getContentPane().add(txt_1);
        txt_1.setColumns(10);

        JLabel lblTimeSlots_2 = new JLabel("Slot3:");
        lblTimeSlots_2.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        lblTimeSlots_2.setBounds(10, 179, 90, 14);
        getContentPane().add(lblTimeSlots_2);

        txt_2 = new JTextField();
        txt_2.setBounds(80, 176, 173, 20);
        getContentPane().add(txt_2);
        txt_2.setColumns(10);

        JLabel lblTimeSlots_3 = new JLabel("Slot4:");
        lblTimeSlots_3.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        lblTimeSlots_3.setBounds(10, 222, 90, 14);
        getContentPane().add(lblTimeSlots_3);

        txt_3 = new JTextField();
        txt_3.setBounds(80, 219, 173, 20);
        getContentPane().add(txt_3);
        txt_3.setColumns(10);

        JLabel lblTimeSlots_4 = new JLabel("Slot5:");
        lblTimeSlots_4.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        lblTimeSlots_4.setBounds(10, 268, 90, 14);
        getContentPane().add(lblTimeSlots_4);

        txt_4 = new JTextField();
        txt_4.setBounds(80, 265, 173, 20);
        getContentPane().add(txt_4);
        txt_4.setColumns(10);

        btnCreate = new JButton("Create");
        btnCreate.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        btnCreate.setBounds(10, 346, 90, 23);
        btnCreate.setBackground(Color.white);
        getContentPane().add(btnCreate);

        lblEventName = new JLabel("Event Name:");
        lblEventName.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        lblEventName.setBounds(10, 65, 85, 14);
        getContentPane().add(lblEventName);

        txt_5 = new JTextField();
        txt_5.setBounds(80, 62, 173, 20);
        getContentPane().add(txt_5);
        txt_5.setColumns(10);

        btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        btnClear.setBounds(110, 346, 70, 23);
        btnClear.setBackground(Color.white);
        getContentPane().add(btnClear);

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Times New Roman", Font.ITALIC, 13));

        btnExit.setBounds(190, 346, 70, 23);
        btnExit.setBackground(Color.white);
        getContentPane().add(btnExit);

        btnTime_1 = new JButton("Time1");
        btnTime_1.setBounds(260, 97, 89, 23);
        btnTime_1.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        getContentPane().add(btnTime_1);
        btnTime_1.setBackground(Color.white);

        btnTime_2 = new JButton("Time2");
        btnTime_2.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        btnTime_2.setBounds(260, 134, 89, 23);
        getContentPane().add(btnTime_2);
        btnTime_2.setBackground(Color.white);

        btnTime_3 = new JButton("Time3");
        btnTime_3.setBounds(260, 175, 89, 23);
        btnTime_3.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        getContentPane().add(btnTime_3);
        btnTime_3.setBackground(Color.white);

        btnTime_4 = new JButton("Time4");
        btnTime_4.setBounds(260, 218, 89, 23);
        btnTime_4.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        getContentPane().add(btnTime_4);
        btnTime_4.setBackground(Color.white);

        btnTime_5 = new JButton("Time5");
        btnTime_5.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        btnTime_5.setBounds(260, 264, 89, 23);

        btnTime_5.setBackground(Color.white);

        getContentPane().add(btnTime_5);
        btnCreate.addActionListener(this);
        btnTime_1.addActionListener(this);
        btnTime_2.addActionListener(this);
        btnTime_3.addActionListener(this);
        btnTime_4.addActionListener(this);
        btnTime_5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCreate) {
            Modeltimeslot ob = new Modeltimeslot();
            ob.setSlot1(txt.getText());
            ob.setEname(txt_5.getText());
            ob.setSlot2(txt_1.getText());
            ob.setSlot3(txt_2.getText());
            ob.setSlot4(txt_3.getText());
            ob.setSlot5(txt_4.getText());
            ob.setUserid(Integer.parseInt(userid));
            boolean status = ControllertimeSlot.createSlot(ob);
            if (status == true) {
                JOptionPane.showMessageDialog(this, "Time slots successfully created for the particular event");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Time slots not successfully created for the particular event");
            }
        }
        if (e.getSource() == btnTime_1) {
            JFrame frame1 = new JFrame();
            frame1.setBounds(860, 180, 111, 68);
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame1.getContentPane().setLayout(null);
            String time[] = new String[]{"1:00pm", "1:30pm", "2:00pm", "2:30pm", "3:00pm", "3:30pm", "4:00pm", "4:30pm", "5:00pm",
                "5:30pm", "6:00pm", "6:30pm", "7:00pm",
                "7:30pm", "8:00pm", "8:30pm", "9:00pm", "9:30pm", "10:00pm", "10:30pm", "11:00pm", "11:30pm", "12:00pm",
                "-------"};
            JComboBox cb = new JComboBox(time);
            cb.setBounds(0, 0, 102, 33);
            frame1.getContentPane().add(cb);
            frame1.setVisible(true);
            String data = "Programming language Selected: "
                    + cb.getItemAt(cb.getSelectedIndex());
            String data1 = null;
            if (data != null) {
                txt.setText("");
                cb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String data1 = (String) cb.getItemAt(cb.getSelectedIndex());
                        if (e.getSource() == cb && cnt == 0) {
                            cnt = cnt + 1;
                            txt.setText(txt.getText().concat(data1));
                            System.out.println("Count=" + cnt);
                        } else if (e.getSource() == cb && cnt != 0) {
                            txt.setText(txt.getText().concat("---" + data1));
                            System.out.println("Count1=" + cnt);
                        }
                    }
                });
            }

        }
        if (e.getSource() == btnTime_2) {
            JFrame frame1 = new JFrame();
            frame1.setBounds(860, 230, 111, 68);
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame1.getContentPane().setLayout(null);
            String time[] = new String[]{"1:00pm", "1:30pm", "2:00pm", "2:30pm", "3:00pm", "3:30pm", "4:00pm",
                "4:30pm", "5:00pm", "5:30pm", "6:00pm", "6:30pm", "7:00pm",
                "7:30pm", "8:00pm", "8:30pm", "9:00pm", "9:30pm", "10:00pm", "10:30pm", "11:00pm", "11:30pm",
                "12:00pm", "-------"};
            JComboBox cb = new JComboBox(time);
            cb.setBounds(0, 0, 102, 33);
            frame1.getContentPane().add(cb);
            frame1.setVisible(true);
            String data = "Programming language Selected: "
                    + cb.getItemAt(cb.getSelectedIndex());
            String data1 = null;
            if (data != null) {
                txt_1.setText("");
                cb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String data1 = (String) cb.getItemAt(cb.getSelectedIndex());
                        if (e.getSource() == cb && cnt1 == 0) {
                            cnt1 = cnt1 + 1;
                            txt_1.setText(txt_1.getText().concat(data1));
                            System.out.println("Count=" + cnt1);
                        } else if (e.getSource() == cb && cnt1 != 0) {
                            txt_1.setText(txt_1.getText().concat("---" + data1));
                            System.out.println("Count1=" + cnt1);
                        }
                    }
                });
            }

        }
        if (e.getSource() == btnTime_3) {
            JFrame frame1 = new JFrame();
            frame1.setBounds(860, 280, 111, 68);
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
                txt_2.setText("");
                cb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String data1 = (String) cb.getItemAt(cb.getSelectedIndex());
                        if (e.getSource() == cb && cnt2 == 0) {
                            cnt2 = cnt2 + 1;
                            txt_2.setText(txt_2.getText().concat(data1));
                            System.out.println("Count=" + cnt);
                        } else if (e.getSource() == cb && cnt2 != 0) {
                            txt_2.setText(txt_2.getText().concat("---" + data1));
                            System.out.println("Count1=" + cnt);
                        }
                    }
                });
            }

        }
        if (e.getSource() == btnTime_4) {
            JFrame frame1 = new JFrame();
            frame1.setBounds(860, 330, 111, 68);
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame1.getContentPane().setLayout(null);
            String time[] = new String[]{"1:00pm", "1:30pm", "2:00pm", "2:30pm", "3:00pm", "3:30pm", "4:00pm",
                "4:30pm", "5:00pm", "5:30pm", "6:00pm", "6:30pm", "7:00pm",
                "7:30pm", "8:00pm", "8:30pm", "9:00pm", "9:30pm", "10:00pm", "10:30pm", "11:00pm", "11:30pm",
                "12:00pm", "-------"};
            JComboBox cb = new JComboBox(time);
            cb.setBounds(0, 0, 102, 33);
            frame1.getContentPane().add(cb);
            frame1.setVisible(true);
            String data = "Programming language Selected: "
                    + cb.getItemAt(cb.getSelectedIndex());
            String data1 = null;
            if (data != null) {
                txt_3.setText("");
                cb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String data1 = (String) cb.getItemAt(cb.getSelectedIndex());
                        if (e.getSource() == cb && cnt3 == 0) {
                            cnt3 = cnt3 + 1;
                            txt_3.setText(txt_3.getText().concat(data1));
                            System.out.println("Count=" + cnt);
                        } else if (e.getSource() == cb && cnt3 != 0) {
                            txt_3.setText(txt_3.getText().concat("---" + data1));
                            System.out.println("Count1=" + cnt);
                        }
                    }
                });
            }
        }
        if (e.getSource() == btnTime_5) {
            JFrame frame1 = new JFrame();
            frame1.setBounds(860, 380, 111, 68);
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame1.getContentPane().setLayout(null);
            String time[] = new String[]{"1:00pm", "1:30pm", "2:00pm", "2:30pm",
                "3:00pm", "3:30pm", "4:00pm", "4:30pm", "5:00pm", "5:30pm", "6:00pm", "6:30pm", "7:00pm",
                "7:30pm", "8:00pm", "8:30pm", "9:00pm", "9:30pm", "10:00pm", "10:30pm",
                "11:00pm", "11:30pm", "12:00pm", "-------"};
            JComboBox cb = new JComboBox(time);
            cb.setBounds(0, 0, 102, 33);
            frame1.getContentPane().add(cb);
            frame1.setVisible(true);
            String data = "Programming language Selected: "
                    + cb.getItemAt(cb.getSelectedIndex());
            String data1 = null;
            if (data != null) {
                txt_4.setText("");
                cb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String data1 = (String) cb.getItemAt(cb.getSelectedIndex());
                        if (e.getSource() == cb && cnt4 == 0) {
                            cnt4 = cnt4 + 1;
                            txt_4.setText(txt_4.getText().concat(data1));
                            System.out.println("Count=" + cnt);
                        } else if (e.getSource() == cb && cnt4 != 0) {
                            txt_4.setText(txt_4.getText().concat("---" + data1));
                            System.out.println("Count1=" + cnt);
                        }
                    }
                });
            }
        }
    }
}
