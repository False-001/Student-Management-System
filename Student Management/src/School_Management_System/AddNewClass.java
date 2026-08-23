package School_Management_System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class AddNewClass extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5;
    JTextField tf1;
    Choice ch1, ch2, ch3;
    JButton bt1, bt2;
    
    AddNewClass()
    {
        setTitle("Add New Class Details");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(840, 600);
        setResizable(false);
        setLocation(550,200);
        setVisible(true);
        
        // Load background
        ImageIcon img = new ImageIcon(getClass().getResource("Icons/classadd.jpg"));
        Image scaledImg = img.getImage().getScaledInstance(840, 600, Image.SCALE_SMOOTH);
        JLabel bg1 = new JLabel(new ImageIcon(scaledImg));
        bg1.setBounds(0, 0, 840, 600);
        bg1.setLayout(null);
        add(bg1);
        
        l1= new JLabel("Add New Class Details");
        l1.setBounds(420, 110, 500, 50);
        l1.setFont(new Font("Ariel", Font.BOLD, 30));
        l1.setForeground(new Color(8, 161, 92));
        bg1.add(l1);
        
        l2=new JLabel("Class Name");
        l2.setBounds(400, 200, 150, 30);
        l2.setFont(new Font("Arial",Font.BOLD, 20));
        l2.setForeground(Color.BLACK);
        bg1.add(l2);
        
        ch1= new Choice();
        ch1.add("Select Grade");
        ch1.add("VIII");
        ch1.add("IX");
        ch1.add("X");
        ch1.add("IBDP-I");
        ch1.add("IBDP-II");
        ch1.add("AS-LEVEL");
        ch1.add("A-LEVEL");
        ch1.setBounds(600, 200, 150, 30);
        ch1.setFont(new Font("Arial",Font.BOLD, 20));
        bg1.add(ch1);
        
        l2=new JLabel("Class Strength");
        l2.setBounds(400, 250, 150, 30);
        l2.setFont(new Font("Arial",Font.BOLD, 20));
        l2.setForeground(Color.BLACK);
        bg1.add(l2);
        
        ch2= new Choice();
        ch2.add("5");
        ch2.add("10");
        ch2.add("15");
        ch2.add("20");
        ch2.setBounds(600, 250, 150, 30);
        ch2.setFont(new Font("Arial",Font.BOLD, 20));
        bg1.add(ch2);
        
        l3= new JLabel("Enrolled Students");
        l3.setBounds(400, 300, 150, 30);
        l3.setFont(new Font("Arial",Font.BOLD, 20));
        l3.setForeground(Color.BLACK);
        bg1.add(l3);
        
        tf1= new JTextField();
        tf1.setBounds(600, 300, 150, 30);
        tf1.setFont(new Font("Arial",Font.BOLD, 20));
        tf1.setEditable(false);
        tf1.setText("0");
        bg1.add(tf1);
        
        bt1=new JButton("Add Class");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(400, 350, 150, 40);
        bg1.add(bt1);
        
        bt2=new JButton("Back");
        bt2.setBackground(new Color(88, 245, 174));
        bt2.setForeground(Color.BLACK);
        bt2.setBounds(600, 350, 150, 40);
        bg1.add(bt2);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        //Force UI refresh and visibility
        revalidate();
        repaint();
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String classname=ch1.getSelectedItem();
            String enrolled_students=ch2.getSelectedItem();
            String enrolled=tf1.getText();
            Random r= new Random();
            String cla_id=""+Math.abs(r.nextInt() % 100000);
            
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="insert into class values('"+cla_id+"','"+classname+"','"+enrolled_students+"','"+enrolled+"')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
                setVisible(false);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
            setVisible(false);
        }
    }
//    public static void main(String[] args) 
//    {
//        new AddNewClass().setVisible(true);
//    }
}