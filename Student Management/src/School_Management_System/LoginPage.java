package School_Management_System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class LoginPage extends JFrame implements ActionListener {

    JLayeredPane lp1;
    JLabel l1, l2, l3, l4, bg1;
    JTextField tf1;
    JPasswordField pf1;
    Choice ch1;
    JButton bt1, bt2;
    Image il;

    LoginPage() {
        setTitle("Login - School Management System");
        setSize(750, 460);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon img = new ImageIcon(getClass().getResource("/School_Management_System/Icons/background.jpg"));
        Image il=img.getImage().getScaledInstance(750, 460, Image.SCALE_SMOOTH);
        
        //background image work
        bg1 = new JLabel();
        bg1.setIcon(new ImageIcon(il));
        bg1.setBounds(0, 0, 750, 460);

        
        lp1 = new JLayeredPane();
        lp1.setBounds(0, 0, 750, 460);
        getContentPane().setLayout(null);
        getContentPane().add(lp1);

        JPanel l0 = new JPanel(null);
        l0.setOpaque(false);
        l0.setBounds(0, 0, 750, 460);

        //main header stating login
        l1 = new JLabel("Login School Account");
        l1.setBounds(200, 40, 400, 40);
        l1.setFont(new Font("Arial", Font.BOLD, 28));
        l1.setForeground(Color.WHITE);
        l0.add(l1);

        //account text in orange
        l2 = new JLabel("Account:");
        l2.setBounds(150, 120, 150, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setForeground(new Color(245, 135, 66));
        l0.add(l2);

        //dropdown of account type
        ch1 = new Choice();
        ch1.add("Select Account Type");
        ch1.add("Admin");
        ch1.add("Teacher");
        ch1.add("Student");
        ch1.setFont(new Font("Arial", Font.BOLD, 18));
        ch1.setBounds(330, 120, 200, 30);
        l0.add(ch1);

        //text in orange of username
        l3 = new JLabel("Username:");
        l3.setBounds(150, 180, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(new Color(245, 135, 66));
        l0.add(l3);

        //textbox for username input
        tf1 = new JTextField();
        tf1.setFont(new Font("Arial", Font.PLAIN, 20));
        tf1.setBounds(330, 180, 200, 30);
        l0.add(tf1);

        //password text in orange
        l4 = new JLabel("Password:");
        l4.setBounds(150, 240, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(new Color(245, 135, 66));
        l0.add(l4);

        //password box for inputing password values
        pf1 = new JPasswordField();
        pf1.setFont(new Font("Arial", Font.PLAIN, 20));
        pf1.setBounds(330, 240, 200, 30);
        l0.add(pf1);

        //buttons of login/exit
        bt1 = new JButton("Login");
        bt2 = new JButton("Exit");
        l0.add(bt1);
        l0.add(bt2);

        //design of login button
        bt1.setFont(new Font("Arial", Font.BOLD, 18));
        bt2.setFont(new Font("Arial", Font.BOLD, 18));
        bt1.setBounds(150, 320, 150, 40);
        bt2.setBounds(380, 320, 150, 40);
        bt1.setBackground(new Color(53, 4, 117));
        bt1.setForeground(Color.WHITE);
        bt2.setBackground(new Color(191, 247, 161));
        bt2.setForeground(Color.BLACK);

        //acctions of login&exit
        bt1.addActionListener(this);
        bt2.addActionListener(this);

        lp1.add(bg1, Integer.valueOf(0));
        lp1.add(l0, Integer.valueOf(1));

        setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == bt1) {
        try {
            ConnectionClass obj = new ConnectionClass();
            String account = ch1.getSelectedItem();
            String username = tf1.getText();
            String password = pf1.getText();
            if (account.equals("Select Account Type")) {
                JOptionPane.showMessageDialog(null, "You have not Selected an Account Type");
                tf1.setText("");
                pf1.setText("");
                new LoginPage();
            }
            else if (account.equals("Admin")) {
                    String q = "select * from admin where username='" + username + "' and password='" + password + "'";
                    ResultSet rest = obj.stm.executeQuery(q);
                    if (rest.next()) 
                    {
                        new AdminHomePage(account, rest.getString("username")).setVisible(true);
                        System.out.println("Admin Login Successful");
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "You have entered Wrong Username and Password!");
                        tf1.setText("");
                        pf1.setText("");
                        new LoginPage();
                    }
                }
                else if (account.equals("Teacher")) {
                    String q = "select * from teacher where username='" + username + "' ";
                            //+ "and password='" + password + "'";
                    ResultSet rest = obj.stm.executeQuery(q);
                    if (rest.next()) 
                    {
                        String PSS=rest.getString("password");
                        boolean passmatch=PasswordUtils.verifyPassword(PSS, password);
                        if (passmatch)
                        {
                            new TeacherHomePage(rest.getString("username"),account);
                            System.out.println("Teacher Login Successful");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "You have entered Wrong Password!");
                            tf1.setText("");
                            pf1.setText("");
                            new LoginPage();
                        }
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "You have entered Wrong Username and Password!");
                        tf1.setText("");
                        pf1.setText("");
                        new LoginPage();
                    }
                } else if (account.equals("Student")) {
                    String q = "select * from student where username='" + username + "'";
//                            + "and password='" + password + "'";
                    ResultSet rest = obj.stm.executeQuery(q);
                    if (rest.next())
                    {
                        String PSS=rest.getString("password");
                        boolean passmatch=PasswordUtils.verifyPassword(PSS, password);
                        if (passmatch)
                        {
                            new StudentHomePage(account, rest.getString("username")).setVisible(true);
                            System.out.println("Teacher Login Successful");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "You have entered Wrong Password!");
                            tf1.setText("");
                            pf1.setText("");
                            new LoginPage();
                        }
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "You have entered Wrong Username and Password!");
                        tf1.setText("");
                        pf1.setText("");
                        new LoginPage();
                    }  
                }
                this.setVisible(false);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    if (ae.getSource() == bt2) {
        System.exit(0);
    }
}

    public static void main(String[] args)
    {
        new LoginPage();
    }
}