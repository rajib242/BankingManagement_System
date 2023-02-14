
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MachineAt extends JFrame implements ActionListener{
    
    JButton depossit,statement,bal,pin,enter,back,cash,link;
    String pinnumber;
    MachineAt(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        
        ImageIcon ik = new ImageIcon(ClassLoader.getSystemResource("photos/machine.jpg"));
         Image ik2 = ik.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
         ImageIcon ik3 = new ImageIcon(ik2);
         JLabel lab = new JLabel(ik3);
        
        lab.setBounds(0, 0, 700, 700);
         add(lab);
        
        
          JLabel select = new JLabel("Please Select your Transaction");
         //text.setFont(new Font("Raleway",Font.BOLD,18));
          select.setBounds(180,200,700,30);
          select.setFont(new Font("Raleway",Font.BOLD,15));
        select.setForeground(Color.BLACK);
        //text.setF
        lab.add(select);
        
        
        depossit = new JButton("Deposit");
        depossit.setBackground(Color.BLACK);
        depossit.setForeground(Color.WHITE);
        depossit.setFont(new Font("Raleway",Font.BOLD,15));
        depossit.setBounds(140, 292, 140, 30);
        depossit.addActionListener(this);
        lab.add(depossit);
        
        cash = new JButton("Cash Withdrawl");
        cash.setBackground(Color.BLACK);
        cash.setForeground(Color.WHITE);
        cash.setFont(new Font("Raleway",Font.BOLD,15));
        cash.setBounds(300, 292, 150, 30);
        cash.addActionListener(this);
        lab.add(cash);
        
        
        statement = new JButton("Mini Statement");
        statement.setBackground(Color.BLACK);
        statement.setForeground(Color.WHITE);
        statement.setFont(new Font("Raleway",Font.BOLD,15));
        statement.setBounds(140, 325, 140, 30);
        statement.addActionListener(this);
        lab.add(statement);
        
        bal = new JButton("Balance Inquery");
        bal.setBackground(Color.BLACK);
        bal.setForeground(Color.WHITE);
        bal.setFont(new Font("Raleway",Font.BOLD,15));
        bal.setBounds(300, 325, 150, 30);
        bal.addActionListener(this);
        lab.add(bal);
        
        
        
        link = new JButton("Fast Cash"); 
        link.setBackground(Color.BLACK);
        link.setForeground(Color.WHITE);
        link.setFont(new Font("Raleway",Font.BOLD,15));
        link.setBounds(140, 357, 140, 30);
        link.addActionListener(this);
        lab.add(link);
        
        pin= new JButton("Pin Change");
        pin.setBackground(Color.BLACK);
        pin.setForeground(Color.WHITE);
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        pin.setBounds(300, 357, 150, 30);
        pin.addActionListener(this);
        lab.add(pin);
        
//        enter= new JButton("Enter");
//        enter.setBackground(Color.BLACK);
//        enter.setForeground(Color.WHITE);
//        enter.setFont(new Font("Raleway",Font.BOLD,15));
//        enter.setBounds(300, 357, 150, 30);
//        enter.addActionListener(this);
//        lab.add(enter);
//        
        back= new JButton("Exit");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.setBounds(300, 389, 150, 30);
        back.addActionListener(this);
        lab.add(back);
        
        
        
        
        
        setTitle("Atm Page ");
        getContentPane().setBackground(Color.GREEN); // for color the fram
        setSize(700,700);
        setLocation(280,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent a){
        if(a.getSource()== back){
            System.exit(0);
        }
        else if(a.getSource()== depossit){
            setVisible(false);
            new Depo(pinnumber).setVisible(true);
        }
        else if(a.getSource() == cash){
            setVisible(false);
            new With(pinnumber).setVisible(true);
        }
        else if(a.getSource() == link){ // fastcash
            setVisible(false);
            new Fast(pinnumber).setVisible(true);
        }
        else if(a.getSource() == pin){
            setVisible(false);
            new Pin(pinnumber).setVisible(true);
        }
        else if(a.getSource() == bal){
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
        }
        else if(a.getSource()== statement){
            setVisible(false);
            new Mini(pinnumber).setVisible(true);
        }
        
    }
    public static void main(String[] args){
        new MachineAt("");
    }
}
