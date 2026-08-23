package School_Management_System;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.security.*;
import java.sql.*;
import java.util.Random;

public class AddStudentDetails extends JFrame implements ActionListener 
{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
    JButton bt1, bt2;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10;
    Choice ch1;
    JComboBox ch2;
    JPasswordField pf1;
    String class_name=null;
    
    AddStudentDetails()
    {
        setTitle("Add New Student Details");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(840, 600);
        setResizable(false);
        setLocation(550,200);
        setVisible(true);
        
        // Load background
        ImageIcon img = new ImageIcon(getClass().getResource("Icons/studentadd.jpg"));
        Image scaledImg = img.getImage().getScaledInstance(840, 600, Image.SCALE_SMOOTH);
        JLabel bg1 = new JLabel(new ImageIcon(scaledImg));
        bg1.setBounds(0, 0, 840, 600);
        bg1.setLayout(null);
        add(bg1);
        
        l1= new JLabel("Add Student Details for Signup");
        l1.setBounds(230, 50, 500, 50);
        l1.setFont(new Font("Ariel", Font.BOLD, 30));
        l1.setForeground(Color.BLACK);
        bg1.add(l1);
        
        l2= new JLabel("Name");
        l2.setBounds(50, 150, 150, 30);
        l2.setFont(new Font("Ariel", Font.BOLD, 20));
        l2.setForeground(Color.WHITE);
        bg1.add(l2);
        
        tf1= new JTextField();
        tf1.setBounds(200, 150, 150, 30);
        bg1.add(tf1);
        
        l3= new JLabel("Username");
        l3.setBounds(450, 150, 150, 30);
        l3.setFont(new Font("Ariel", Font.BOLD, 20));
        l3.setForeground(Color.WHITE);
        bg1.add(l3);
        
        tf2= new JTextField();
        tf2.setBounds(600, 150, 150, 30);
        bg1.add(tf2);
        
        l4= new JLabel("Password");
        l4.setBounds(50, 200, 150, 30);
        l4.setFont(new Font("Ariel", Font.BOLD, 20));
        l4.setForeground(Color.WHITE);
        bg1.add(l4);
        
        pf1= new JPasswordField();
        pf1.setBounds(200, 200, 150, 30);
        bg1.add(pf1);
        
        l5= new JLabel("E-Mail");
        l5.setBounds(450, 200, 150, 30);
        l5.setFont(new Font("Ariel", Font.BOLD, 20));
        l5.setForeground(Color.WHITE);
        bg1.add(l5);
        
        tf3= new JTextField();
        tf3.setBounds(600, 200, 150, 30);
        bg1.add(tf3);
        
        l6= new JLabel("Father's name");
        l6.setBounds(50, 250, 150, 30);
        l6.setFont(new Font("Ariel", Font.BOLD, 20));
        l6.setForeground(Color.WHITE);
        bg1.add(l6);
        
        tf4= new JTextField();
        tf4.setBounds(200, 250, 150, 30);
        bg1.add(tf4);
        
        l7= new JLabel("Phone");
        l7.setBounds(450, 250, 150, 30);
        l7.setFont(new Font("Ariel", Font.BOLD, 20));
        l7.setForeground(Color.WHITE);
        bg1.add(l7);
        
        tf5= new JTextField();
        tf5.setBounds(600, 250, 150, 30);
        bg1.add(tf5);
        
        l8= new JLabel("Blood Group");
        l8.setBounds(50, 300, 150, 30);
        l8.setFont(new Font("Ariel", Font.BOLD, 20));
        l8.setForeground(Color.WHITE);
        bg1.add(l8);
        
        tf6= new JTextField();
        tf6.setBounds(200, 300, 150, 30);
        bg1.add(tf6);
        
        l9= new JLabel("Gender");
        l9.setBounds(450, 300, 150, 30);
        l9.setFont(new Font("Ariel", Font.BOLD, 20));
        l9.setForeground(Color.WHITE);
        bg1.add(l9);
        
        
        ch1=new Choice();
        ch1.add("Select Gender");
        ch1.add("Male");
        ch1.add("Female");
        ch1.setFont(new Font("Arial", Font.BOLD, 18));
        ch1.setBounds(600, 300, 150, 30);
        bg1.add(ch1);
        
        // City
        l10 = new JLabel("City");
        l10.setBounds(50, 350, 150, 30);
        l10.setFont(new Font("Ariel", Font.BOLD, 20));
        l10.setForeground(Color.WHITE);
        bg1.add(l10);

        tf7 = new JTextField();
        tf7.setBounds(200, 350, 150, 30);
        bg1.add(tf7);

        // AGE
        l11 = new JLabel("Age");
        l11.setBounds(450, 350, 150, 30);
        l11.setFont(new Font("Ariel", Font.BOLD, 20));
        l11.setForeground(Color.WHITE);
        bg1.add(l11);

        tf8 = new JTextField();
        tf8.setBounds(600, 350, 150, 30);
        bg1.add(tf8);

        // GRADE
        l12 = new JLabel("Grade");
        l12.setBounds(50, 400, 200, 30);
        l12.setFont(new Font("Ariel", Font.BOLD, 20));
        l12.setForeground(Color.WHITE);
        bg1.add(l12);

        // create JComboBox
        JComboBox<String> ch2 = new JComboBox<>();
        ch2.addItem("Select Grade");
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select distinct * from class";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                ch2.addItem(rest.getString("class_name"));
            }
            rest.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // size, font, and placement
        ch2.setBounds(200, 400, 150, 30);
        ch2.setFont(new Font("Ariel", Font.BOLD, 14));
        ch2.setFocusable(false);            // optional
        ((JComponent)ch2.getRenderer()).setOpaque(false); // keep renderer transparent if needed
        bg1.add(ch2);

        // DOB (fixed position)
        l13 = new JLabel("DOB");
        l13.setBounds(450, 400, 150, 30);  // moved down from 350 → 400
        l13.setFont(new Font("Ariel", Font.BOLD, 20));
        l13.setForeground(Color.WHITE);
        bg1.add(l13);

        tf9 = new JTextField();
        tf9.setBounds(600, 400, 150, 30);  // aligned with DOB
        bg1.add(tf9);

        // ROLL NO
        l14 = new JLabel("Roll No");
        l14.setBounds(250, 450, 150, 30);   // stays fine
        l14.setFont(new Font("Ariel", Font.BOLD, 20));
        l14.setForeground(Color.BLACK);
        bg1.add(l14);

        tf10 = new JTextField();
        tf10.setBounds(400, 450, 150, 30);
        tf10.setEditable(false);
        bg1.add(tf10);
        
        //buttons
        bt1= new JButton("Submit");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(250, 500, 150, 30);
        
        bt2= new JButton("Cancel");
        bt2.setBackground(new Color(8, 161, 92));
        bt2.setForeground(Color.BLACK);
        bt2.setBounds(500, 500, 150, 30);
        
        bg1.add(bt1);
        bg1.add(bt2);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        /*ch2.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                try
                {
                    ConnectionClass obj=new ConnectionClass();
                    String class_name = (String) ch2.getSelectedItem();
                    String q1="select * from class where class_name='"+class_name+"'";
                    ResultSet rest1=obj.stm.executeQuery(q1);
                    while (rest1.next())
                    {
                        int roll_no=Integer.parseInt(rest1.getString("enrolled"))+1;
                        tf10.setText(String.valueOf(roll_no));
                    }
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }); */
        
        ch2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // get selected value from combobox
                class_name = (String) ch2.getSelectedItem();

                // show the selected class_name (example: print or set in a text field)
                System.out.println("Selected class: " + class_name);

                ConnectionClass obj = new ConnectionClass();
                String q1 = "select * from class where class_name='" + class_name + "'";
                ResultSet rest1 = obj.stm.executeQuery(q1);

                while (rest1.next()) {
                    int roll_no = Integer.parseInt(rest1.getString("enrolled")) + 1;
                    tf10.setText(String.valueOf(roll_no));
                }

                rest1.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    });
    //Force UI refresh and visibility
    revalidate();
    repaint();
    setVisible(true);
    }
     
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String name=tf1.getText();
            String roll_no=tf10.getText();
            String username=tf2.getText();
            String password=pf1.getText();
            // Hash the password with a salt
            String hashedPassword=null;
                try {
                    hashedPassword = PasswordUtils.hashPassword(password);
                }
                catch (NoSuchAlgorithmException ex) { }
                    //Logger.getLogger(UserScreen.class.getName()).log(Level.SEVERE, null, ex);
            String email=tf3.getText();
            String father_name=tf4.getText();
            String phone=tf5.getText();
            String blood_group=tf6.getText();
            String gender=(String) ch1.getSelectedItem();
            String city=tf7.getText();
            String age=tf8.getText();
            String grade=class_name;
            String dob=tf9.getText();
            Random r= new Random();
            String stu_id=""+Math.abs(r.nextInt() % 100000);
            int total_student=0;
            
            try
            {
                ConnectionClass obj= new ConnectionClass();
                String q= "insert into student values('"+stu_id+"','"+roll_no+"','"+name+"','"+username+"','"+hashedPassword+"','"+email+"','"+father_name+"','"+phone+"','"+blood_group+"','"+gender+"','"+city+"','"+age+"','"+grade+"','"+dob+"')";
                String q1="update class set enrolled='"+roll_no+"' where class_name='"+grade+"'";
                String q2="select * from class where class_name='"+grade+"'";
                
                ResultSet rest=obj.stm.executeQuery(q2);
                while(rest.next())
                {
                    total_student=Integer.parseInt(rest.getString("strength"));
                }
                if (Integer.parseInt(roll_no)>total_student)
                {
                    JOptionPane.showMessageDialog(null,"Sorry ! This class is full");
                }
                else
                {
                    obj.stm.executeUpdate(q);
                    obj.stm.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                    setVisible(false);
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if (e.getSource()==bt2)
        {
            setVisible(false);
        }
    }
    
//    public static void main(String[] args) 
//    {
//        new AddStudentDetails().setVisible(true);
//    }
}