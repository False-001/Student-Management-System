package School_Management_System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateClassDetails extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4;
    JPanel p1, p2, p3;
    JTextField tf1, tf2;
    Choice ch1, ch2;
    JButton bt1, bt2;
    
    UpdateClassDetails()
    {
        
        setTitle("Update Class Details");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(700, 320);
        setResizable(false);
        setLocation(550,200);
        setVisible(true);
        
        Font f = new Font("Arial", Font.BOLD, 28);
        Font f1 = new Font("Arial", Font.PLAIN, 18);
        
        ch1= new Choice();
        ch1.add("Select Class");
        
        try
        {
            ConnectionClass obj= new ConnectionClass();
            String q="select distinct class_name from class";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch1.add(rest.getString("class_name"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        l1=new JLabel("Update Class Details");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(new Color(176, 4, 21));
        l1.setFont(f);


        l2=new JLabel("Class Name");
        l2.setFont(f1);
        
        l3=new JLabel("Class Strength");
        l3.setFont(f1);
        
        l4=new JLabel("Enrolled Students");
        l4.setFont(f1);
        
        tf1=new JTextField();
        tf1.setFont(f1);
        
        tf2=new JTextField();
        tf2.setFont(f1);
        tf2.setEditable(false);
        
        bt1=new JButton("Update");
        bt1.setFont(f1);
        bt1.setForeground(Color.WHITE);
        bt1.setBackground(Color.RED);
        
        bt2=new JButton("Back");
        bt2.setFont(f1);
        bt2.setForeground(Color.WHITE);
        bt2.setBackground(Color.BLACK);
        

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(3, 2, 10, 10));
        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        
        p3=new JPanel();
        p3.add(bt1);
        p3.add(bt2);
        
        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "South");
        
        p2.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40)); 
        p3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        ch1.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                tf1.setText("");
                try
                {
                    ConnectionClass obj= new ConnectionClass();
                    String class_name=ch1.getSelectedItem();
                    String q = "select strength, enrolled from class where class_name='" + class_name + "'";
                    ResultSet rest=obj.stm.executeQuery(q);
                    while (rest.next())
                    {
                        tf1.setText(rest.getString("strength"));
                        tf2.setText(rest.getString("enrolled"));
                    }
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bt1)
        {
            String classname=ch1.getSelectedItem();
            String enrolled=tf1.getText();
            String enrolled_students=tf2.getText();
            
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q = "update class set strength='" + enrolled + "' where class_name='" + classname + "'";
                obj.stm.executeUpdate(q);
                int result = obj.stm.executeUpdate(q);
                if (result == 1)
                {
                    JOptionPane.showMessageDialog(null, "Class Details Successfully Updated");
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please Fill all the Details");
                    this.setVisible(false);
                    new UpdateClassDetails().setVisible(true);
                }
                setVisible(false);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(ae.getSource()==bt2)
        {
            setVisible(false);
        }
    }
    
//    public static void main(String[] args) 
//    {
//        new UpdateClassDetails().setVisible(true);
//    }
}