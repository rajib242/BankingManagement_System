
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Balance extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    Balance(String pinnumber){
    this.pinnumber=pinnumber;
        
         setLayout(null);
        
        
         ImageIcon is = new ImageIcon(ClassLoader.getSystemResource("photos/machine.jpg"));
         Image is2 = is.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
         ImageIcon is3 = new ImageIcon(is2);
         JLabel lab = new JLabel(is3);
         lab.setBounds(0, 0, 700, 700);
         add(lab);
         
         back= new JButton("Back");
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         back.setFont(new Font("Raleway",Font.BOLD,15));
         back.setBounds(280, 389, 150, 30);
         back.addActionListener(this);
         lab.add(back);
         
        Conn c = new Conn();
            int balance = 0;
            try{ 
                ResultSet rs  = c.s.executeQuery("select * from amount where Pin_Number = '"+pinnumber+"'");
                
                while(rs.next()){
                   if(rs.getString("Type_of_Trans").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                    }
                   else{
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
                }
            }
                catch(Exception e){
                      System.out.println(e);  
             }
        
       JLabel text = new JLabel("Your Current Ac Balance is Rs: " + balance );
           // back.setBackground(Color.BLACK);
         text.setForeground(Color.BLACK);
         text.setFont(new Font("Raleway",Font.BOLD,15));
         text.setBounds(120, 300, 400, 30);
         //back.addActionListener(this);
         lab.add(text);
        
        getContentPane().setBackground(Color.GREEN); // for color the fram
        setSize(700,700);
        setLocation(280,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
    }
            
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new MachineAt(pinnumber).setVisible(true);
    }
    public static void main(String args[]){
        new Balance("");
    }
}
