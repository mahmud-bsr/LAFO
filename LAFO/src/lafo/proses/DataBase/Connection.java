package lafo.proses.DataBase;

import java.sql.*;

public class Connection {
    
    public static java.sql.Connection conn;
    
    public static void main(String[] args) throws SQLException {
        
        //variabel for database connection
//        String link = 
        String port = "3306";
        String DataBase = "lafo";
        String url = "jdbc:mysql://localhost:"+port+"/"+DataBase;
        String user = "root";
        String password = "";
        
        String sql = "SELECT * FROM `penngguna`";
        
        //open connection
        
        try{
            //Connection conn;
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(url, user, password); 
            
            
            if (conn.isValid(0)) {
                System.out.println("koneksi berhasil");
            }
        }
        catch(Exception e){
            System.out.println("koneksi bermasalah : "+e);
        }
        finally{
            conn.close();
        }
            
        
    }
    
}
