package BookingTicketManagement.Repository;

import BookingTicketManagement.Model.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RoleRepository {

	public Role findByID(int id) {

		String SQL = "select * from `role` where id=\""+id+"\"";
        Role role = null;
        try(Connection con = DataAccessHelper.getConnection();
            Statement statement = con.createStatement()){
            
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                role = new Role(
                    Integer.parseInt(rs.getString("id")),
                    rs.getString("role")
                );
            }
            
        } catch (Exception e) {}
        return role;
	}

    public Role findByName(String roleName) {

        String SQL = "select * from `role` where role=\""+roleName+"\"";
        Role role = null;
        try(Connection con = DataAccessHelper.getConnection();
            Statement statement = con.createStatement()){
            
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                role = new Role(
                    Integer.parseInt(rs.getString("id")),
                    rs.getString("role")
                );
            }
            
        } catch (Exception e) {}
        return role;
    }

    public ArrayList<Role> findAll() {

        String SQL = "select * from `role`";
        ArrayList<Role> list = new ArrayList<>();
        try(Connection con = DataAccessHelper.getConnection();
            Statement statement = con.createStatement()){
            
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next()) {
                list.add(new Role(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("role")
                ));
            }
            
        } catch (Exception e) {}
        return list;
    }

}
