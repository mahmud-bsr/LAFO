package lafo.proses.DataBase;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection {
    
    public static java.sql.Connection conn;
    
    //variabel for database connection
    static String port = "3306";
    static String DataBase = "s2_cafe_lafo_v2";
    static String url = "jdbc:mysql://localhost:"+port+"/"+DataBase;
    static String user = "root";
    static String password = "";
        
    public static void connecting(){
        try{
            conn = DriverManager.getConnection(url, user, password); 

        }
        catch(Exception e){
                System.out.println(e);
                //System.out.println(sqlE);
        }
        finally{
//            try {
//                //conn.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }
    
    public static void main(String[] args) throws SQLException {
        
        
        
        String sql = "SELECT * FROM `penngguna`";
        
        //open connection
        
       
            
        
    }
    
}
