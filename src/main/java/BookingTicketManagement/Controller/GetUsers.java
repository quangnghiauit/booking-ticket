
package BookingTicketManagement.Controller;

import BookingTicketManagement.Model.Role;
import BookingTicketManagement.Model.UserDTO;
import BookingTicketManagement.Service.AdminManagementService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "GetUsers", urlPatterns = {"/admin/get-all-users"})
public class GetUsers extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public GetUsers() {
        super();
    }
    
    private AdminManagementService service = new AdminManagementService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        ArrayList<UserDTO> list = service.getUsers();
        ArrayList<Role> listRole = service.getRoles();
        
        request.setAttribute("listUser", list);
        request.setAttribute("listRole", listRole);
        
        request.getRequestDispatcher("/manage-user.jsp").forward(request, response);
    }

}
