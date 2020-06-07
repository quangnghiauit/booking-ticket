
package BookingTicketManagement.Controller;

import BookingTicketManagement.Service.CustomerManagementService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CancelBookingCustomer", urlPatterns = {"/customer/cancel-booking"})
public class CancelBookingCustomer extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public CancelBookingCustomer() {
        super();
    }

    private CustomerManagementService service = new CustomerManagementService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String user = (String) request.getSession().getAttribute("username");
        
        try {
            service.cancelBooking(id,user);
        } catch (ParseException ex) {
            Logger.getLogger(CancelBookingCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect(request.getContextPath() + "/customer/tick-booked");
    }

    
}
