
package BookingTicketManagement.Controller;

import BookingTicketManagement.Model.SeatDTO;
import BookingTicketManagement.Service.CustomerManagementService;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "BookingTicket", urlPatterns = {"/customer/booking-ticket"})
public class BookingTicket extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public BookingTicket() {
        super();
    }
    
    private CustomerManagementService service = new CustomerManagementService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Start booking ticket controller....");

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String username = (String) request.getSession().getAttribute("username");
        String seatStr = (String)request.getParameter("listSeat");
        String departureTime = (String) request.getParameter("departureTime");
        int route = Integer.parseInt(request.getParameter("route"));
        String[] listSeat = seatStr.split(",");
        for(String seatId : listSeat) {
            service.bookingTicket(username,Integer.parseInt(seatId),route,departureTime);
        }
        System.out.println("End booking ticket controller....");

        response.sendRedirect(request.getContextPath() + "/customer/tick-booked");
    }
}
