package School_Management_System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewMarksDetails extends JFrame
{
    String x[]={"Id", "Class Name", "Username", "Name", "Subject Name", "Marks", "Terms"};
    String y[][]=new String [21][7];
    int i=0,j=0;
    JTable t;
    String query;
    public static String pu, pa;
    Choice ch1;
    JButton bt1;
    JPanel p1, p2, p3;
    JLabel l1, l2;
    Font f, f1;
    
    ViewMarksDetails(String pub_username, String account2)
    {
        super("Marks Details");
        setSize(1500,400);
        setResizable(false);
        setLocation(1,1);
        
        f=new Font("Arial",Font.BOLD,15);
        
        pu=pub_username;
        pa=account2;
        String account= pa;
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            if(account.equals("Student"))
            {
                query="select * from marks where username='"+pu+"'";
            }
            else
            {
                query="select * from marks";  
            }
            ResultSet rest=obj.stm.executeQuery(query);
            while(rest.next())
            {
                y[i][j++] = rest.getString("exam_id");
                y[i][j++] = rest.getString("class_name");
                y[i][j++] = rest.getString("username");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("subject_name"); 
                y[i][j++] = rest.getString("marks");
                y[i][j++] = rest.getString("term");
                i++;
                j=0;
            }
            t=new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
            if(pa.equals("Admin"))
            {
                f1 = new Font("Lucida Fax", Font.BOLD, 20);

                l1 = new JLabel("Delete Marks Record ?");
                l1.setForeground(Color.YELLOW);
                l1.setFont(f1);

                l2 = new JLabel("Exam ID");
                l2.setForeground(Color.GRAY);
                l2.setFont(f1);

                ch1 = new Choice();
                ch1.add("Select Exam ID");
                ch1.setFont(f1);

                ConnectionClass obj2 = new ConnectionClass();
                ResultSet rs2 = obj2.stm.executeQuery("SELECT exam_id FROM marks");

                while(rs2.next())
                {
                    ch1.add(rs2.getString("exam_id"));
                }

                bt1 = new JButton("Delete Marks");
                bt1.setFont(f1);
                bt1.setForeground(Color.RED);
                bt1.setBackground(Color.BLACK);

                bt1.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        String exam_id = ch1.getSelectedItem();

                        if(exam_id.equals("Select Exam ID"))
                        {
                            JOptionPane.showMessageDialog(null,"Please select a record");
                            return;
                        }

                        int confirm = JOptionPane.showConfirmDialog(null,
                                "Delete record ID: "+exam_id+" ?",
                                "Confirm Delete",
                                JOptionPane.YES_NO_OPTION);

                        if(confirm != JOptionPane.YES_OPTION)
                            return;

                        try
                        {
                            ConnectionClass obj3 = new ConnectionClass();
                            String q = "DELETE FROM marks WHERE exam_id='"+exam_id+"'";
                            int res = obj3.stm.executeUpdate(q);

                            if(res==1)
                            {
                                JOptionPane.showMessageDialog(null,"Marks record deleted");
                                setVisible(false);
                                new ViewMarksDetails(pu,pa).setVisible(true);
                            }
                        }
                        catch(Exception ex)
                        {
                            ex.printStackTrace();
                        }
                    }
                });

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
        
        JScrollPane sp=new JScrollPane(t);
        add (sp);
    }
//    public static void main(String[] args) 
//    {
//        new ViewMarksDetails(pu, pa).setVisible(true);
//    }
}