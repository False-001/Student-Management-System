package School_Management_System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewFeeDetails extends JFrame
{
    String x[]={"Id", "Class Name", "Username", "Name", "Email", "Total Fee", "Submitted Fee", "Status", "Date"};
    String y[][]=new String [21][9];
    int i=0,j=0;
    JTable t;
    String query;
    public static String pu, pa;
    Choice ch1;
    JButton bt1;
    JPanel p1, p2, p3;
    JLabel l1, l2;
    Font f, f1;
    
    ViewFeeDetails(String pub_username, String account2)
    {
        
        super("Fee Information");
        setSize(1500, 400);
        setResizable(false);
        setLocation(1,1);
        f=new Font("MS UI Gothic", Font.BOLD, 15);
        
        pu=pub_username;
        pa=account2;
        try
        {
            ConnectionClass obj=new ConnectionClass();
            if(pa.equals("Student"))
            {
                query="select * from student_fee where username='"+pu+"'";
            }
            else if(pa.equals("Admin"))
            {
                query="select * from student_fee";
            }
            ResultSet rest=obj.stm.executeQuery(query);
            while(rest.next())
            {
                y[i][j++]=rest.getString("fee_id");
                y[i][j++]=rest.getString("class_name");
                y[i][j++]=rest.getString("username");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("total_fee");
                y[i][j++]=rest.getString("submited_fee");
                y[i][j++]=rest.getString("status");
                y[i][j++]=rest.getString("date");
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

                l1 = new JLabel("Delete Fee Record ?");
                l1.setForeground(Color.YELLOW);
                l1.setFont(f1);

                l2 = new JLabel("Fee ID");
                l2.setForeground(Color.GRAY);
                l2.setFont(f1);

                ch1 = new Choice();
                ch1.add("Select Fee ID");
                ch1.setFont(f1);

                ConnectionClass obj2 = new ConnectionClass();
                ResultSet rs2 = obj2.stm.executeQuery("SELECT fee_id FROM student_fee");

                while(rs2.next())
                {
                    ch1.add(rs2.getString("fee_id"));
                }

                bt1 = new JButton("Delete Fee");
                bt1.setFont(f1);
                bt1.setForeground(Color.RED);
                bt1.setBackground(Color.BLACK);

                bt1.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        String fee_id = ch1.getSelectedItem();

                        if(fee_id.equals("Select Fee ID"))
                        {
                            JOptionPane.showMessageDialog(null,"Please select a record");
                            return;
                        }

                        int confirm = JOptionPane.showConfirmDialog(null,
                                "Delete Fee Record ID: "+fee_id+" ?",
                                "Confirm Delete",
                                JOptionPane.YES_NO_OPTION);

                        if(confirm != JOptionPane.YES_OPTION)
                            return;

                        try
                        {
                            ConnectionClass obj3 = new ConnectionClass();
                            String q = "DELETE FROM student_fee WHERE fee_id='"+fee_id+"'";
                            int res = obj3.stm.executeUpdate(q);

                            if(res == 1)
                            {
                                JOptionPane.showMessageDialog(null,"Fee record deleted!");
                                setVisible(false);
                                new ViewFeeDetails(pu,pa).setVisible(true);
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
        JScrollPane sp = new JScrollPane(t);
        add(sp);
    }
//    public static void main(String[] args) 
//    {
//        new ViewFeeDetails(pu, pa).setVisible(true);
//    }
}