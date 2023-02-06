package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
   JButton login,signup ,clear;
   JTextField cardtextfield ;
   JPasswordField pintextfield;
    
    Login(){
        
        setTitle("BANK MANAGEMENT SYSTEM");  // frame title bar
        
        setLayout(null); // for border layout for image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/logo.jpg")); // to factch image icon ---->  class name classLoader static method get.systemResource
       // JLabel label = new JLabel();
       //add(label);
       
       
       
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("photos/logo.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel label1 = new JLabel(ii3);
        label1.setBounds(630, 10, 100, 100); // setBounds that in a frame inside height , width x, y axis
        add(label1);
        
        
        
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // to change the image height , weight
        // Image class is there in awt package
        // ImageIcon i1 u can put into the JLabel 
        // But u can't put Image into JLabel
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        
        label.setBounds(70, 10, 100, 100); // setBounds that in a frame inside height , width x, y axis
        add(label); // to show the image in frame
       
        
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));  // Welcome to ATM
        text.setBounds(260,40,400,40);
        add(text);
        
        
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Osward",Font.BOLD,28)); // Card No
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardtextfield = new JTextField();
        cardtextfield.setBounds(300,150,230,40);
        cardtextfield.setFont(new Font("Arial",Font.BOLD,15));
        
        add(cardtextfield);
        
        JLabel pin = new JLabel("Pin No:");
        pin.setFont(new Font("Osward",Font.BOLD,28));  // PIN
        pin.setBounds(120,220,400,40);
        add(pin);
        
        
        pintextfield = new JPasswordField();
        pintextfield.setBounds(300,220,230,40);
        pintextfield.setFont(new Font("Arial",Font.BOLD,15));
        add(pintextfield);
        
        login = new JButton("SIGN IN");
        login.setForeground(Color.white);
        login.setBackground(Color.BLACK);
        login.setBounds(300,300,100,30);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setForeground(Color.white);
        clear.setBackground(Color.BLACK);
        clear.setBounds(430,300,100,30);
        clear.addActionListener(this);
        add(clear);

        
        signup = new JButton("SIGN UP");
        signup.setForeground(Color.white);
        signup.setBackground(Color.BLACK);
        signup.setBounds(360,360,120,30);
        signup.addActionListener(this);
        add(signup);
        
     
        
        
        
        getContentPane().setBackground(Color.GREEN); // for color the fram
        setSize(800,480); // frame size
        setVisible(true); // visible the frame
        setLocation(300,140); // set the location of a frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == clear){
          cardtextfield.setText("");
          pintextfield.setText("");
       }
       else if(ae.getSource() == login){
           Conn c = new Conn();
           String cardnumber = cardtextfield.getText();
           String pinnumber = pintextfield.getText();
           
           String que = "select * from login where Card_Number = '"+cardnumber+"' and Pin_Number = '"+pinnumber+"'";
           
           try{
               ResultSet rs = c.s.executeQuery(que);
               if(rs.next()){
                   setVisible(false);
                   new MachineAt(pinnumber).setVisible(true);
               }
               else{
                   JOptionPane.showMessageDialog(null,"Please Enter Correct Information");
               }
           }
           catch(Exception e){
              System.out.println(e); 
           }
       }
       else if(ae.getSource() == signup){
         setVisible(false);
         new SignupOne().setVisible(true);
       }
    }
    public static void main(String args[]){
        new Login(); // creating a object
    }
}
