package BookingTicketManagement.Controller;

import BookingTicketManagement.Service.CustomerManagementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "PayBookingCustomer", urlPatterns = {"/customer/pay-booking"})
public class PayBookingCustomer extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public PayBookingCustomer() {
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
            service.payBooking(id,user);
        } catch (ParseException ex) {
            Logger.getLogger(CancelBookingCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect(request.getContextPath() + "/customer/tick-booked");
    }


}
