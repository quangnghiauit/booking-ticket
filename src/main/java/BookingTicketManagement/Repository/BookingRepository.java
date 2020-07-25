
package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.Booking;
import BookingTicketManagement.Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookingRepository {

    public ArrayList<Booking> find(int seatId, String departure) {

        String SQL = "select * from `booking` where seat=\""+seatId+"\" and departure=\""+departure+"\"";
        ArrayList<Booking> list = new ArrayList<>();
        try(Connection con = DataAccessHelper.getConnection();
            Statement statement = con.createStatement()){

            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                list.add(new Booking(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("user")),
                        Integer.parseInt(rs.getString("seat")),
                        rs.getString("departure"),
                        Integer.parseInt(rs.getString("route")),
                        rs.getString("createdDate"),
                        rs.getString("updatedDate"),
                        rs.getString("updatedBy"),
                        Integer.parseInt(rs.getString("isactive")),
                        Integer.parseInt(rs.getString("ispaid"))
                ));
            }

        } catch (Exception e) {}
        return list;
    }

    public ArrayList<Booking> findCP(int seatId, String departure) {

        ArrayList<Booking> list = new ArrayList<>();
        System.out.println("Login connection pool....");

        try{
            String SQL = "select * from `booking` where seat=\""+seatId+"\" and departure=\""+departure+"\"";

            try (Connection con = DataAccessHelper.getConnection();
                 Statement statement = con.createStatement();
                 ResultSet rs=statement.executeQuery(SQL);) {
                //Thread.sleep(2000);
                while (rs.next()) {
                    list.add(new Booking(
                            Integer.parseInt(rs.getString("id")),
                            Integer.parseInt(rs.getString("user")),
                            Integer.parseInt(rs.getString("seat")),
                            rs.getString("departure"),
                            Integer.parseInt(rs.getString("route")),
                            rs.getString("createdDate"),
                            rs.getString("updatedDate"),
                            rs.getString("updatedBy"),
                            Integer.parseInt(rs.getString("isactive")),
                            Integer.parseInt(rs.getString("ispaid"))
                    ));
                }
            }
        } catch (SQLException e) {// | InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean save(int userId, int seatId, int routeId, String departureTime) {

        Date createdDate = new Date();
        String SQL ="insert `booking`(`user`,`seat`,`departure`, `route`,`createdDate`) " +
                    "values(" +
                    "\""+ userId +"\"," +
                    "\""+ seatId +"\"," +
                    "\""+ departureTime +"\"," +
                    "\""+ routeId +"\"," +
                    "\""+ (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(createdDate) +"\" " +
                    ")";
        try(Connection con = DataAccessHelper.getConnection();
            Statement statement = con.createStatement()){
            
            int rs=statement.executeUpdate(SQL);
            if(rs>0)
            {

                return true;
            }
            else
            {
                
                return false;
            }
        } catch (Exception e) {return false;}
    }

    public ArrayList<Booking> findByUserId(int id) {

        String SQL = "select * from `booking` where user=\""+id+"\"";
        ArrayList<Booking> list = new ArrayList<>();
        try(Connection con = DataAccessHelper.getConnection();
            Statement statement = con.createStatement()){
            
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                list.add(new Booking(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("user")),
                        Integer.parseInt(rs.getString("seat")),
                        rs.getString("departure"),
                        Integer.parseInt(rs.getString("route")),
                        rs.getString("createdDate"),
                        rs.getString("updatedDate"),
                        rs.getString("updatedBy"),
                        Integer.parseInt(rs.getString("isactive")),
                        Integer.parseInt(rs.getString("ispaid"))
                ));
            }
            
        } catch (Exception e) {}
        return list;
    }


    public ArrayList<Booking> findByUserIdCP(int id) {
        ArrayList<Booking> list = new ArrayList<>();
        System.out.println("Login connection pool....");
        try {
            String sqlSelect = "select * from `booking` where user=\""+id+"\"";

            try (Connection con = DataAccessHelper.getConnection();
                 Statement statement = con.createStatement();
                 ResultSet rs=statement.executeQuery(sqlSelect);) {
                //Thread.sleep(2000);
                while(rs.next()) {
                    list.add(new Booking(
                            Integer.parseInt(rs.getString("id")),
                            Integer.parseInt(rs.getString("user")),
                            Integer.parseInt(rs.getString("seat")),
                            rs.getString("departure"),
                            Integer.parseInt(rs.getString("route")),
                            rs.getString("createdDate"),
                            rs.getString("updatedDate"),
                            rs.getString("updatedBy"),
                            Integer.parseInt(rs.getString("isactive")),
                            Integer.parseInt(rs.getString("ispaid"))
                    ));
                }
            }

        } catch (SQLException e){// | InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Booking findById(int id) {
        String SQL = "select * from `booking` where id=\""+id+"\"";
        Booking booing = null;
        try(Connection con = DataAccessHelper.getConnection();
            Statement statement = con.createStatement()){
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                booing = new Booking(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("user")),
                        Integer.parseInt(rs.getString("seat")),
                        rs.getString("departure"),
                        Integer.parseInt(rs.getString("route")),
                        rs.getString("createdDate"),
                        rs.getString("updatedDate"),
                        rs.getString("updatedBy"),
                        Integer.parseInt(rs.getString("isactive")),
                        Integer.parseInt(rs.getString("ispaid"))
                );
            }
            
        } catch (Exception e) {}
        return booing;
    }

    public Booking findByIdCP(int id) {
        Booking booking = null;
        System.out.println("Login connection pool....");
        try {
            String sqlSelect = "select * from `booking` where id=\""+id+"\"";

            try (Connection con = DataAccessHelper.getConnection();
                 Statement statement = con.createStatement();
                 ResultSet rs=statement.executeQuery(sqlSelect);) {
                //Thread.sleep(2000);
                rs.next();
                booking = new Booking(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("user")),
                        Integer.parseInt(rs.getString("seat")),
                        rs.getString("departure"),
                        Integer.parseInt(rs.getString("route")),
                        rs.getString("createdDate"),
                        rs.getString("updatedDate"),
                        rs.getString("updatedBy"),
                        Integer.parseInt(rs.getString("isactive")),
                        Integer.parseInt(rs.getString("ispaid"))
                );
            }

        } catch (SQLException e){// | InterruptedException e) {
            e.printStackTrace();
        }
        return booking;
    }

    public boolean update(int id, int updatedBy) {
        System.out.println("Start cancel booking repository....");

        Date updatedDate = new Date();
        String SQL="update `booking` set "+
                    "isactive=\""+ 0 +"\"," +
                    "updatedDate=\""+ (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(updatedDate) +"\","+
                    "updatedBy=\""+ updatedBy +"\"" +
                    "where `id`=\"" + id + "\""
                    ;

        try(Connection con = DataAccessHelper.getConnection();
            Statement statement = con.createStatement()){

            int rs=statement.executeUpdate(SQL);
            if(rs>0)
            {
                System.out.println("End cancel booking repository: " + rs);

                return true;
            }
            else
            {
                System.out.println("End cancel booking repository: " + rs);

                return false;
            }
        } catch (Exception e) {return false;}
    }

    public boolean updateCP(int id, int updatedBy) {
        System.out.println("Login connection pool....");

        Date updatedDate = new Date();
        String SQL="update `booking` set "+
                "isactive=\""+ 0 +"\"," +
                "updatedDate=\""+ (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(updatedDate) +"\","+
                "updatedBy=\""+ updatedBy +"\"" +
                "where `id`=\"" + id + "\""
                ;

        try
            (Statement statement =DataAccessHelper.getConnection().createStatement();){
            int rs=statement.executeUpdate(SQL);
            if(rs>0)
            {
                return true;
            }
            else
            {

                return false;
            }
        } catch (Exception e) {return false;}
    }

    public boolean payBookingCP(int id, int updatedBy) {
        System.out.println("Login connection pool....");

        Date updatedDate = new Date();
        String SQL="update `booking` set "+
                "ispaid=\""+ 1 +"\"," +
                "updatedDate=\""+ (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(updatedDate) +"\","+
                "updatedBy=\""+ updatedBy +"\"" +
                "where `id`=\"" + id + "\""
                ;

        try
                (Statement statement =DataAccessHelper.getConnection().createStatement();){
            int rs=statement.executeUpdate(SQL);
            if(rs>0)
            {
                return true;
            }
            else
            {

                return false;
            }
        } catch (Exception e) {return false;}
    }

    public ArrayList<Booking> findAll() {

        String SQL = "select * from `booking`";
        ArrayList<Booking> list = new ArrayList<>();
        try(Connection con = DataAccessHelper.getConnection();
            Statement statement = con.createStatement()){
            
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                list.add(new Booking(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("user")),
                        Integer.parseInt(rs.getString("seat")),
                        rs.getString("departure"),
                        Integer.parseInt(rs.getString("route")),
                        rs.getString("createdDate"),
                        rs.getString("updatedDate"),
                        rs.getString("updatedBy"),
                        Integer.parseInt(rs.getString("isactive")),
                        Integer.parseInt(rs.getString("ispaid"))
                ));
            }
            
        } catch (Exception e) {}
        return list;
    }

    public boolean update(int id, int updatedBy, int pay) {

        Date updatedDate = new Date();
        String SQL="update `booking` set "+
                    "ispaid=\""+ 1 +"\"," +
                    "updatedDate=\""+ (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(updatedDate) +"\","+
                    "updatedBy=\""+ updatedBy +"\"" +
                    "where `id`=\"" + id + "\""
                    ;
            
        try(Connection con = DataAccessHelper.getConnection();
            Statement statement = con.createStatement()){
            int rs=statement.executeUpdate(SQL);
            if(rs>0)
            {
                
                return true;
            }
            else
            {
                
                return false;
            }
        } catch (Exception e) {return false;}
    }
    
}
