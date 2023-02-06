
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class Fast extends JFrame implements ActionListener{
    
    JButton depossit,statement,bal,pin,enter,back,cash,link;
    String pinnumber;
    Fast(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        
        ImageIcon ik = new ImageIcon(ClassLoader.getSystemResource("photos/machine.jpg"));
         Image ik2 = ik.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
         ImageIcon ik3 = new ImageIcon(ik2);
         JLabel lab = new JLabel(ik3);
        
        lab.setBounds(0, 0, 700, 700);
         add(lab);
        
        
          JLabel select = new JLabel("Select Withdrawl Amount ");
         //text.setFont(new Font("Raleway",Font.BOLD,18));
          select.setBounds(200,200,700,30);
        select.setForeground(Color.BLACK);
        //text.setF
        lab.add(select);
        
        
        depossit = new JButton("Rs 100");
        depossit.setBackground(Color.BLACK);
        depossit.setForeground(Color.WHITE);
        depossit.setFont(new Font("Raleway",Font.BOLD,15));
        depossit.setBounds(140, 292, 140, 30);
        depossit.addActionListener(this);
        lab.add(depossit);
        
        cash = new JButton("Rs 500");
        cash.setBackground(Color.BLACK);
        cash.setForeground(Color.WHITE);
        cash.setFont(new Font("Raleway",Font.BOLD,15));
        cash.setBounds(300, 292, 150, 30);
        cash.addActionListener(this);
        lab.add(cash);
        
        
        statement = new JButton("Rs 1000");
        statement.setBackground(Color.BLACK);
        statement.setForeground(Color.WHITE);
        statement.setFont(new Font("Raleway",Font.BOLD,15));
        statement.setBounds(140, 325, 140, 30);
        statement.addActionListener(this);
        lab.add(statement);
        
        bal = new JButton("Rs 2000");
        bal.setBackground(Color.BLACK);
        bal.setForeground(Color.WHITE);
        bal.setFont(new Font("Raleway",Font.BOLD,15));
        bal.setBounds(300, 325, 150, 30);
        bal.addActionListener(this);
        lab.add(bal);
        
        
        
        link = new JButton("Rs 5000");
        link.setBackground(Color.BLACK);
        link.setForeground(Color.WHITE);
        link.setFont(new Font("Raleway",Font.BOLD,15));
        link.setBounds(140, 357, 140, 30);
        link.addActionListener(this);
        lab.add(link);
        
        pin= new JButton("Rs 10000");
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
        
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.setBounds(300, 389, 150, 30);
        back.addActionListener(this);
        lab.add(back);
        
        
        
        
        
        setTitle("Fast Trans Page");
        getContentPane().setBackground(Color.GREEN); // for color the fram
        setSize(700,700);
        setLocation(280,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== back){
            setVisible(false);
            new MachineAt(pinnumber).setVisible(true);
        }
        else{
            String findamount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs  =c.s.executeQuery("select * from amount where Pin_Number = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                   if(rs.getString("Type_of_Trans").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                    }
                   else{
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
                }
                if(ae.getSource() != back && balance <= Integer.parseInt(findamount)){
                    JOptionPane.showMessageDialog(null,"Insuffisint Balance");
                    return;
                }
                
                Date date = new Date();
                
                String query6 = "insert into amount values('"+pinnumber+"','"+date+"','Withdraw','"+findamount+"')";
                c.s.executeUpdate(query6);
                JOptionPane.showMessageDialog(null,"Rs"+findamount+" Debited SuccessFully");
                
                setVisible(false);
                new MachineAt(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        } 
        
    }
    public static void main(String[] args){
        new Fast("");
    }
}
