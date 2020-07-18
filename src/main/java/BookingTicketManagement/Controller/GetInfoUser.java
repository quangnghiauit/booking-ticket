
package BookingTicketManagement.Controller;

import BookingTicketManagement.Model.UserDTO;
import BookingTicketManagement.Service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetInfoUser", urlPatterns = {"/user/get-info-user"})
public class GetInfoUser extends HttpServlet {

    
    private static final long serialVersionUID = 1L;
    public GetInfoUser() {
        super();
    }
    
    private UserService service = new UserService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String username = (String) request.getSession().getAttribute("username");
        UserDTO user = service.getUser(username);
        
        request.setAttribute("user", user);
        
        request.getRequestDispatcher("/user-info.jsp").forward(request, response);
    }
}
