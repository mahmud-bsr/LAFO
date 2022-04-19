package lafo.proses.DataBase;

import java.sql.*;

public class Connection {
    
    public static java.sql.Connection conn;
    
    public static void main(String[] args) throws SQLException {
        
        //variabel for database connection
        String port = "3306";
        String DataBase = "s2_cafe_lafo_v2";
        String url = "jdbc:mysql://localhost:"+port+"/"+DataBase;
        String user = "root";
        String password = "";
        
        String sql = "SELECT * FROM `penngguna`";
        
        //open connection
        
        try{
            //Connection conn;
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(url, user, password); 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
           
            //SELECT `Id_Pegawai`, `Nama_Pegawai`, `Gender`, `Alamat`, `No_Hp`, `Status_pengguna`, `Tanggal_Terdaftar`, `kode_hak_akses` FROM `penngguna` WHERE 1
            
            while(rs.next()){
                System.out.println("ID = "+ rs.getString("Id_Pegawai"));
                System.out.println("nama = "+ rs.getString("Nama_Pegawai"));
                System.out.println("gender = "+ rs.getString("Gender"));
                System.out.println("alamat = "+ rs.getString("Alamat"));
                System.out.println("no Hp = "+ rs.getString("No_Hp"));
                System.out.println("Status = "+ rs.getString("Status_pengguna"));
                System.out.println("tanggal gabung = "+ rs.getString("Tanggal_Terdaftar"));
                System.out.println("kode hak akases = "+ rs.getString("kode_hak_akses"));
                
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            conn.close();
        }
            
        
    }
    
}
