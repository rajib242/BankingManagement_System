
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class Mini extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    Mini(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bal = new JLabel();
        bal.setBounds(90,560,300,20);
        add(bal);
        
        JLabel bankk = new JLabel("SBI BANK");
        bankk.setBounds(150,20,100,20);
        add(bankk);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        try{
            Conn crrrr = new Conn();
            ResultSet rs = crrrr.s.executeQuery("select * from login where Pin_Number = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("Card_Number").substring(0,4)+ "XXXXXXXX" + rs.getString("Card_Number").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c = new Conn();
            int balance=0;
            ResultSet rs = c.s.executeQuery("select * from amount where Pin_Number = '"+pinnumber+"'");
            while(rs.next()){
            mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + rs.getString("Type_of_Trans")+ "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;" + rs.getString("amount") + "<br><br><html>");
            if(rs.getString("Type_of_Trans").equals("Deposit")){
               balance += Integer.parseInt(rs.getString("amount"));
                 }
           else{
                 balance -= Integer.parseInt(rs.getString("amount"));
              }
            }
            bal.setText("Your Current Account Balance:  "+ balance);
        }catch(Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(30,140,400,400);
       // new MachineAt(pinnumber).setVisible(true);
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(270, 630, 100, 25);
        add(back);
        
        
        
        
        setTitle("Mini Statement Page");
        getContentPane().setBackground(Color.GREEN); // for color the fram
        setSize(400,700);
        setLocation(280,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
       // setVisible(false);
        if(ae.getSource()== back){
            setVisible(false);
            new MachineAt(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Mini("");
    }
}
