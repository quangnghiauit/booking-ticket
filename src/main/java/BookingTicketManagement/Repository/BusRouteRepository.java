
package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.Bus_Route;
import BookingTicketManagement.Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BusRouteRepository {

    public ArrayList<Bus_Route> findByRouteId(int route) {

        String SQL = "select * from `bus_route` where routeId=\""+route+"\"";
        ArrayList<Bus_Route> list = new ArrayList<>();
        try{
            
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
            
        } catch (Exception e) {}
        return list;
    }

    public Bus_Route find(int bus, int route) {

        String SQL = "select * from `bus_route` where busId=\""+bus+"\" and routeId=\""+route+"\"";
        Bus_Route busRoute = null;
        try{
            
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
            
        } catch (Exception e) {}
        return busRoute;
    }

    public Bus_Route findCP(int bus, int route) {
        Bus_Route busRoute = null;
        System.out.println("Login connection pool....");
        try {
            String sqlSelect = "select * from `bus_route` where busId=\""+bus+"\" and routeId=\""+route+"\"";

            try (Connection con = DataAccessHelper.getConnection();
                 Statement statement = con.createStatement();
                 ResultSet rs=statement.executeQuery(sqlSelect);) {
                Thread.sleep(2000);
                rs.next();
                busRoute = new Bus_Route(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("busId")),
                        Integer.parseInt(rs.getString("routeId")),
                        Float.parseFloat(rs.getString("price"))
                );
            }

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        return busRoute;
    }

}
