
package BookingTicketManagement.Controller;

import BookingTicketManagement.Service.AdminManagementService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CreateUser", urlPatterns = {"/admin/create-user"})
public class CreateUser extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public CreateUser() {
        super();
    }

    private AdminManagementService service = new AdminManagementService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String createdBy = (String)request.getSession().getAttribute("username");
        String displayname = request.getParameter("displayname");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        
        if(service.createUser(username,password,role,displayname,phonenumber
                ,address,email,createdBy)) {
            response.sendRedirect(request.getContextPath() + "/manage-user");
        }
        else {
            response.sendRedirect(request.getContextPath() + "/manage-user");
        }
    }
    
    
}
