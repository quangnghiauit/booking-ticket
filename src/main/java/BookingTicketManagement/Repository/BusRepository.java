package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.Bus;
import BookingTicketManagement.Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusRepository {

    public Bus findById(int id) {

        String SQL = "select * from `bus` where id=\""+id+"\"";
        Bus bus = null;
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                bus = new Bus(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name"),
                        Integer.parseInt(rs.getString("type"))
                );
            }
            
        } catch (Exception e) {}
        return bus;
    }

    public Bus findByIdCP(int id) {
        Bus bus = null;
        System.out.println("Login connection pool....");
        try {
            String sqlSelect = "select * from `bus` where id=\""+id+"\"";

            try (Connection con = DataAccessHelper.getConnection();
                 Statement statement = con.createStatement();
                 ResultSet rs=statement.executeQuery(sqlSelect);) {
                Thread.sleep(2000);
                rs.next();
                bus = new Bus(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name"),
                        Integer.parseInt(rs.getString("type"))
                );
            }

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        return bus;
    }
}
