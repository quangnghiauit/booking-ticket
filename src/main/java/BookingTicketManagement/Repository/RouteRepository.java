
package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.Route;
import BookingTicketManagement.Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class RouteRepository {

    public ArrayList<Route> findAll() {

        String SQL = "select * from `route`";
        ArrayList<Route> list = new ArrayList<>();
        try{

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

        } catch (Exception e) {}
        return list;
    }

    public ArrayList<Route> findAllCP() {
        ArrayList<Route> list = new ArrayList<>();
        System.out.println("Start get route repo....");
        System.out.println("Login connection pool....");
        try {
            String sqlSelect = "select * from `route`";

            try (Connection con = DataAccessHelper.getConnection();
                 Statement statement = con.createStatement();
                 ResultSet rs=statement.executeQuery(sqlSelect);) {
                //Thread.sleep(2000);
                while(rs.next()) {
                    list.add(new Route(
                            Integer.parseInt(rs.getString("id")),
                            rs.getString("from"),
                            rs.getString("to"),
                            rs.getString("timeGo"),
                            rs.getString("duration")
                    ));
                }
            }

        } catch (SQLException e) {// | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End get route repo....");

        return list;
    }

    public Route findById(int id) {

        String SQL = "select * from `route` where id=\""+id+"\"";
        Route route = null;
        try{
            
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
            
        } catch (Exception e) {}
        return route;
    }


    public Route findByIdCP(int id) {
        Route route = null;
        System.out.println("Login connection pool....");
        try {
            String sqlSelect = "select * from `route` where id=\""+id+"\"";

            try (Connection con = DataAccessHelper.getConnection();
                 Statement statement = con.createStatement();
                 ResultSet rs=statement.executeQuery(sqlSelect);) {
                //Thread.sleep(2000);
                rs.next();
                route = new Route(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("from"),
                        rs.getString("to"),
                        rs.getString("timeGo"),
                        rs.getString("duration")
                );
            }

        } catch (SQLException e) {// | InterruptedException e) {
            e.printStackTrace();
        }
        return route;
    }


    public Route find(String from, String to, String departureTime) {

        String SQL = "select * from `route` where `from`=\""+from+"\" and `to`=\""+to+"\" and `timeGo`=\""+departureTime+"\"";
        Route route=null;
        try{
            
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
            
        } catch (Exception e) {}
        return route;
    }
    
}
