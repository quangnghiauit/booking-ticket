
package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.Route;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class RouteRepository {

    public ArrayList<Route> findAll() {

        String SQL = "select * from `route`";
        ArrayList<Route> list = new ArrayList<>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                list.add(new Route(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("from"),
                        rs.getString("to"),
                        rs.getString("timeGo"),
                        rs.getString("duration")
                ));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }

    public Route findById(int id) {

        String SQL = "select * from `route` where id=\""+id+"\"";
        Route route = null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                route = new Route(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("from"),
                        rs.getString("to"),
                        rs.getString("timeGo"),
                        rs.getString("duration")
                );
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return route;
    }

    public Route find(String from, String to, String departureTime) {

        String SQL = "select * from `route` where `from`=\""+from+"\" and `to`=\""+to+"\" and `timeGo`=\""+departureTime+"\"";
        Route route=null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                route = new Route(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("from"),
                        rs.getString("to"),
                        rs.getString("timeGo"),
                        rs.getString("duration")
                );
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return route;
    }
    
}
