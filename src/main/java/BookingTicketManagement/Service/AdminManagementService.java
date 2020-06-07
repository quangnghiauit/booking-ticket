package BookingTicketManagement.Service;

import BookingTicketManagement.Model.Role;
import BookingTicketManagement.Model.User;
import BookingTicketManagement.Model.UserDTO;
import BookingTicketManagement.Repository.RoleRepository;
import BookingTicketManagement.Repository.UserRepository;
import java.util.ArrayList;

public class AdminManagementService {

    private UserRepository userRepository = new UserRepository();
    private RoleRepository roleRepository = new RoleRepository();

    public boolean createUser(String username, String password, String roleName, 
            String displayname, String phonenumber, String address, String email, String createdBy) {

        User user = userRepository.findByUsername(username);
        if(user != null)
            return false;
        
        User userCreate = userRepository.findByUsername(createdBy);
        if(userCreate==null)
            return false;
        
        Role role = roleRepository.findByName(roleName);
        if(role==null)
            return false;
        
        return userRepository.save(username,password,role.getId(),displayname,
                phonenumber,address,email,userCreate.getId());
    }

    public boolean updateUser(int id, String password, String roleName, String displayname, 
            String phonenumber, String address, String email, String updatedBy) {

        User user = userRepository.findByID(id);
        if(user == null)
            return false;
        
        User userUpdate = userRepository.findByUsername(updatedBy);
        if(userUpdate == null)
            return false;
        
        if(user.getId() == userUpdate.getId())
            return false;
        
        Role role = roleRepository.findByName(roleName);
        if(role == null )
            return false;
        
        return userRepository.updateUser(id,password,role.getId(),displayname,phonenumber,address,email,userUpdate.getId());
    }

    public ArrayList<UserDTO> getUsers() {
        
        ArrayList<UserDTO> list = new ArrayList<>();
        ArrayList<User> listUser = userRepository.findAll();
        
        for(User user : listUser) {
            
            Role role = roleRepository.findByID(user.getRoleID());
            
            list.add(new UserDTO(
                    user.getId(),
                    user.getRoleID(),
                    role.getRole(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getDisplayname(),
                    user.getIsactive(),
                    user.getCreatedDate(),
                    user.getCreatedBy(),
                    user.getUpdatedDate(),
                    user.getUpdatedBy(),
                    user.getPhonenumber(),
                    user.getAddress(),
                    user.getEmail()
            ));
        }
        
        return list;
    }

    public ArrayList<Role> getRoles() {

        return roleRepository.findAll();
    }

}
