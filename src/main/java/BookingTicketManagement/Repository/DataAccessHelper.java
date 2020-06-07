package BookingTicketManagement.Repository;

import BookingTicketManagement.Config.Database.ConnectDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataAccessHelper {

	private String url= "jdbc:mysql://"+ConnectDatabase.host+":"+ConnectDatabase.post+"/"+ConnectDatabase.database+"?user="+ConnectDatabase.user+"&password="+ConnectDatabase.password;
    
    public Connection conn=null;
    
    private static DataAccessHelper instance=null;
    
    public static DataAccessHelper getInstance()
    {
        if(instance==null)
            instance=new DataAccessHelper();
        return instance;
    }
    
    private DataAccessHelper(){}

    public void getConnect() throws SQLException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }        
    } 
    
    public void getClose(){
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
