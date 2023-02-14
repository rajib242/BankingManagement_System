package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; //listerner
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    String fno;
    JRadioButton ra1,ra2,ra3,ra4;
    ButtonGroup group; 
    JCheckBox ch1,ch2,ch3,ch4,ch5,ch6,ch7;
    JButton submit , cancel; 
    
    SignupThree(String fno){
        this.fno=fno;
        
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3 : Account Deatils " + fno );
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel l2 = new JLabel("Account Type: ");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(100,100,200,30);
        add(l2);
        
        ra1 = new JRadioButton("Saving Account");
        ra1.setBounds(140,140,120,30);
        ra1.setBackground(Color.WHITE);
        add(ra1);
        
        ra2 = new JRadioButton("Fixed Deposit");
        ra2.setBounds(400,140,120,30);
        ra2.setBackground(Color.WHITE);
        add(ra2);
        
        
        ra3 = new JRadioButton("Current Account ");
        ra3.setBounds(140,180,130,30);
        ra3.setBackground(Color.WHITE);
        add(ra3);
        
        
        
        ra4 = new JRadioButton("Recurring Deposit Account ");
        ra4.setBounds(400,180,180,30);
        ra4.setBackground(Color.WHITE);
        add(ra4);
        
        group = new ButtonGroup();
        group.add(ra1);
        group.add(ra2);
        group.add(ra3);
        group.add(ra4);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,240,200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-7895");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,240,300,30);
        add(number);
        
        JLabel carddetails = new JLabel("Your 16 Digit Card Number");
       carddetails.setFont(new Font("Raleway",Font.BOLD,12));
        carddetails.setBounds(100,265,300,20);
        add(carddetails);
        
        
        JLabel pin = new JLabel("Pin Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,290,200,30);
        add(pin);
        
        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinnumber.setBounds(330,290,150,30);
        add(pinnumber);
        
       JLabel pindetails = new JLabel("Your 4 digit pin Number");
       pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        pindetails.setBounds(100,315,300,20);
        add(pindetails); 
        
        
        JLabel required = new JLabel("Services Required:");
        required.setFont(new Font("Raleway",Font.BOLD,22));
        required.setBounds(100,350,300,30);
        add(required);
        
        
        ch1 = new JCheckBox("Atm Card");
        ch1.setFont(new Font("Raleway",Font.BOLD,17));
        ch1.setBackground(Color.WHITE);
        ch1.setBounds(180,400,140,17);
        add(ch1);
        
        ch2 = new JCheckBox("Internet Banking");
        ch2.setFont(new Font("Raleway",Font.BOLD,17));
        ch2.setBackground(Color.WHITE);
        ch2.setBounds(360,400,190,20);
        add(ch2);
        
        ch3 = new JCheckBox("Mobile Banking");
        ch3.setFont(new Font("Raleway",Font.BOLD,17));
        ch3.setBackground(Color.WHITE);
        ch3.setBounds(180,440,160,20);
        add(ch3);
        
        
        ch4 = new JCheckBox("Email Alert");
        ch4.setFont(new Font("Raleway",Font.BOLD,17));
        ch4.setBackground(Color.WHITE);
        ch4.setBounds(360,440,190,20);
        add(ch4);
        
        
        ch5 = new JCheckBox("Cheque Book");
        ch5.setFont(new Font("Raleway",Font.BOLD,17));
        ch5.setBackground(Color.WHITE);
        ch5.setBounds(180,480,150,20);
        add(ch5);
        
        
        ch6 = new JCheckBox("E-Statement");
        ch6.setFont(new Font("Raleway",Font.BOLD,17));
        ch6.setBackground(Color.WHITE);
        ch6.setBounds(360,480,150,20);
        add(ch6);
        
        
        
        ch7 = new JCheckBox("I hereby declares that terms above details correct to be the best of my knowledge.");
        ch7.setFont(new Font("Raleway",Font.BOLD,17));
        ch7.setBackground(Color.WHITE);
        ch7.setBounds(90,540,680,17);
        add(ch7);
        
        // Buttom
        
        submit = new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.BLACK);
        submit.setBounds(270,590,100,30);
        submit.addActionListener(this);
        add(submit);
        
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(420,590,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        
     //   setTitle("");
        getContentPane().setBackground(Color.WHITE); // for color the fram
        setSize(850,700);
        setLocation(280,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ap){
        if(ap.getSource() == submit){
             String cardtype="";
            if(ra1.isSelected()){
                cardtype="Saving Account ";
            }
            else if(ra2.isSelected()){
                cardtype="Fixed Deposit Account";
            }
            else if(ra3.isSelected()){
                cardtype="Current Account";
            }
            else if(ra4.isSelected()){
                cardtype="Recurring Deposit Account";
            }
            
            
                
            Random random = new Random();
            
            String  cardnumbercard = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            
            String pinnumberpin = ""+ Math.abs((random.nextLong() % 9000L)+1000L );
            
            String fc ="";// facility
            
            if(ch1.isSelected()){
                fc = fc + " Atm Card";
            }
            else if(ch2.isSelected()){
                fc = fc + " Internet Banking";
            }
            else if(ch3.isSelected()){
                fc= fc + " Mobile Banking";
            }
            else if(ch4.isSelected()){
                fc = fc +" Email Alert";
            }
            else if(ch5.isSelected()){
                fc = fc +" Cheque Book";
            }
            else if(ch3.isSelected()){
                fc = fc + " E-Statement";
            }
            
            try{
                if(cardtype.equals("")){
                JOptionPane.showConfirmDialog(null, "Account type is Required");
                }
                else if(fc.equals("")){
                  JOptionPane.showConfirmDialog(null, "Facility is  Required");  
                }
                else{
                    Conn c = new Conn();
                    String query1 = "insert into SignupThree values('"+fno+"','"+cardtype+"', '"+cardnumbercard+"','"+pinnumberpin+"','"+fc+"')";
                    String query2 = "insert into login values('"+fno+"','"+cardnumbercard+"',  '"+pinnumberpin+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showConfirmDialog(null, "Card Number: " + cardnumbercard + "\nPin:"+pinnumberpin);
                    
                    setVisible(false);
                    new Depo(pinnumberpin).setVisible(false); // false
                }
            } 
            catch(Exception e){
               System.out.println(e);  
            }
        }
        else if(ap.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new SignupThree(" ");
    }
}
