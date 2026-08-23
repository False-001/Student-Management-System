package School_Management_System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudentDetails extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
    JPanel p1, p2, p3;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11;
    Choice ch1;
    JButton bt1, bt2;
    public String pubu, account2;
    
    UpdateStudentDetails(String account, String username)
    {
        super("Update Student Details");
        setSize(760, 720);
        setLocation(550,200);
        setVisible(true);
        account2=account;
        pubu=username;
        
        Font f = new Font("Arial", Font.BOLD, 28);
        Font f1 = new Font("Arial", Font.PLAIN, 18);
        
        ch1=new Choice();
        ch1.setFont(f1);
        ch1.add("Select Username");
        
        try
        {
            ConnectionClass obj= new ConnectionClass();
            String q;
            q="";
            if (account.equals("Admin"))
            {
                q="select username from student";
            }
            else if (account.equals("Teacher"))
            {
                q="select username from student";
            }
            else if(account.equals("Student"))
            {
                q="select username from student where username='"+username+"'";
            }
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch1.add(rest.getString("username"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        l1 = new JLabel("Update Student Details");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(new Color(176, 4, 21));
        l1.setFont(f);
        
        l2 = new JLabel("Username");
        l3 = new JLabel("Roll No");
        l4 = new JLabel("Name");
        l5 = new JLabel("Email");
        l6 = new JLabel("Father Name");
        l7 = new JLabel("Phone");
        l8 = new JLabel("Class");
        l9 = new JLabel("Gender");
        l10 = new JLabel("Blood");
        l11 = new JLabel("Age");
        l12 = new JLabel("DOB");
        l13 = new JLabel("City");
        
        
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l12.setFont(f1);
        l13.setFont(f1);
        
        l2.setForeground(Color.DARK_GRAY);
        
        tf1=new JTextField();
        tf1.setFont(f1);
        tf1.setEditable(false);
        tf2=new JTextField();
        tf2.setFont(f1);
        tf3=new JTextField();
        tf3.setEditable(false);
        tf3.setFont(f1);
        tf4=new JTextField();
        tf4.setFont(f1);
        tf5=new JTextField();
        tf5.setFont(f1);
        tf6=new JTextField();
        tf6.setFont(f1);
        tf7=new JTextField();
        tf7.setFont(f1);
        tf8=new JTextField();
        tf8.setFont(f1);
        tf9=new JTextField();
        tf9.setFont(f1);
        tf10=new JTextField();
        tf10.setFont(f1);
        tf11=new JTextField();
        tf11.setFont(f1);
        
        bt1=new JButton("Update Student");
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
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(12, 2, 10, 10));
        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(l8);
        p2.add(tf6);
        p2.add(l9);
        p2.add(tf7);
        p2.add(l10);
        p2.add(tf8);
        p2.add(l11);
        p2.add(tf9);
        p2.add(l12);
        p2.add(tf10);
        
        p3=new JPanel();
        p3.add(bt1);
        p3.add(bt2);
        
        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "South");
        
        p2.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40)); 
        p3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        ch1.addItemListener(new ItemListener() 
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED) 
                {
                    try
                    {
                        ConnectionClass obj= new ConnectionClass();
                        String username=ch1.getSelectedItem();
                        String q = "select roll_no, name, email, father_name, phone, city, gender, blood, age, dob, class from student where username='" + username + "'";
                        ResultSet rest=obj.stm.executeQuery(q);
                        while (rest.next())
                        {
                            tf1.setText(rest.getString("roll_no"));
                            tf2.setText(rest.getString("name"));
                            tf3.setText(rest.getString("email"));
                            tf4.setText(rest.getString("father_name"));
                            tf5.setText(rest.getString("phone"));
                            tf6.setText(rest.getString("class"));
                            tf7.setText(rest.getString("gender"));
                            tf8.setText(rest.getString("blood"));
                            tf9.setText(rest.getString("age"));
                            tf10.setText(rest.getString("dob"));
                            tf11.setText(rest.getString("city"));
                        }
                    }
                    catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
            if(ae.getSource()==bt1)
        {
            String username=ch1.getSelectedItem();
            String name=tf2.getText();
            String email=tf3.getText();
            String father_name=tf4.getText();
            String phone=tf5.getText();
            String city=tf11.getText();
            String gender=tf7.getText();
            String blood_group=tf8.getText();
            String age=tf9.getText();
            String dob=tf10.getText();
            
            
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q = "update student set name='"+name+"', email='"+email+"', father_name='"+father_name+"', phone='"+phone+"', city='"+city+"', gender='"+gender+"', blood='"+blood_group+"', age='"+age+"', dob='"+dob+"' where username='"+username+"'";
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
//        new UpdateStudentDetails("account2", "pubu").setVisible(true);
//    }
}