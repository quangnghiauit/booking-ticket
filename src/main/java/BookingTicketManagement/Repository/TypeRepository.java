package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.Type;
import BookingTicketManagement.Model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

public class TypeRepository {

    public ArrayList<Type> findAll() {

        String SQL = "select * from `type`";
        ArrayList<Type> list = new ArrayList<>();
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                list.add(new Type(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name")
                ));
            }

        } catch (Exception e) {}
        return list;
    }

    public ArrayList<Type> findAllCP() {
        ArrayList<Type> list = new ArrayList<>();
        System.out.println("Start get type repo....");

        System.out.println("Login connection pool....");
        try {
            String sqlSelect = "select * from `type`";

            try (Connection con = DataAccessHelper.getConnection();
                 Statement statement = con.createStatement();
                 ResultSet rs=statement.executeQuery(sqlSelect);) {
                //Thread.sleep(2000);
                while(rs.next()) {
                    list.add(new Type(
                            Integer.parseInt(rs.getString("id")),
                            rs.getString("name")
                    ));
                }
            }

        } catch (SQLException e) {// | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End get type repo....");

        return list;
    }

    public Type findById(int id) {

        String SQL = "select * from `type` where id=\""+id+"\"";
        Type type = null;
        try{
            
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                type = new Type(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name")
                );
            }
            
        } catch (Exception e) {}
        return type;
    }


    public Type findByIdCP(int id) {
        Type type = null;
        System.out.println("Login connection pool....");
        try {
            String sqlSelect = "select * from `type` where id=\""+id+"\"";

            try (Connection con = DataAccessHelper.getConnection();
                 Statement statement = con.createStatement();
                 ResultSet rs=statement.executeQuery(sqlSelect);) {
                //Thread.sleep(2000);
                rs.next();
                type = new Type(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name")
                );
            }

        } catch (SQLException e){// | InterruptedException e) {
            e.printStackTrace();
        }
        return type;
    }

}
