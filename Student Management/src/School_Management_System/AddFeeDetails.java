package School_Management_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import java.util.Date;
import javax.swing.*;

public class AddFeeDetails extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf1, tf2, tf3, tf4;
    JButton bt1, bt2;
    Choice ch1, ch2, ch3;
    
    AddFeeDetails()
    {
        setTitle("Add Student Fee Details");
        getContentPane().setBackground(Color.WHITE);
        
        setLocation(400,150);
        setSize(900, 600);
        
        ImageIcon img = new ImageIcon(getClass().getResource("/School_Management_System/Icons/addfeedetails.jpg"));
        Image scaledImg = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        JLabel bg1 = new JLabel(new ImageIcon(scaledImg));
        bg1.setBounds(0, 0, 900, 600);
        add(bg1);
        
        l1 = new JLabel("Add Student Fee Details", SwingConstants.CENTER);
        l1.setFont(new Font("Arial", Font.BOLD, 32));
        l1.setForeground(new Color(84, 2, 224));
        l1.setBounds(150, 30, 600, 50);
        bg1.add(l1);
        
        // Class Name
        l2 = new JLabel("Class Name");
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setForeground(new Color(59, 25, 117));
        l2.setBounds(100, 110, 150, 30);
        bg1.add(l2);

        ch1=new Choice();
        ch1.add("Select Grade");
        try
        {
            ConnectionClass obj= new ConnectionClass();
            String q="select distinct class from student";
            ResultSet rest= obj.stm.executeQuery(q);
            while (rest.next())
            {
                ch1.add(rest.getString("class"));                
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        ch1.setBounds(280, 110, 200, 30);
        ch1.setFont(new Font("Arial", Font.BOLD, 20));
        bg1.add(ch1);
        
        
        // Username
        l3 = new JLabel("Username");
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setBounds(100, 170, 150, 30);
        bg1.add(l3);

        ch2 = new Choice();
        ch2.add("Select Username");
        ch2.setBounds(280, 170, 200, 30);
        ch2.setFont(new Font("Arial", Font.BOLD, 20));
        bg1.add(ch2);
        
        // Student Name
        l4 = new JLabel("Student Name");
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setBounds(500, 170, 150, 30);
        bg1.add(l4);

        tf1 = new JTextField();
        tf1.setBounds(660, 170, 200, 30);
        tf1.setFont(new Font("Arial", Font.BOLD, 20));
        tf1.setEditable(false);
        bg1.add(tf1);
        
        l5 = new JLabel("Email");
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setBounds(100, 230, 150, 30);
        bg1.add(l5);
        
        tf2 = new JTextField();
        tf2.setBounds(280, 230, 200, 30);
        tf2.setFont(new Font("Arial", Font.BOLD, 20));
        tf2.setEditable(false);
        bg1.add(tf2);
        
        // Total Fee
        l6 = new JLabel("Total Fee");
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setBounds(500, 230, 150, 30);
        bg1.add(l6);

        tf3 = new JTextField();
        tf3.setBounds(660, 230, 200, 30);
        tf3.setFont(new Font("Arial", Font.BOLD, 20));
        tf3.setEditable(false);
        bg1.add(tf3);

        // Submit Fee
        l7 = new JLabel("Submit Fee");
        l7.setFont(new Font("Arial", Font.BOLD, 20));
        l7.setBounds(100, 290, 150, 30);
        bg1.add(l7);

        tf4 = new JTextField();
        tf4.setBounds(280, 290, 200, 30);
        tf4.setFont(new Font("Arial", Font.BOLD, 20));
        bg1.add(tf4);

        // Fee Status
        l8 = new JLabel("Fee Status");
        l8.setFont(new Font("Arial", Font.BOLD, 20));
        l8.setBounds(500, 290, 150, 30);
        bg1.add(l8);

        ch3 = new Choice();
        ch3.add("Select Status");
        ch3.add("Due");
        ch3.add("Completed");
        ch3.setBounds(660, 290, 200, 30);
        ch3.setFont(new Font("Arial", Font.BOLD, 20));
        bg1.add(ch3);
        
        bt1 = new JButton("Submit");
        bt1.setBounds(300, 360, 150, 40);
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bg1.add(bt1);
        bt1.addActionListener(this);
        
        bt2 = new JButton("Back");
        bt2.setBounds(500, 360, 150, 40);
        bt2.setBackground(new Color(8, 161, 92));
        bt2.setForeground(Color.BLACK);
        bg1.add(bt2);
        bt2.addActionListener(this);
        
        
        ch1.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                    String class_name = ch1.getSelectedItem();

                    try {

                        ch2.removeAll();
                        ch2.add("Select Username");

                        ConnectionClass objUser = new ConnectionClass();

                        String qUser = "SELECT username FROM student WHERE `class`='" + class_name + "'";
                        ResultSet rsUser = objUser.stm.executeQuery(qUser);

                        while (rsUser.next()) {
                            ch2.add(rsUser.getString("username"));
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        ch2.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    String username = ch2.getSelectedItem();
                    String class_name = ch1.getSelectedItem();
                    try {
                        ConnectionClass obj = new ConnectionClass();
                        // Get student name and email
                        String q = "SELECT name, email FROM student WHERE username='" + username + "'";
                        ResultSet rs = obj.stm.executeQuery(q);

                        if (rs.next()) {
                            tf1.setText(rs.getString("name"));
                            tf2.setText(rs.getString("email"));
                        }
                        // Get full fee from fee_structure
                        String qFee = "SELECT fee_rs FROM fee_structure WHERE class_name='" + class_name + "'";
                        ResultSet rsFee = obj.stm.executeQuery(qFee);

                        if (rsFee.next())
                        {
                            int fullFee = rsFee.getInt("fee_rs");

                            int completed = 0;
                            int due = 0;

                            // Get completed fees
                            String qCompleted = "SELECT SUM(submited_fee) FROM student_fee WHERE username='" + username + "' AND status='Completed'";
                            ResultSet rsCompleted = obj.stm.executeQuery(qCompleted);

                            if(rsCompleted.next())
                                completed = rsCompleted.getInt(1);

                            // Get due fees
                            String qDue = "SELECT SUM(submited_fee) FROM student_fee WHERE username='" + username + "' AND status='Due'";
                            ResultSet rsDue = obj.stm.executeQuery(qDue);

                            if(rsDue.next())
                                due = rsDue.getInt(1);

                            int remaining = fullFee - completed + due;

                            if(remaining < 0)
                                remaining = 0;

                            tf3.setText(String.valueOf(remaining));
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        revalidate();
        repaint();
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String class_name=ch1.getSelectedItem();
            String username=ch2.getSelectedItem();
            String name=tf1.getText();
            String email=tf2.getText();
            String total_fee=tf3.getText();
            String submit_fee=tf4.getText();
            String status=ch3.getSelectedItem();
            Random r=new Random();
            String fee_id=""+Math.abs(r.nextInt() % 100000);
            Date date=new Date();
            
            if (username == null || username.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Please select a username!");
                return;
            }
            else if (submit_fee.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Fee should not be empty!");
            }
            else if (Integer.parseInt(submit_fee) > Integer.parseInt(total_fee)) 
            {
                JOptionPane.showMessageDialog(null, "Submitted fee cannot be greater than total fee: " + total_fee);
            }
            else if (Integer.parseInt(submit_fee) == Integer.parseInt(total_fee) &&
                     status.equalsIgnoreCase("Due")) 
            {
                JOptionPane.showMessageDialog(null, "If fee is fully paid, status must be Complete — not Due!");
            }
            else 
            {
                try 
                {
                    ConnectionClass obj= new ConnectionClass();
                    String q="insert into student_fee values('"+fee_id+"', '"+class_name+"', '"+username+"', '"+name+"', '"+email+"', '"+total_fee+"', '"+submit_fee+"', '"+status+"', '"+date+"')";
                    obj.stm.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
                    this.setVisible(false);
                }
                catch (Exception ee) 
                {
                    ee.printStackTrace();
                }
            }
        }
        if (e.getSource()==bt2)
        {
            setVisible(false);
        }
    }
    
//    public static void main(String[] args) {
//        new AddFeeDetails().setVisible(true);
//    }
}