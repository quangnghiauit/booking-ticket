package BookingTicketManagement.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BookingTicketManagement.Model.UserDTO;
import BookingTicketManagement.Service.UserService;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public Login() {
            super();
        }

        private UserService service = new UserService();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("utf-8");
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if(service.login(username, password)) {

                    HttpSession session = request.getSession();
                    UserDTO user = service.getUser(username);
                    session.setAttribute("username", username);
                    session.setAttribute(("displayname"), user.getDisplayname());
                    session.setAttribute("role", user.getRole());
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
            else
                response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

}
