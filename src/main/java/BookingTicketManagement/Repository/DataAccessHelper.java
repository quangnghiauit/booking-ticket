package BookingTicketManagement.Repository;

import BookingTicketManagement.Constants.DBConfiguration;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataAccessHelper {

	private static ComboPooledDataSource cpds = new ComboPooledDataSource();

	static {
	    try {
            cpds.setDriverClass(DBConfiguration.DB_DRIVER);
            cpds.setJdbcUrl(DBConfiguration.CONNECTION_URL);
            cpds.setUser(DBConfiguration.USER_NAME);
            cpds.setPassword(DBConfiguration.PASSWORD);
            cpds.setMinPoolSize(DBConfiguration.DB_MIN_CONNECTIONS);
            cpds.setInitialPoolSize(DBConfiguration.DB_MIN_CONNECTIONS);
            cpds.setMaxPoolSize(DBConfiguration.DB_MAX_CONNECTIONS);
        } catch (PropertyVetoException ex) {
	        ex.printStackTrace();
        }
    }

    public DataAccessHelper() throws SQLException {
        System.out.println("Getting connection .........");
        conn = cpds.getConnection();
        System.out.println("Getting connection successfull .........");
    }
    public Connection conn=null;

    public static DataAccessHelper getInstance() throws SQLException {
        return new DataAccessHelper();
    }
    
//    public void getConnect() throws SQLException{
//        System.out.println("Getting connection .........");
//        conn = cpds.getConnection();
//        System.out.println("Getting connection successfull .........");
//    }

    public static Connection getConnection() throws SQLException {
        System.out.println("Getting connection pool...... ");
        Connection conn = cpds.getConnection();
        return conn;
    }
    
    public void getClose(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
