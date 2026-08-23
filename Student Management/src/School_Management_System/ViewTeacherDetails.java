package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewTeacherDetails extends JFrame implements ActionListener
{
    String x[] = {"Name", "Username", "Email", "Phone", "Blood Group", "Gender", "City", "Age", "DOB"};
    String y[][] = new String[30][9];
    int i=0, j=0;
    JTable t;
    Font f, f1;
    JLabel l1, l2;
    JButton bt1;
    JPanel p1, p2, p3;
    Choice ch1;
    
    ViewTeacherDetails(String account, String username)
    {
        super("Teacher Information");
        setSize(1500,550);
        setResizable(false);
        setLocation(200,200);
        f= new Font("Arial",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q;
            if (account.equals("Admin")) {
                q = "SELECT * FROM teacher";
            } else {
                q = "SELECT * FROM teacher WHERE username='" + username + "'";
            }
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("name");
                y[i][j++] = rest.getString("username");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("phone");
                y[i][j++]=rest.getString("blood_group");
                y[i][j++]=rest.getString("gender");
                y[i][j++]=rest.getString("city");
                y[i][j++]=rest.getString("age");
                y[i][j++]=rest.getString("dob");
                i++;
                j=0;
            }
            t= new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
            JScrollPane sp=new JScrollPane(t);
            if (account.equals("Admin"))
            {
                f1=new Font("Lucida Fax",Font.BOLD,25);
                
                l1=new JLabel("Delete any Teacher ?");
                l1.setForeground(Color.YELLOW);
                l1.setFont(f1);
                
                l2=new JLabel("Teacher Username");
                l2.setBackground(Color.BLACK);
                l2.setForeground(Color.GRAY);
                l2.setFont(f1);
                
                ch1 = new Choice();
                ch1.add("Select Username");
                ch1.setSize(100, 100);
                ch1.setFont(f1);
                ConnectionClass obj2 = new ConnectionClass();
                ResultSet rs2 = obj2.stm.executeQuery("SELECT username FROM teacher");

                while (rs2.next()) {
                    ch1.add(rs2.getString("username"));
                }
                
                bt1=new JButton("Delete Teacher");
                bt1.addActionListener(this);
                bt1.setBackground(Color.BLACK);
                bt1.setForeground(Color.RED);
                bt1.setFont(f1);
                
                p1=new JPanel();
                p1.setLayout(new GridLayout(1, 1, 10, 10));
                p1.add(l1);
                
                p2=new JPanel();
                p2.setLayout(new GridLayout(1, 3, 10, 10));
                p2.add(l2);
                p2.add(ch1);
                p2.add(bt1);
                
                p3=new JPanel();
                p3.setLayout(new GridLayout(2, 1, 10, 10));
                p3.add(p1);
                p3.add(p2);
                
                p1.setBackground(Color.BLACK);
                p2.setBackground(Color.BLACK);
                p3.setBackground(Color.BLACK);
                add(p3, "South");
            }
            add (sp);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == bt1)
        {
            String username = ch1.getSelectedItem();

            // ✅ CONFIRMATION MUST COME HERE
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete teacher: " + username + "?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm != JOptionPane.YES_OPTION)
            {
                return; // stop deletion
            }

            try
            {
                ConnectionClass obj = new ConnectionClass();
                String q = "DELETE FROM teacher WHERE username='" + username + "'";
                int res = obj.stm.executeUpdate(q);

                if (res == 1)
                {
                    JOptionPane.showMessageDialog(this, "Teacher record is deleted!");
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Teacher record does not match!");
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
//        new ViewTeacherDetails("account", "username").setVisible(true);
//    }
}