/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookingTicketManagement.Controller;

import BookingTicketManagement.Service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public Register() {
        super();
    }
    
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.sendRedirect(request.getContextPath() + "/register.jsp");
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String displayname = request.getParameter("displayname");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        
        if(service.register(username,password,displayname,phonenumber
                ,address,email)) {
            response.sendRedirect(request.getContextPath() + "/login");
        }
        else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    
}
