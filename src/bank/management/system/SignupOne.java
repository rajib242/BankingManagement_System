package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
//import bank.management.system.Connec;
//import java.util.Scanner;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JDateChooser dateChooser;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JTextField nametext,fnametext,textmailid,textAdderss,textAddresscity,textstate,textpincode;
    SignupOne(){
        setLayout(null);
        
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
            
        JLabel fno = new JLabel("APPLICATION FROM NO . " + random );
        fno.setFont(new Font("Raleway",Font.BOLD,38));
        fno.setBounds(140,20,600,40);
        add(fno);
        
        
        JLabel pdeatils = new JLabel("Page 1: Personal Details " );
        pdeatils.setFont(new Font("Raleway",Font.BOLD,24));
        pdeatils.setBounds(290,80,300,40);
        add(pdeatils);
        
        
        JLabel name = new JLabel("Name:" );
        name.setFont(new Font("Raleway",Font.BOLD,24));
        name.setBounds(100,140,100,30);
        add(name);
        
        nametext = new JTextField();
        nametext.setFont(new Font("Raleway",Font.BOLD,15));
        nametext.setBounds(300,140,400,30);
        add(nametext);        
                
                
        JLabel fathersname = new JLabel("Father's Name:" );
        fathersname.setFont(new Font("Raleway",Font.BOLD,24));
        fathersname.setBounds(100,190,200,30);
        add(fathersname);
        fnametext = new JTextField();
        fnametext.setFont(new Font("Raleway",Font.BOLD,15));
        fnametext.setBounds(300,190,400,30);
        add(fnametext);
        
        
        
        
        JLabel dob = new JLabel("Date of Birth:" );
        dob.setFont(new Font("Raleway",Font.BOLD,24));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
       // dateChooser.setFont(new Font("Raleway",Font.BOLD,15));
        //dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);
        
        
        
        
        JLabel gender = new JLabel("Gender:" );
        gender.setFont(new Font("Raleway",Font.BOLD,24));
        gender.setBounds(100,290,200,30);
        add(gender);
//        JTextField textgender = new JTextField();
//        textgender.setFont(new Font("Raleway",Font.BOLD,15));
//        textgender.setBounds(300,290,400,30);
//        add(textgender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(460,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        
        
        
        JLabel mailid = new JLabel("Email:" );
        mailid.setFont(new Font("Raleway",Font.BOLD,24));
        mailid.setBounds(100,340,200,30);
        add(mailid);
        textmailid = new JTextField();
        textmailid.setFont(new Font("Raleway",Font.BOLD,15));
        textmailid.setBounds(300,340,400,30);
        add(textmailid);
        
        
        
        
        JLabel maritalStatus = new JLabel("Marital Status:" );
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,24));
        maritalStatus.setBounds(100,390,200,30);
        add(maritalStatus);
//        JTextField textmaritalStatus = new JTextField();
//        textmaritalStatus.setFont(new Font("Raleway",Font.BOLD,15));
//        textmaritalStatus.setBounds(300,390,400,30);
//        add(textmaritalStatus);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(460,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other= new JRadioButton("Others");
        other.setBounds(600,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
          
        ButtonGroup marriedstatus= new ButtonGroup();
        marriedstatus.add(married);
        marriedstatus.add(unmarried);
        marriedstatus.add(other);
        
        
        
        JLabel Adderss = new JLabel("Adderss:" );
        Adderss.setFont(new Font("Raleway",Font.BOLD,22));
        Adderss.setBounds(100,440,200,30);
        add(Adderss);
        textAdderss = new JTextField();
        textAdderss.setFont(new Font("Raleway",Font.BOLD,15));
        textAdderss.setBounds(300,440,400,30);
        add(textAdderss);
        
        
        
        JLabel Addresscity = new JLabel("City:" );
        Addresscity.setFont(new Font("Raleway",Font.BOLD,22));
        Addresscity.setBounds(100,490,200,30);
        add(Addresscity);
        textAddresscity = new JTextField();
        textAddresscity.setFont(new Font("Raleway",Font.BOLD,15));
        textAddresscity.setBounds(300,490,400,30);
        add(textAddresscity);
        
        
        
        
        JLabel state= new JLabel("State:" );
        state.setFont(new Font("Raleway",Font.BOLD,24));
        state.setBounds(100,540,200,30);
        add(state);
        textstate = new JTextField();
        textstate.setFont(new Font("Raleway",Font.BOLD,15));
        textstate.setBounds(300,540,400,30);
        add(textstate);
        
        
        
        
        JLabel pincode= new JLabel("Pin Code:" );
        pincode.setFont(new Font("Raleway",Font.BOLD,24));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        textpincode = new JTextField();
        textpincode.setFont(new Font("Raleway",Font.BOLD,15));
        textpincode.setBounds(300,590,400,30);
        add(textpincode);
        
        next = new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(720, 590, 80, 30);
        next.addActionListener(this);
        add(next);
        
        setTitle("Login Page");
        getContentPane().setBackground(Color.GREEN); // for color the fram
        setSize(850,700);
        setLocation(280,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    public void actionPerformed(ActionEvent ae){
        
     String fno = "" + random; //long
     String name = nametext.getText(); // getText we will get the value
     String fathersname = fnametext.getText();
     String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
     String gender = null;
     if(male.isSelected()){
         gender="Male";
     }
     else if(female.isSelected()){
        gender="Female"; 
     }
     
     String  mailid = textmailid.getText();
     
     String maritalStatus = null;
     if(married.isSelected()){
         maritalStatus ="Married";
     }
     else if(unmarried.isSelected()){
         maritalStatus ="Unmarried";
     }
     else if(other.isSelected()){
         maritalStatus ="Others";
     }
     String Adderss = textAdderss.getText(); 
     String Addresscity = textAddresscity.getText(); 
     String state = textstate.getText(); 
     String pincode = textpincode.getText(); 
     
     try{
        if(name.equals("")){
            JOptionPane.showConfirmDialog(null, "Name is Required");
        }
        else if(fathersname.equals("")){
            JOptionPane.showConfirmDialog(null, "Father Name is Required");
       }
        else{
             Conn c = new Conn();
             String query = "insert into signup values('"+fno+"','"+name+"','"+fathersname+"','"+dob+"','"+gender+"','"+mailid+"','"+maritalStatus+"','"+Adderss+"','"+Addresscity+"','"+state+"','"+pincode+"')";
             c.s.executeUpdate(query);
             setVisible(false);
             new SignupSecond(fno).setVisible(true);
             
        }
        
     }catch(Exception e){
          //e.printStackTrace();
          System.out.println(e);
     }
     
    }
    
   // TextField nametext,fnametext,textmailid,textAdderss,textAddresscity,textstate,textpincode;
    
    public static void main(String args[]){
        new SignupOne();
    }
}
