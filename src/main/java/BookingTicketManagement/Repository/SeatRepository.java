package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.Seat;
import BookingTicketManagement.Model.SeatDTO;
import BookingTicketManagement.Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeatRepository {

    public ArrayList<Seat> findByBusId(int busId) {

        String SQL = "select * from `seat` where bus=\""+busId+"\"";
        ArrayList<Seat> list = new ArrayList<>();
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                list.add(new Seat(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name"),
                        Integer.parseInt(rs.getString("bus"))
                ));
            }
            
        } catch (Exception e) {}
        return list;
    }

    public Seat findById(int id) {

        String SQL = "select * from `seat` where id=\""+id+"\"";
        Seat seat = null;
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                seat = new Seat(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name"),
                        Integer.parseInt(rs.getString("bus"))
                );
            }
            
        } catch (Exception e) {}
        return seat;
    }


    public Seat findByIdCP(int id) {
        Seat seat = null;
        System.out.println("Login connection pool....");
        try {
            String sqlSelect = "select * from `seat` where id=\""+id+"\"";

            try (Connection con = DataAccessHelper.getConnection();
                 Statement statement = con.createStatement();
                 ResultSet rs=statement.executeQuery(sqlSelect);) {
                Thread.sleep(2000);
                rs.next();
                seat = new Seat(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name"),
                        Integer.parseInt(rs.getString("bus"))
                );
            }

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        return seat;
    }


    public ArrayList<Seat> findAll() {

         String SQL = "select * from `seat`";
        ArrayList<Seat> list = new ArrayList<>();
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                list.add(new Seat(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name"),
                        Integer.parseInt(rs.getString("bus"))
                ));
            }
            
        } catch (Exception e) {}
        return list;
    }

}
