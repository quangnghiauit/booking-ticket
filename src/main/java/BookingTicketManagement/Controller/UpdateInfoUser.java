
package BookingTicketManagement.Controller;

import BookingTicketManagement.Service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UpdateInfoUser", urlPatterns = {"/user/update-info-user"})
public class UpdateInfoUser extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public UpdateInfoUser() {
        super();
    }
    
    private UserService service = new UserService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");
        String displayname = request.getParameter("displayname");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        
        if(service.updateInfoUser(id,password,displayname,phonenumber
                ,address,email)) {
            request.getSession().setAttribute(("displayname"), displayname);
            response.sendRedirect(request.getContextPath() + "/user/get-info-user");
        }
        else {
            response.sendRedirect(request.getContextPath() + "/user/get-info-user");
        }
    }
}
