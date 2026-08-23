package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TeacherHomePage extends JFrame implements ActionListener {
    JLabel l5;
    Font f, f1;
    public String id, account2, pub_username, classe;

    TeacherHomePage(String username, String account) {
        account2 = account;
        pub_username=username;
        this.setTitle("School Management System TEACHER HOME PAGE");
        setLocation(0, 0);
        setSize(2000, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        f = new Font("Arial", Font.BOLD, 20);
        f1 = new Font("Arial", Font.BOLD, 18);

        // Load background
        ImageIcon img = new ImageIcon(getClass().getResource("/School_Management_System/Icons/teacherhome.jpg"));
        Image scaledImg = img.getImage().getScaledInstance(2000, 1050, Image.SCALE_SMOOTH);
        JLabel bg1 = new JLabel(new ImageIcon(scaledImg));
        bg1.setBounds(0, 0, 2000, 1050);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 2000, 1200);
        layeredPane.add(bg1, Integer.valueOf(0));

        getContentPane().add(layeredPane);

        // Menu bar setup
        JMenuBar m1 = new JMenuBar();
        setJMenuBar(m1);
        m1.setBackground(Color.black.darker());

        setVisible(true);
        
        //menu buttons extender
        JMenu menu1 = new JMenu("Teacher Profile");
        JMenu menu2 = new JMenu("Student Profile");
        JMenu menu3 = new JMenu("Marks Details");
        JMenu menu4 = new JMenu("Result");
        JMenu menu5 = new JMenu("Logout");
        
        // teacher menu items
        JMenuItem ment1 = new JMenuItem("Update Teacher Details");
        JMenuItem ment2 = new JMenuItem("View Teacher Details");

        // student menu items
        JMenuItem ment3 = new JMenuItem("Update Student Details");
        JMenuItem ment4 = new JMenuItem("View Student Details");
        
        // marks mark items
        JMenuItem ment5 = new JMenuItem("Add Mark Subject");
        JMenuItem ment8 = new JMenuItem("View Mark Details");
        
        // result menu items
        JMenuItem ment6 = new JMenuItem("Show Results");
        
        // logout menu items
        JMenuItem ment7 = new JMenuItem("Exit");
        
        //add buttons to menus
        menu1.add(ment1);
        menu1.add(ment2);
        menu2.add(ment3);
        menu2.add(ment4);
        menu3.add(ment5);
        menu4.add(ment6);
        menu5.add(ment7);
        
        // add menus to menubar
        m1.add(menu1);
        m1.add(menu2);
        m1.add(menu3);
        m1.add(menu4);
        m1.add(menu5);
        
         //menu items customization
        menu1.setFont(f);
        menu2.setFont(f);
        menu3.setFont(f);
        menu4.setFont(f);
        menu5.setFont(f);

        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);
        ment5.setFont(f1);
        ment6.setFont(f1);
        ment7.setFont(f1);

        menu1.setForeground(Color.GRAY);
        menu2.setForeground(Color.GRAY);
        menu3.setForeground(Color.GRAY);
        menu4.setForeground(Color.GRAY);
        menu5.setForeground(Color.RED);

        ment1.setForeground(Color.ORANGE);
        ment2.setForeground(Color.ORANGE);
        ment3.setForeground(Color.ORANGE);
        ment4.setForeground(Color.ORANGE);
        ment5.setForeground(Color.ORANGE);
        ment6.setForeground(Color.ORANGE);
        ment7.setForeground(Color.RED);

        ment1.setBackground(Color.BLACK);
        ment2.setBackground(Color.BLACK);
        ment3.setBackground(Color.BLACK);
        ment4.setBackground(Color.BLACK);
        ment5.setBackground(Color.BLACK);
        ment6.setBackground(Color.BLACK);
        ment7.setBackground(Color.BLACK);
        
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        ment7.addActionListener(this);
        
        setJMenuBar(m1);
        
    }
       
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String comnd = ae.getActionCommand();
        if (comnd.equals("Update Teacher Details"))
        {
            System.out.println("Update Teacher Details class open");
            new UpdateTeacherDetails(account2, pub_username).setVisible(true);
        }
        else if (comnd.equals("View Teacher Details"))
        {
//            System.out.println("View Teacher Details class open");
            new ViewTeacherDetails(account2, pub_username).setVisible(true);
        }
        else if (comnd.equals("Update Student Details"))
        {
//            System.out.println("Update Student Details class open");
            new UpdateStudentDetails(account2, pub_username).setVisible(true);
        }
        else if (comnd.equals("View Student Details"))
        {
//            System.out.println("View Student Details class open");
            new ViewStudentDetails(account2, pub_username).setVisible(true);
        }
        else if (comnd.equals("Update Class Details"))
        {
//            System.out.println("Update Class Details class open");
            new UpdateClassDetails().setVisible(true);
        }
        else if (comnd.equals("Add Mark Subject"))
        {
//            System.out.println("Add Mark Subject class open");
            new AddMarksDetails().setVisible(true);
        }
        else if (comnd.equals("Show Results"))
        {
//            System.out.println("Show Results class open");
            new ShowResult(pub_username, account2).setVisible(true);
        }
        else if (comnd.equals("Exit"))
        {
            System.out.println("You are Logged Out");
            this.setVisible(false);
            new LoginPage();
        }
    }
//     public static void main (String[] args) {
//        new TeacherHomePage("account2", "pub_username").setVisible(true);
//    }       
}