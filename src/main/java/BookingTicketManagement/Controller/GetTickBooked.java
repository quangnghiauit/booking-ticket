
package BookingTicketManagement.Controller;

import BookingTicketManagement.Model.BookingDTO;
import BookingTicketManagement.Service.CustomerManagementService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "GetTickBooked", urlPatterns = {"/customer/tick-booked"})
public class GetTickBooked extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public GetTickBooked() {
        super();
    }
    
    private CustomerManagementService service = new CustomerManagementService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Start get ticket booked controller....");

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String user = (String) request.getSession().getAttribute("username");
        ArrayList<BookingDTO> listBooking = service.getBookings(user);
        
        request.setAttribute("listBooking", listBooking);

        System.out.println("End get ticket booked controller....");

        request.getRequestDispatcher("/tickBooked.jsp").forward(request, response);
    }
    
    
}
