package School_Management_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import javax.swing.*;

public class AddSubjectDetails extends JFrame implements ActionListener
{
    JLabel l1, l2, l3;
    JButton bt1, bt2;
    Choice ch1, ch2;
    
    AddSubjectDetails()
    {
        setTitle("Add New Subject Details");
        getContentPane().setBackground(Color.WHITE);
        
        setLocation(400,150);
        setSize(900, 600);
        
        ImageIcon img = new ImageIcon(getClass().getResource("/School_Management_System/Icons/addsubject.jpg"));
        Image scaledImg = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        JLabel bg1 = new JLabel(new ImageIcon(scaledImg));
        bg1.setBounds(0, 0, 900, 600);
        add(bg1);
        
        l1 = new JLabel("Add Subject Details", SwingConstants.CENTER);
        l1.setFont(new Font("Arial", Font.BOLD, 32));
        l1.setForeground(Color.BLACK);
        l1.setBounds(150, 80, 600, 50);
        bg1.add(l1);
        
        // Class Name
        l2 = new JLabel("Subject Code");
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setForeground(Color.BLACK);
        l2.setBounds(250, 220, 200, 35);
        bg1.add(l2);
        
        ch1=new Choice();
        ch1.add("Select Subject Code Offered");
        ch1.add("ECO");
        ch1.add("BM");
        ch1.add("GP");
        ch1.setBounds(480, 220, 200, 35);
        ch1.setFont(new Font("Arial", Font.BOLD, 22));
        bg1.add(ch1);
        
        l3=new JLabel("Subject Name");
        l3.setBounds(250, 280, 200, 35);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l3.setForeground(Color.BLACK);
        bg1.add(l3);
        
        ch2=new Choice();
        ch2.add("Economics");
        ch2.add("Business Managment");
        ch2.add("Global Politics");
        ch2.setBounds(480, 280, 200, 35);
        ch2.setFont(new Font("Arial", Font.BOLD, 22));
        ch2.setEnabled(false);
        bg1.add(ch2);
        
        bt1=new JButton("Add Subject Details");
        bt1.setBounds(200, 350, 200, 35);
        bt1.setForeground(Color.WHITE);
        bt1.setBackground(Color.BLACK);
        bt1.addActionListener(this);
        bg1.add(bt1);
        
        bt2=new JButton("Back");
        bt2.setBounds(480, 350, 200, 35);
        bt2.setForeground(Color.BLACK);
        bt2.setBackground(new Color(88,245,174));
        bt2.addActionListener(this);
        bg1.add(bt2);
        
        
        ch1.addItemListener(new ItemListener() 
        {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                    ch2.removeAll(); // clear old items

                    String code = ch1.getSelectedItem();

                    if (code.equals("ECO")) {
                        ch2.add("Economics");
                    }
                    else if (code.equals("BM")) {
                        ch2.add("Business Management");
                    }
                    else if (code.equals("GP")) {
                        ch2.add("Global Politics");
                    }
                    else if(code.equals("Select Subject Code Offered")){
                        ch2.add("");
                    }
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            Random r=new Random();
            String sub_id=""+Math.abs(r.nextInt() % 100000);
            String sub_code=ch1.getSelectedItem();
            String sub_name=ch2.getSelectedItem();
            
            if(sub_name == null || sub_name.isEmpty()){
                JOptionPane.showMessageDialog(null, "Select Subject Details Before Inserting!");
                return;
            }
            else if (sub_code==null||sub_code.isEmpty()){
                JOptionPane.showMessageDialog(null, "Select Proper Subject Details Before Inserting!");
                return;
            }
            else if (sub_code != null && sub_name.isEmpty()==false);
            {
                try
                {
                    ConnectionClass obj=new ConnectionClass();
                    String q="insert into subject values('"+sub_id+"','"+sub_code+"', '"+sub_name+"')";
                    obj.stm.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Subject Details Successfully Inserted");
                    setVisible(false);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        else if(e.getSource()==bt2)
        {
            setVisible(false);
        }
    }    
}
    
//    public static void main(String[] args)
//    {
//        new AddSubjectDetails().setVisible(true);
//    }