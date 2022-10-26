
package conection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
public class conection {
    
    Connection con;
    public conection()
            {
             try
             {
               Class.forName("com.mysql.cj.jdbc.Driver");
               con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","12345678");
               
             }
             catch (Exception e)
                     {
                      System.err.println("Error: " +e);
                     }
             
             
            }
    public static void main(String[] args)
             {
              conection cn=new conection();
              
              Statement st;
              ResultSet rs;
              
              try {
              st=cn.con.createStatement();
              
              rs=st.executeQuery("Select * from country");
              
              while (rs.next())
              {
                 System.out.println(rs.getString("code"));
              }
              cn.con.close();
              } 
              catch (Exception e)
              {
              
              }
             }
}
