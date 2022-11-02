
package conection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class conection {
    
    private Connection con;
    
    
    
    public conection()
    {
      this.con = null;
    }
    
    public Connection getconection()
            {
             try
             {
               Class.forName("com.mysql.cj.jdbc.Driver");
               con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","Cuchumino1*");
               if(con != null)
               {
                System.out.println("Conexión establecida");
               }
             }
             catch (ClassNotFoundException | SQLException e)
                     {
                      System.err.println("Error: " +e);
                     }
             
              return this.con;
            }
           
    
}
