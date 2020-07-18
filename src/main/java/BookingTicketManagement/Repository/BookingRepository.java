
package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.Booking;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookingRepository {


    public ArrayList<Booking> find(int seatId, String departure) {

        String SQL = "select * from `booking` where seat=\""+seatId+"\" and departure=\""+departure+"\"";
        ArrayList<Booking> list = new ArrayList<>();
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
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
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
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
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
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

    public Booking findById(int id) {

        String SQL = "select * from `booking` where id=\""+id+"\"";
        Booking booing = null;
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
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

    public boolean update(int id, int updatedBy) {

        Date updatedDate = new Date();
        String SQL="update `booking` set "+
                    "isactive=\""+ 0 +"\"," +
                    "updatedDate=\""+ (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(updatedDate) +"\","+
                    "updatedBy=\""+ updatedBy +"\"" +
                    "where `id`=\"" + id + "\""
                    ;
            
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
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
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
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
            
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
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
