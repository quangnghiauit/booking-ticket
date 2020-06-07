
package BookingTicketManagement.Controller;

import BookingTicketManagement.Service.AdminManagementService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UpdateUser", urlPatterns = {"/admin/update-user"})
public class UpdateUser extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public UpdateUser() {
        super();
    }   
    
    private AdminManagementService service = new AdminManagementService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String updatedBy = (String)request.getSession().getAttribute("username");
        String displayname = request.getParameter("displayname");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        
        if(service.updateUser(id,password,role,displayname,phonenumber
                ,address,email,updatedBy)) {
            
            response.sendRedirect(request.getContextPath() + "/manage-user");
        }
        else {
            response.sendRedirect(request.getContextPath() + "/manage-user");
        }
    }

    
    
}
