

package lafo.proses.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lafo.view.MainJframe;


public class DataBaseDisplayer extends Connection{
private Connection koneksi;
private String sqlTabel;
private String[] field;

    //konstruktor
    public DataBaseDisplayer(Connection koneksi) {
        this.koneksi = koneksi;
    }
    
    public void tabel(String sqlTabel, String[] taBelHeader, JTable tabel){
        DefaultTableModel tbmodel = new DefaultTableModel();
        
        //seting table heeader
        
        //menambahkan header pada tabel model
        for (int i = 0; i < taBelHeader.length; i++) {
            tbmodel.addColumn(field[i]);
        }
        //menambahkan header pada awal tabel
        tabel.setModel(tbmodel);
        int kolomLength = tbmodel.getColumnCount() ;
        
        
        //mengisi data 
        
        //membuat object untuk penampung data
        Object[] tempData = new Object[kolomLength];

        try{
            //mengambil data dari data base melalui object koneksi
            koneksi.connecting();
            PreparedStatement pst = koneksi.conn.prepareStatement(sqlTabel);
            ResultSet rs = pst.executeQuery();
            
            //mengambil hasil dari query keadlam object penampung data (tempData)
            while(rs.next()){
                for (int i = 0; i < kolomLength; i++) {
                    tempData[i] = rs.getString(i+1);
                }
                
                //menambahkan barisbaru dengan isi data ke tabel model
                tbmodel.addRow(tempData);
           }
            
        }
        catch(SQLException sE){
            System.out.println(sE);
        }
        finally{
            
            //menutup koneksi
            koneksi.connectionClose();
        }
        
        //memasukan tabel model kedalam jtabel
        tabel.setModel(tbmodel);
        
        
    }
    
}
