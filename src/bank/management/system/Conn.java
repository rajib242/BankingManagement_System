package bank.management.system;
import java.sql.*;

public class Conn {
 
          Connection c;
          Statement s;
        
    public Conn(){
        
        // use of try catch for jdbc bcz mysql is external entity to handle the exception we use exception ...  it's happen on compile time but not runtime
        try{
          // Class.forName(com.mysql.cj.jdbc.Driver);
          // c = DriverManager.getConnection("jdbc:mysql://localhost:3306");
             c = DriverManager.getConnection("jdbc:mysql:///banksystem", "root","Rajib@2002");
             s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
        public static void main(String[] ars){
           new Conn();
        
    }

// Process of connect the database
// 1. Register the driver
// 2. create Connection
// 3. Create Statement
// 4. Execute Query
// 5. Close Connection
}

