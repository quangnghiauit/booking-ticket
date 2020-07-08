package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.Bus;
import java.sql.ResultSet;
import java.sql.Statement;

public class BusRepository {

    public Bus findById(int id) {

        String SQL = "select * from `bus` where id=\""+id+"\"";
        Bus bus = null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                bus = new Bus(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name"),
                        Integer.parseInt(rs.getString("type"))
                );
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return bus;
    }


}
