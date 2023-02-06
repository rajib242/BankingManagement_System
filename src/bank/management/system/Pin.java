package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;
//import java.util.Date;


public class Pin extends JFrame implements ActionListener{
    JTextField pin,repin;
    JButton change,back;
    String pinnumber;
    
    Pin(String pinnumber){
        this.pinnumber=pinnumber;
        
         setLayout(null);
        
        
         ImageIcon ik = new ImageIcon(ClassLoader.getSystemResource("photos/machine.jpg"));
         Image ik2 = ik.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
         ImageIcon ik3 = new ImageIcon(ik2);
         JLabel lab = new JLabel(ik3);
         lab.setBounds(0, 0, 700, 700);
         add(lab);
         
          JLabel select = new JLabel("Change Your Pin");
         //text.setFont(new Font("Raleway",Font.BOLD,18));
          select.setBounds(200,200,700,30);
          select.setForeground(Color.BLACK);
        //text.setF
          lab.add(select);
         
         
         JLabel pintext = new JLabel("New Pin");
         pintext.setFont(new Font("Raleway",Font.BOLD,18));
         pintext.setBounds(160,280,180,30);
          pintext.setForeground(Color.BLACK);
          lab.add(pintext);
                 
         pin = new JTextField();
         pin.setFont(new Font("Raleway",Font.BOLD,18));
         pin.setBounds(290,280,140,30);
          pin.setForeground(Color.BLACK);
          lab.add(pin);
          
          
          
          JLabel repintext = new JLabel("Re-Enter Pin ");
          repintext.setFont(new Font("Raleway",Font.BOLD,18));
          repintext.setBounds(160,310,140,30);
          repintext.setForeground(Color.BLACK);
          lab.add(repintext);
                 
         
          repin = new JTextField();
          repin.setFont(new Font("Raleway",Font.BOLD,18));
          repin.setBounds(290,320,140,30);
          repin.setForeground(Color.BLACK);
          lab.add(repin);
         
         
         change = new JButton("Change");
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.setFont(new Font("Raleway",Font.BOLD,15));
        change.setBounds(280, 360, 150, 30);
        change.addActionListener(this);
        lab.add(change);
         
         
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.setBounds(280, 389, 150, 30);
        back.addActionListener(this);
        lab.add(back);
        
         
         
         
      //  setTitle("U  ");
        getContentPane().setBackground(Color.GREEN); // for color the fram
        setSize(700,700);
        setLocation(280,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
         try{
            String newpin = pin.getText();
            String rpin  = repin.getText();
            if(!newpin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Enter pin Not match");
                return;
            }
           if(newpin.equals("")){
               JOptionPane.showMessageDialog(null,"Enter the pin");
                return;
           }
           
           if(rpin.equals("")){
               JOptionPane.showMessageDialog(null,"Enter the re-pin");
                return;
           }
          Conn c = new  Conn();
          String query1= "update amount set Pin_Number = '"+rpin+"' where Pin_Number='"+pinnumber+"'";
          String query2= "update login set Pin_Number = '"+rpin+"' where Pin_Number='"+pinnumber+"'";
          String query3= "update SignupThree set Pin_Number = '"+rpin+"' where Pin_Number='"+pinnumber+"'";
          c.s.executeUpdate(query1);
          c.s.executeUpdate(query2);
          c.s.executeUpdate(query3);
          
          JOptionPane.showMessageDialog(null,"Pin Change SuccessFully");
          setVisible(false);
          new MachineAt(rpin).setVisible(true); //new
        }
        catch(Exception e){
            System.out.println(e);
           }
        }
        else{
            setVisible(false);
            new MachineAt(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Pin("");
    }
    
}
