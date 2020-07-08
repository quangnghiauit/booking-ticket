package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class UserRepository {

	public User findByUsername(String username) {
	
        String SQL = "select * from `user` where username=\""+username+"\"";
        User user = null;
        try{
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);            
            while(rs.next()) {
                user = new User(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("role")),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("displayname"),
                        Integer.parseInt(rs.getString("isactive")),
                        rs.getString("createdDate"),
                        rs.getString("createdBy"),
                        rs.getString("updatedDate"),
                        rs.getString("updatedBy"),
                        rs.getString("phonenumber"),
                        rs.getString("address"),
                        rs.getString("email")
                );
            }
            
        } catch (Exception e) {}
        return user;
	}

	public User findByUserNameCP(String userName) {
        User user = null;
        System.out.println("Login connection pool....");
        try {
            String sqlSelect = "select * from `user` where username=\""+userName+"\"";

            try (Connection con = DataAccessHelper.getConnection();
                 Statement statement = con.createStatement();
                 ResultSet rs=statement.executeQuery(sqlSelect);) {
                Thread.sleep(2000);
                rs.next();
                user = new User(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("role")),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("displayname"),
                        Integer.parseInt(rs.getString("isactive")),
                        rs.getString("createdDate"),
                        rs.getString("createdBy"),
                        rs.getString("updatedDate"),
                        rs.getString("updatedBy"),
                        rs.getString("phonenumber"),
                        rs.getString("address"),
                        rs.getString("email")
                );
            }

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean save(String username, String password, int role, String displayname, String phonenumber, String address, String email, int createdBy) {

        String SQL;
        Date createdDate = new Date();
        if(createdBy==-1)
            SQL="insert `user`(`username`,`password`,`role`,`displayname`,`phonenumber`,"+
                    "`address`,`email`,`createdDate`,`createdBy`) " +
                    "values(" +
                    "\""+ username +"\"," +
                    "\""+ password +"\"," +
                    "\""+ role +"\"," +
                    "\""+ displayname +"\"," +
                    "\""+ phonenumber +"\"," +
                    "\""+ address +"\"," +
                    "\""+ email +"\"," +
                    "\""+ (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(createdDate) +"\"," +
                    "null" +
                    ")";
        else
            SQL="insert `user`(`username`,`password`,`role`,`displayname`,`phonenumber`,"+
                    "`address`,`email`,`createdDate`,`createdBy`) " +
                    "values(" +
                    "\""+ username +"\"," +
                    "\""+ password +"\"," +
                    "\""+ role +"\"," +
                    "\""+ displayname +"\"," +
                    "\""+ phonenumber +"\"," +
                    "\""+ address +"\"," +
                    "\""+ email +"\"," +
                    "\""+ (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(createdDate) +"\"," +
                    "\""+ createdBy +"\"" +
                    ")"
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

    public boolean updateUser(int id, String password, int role, String displayname, String phonenumber, String address, String email, int updatedBy) {

        Date updatedDate = new Date();
        String SQL="update `user` set "+
                    "role=\""+ role +"\"," +
                    "password=\""+ password +"\"," +
                    "displayname=\""+ displayname +"\"," +
                    "phonenumber=\""+ phonenumber +"\"," +
                    "address=\""+ address +"\"," +
                    "email=\""+ email +"\"," +
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

    public User findByID(int id) {

        String SQL = "select * from `user` where id=\""+id+"\"";
        User user = null;
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                user = new User(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("role")),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("displayname"),
                        Integer.parseInt(rs.getString("isactive")),
                        rs.getString("createdDate"),
                        rs.getString("createdBy"),
                        rs.getString("updatedDate"),
                        rs.getString("updatedBy"),
                        rs.getString("phonenumber"),
                        rs.getString("address"),
                        rs.getString("email")
                );
            }
            
        } catch (Exception e) {}
        return user;
    }

    public ArrayList<User> findAll() {

        String SQL = "select * from `user`";
        ArrayList<User> list = new ArrayList<>();
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                list.add(new User(
                        Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("role")),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("displayname"),
                        Integer.parseInt(rs.getString("isactive")),
                        rs.getString("createdDate"),
                        rs.getString("createdBy"),
                        rs.getString("updatedDate"),
                        rs.getString("updatedBy"),
                        rs.getString("phonenumber"),
                        rs.getString("address"),
                        rs.getString("email")
                ));
            }
            
        } catch (Exception e) {}
        return list;
    }

}
