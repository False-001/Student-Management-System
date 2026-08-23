package School_Management_System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ShowResult extends JFrame implements ActionListener, ItemListener
{
    JButton bt1, bt2;
    JLabel l1, l2;
    JTextArea ta;
    Choice ch1, ch2;
    JPanel p1;
    Font f;
    String q;
    public static String pu, pa;

    ShowResult(String pub_username, String account2)
    {
        super("Generate Result");

        setSize(500,500);
        setLocation(100,100);
        setResizable(false);

        f = new Font("Arial", Font.BOLD, 16);

        pu = pub_username;
        pa = account2;

        l1 = new JLabel("Class");
        l1.setFont(f);

        ch1 = new Choice();
        ch1.add("Select Grade");

        l2 = new JLabel("Username");
        l2.setFont(f);

        ch2 = new Choice();
        ch2.add("Select Username");

        try
        {
            ConnectionClass obj = new ConnectionClass();

            if(pa.equals("Admin") || pa.equals("Teacher"))
            {
                q = "select distinct class_name from marks";
                ResultSet rest = obj.stm.executeQuery(q);

                while(rest.next())
                {
                    ch1.add(rest.getString("class_name"));
                }
            }
            else if(pa.equals("Student"))
            {
                q = "select class_name from student where username='"+pu+"'";
                ResultSet rest = obj.stm.executeQuery(q);

                while(rest.next())
                {
                    ch1.add(rest.getString("class_name"));
                }
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        ch1.setFont(f);
        ch2.setFont(f);

        // IMPORTANT: add listener to detect class change
        ch1.addItemListener(this);

        bt1 = new JButton("Show");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.addActionListener(this);

        bt2 = new JButton("Print PDF");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt2.addActionListener(this);

        ta = new JTextArea();
        ta.setFont(f);
        ta.setEditable(false);

        JScrollPane sp = new JScrollPane(ta);

        ta.setText("----------------------------------SCHOOL RESULT----------------------------------");

        p1 = new JPanel();
        p1.setLayout(new GridLayout(4,2,10,10));

        p1.add(l1);
        p1.add(ch1);
        p1.add(l2);
        p1.add(ch2);
        p1.add(bt1);
        p1.add(bt2);

        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);
        add(p1, BorderLayout.SOUTH);
    }

    // THIS METHOD RUNS WHEN CLASS IS SELECTED
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getSource() == ch1)
        {
            ch2.removeAll();
            ch2.add("Select Username");

            String grade = ch1.getSelectedItem();

            try
            {
                ConnectionClass obj = new ConnectionClass();

                if(pa.equals("Admin") || pa.equals("Teacher"))
                {
                    q = "select distinct username from marks where class_name='"+grade+"'";
                    ResultSet rest = obj.stm.executeQuery(q);

                    while(rest.next())
                    {
                        ch2.add(rest.getString("username"));
                    }
                }
                else if(pa.equals("Student"))
                {
                    q = "select username from marks where username='"+pu+"' and class_name='"+grade+"'";
                    ResultSet rest = obj.stm.executeQuery(q);

                    while(rest.next())
                    {
                        ch2.add(rest.getString("username"));
                    }
                }

            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        int total = 0;

        if(e.getSource() == bt1)
        {
            ta.setText("----------------------------------SCHOOL RESULT----------------------------------");

            try
            {
                ConnectionClass obj = new ConnectionClass();

                String class_name = ch1.getSelectedItem();
                String username = ch2.getSelectedItem();

                q = "select * from marks where class_name='"+class_name+"' and username='"+username+"'";
                ResultSet rest1 = obj.stm.executeQuery(q);

                while(rest1.next())
                {
                    ta.append("\n\nStudent Name : " + rest1.getString("name"));
                    ta.append("\nTerm : " + rest1.getString("term"));
                    ta.append("\n-----------------------------------");

                    ta.append("\n" + rest1.getString("subject_name") + " : " + rest1.getString("marks"));

                    total = Integer.parseInt(rest1.getString("marks")) + total;
                }

                float percentage = (total * 100f) / 300f;

                ta.append("\n-----------------------------------");
                ta.append("\nTotal Marks : " + total);
                ta.append("\nPercentage : " + percentage + "%");
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }

        if(e.getSource() == bt2)
        {
            JOptionPane.showMessageDialog(this, "PDF Printing to be added in the future upgrade");
        }
    }
}