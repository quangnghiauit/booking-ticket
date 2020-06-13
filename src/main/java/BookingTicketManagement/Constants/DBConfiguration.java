package BookingTicketManagement.Constants;

public class DBConfiguration {

    public static final String HOST_NAME = "localhost";
    public static final String DB_NAME = "BOOKINGTICKETMANAGEMENT";
    public static final String DB_PORT = "3306";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "abc@123456";
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final int DB_MIN_CONNECTIONS = 10;
    public static final int DB_MAX_CONNECTIONS = 30;
    // jdbc:mysql://hostname:port/dbname
    public static final String CONNECTION_URL = "jdbc:mysql://"
            + HOST_NAME + ":" + DB_PORT + "/" + DB_NAME;

    private DBConfiguration() {
        super();
    }
}
