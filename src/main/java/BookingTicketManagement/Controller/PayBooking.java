
package BookingTicketManagement.Controller;

import BookingTicketManagement.Service.SellerManagementService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PayBooking", urlPatterns = {"/seller/pay-booking"})
public class PayBooking extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public PayBooking() {
        super();
    }

    private SellerManagementService service = new SellerManagementService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String user = (String) request.getSession().getAttribute("username");
        
        service.payBooking(id,user);
        response.sendRedirect(request.getContextPath() + "/seller/manage-ticket");
    }
    
    
}
