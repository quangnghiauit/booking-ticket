package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.Type;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

public class TypeRepository {

    public ArrayList<Type> findAll() {

        String SQL = "select * from `type`";
        ArrayList<Type> list = new ArrayList<>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                list.add(new Type(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name")
                ));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }

    public Type findById(int id) {

        String SQL = "select * from `type` where id=\""+id+"\"";
        Type type = null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                type = new Type(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name")
                );
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return type;
    }

}
