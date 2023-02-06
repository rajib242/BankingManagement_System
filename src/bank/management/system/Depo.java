
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Depo extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposs,backs;
    String pinnumber;
    Depo(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        
        ImageIcon ik = new ImageIcon(ClassLoader.getSystemResource("photos/machine.jpg"));
         Image ik2 = ik.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
         ImageIcon ik3 = new ImageIcon(ik2);
         JLabel img = new JLabel(ik3);
        
        img.setBounds(0, 0, 700, 700);
         add(img);
         
         JLabel select = new JLabel("Please Enter the Amount to Deposit ");
         //text.setFont(new Font("Raleway",Font.BOLD,18));
          select.setBounds(150,170,500,30);
          select.setFont(new Font("Osward",Font.BOLD,15));
          select.setForeground(Color.BLACK);
        //text.setF
          img.add(select);
         
          amount = new JTextField();
          amount.setFont(new Font("Osward",Font.BOLD,25));  // Welcome to ATM
          amount.setBounds(200,220,160,40);
          img.add(amount);
         
           
        deposs = new JButton("Deposit");
        deposs.setBackground(Color.WHITE);
        deposs.setForeground(Color.BLACK);
        deposs.setFont(new Font("Raleway",Font.BOLD,15));
        deposs.setBounds(210, 300, 140, 30);
        deposs.addActionListener(this);
        img.add(deposs);
        
        backs = new JButton("Back");
        backs.setBackground(Color.WHITE);
        backs.setForeground(Color.BLACK);
        backs.setFont(new Font("Raleway",Font.BOLD,15));
        backs.setBounds(210, 350, 140, 30);
        backs.addActionListener(this);
        img.add(backs);
        
         
        setTitle("Users Accounts  ");
        getContentPane().setBackground(Color.GREEN); // for color the fram
        setSize(700,700);
        setLocation(280,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent d){
        if(d.getSource()== deposs){
            String rajib_depo = amount.getText();
            Date date = new Date();
            if(rajib_depo.equals("")){ // empty amount
                JOptionPane.showMessageDialog(null,"Please deposit your money" );
            }
            else{
                try{
                Conn c = new Conn();
                String query4 = "insert into amount values('"+pinnumber+"','"+date+"','Deposit','"+rajib_depo+"')";
                c.s.executeUpdate(query4);
                JOptionPane.showMessageDialog(null,"Rs " + rajib_depo + " Deposited Successfully" );
                setVisible(false);
                new MachineAt(pinnumber).setVisible(true);
                
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(d.getSource() == backs){
            setVisible(false);
            new MachineAt(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Depo("");
    }
}
