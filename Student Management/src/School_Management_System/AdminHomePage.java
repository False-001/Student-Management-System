package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AdminHomePage extends JFrame implements ActionListener {
    Font f, f1;
    public String id, account2, pub_username;

    AdminHomePage(String account, String username) 
    {
        account2 = account;
        pub_username=username;
        
        this.setTitle("School Management System ADMIN HOME PAGE");
        setLocation(0, 0);
        setSize(2000, 1050);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        f = new Font("Arial", Font.BOLD, 20);
        f1 = new Font("Arial", Font.BOLD, 18);
        
        // Load image
        ImageIcon img = new ImageIcon(getClass().getResource("/School_Management_System/Icons/adminhome.jpg"));
        Image scaledImg = img.getImage().getScaledInstance(2000, 1050, Image.SCALE_SMOOTH);
        
        // Set background label
        JLabel bg1 = new JLabel(new ImageIcon(scaledImg));
        bg1.setBounds(0, 0, 2000, 1050);

        // Add background first
        getContentPane().add(bg1);

        // Optional: add layered panel on top
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 2000, 1200);
        layeredPane.setOpaque(false);
        getContentPane().add(layeredPane);

        JMenuBar m1 = new JMenuBar();
        m1.setBackground(Color.black.darker());
        
        //menu buttons extender
        JMenu menu1 = new JMenu("Teacher Profile");
        JMenu menu2 = new JMenu("Student Profile");
        JMenu menu3 = new JMenu("Class Details");
        JMenu menu4 = new JMenu("Subject Details");
        JMenu menu5 = new JMenu("Marks Details");
        JMenu menu6 = new JMenu("Fee Details");
        JMenu menu7 = new JMenu("Result");
        JMenu menu8 = new JMenu("Logout");

        // teacher menu items
        JMenuItem ment1 = new JMenuItem("Add Teacher Details");
        JMenuItem ment2 = new JMenuItem("Update Teacher Details");
        JMenuItem ment3 = new JMenuItem("View Teacher Details");

        // student menu items
        JMenuItem ment4 = new JMenuItem("Add Student Details");
        JMenuItem ment5 = new JMenuItem("Update Student Details");
        JMenuItem ment6 = new JMenuItem("View Student Details");

        // class menu items
        JMenuItem ment7 = new JMenuItem("Add Class Details");
        JMenuItem ment8 = new JMenuItem("Update Class Details");

        
        // subject menu items
        JMenuItem ment9 = new JMenuItem("Add Subject Details");
        
        // marks mark items
        JMenuItem ment10 = new JMenuItem("Add Marks");
        JMenuItem ment11 = new JMenuItem("View Marks");
        
        // fee menu items
        JMenuItem ment12 = new JMenuItem("Add Fee Details");
        JMenuItem ment13 = new JMenuItem("Add Fee Structure");
        JMenuItem ment14 = new JMenuItem("View Fee Details");
        
        // result menu items
        JMenuItem ment15 = new JMenuItem("Show Results");
        
        // logout menu items
        JMenuItem ment16 = new JMenuItem("Exit");

        // add items to menu1 Teacher Profile
        menu1.add(ment1);
        menu1.add(ment2);
        menu1.add(ment3);
        
        // add items to menu2 Student Profile
        menu2.add(ment4);
        menu2.add(ment5);
        menu2.add(ment6);
        
        // add items to menu3 Classes
        menu3.add(ment7);
        menu3.add(ment8);
        
        // add items to menu4 Subject Details
        menu4.add(ment9);
        
        // add items to menu5 Marks
        menu5.add(ment10);
        menu5.add(ment11);
        
        // add items to menu6 Fee Details
        menu6.add(ment12);
        menu6.add(ment13);
        menu6.add(ment14);
        
        // add items to menu7 Results
        menu7.add(ment15);
        
        // add items to menu8 Logout
        menu8.add(ment16);

        // add menus to menubar
        m1.add(menu1);
        m1.add(menu2);
        m1.add(menu3);
        m1.add(menu4);
        m1.add(menu5);
        m1.add(menu6);
        m1.add(menu7);
        m1.add(menu8);
        
        //menu 
        menu1.setFont(f);
        menu2.setFont(f);
        menu3.setFont(f);
        menu4.setFont(f);
        menu5.setFont(f);
        menu6.setFont(f);
        menu7.setFont(f);
        menu8.setFont(f);
        
        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);
        ment5.setFont(f1);
        ment6.setFont(f1);
        ment7.setFont(f1);
        ment8.setFont(f1);
        ment9.setFont(f1);
        ment10.setFont(f1);
        ment11.setFont(f1);
        ment12.setFont(f1);
        ment13.setFont(f1);
        ment14.setFont(f1);
        ment15.setFont(f1);
        ment16.setFont(f1);
        
        menu1.setForeground(Color.GRAY);
        menu2.setForeground(Color.GRAY);
        menu3.setForeground(Color.GRAY);
        menu4.setForeground(Color.GRAY);
        menu5.setForeground(Color.GRAY);
        menu6.setForeground(Color.GRAY);
        menu7.setForeground(Color.GRAY);
        menu8.setForeground(Color.RED);
        
        ment1.setForeground(Color.ORANGE);
        ment2.setForeground(Color.ORANGE);
        ment3.setForeground(Color.ORANGE);
        ment4.setForeground(Color.ORANGE);
        ment5.setForeground(Color.ORANGE);
        ment6.setForeground(Color.ORANGE);
        ment7.setForeground(Color.ORANGE);
        ment8.setForeground(Color.ORANGE);
        ment9.setForeground(Color.ORANGE);
        ment10.setForeground(Color.ORANGE);
        ment11.setForeground(Color.ORANGE);
        ment12.setForeground(Color.ORANGE);
        ment13.setForeground(Color.ORANGE);
        ment14.setForeground(Color.ORANGE);
        ment15.setForeground(Color.ORANGE);
        ment16.setForeground(Color.RED);
        
        ment1.setBackground(Color.BLACK);
        ment2.setBackground(Color.BLACK);
        ment3.setBackground(Color.BLACK);
        ment4.setBackground(Color.BLACK);
        ment5.setBackground(Color.BLACK);
        ment6.setBackground(Color.BLACK);
        ment7.setBackground(Color.BLACK);
        ment8.setBackground(Color.BLACK);
        ment9.setBackground(Color.BLACK);
        ment10.setBackground(Color.BLACK);
        ment11.setBackground(Color.BLACK);
        ment12.setBackground(Color.BLACK);
        ment13.setBackground(Color.BLACK);
        ment14.setBackground(Color.BLACK);
        ment15.setBackground(Color.BLACK);
        ment16.setBackground(Color.BLACK);
        
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        ment7.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment11.addActionListener(this);
        ment12.addActionListener(this);
        ment13.addActionListener(this);
        ment14.addActionListener(this);
        ment15.addActionListener(this);
        ment16.addActionListener(this);
        
        
        setJMenuBar(m1);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String comnd=ae.getActionCommand();
        if (comnd.equals("Add Teacher Details"))
        {
//            System.out.println("Add Teacher Details class open");
            new AddTeacherDetails().setVisible(true);
        }
        else if (comnd.equals("Update Teacher Details"))
        {
//            System.out.println("Update Teacher Details class open");
            new UpdateTeacherDetails(account2, pub_username).setVisible(true);
        }
        else if (comnd.equals("View Teacher Details"))
        {
//            System.out.println("View Teacher Details class open");
            new ViewTeacherDetails(account2, pub_username).setVisible(true);
        }
        else if (comnd.equals("Add Student Details"))
        {
//            System.out.println("Add Student Details class open");
            new AddStudentDetails().setVisible(true);
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
        else if (comnd.equals("Add Class Details"))
        {
//            System.out.println("Add Class Details class open");
            new AddNewClass().setVisible(true);
        }
        else if (comnd.equals("Update Class Details"))
        {
//            System.out.println("Update Class Details class open");
            new UpdateClassDetails().setVisible(true);
        }
        else if (comnd.equals("Add Subject Details"))
        {
//            System.out.println("Add Subject Details class open");
            new AddSubjectDetails().setVisible(true);
        }
        else if (comnd.equals("Add Marks"))
        {
//            System.out.println("Add Mark Subject class open");
            new AddMarksDetails().setVisible(true);
        }
        else if (comnd.equals("View Marks"))
        {
//            System.out.println("Add Mark Subject class open");
            new ViewMarksDetails(pub_username, account2).setVisible(true);
        }
        else if (comnd.equals("Add Fee Details"))
        {
//            System.out.println("Add Fee Details class open");
            new AddFeeDetails().setVisible(true);
        }
        else if (comnd.equals("Add Fee Structure"))
        {
            System.out.println("Add Fee Structure class open");
            new AddFeeStructure().setVisible(true);
        }
        else if (comnd.equals("View Fee Details"))
        {
            System.out.println("View Fee Details class open");
            new ViewFeeDetails(pub_username, account2).setVisible(true);
        }
        else if (comnd.equals("Show Results"))
        {
            System.out.println("Show Results class open");
            new ShowResult(pub_username, account2).setVisible(true);
        }
        else if (comnd.equals("Exit"))
        {
            System.out.println("You are Logged Out");
            this.setVisible(false);
            new LoginPage();
        }
    }

//    public static void main (String[] args) {
//        new AdminHomePage("account", "username").setVisible(true);
//    }
}
