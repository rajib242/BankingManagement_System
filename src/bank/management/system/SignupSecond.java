package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import bank.management.system.Connec;
//import java.util.Scanner;

public class SignupSecond extends JFrame implements ActionListener{
    JComboBox religion,category,income,eduqualification,occupa ;
    JButton next;
    JRadioButton acno,acyes,seniorno,senioryes;
    JTextField textpan,textadhar;
    String fno;
    SignupSecond(String fno){
        this.fno=fno;
        setLayout(null);
        
        JLabel reqdeails = new JLabel("Page 2: Required Details " );
        reqdeails.setFont(new Font("Raleway",Font.BOLD,24));
        reqdeails.setBounds(290,50,400,40);
        add(reqdeails);
        
        
        JLabel reg = new JLabel("Religion:" );
        reg.setFont(new Font("Raleway",Font.BOLD,24));
        reg.setBounds(100,140,120,30);
        add(reg);
        
        String Array[] = {"  Hindu","  Muslim","  Others"};
        religion =  new JComboBox(Array);
        religion.setFont(new Font("Raleway",Font.BOLD,15));
        religion.setBounds(300,140,400,30);
        add(religion);        
                
                
        JLabel cate = new JLabel("Category:" );
        cate.setFont(new Font("Raleway",Font.BOLD,24));
        cate.setBounds(100,190,200,30);
        add(cate);
        
        String Arrayc[] = {"  General","  Sc","  St","  Obc","  Others"};
        category =  new JComboBox(Arrayc);
        category.setFont(new Font("Raleway",Font.BOLD,15));
        category.setBounds(300,190,400,30);
        add(category);
        
        
        
        
        JLabel inc = new JLabel("Income:" );
        inc.setFont(new Font("Raleway",Font.BOLD,24));
        inc.setBounds(100,240,200,30);
        add(inc);
        
        
        String incr[] = {"  Null","  100000","  200000","  300000","  Upto 10000000"};
        income =  new JComboBox(incr);
        income.setFont(new Font("Raleway",Font.BOLD,15));
        income.setBounds(300,240,400,30);
        add(income);
        
       
        
        JLabel education = new JLabel("Educational" );
        education.setFont(new Font("Raleway",Font.BOLD,24));
        education.setBounds(100,290,200,30);
        add(education);
        JLabel qualification = new JLabel("Qualification:" );
        qualification.setFont(new Font("Raleway",Font.BOLD,24));
        qualification.setBounds(100,320,200,30);
        add(qualification);
//       
        
        String Arrayq[] = {"  Post Graduate","  Graduate","  12th Pass","  10th Pass","  Others"};
        eduqualification =  new JComboBox(Arrayq);
        eduqualification.setFont(new Font("Raleway",Font.BOLD,15));
        eduqualification.setBounds(300,305,400,30);
        add(eduqualification);
        
        
        JLabel occupation = new JLabel("Occupation:" );
        occupation.setFont(new Font("Raleway",Font.BOLD,24));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        String Arrayo[] = {"  Self Employee","  Teacher","  Bussiness","  Retired","  Student","  Labour","  Others"};
        occupa =  new JComboBox(Arrayo);
        occupa.setFont(new Font("Raleway",Font.BOLD,15));
        occupa.setBounds(300,390,400,30);
        add(occupa);

     
        JLabel pan = new JLabel("Pan No:" );
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        pan.setBounds(100,440,200,30);
        add(pan);
        textpan = new JTextField();
        textpan.setFont(new Font("Raleway",Font.BOLD,15));
        textpan.setBounds(300,440,400,30);
        add(textpan);
        
        
        
        JLabel adhar = new JLabel("Aadhar No:" );
        adhar.setFont(new Font("Raleway",Font.BOLD,22));
        adhar.setBounds(100,490,200,30);
        add(adhar);
        
        textadhar = new JTextField();
        textadhar.setFont(new Font("Raleway",Font.BOLD,15));
        textadhar.setBounds(300,490,400,30);
        add(textadhar);
        
        
        JLabel senior= new JLabel("Senior Citizen:" );
        senior.setFont(new Font("Raleway",Font.BOLD,24));
        senior.setBounds(100,540,200,30);
        add(senior);
        
        senioryes = new JRadioButton("Yes");
        senioryes.setBounds(320,540,60,30);
        senioryes.setBackground(Color.WHITE);
        add(senioryes);
        
        seniorno = new JRadioButton("No");
        seniorno.setBounds(460,540,60,30);
        seniorno.setBackground(Color.WHITE);
        add(seniorno);
        
        ButtonGroup group = new ButtonGroup();
        group.add(senioryes);
        group.add(seniorno);
        
        
        
        JLabel account= new JLabel("Exisiting Account:" );
        account.setFont(new Font("Raleway",Font.BOLD,24));
        account.setBounds(100,590,240,30);
        add(account);
        
        acyes = new JRadioButton("Yes");
        acyes.setBounds(320,590,60,30);
        acyes.setBackground(Color.WHITE);
        add(acyes);
        
        acno = new JRadioButton("No");
        acno.setBounds(460,590,60,30);
        acno.setBackground(Color.WHITE);
        add(acno);
        
        ButtonGroup groupE = new ButtonGroup();
        groupE.add(acyes);
        groupE.add(acno);
        
        next = new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(720, 590, 80, 30);
        next.addActionListener(this);
        add(next);
        
        setTitle("New Acount Application From");
        getContentPane().setBackground(Color.GREEN); // for color the fram
        setSize(850,700);
        setLocation(280,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    public void actionPerformed(ActionEvent ae){
        
 
     String reg = (String)religion.getSelectedItem();
     String cate = (String)category.getSelectedItem();
     String inc = (String)income.getSelectedItem();
     String education = (String)eduqualification.getSelectedItem();
     String occupation = (String)occupa.getSelectedItem();
     
     String senior = null;    
     if(senioryes.isSelected()){
         senior="Yes";
     }
     else if(seniorno.isSelected()){
        senior="No"; 
     }
     
   
     String account = "";
     if(acyes.isSelected()){
         account ="Yes";
     }
     else if(acno.isSelected()){
         account="No";
     }
     String pan = textpan.getText(); 
     String adhar= textadhar.getText();
     
     String from = ""+fno;  
     try{
         
             Conn c = new Conn();
             String query = "insert into signupsecond values('"+from+"','"+reg+"','"+cate+"','"+inc+"','"+education+"','"+occupation+"','"+pan+"','"+adhar+"','"+account+"','"+senior+"')";
             c.s.executeUpdate(query);
             
              setVisible(false);

              // signup3 object
             new SignupThree(from).setVisible(true);
             
        }catch(Exception e){
          //e.printStackTrace();
          System.out.println(e);
     }
     
    }
    
   // TextField nametext,fnametext,textmailid,textAdderss,textAddresscity,textstate,textpincode;
    
    public static void main(String args[]){
        new SignupSecond(" ");
    }
}
