package School_Management_System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class AddMarksDetails extends JFrame implements ActionListener
{
    
    JLabel l1, l2, l3, l4, l5, l6, l7;
    Choice ch1, ch2, ch3, ch4;
    JButton bt1, bt2;
    JTextField tf1, tf2;
    JPanel p1, p2;
    Font f, f1;
    
    AddMarksDetails()
    {
        super("Add Marks Detail");
        
        setSize(700, 480);
        setLocation(50, 10);
        setResizable(false);
        
        
        f=new Font("Arial", Font.BOLD,25);
        f1=new Font("Arial", Font.BOLD,18);
        
        ch1=new Choice();
        ch1.add("Select Grade");
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select distinct class from student";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch1.add(rest.getString("class"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        ch2=new Choice();
        ch2.add("Select Username");
        ch4=new Choice();
        ch4.add("Select Subject");
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select distinct subject_name from subject";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch4.add(rest.getString("subject_name"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        l1=new JLabel("Add Marks Details");
        l1.setForeground(Color.RED);
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        l2=new JLabel("Class Name");
        l3=new JLabel("Student Username");
        l4=new JLabel("Student Name");
        l5=new JLabel("Subject");
        l6=new JLabel("Marks");
        l7=new JLabel("Term");
        
        ch3=new Choice();
        ch3.add("Select Term");
        ch3.add("First Term");
        ch3.add("Second Term");
        ch3.add("Third Term");
        
        tf1=new JTextField();
        tf2=new JTextField();
        
        bt1=new JButton("Add Marks");
        bt1.setBackground(Color.RED);
        bt1.setForeground(Color.WHITE);
        
        bt2=new JButton("Back");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        ch1.addItemListener(new ItemListener() 
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        ConnectionClass obj = new ConnectionClass();
                        String class_name = ch1.getSelectedItem();
                        String q = "select username from student where class='" + class_name + "'";
                        ResultSet rest = obj.stm.executeQuery(q);
                        while (rest.next()) {
                            ch2.add(rest.getString("username"));
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
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        ConnectionClass obj = new ConnectionClass();
                        String class_name = ch1.getSelectedItem();
                        String username = ch2.getSelectedItem();
                        String q = "select name from student where class='" + class_name + "' and username='" + username + "'";
                        ResultSet rest = obj.stm.executeQuery(q);
                        if (rest.next()) {
                            tf1.setText(rest.getString("name"));
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(8,2,10,10));
        p2.add(l2);   // Class
        p2.add(ch1);

        p2.add(l3);   // Username
        p2.add(ch2);

        p2.add(l4);   // Student Name
        p2.add(tf1);

        p2.add(l5);   // Subject
        p2.add(ch4);

        p2.add(l6);   // Marks
        p2.add(tf2);

        p2.add(l7);   // Term
        p2.add(ch3);

        p2.add(bt1);  // Buttons
        p2.add(bt2);
        
        setLayout(new BorderLayout(10,10));
        add(p1, "North");
        add(p2, "Center");
        
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        l7.setFont(f);
        
        ch1.setFont(f1);
        ch2.setFont(f1);
        ch3.setFont(f1);
        ch4.setFont(f1);
        tf1.setFont(f1);
        tf2.setFont(f1);
        
        bt1.setFont(f);
        bt2.setFont(f);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String class_name=ch1.getSelectedItem();
            String name=tf1.getText();
            String username=ch2.getSelectedItem();
            String subject=ch4.getSelectedItem();
            String marks=tf2.getText();
            String term=ch3.getSelectedItem();
            Random r=new Random();
            String exam_id=""+Math.abs(r.nextInt() % 100000);
            
            if(marks.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Marks should not be empty");
            }
            else if(Integer.parseInt(marks)>500)
            {
                JOptionPane.showMessageDialog(null, "Marks should not be greater than 500");
            }
            else
            {
                try
                {
                    ConnectionClass obj1=new ConnectionClass();
                    String q = "insert into marks values('"+exam_id+"', '"+class_name+"', '"+username+"', '"+name+"', '"+subject+"', '"+marks+"', '"+term+"')";
                    obj1.stm.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                    setVisible(false);
                }
                catch(Exception ee)
                {
                    ee.printStackTrace();
                }
            }
        }
        if(e.getSource()==bt2)
        {
            setVisible(false);
        }
    }
//    public static void main(String[] args) 
//    {
//        new AddMarksDetails().setVisible(true);
//    }
}