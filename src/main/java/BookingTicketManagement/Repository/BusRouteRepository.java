
package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.Bus_Route;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class BusRouteRepository {

    public ArrayList<Bus_Route> findByRouteId(int route) {

        String SQL = "select * from `bus_route` where routeId=\""+route+"\"";
        ArrayList<Bus_Route> list = new ArrayList<>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                list.add(new Bus_Route(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("busId")),
                        Integer.parseInt(rs.getString("routeId")),
                        Float.parseFloat(rs.getString("price"))
                ));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }

    public Bus_Route find(int bus, int route) {

        String SQL = "select * from `bus_route` where busId=\""+bus+"\" and routeId=\""+route+"\"";
        Bus_Route busRoute = null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                busRoute = new Bus_Route(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("busId")),
                        Integer.parseInt(rs.getString("routeId")),
                        Float.parseFloat(rs.getString("price"))
                );
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return busRoute;
    }
    
}
