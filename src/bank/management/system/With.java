
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class With extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdrawl,backs;
    String pinnumber;
    JLabel select;
    With(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        
        ImageIcon ik = new ImageIcon(ClassLoader.getSystemResource("photos/machine.jpg"));
         Image ik2 = ik.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
         ImageIcon ik3 = new ImageIcon(ik2);
         JLabel img = new JLabel(ik3);
        
        img.setBounds(0, 0, 700, 700);
         add(img);
         
         select = new JLabel("Please Enter the Amount to  Withdrawl ");
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
         
           
        withdrawl = new JButton("Withdraw");
        withdrawl.setBackground(Color.WHITE);
        withdrawl.setForeground(Color.BLACK);
        withdrawl.setFont(new Font("Raleway",Font.BOLD,15));
        withdrawl.setBounds(210, 300, 140, 30);
        withdrawl.addActionListener(this);
        img.add(withdrawl);
        
        backs = new JButton("Back");
        backs.setBackground(Color.WHITE);
        backs.setForeground(Color.BLACK);
        backs.setFont(new Font("Raleway",Font.BOLD,15));
        backs.setBounds(210, 350, 140, 30);
        backs.addActionListener(this);
        img.add(backs);
        
         
        setTitle("Withdraw Page ");
        getContentPane().setBackground(Color.GREEN); // for color the fram
        setSize(700,700);
        setLocation(280,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
//        if(d.getSource()== withdrawl){
//            String rajib_depo = amount.getText();
//            Date date = new Date();
//            if(rajib_depo.equals("")){ // empty amount
//                JOptionPane.showMessageDialog(null,"Please enter the amount to Withdrawl" );
//            }
//            else{
//                try{
//                Conn c = new Conn();
//                String query4 = "insert into amount values('"+pinnumber+"','"+date+"','Withdraw','"+rajib_depo+"')";
//                c.s.executeUpdate(query4);
//                JOptionPane.showMessageDialog(null,"Rs " + rajib_depo + " Withdrawl Successfully" );
//                setVisible(false);
//                new MachineAt(pinnumber).setVisible(true);
//                
//                }catch(Exception e){
//                    System.out.println(e);
//                }
//            }
//        }
//        else if(d.getSource() == backs){
//            setVisible(false);
//            new MachineAt(pinnumber).setVisible(true);
//        }

      try{
          String rajib_depo=amount.getText();
          Date date = new Date();
          if(ae.getSource()== withdrawl){
              if(select.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");  
              }
              else{
                  Conn c = new Conn();
                  ResultSet rs = c.s.executeQuery("select * from amount where Pin_Number = '"+pinnumber+"'");
                  int balance=0;
                  while(rs.next()){
                   if(rs.getString("Type_of_Trans").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                    }
                   else{
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
                }
                  if(balance<Integer.parseInt(rajib_depo)){
                      JOptionPane.showMessageDialog(null,"Insuffient balance");
                      return;
                  }
                  String query4 = "insert into amount values('"+pinnumber+"','"+date+"','Withdraw','"+rajib_depo+"')";
                  c.s.executeUpdate(query4);
                  
                  JOptionPane.showMessageDialog(null,"Rs " + rajib_depo + " Withdrawl Successfully" );
                  
                setVisible(false);
                new MachineAt(pinnumber).setVisible(true);
              }
          }else if(ae.getSource()== backs){
               setVisible(false);
               new MachineAt(pinnumber).setVisible(true);
          }
      }catch(Exception e){
       System.out.println(e);   
      }

    }
    public static void main(String args[]){
        new With("");
    }
}
