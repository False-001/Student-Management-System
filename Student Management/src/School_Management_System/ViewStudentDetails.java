package School_Management_System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewStudentDetails extends JFrame implements ActionListener
{
    String x[]={"Roll No", "Name", "Username", "Email", "Father Name", "Phone", "Blood", "Gender", "City", "Age", "Class", "DOB"};
    String y[][]=new String[30][12];
    int i=0,j=0;
    JTable t;
    Font f;
    String query;
    public static String pu, pa;
    Choice ch1;
    JButton bt1;
    JPanel p1, p2, p3;
    JLabel l1, l2;
    Font f1;

    ViewStudentDetails(String pub_username, String account2)
    {
        super("Student Details");
        setSize(1500, 500);
        setResizable(true);
        setLocation(1,1);
        f=new Font("MS UI Gothic", Font.BOLD, 15);
        
        pa=pub_username;
        pu=account2;
        
        System.out.println(pu +  "pub_username" + "Account type :" + pa);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            if(pa.equals("Student"))
            {
                query="select * from student where username='"+pu+"'";
            }
            else if(pa.equals("Admin"))
            {
                query="select * from student";
            }
            else if(pa.equals("Teacher"))
            {
                query="select * from student";
            }
            ResultSet rest=obj.stm.executeQuery(query);
            while(rest.next())
            {
                y[i][j++]=rest.getString("roll_no");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("username");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("father_name");
                y[i][j++]=rest.getString("phone");
                y[i][j++]=rest.getString("blood");
                y[i][j++]=rest.getString("gender");
                y[i][j++]=rest.getString("city");
                y[i][j++]=rest.getString("age");
                y[i][j++]=rest.getString("class");
                y[i][j++]=rest.getString("dob");
                i++;
                j=0;
            }
            
            t=new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
            if (pa.equals("Admin"))
            {
                f1 = new Font("Lucida Fax", Font.BOLD, 20);

                l1 = new JLabel("Delete any Student ?");
                l1.setForeground(Color.YELLOW);
                l1.setFont(f1);

                l2 = new JLabel("Student Username");
                l2.setForeground(Color.GRAY);
                l2.setFont(f1);

                ch1 = new Choice();
                ch1.add("Select Username");
                ch1.setFont(f1);

                ConnectionClass obj2 = new ConnectionClass();
                ResultSet rs2 = obj2.stm.executeQuery("SELECT username FROM student");

                while (rs2.next())
                {
                    ch1.add(rs2.getString("username"));
                }

                bt1 = new JButton("Delete Student");
                bt1.setFont(f1);
                bt1.setForeground(Color.RED);
                bt1.setBackground(Color.BLACK);
                bt1.addActionListener(this);

                p1 = new JPanel(new GridLayout(1,1));
                p1.add(l1);

                p2 = new JPanel(new GridLayout(1,3,10,10));
                p2.add(l2);
                p2.add(ch1);
                p2.add(bt1);

                p3 = new JPanel(new GridLayout(2,1));
                p3.add(p1);
                p3.add(p2);

                p1.setBackground(Color.BLACK);
                p2.setBackground(Color.BLACK);
                p3.setBackground(Color.BLACK);

                add(p3, BorderLayout.SOUTH);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t);
        add(sp);
    }
    public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == bt1)
            {
                String username = ch1.getSelectedItem();

                if (username.equals("Select Username"))
                {
                    JOptionPane.showMessageDialog(this, "Please select a student");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete student: " + username + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

                if (confirm != JOptionPane.YES_OPTION)
                    return;

                try
                {
                    ConnectionClass obj = new ConnectionClass();
                    String q = "DELETE FROM student WHERE username='" + username + "'";
                    int res = obj.stm.executeUpdate(q);

                    if (res == 1)
                    {
                        JOptionPane.showMessageDialog(this, "Student record deleted!");
                        setVisible(false);
                        new ViewStudentDetails(pu, pa).setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Student not found!");
                    }
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        
//    public static void main(String[] args) 
//    {
//        new ViewStudentDetails(pu, pa).setVisible(true);
//    }
}