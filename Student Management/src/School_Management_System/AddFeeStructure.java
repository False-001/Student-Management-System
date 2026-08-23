package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;

public class AddFeeStructure extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4;
    Choice ch1;
    JTextField tf1;
    JButton bt1, bt2;
    
    AddFeeStructure()
    {
        setTitle("Add Fee Details");
        setSize(800, 560);
        setLocationRelativeTo(null);
        setLayout(null);

        // ---- Background ----
        ImageIcon img = new ImageIcon(getClass().getResource("/School_Management_System/Icons/feestructure.jpg"));
        Image scaledImg = img.getImage().getScaledInstance(800, 560, Image.SCALE_SMOOTH);
        JLabel bg = new JLabel(new ImageIcon(scaledImg));
        bg.setBounds(0, 0, 800, 560);
        add(bg);

        // ---- Transparent Panel on top of Background ----
        JPanel panel = new JPanel(null);
        panel.setBounds(200, 100, 400, 300);
        panel.setOpaque(false);
        bg.add(panel);

        // ---- Title ----
        l2 = new JLabel("Add Fee Structure");
        l2.setBounds(80, 0, 300, 40);
        l2.setFont(new Font("Arial", Font.BOLD, 22));
        l2.setForeground(Color.WHITE);
        panel.add(l2);

        // ---- Class Name ----
        l3 = new JLabel("Class Name:");
        l3.setBounds(30, 70, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 18));
        l3.setForeground(Color.WHITE);
        panel.add(l3);

        ch1 = new Choice();
        ch1.add("Select Grade");
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select distinct class_name from class";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                ch1.add(rest.getString("class_name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ch1.setBounds(200, 70, 150, 25);
        panel.add(ch1);

        // ---- Fee ----
        l4 = new JLabel("Fee/Year (Rs):");
        l4.setBounds(30, 120, 200, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 18));
        l4.setForeground(Color.WHITE);
        panel.add(l4);

        tf1 = new JTextField();
        tf1.setBounds(200, 120, 150, 30);
        tf1.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(tf1);

        // ---- Buttons ----
        bt1 = new JButton("Add Fee");
        bt1.setBounds(40, 200, 130, 40);
        bt1.setBackground(new Color(0, 0, 0));
        bt1.setForeground(Color.WHITE);
        bt1.setFont(new Font("Arial", Font.BOLD, 15));
        bt1.addActionListener(this);
        panel.add(bt1);

        bt2 = new JButton("Back");
        bt2.setBounds(210, 200, 130, 40);
        bt2.setBackground(new Color(88, 245, 174));
        bt2.setForeground(Color.BLACK);
        bt2.setFont(new Font("Arial", Font.BOLD, 15));
        bt2.addActionListener(this);
        panel.add(bt2);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String class_name=ch1.getSelectedItem();
            String fee_rs=tf1.getText();
            Random r=new Random();
            String fee_id=""+Math.abs(r.nextInt()%100000);
            
            if(fee_rs.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fee amount should not be an empty");
            }
            else if (Integer.parseInt(fee_rs)>12000)
            {
                JOptionPane.showMessageDialog(null, "Fee amount should not be greater than 12000 rs");
            }
            else if (Integer.parseInt(fee_rs)<10000)
            {
                JOptionPane.showMessageDialog(null, "Fee amount should not be lesser than 10000 rs");
            }
            else
            {
                try
                {
                    ConnectionClass obj=new ConnectionClass();
                    String q="insert into fee_structure values('"+fee_id+"','"+class_name+"','"+fee_rs+"')";
                    obj.stm.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Fee Details Successful Inserted");
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        if(e.getSource()==bt2)
        {
            setVisible(false);
        }
    }

//    public static void main(String[] args) {
//        new AddFeeStructure().setVisible(true);
//    }
}