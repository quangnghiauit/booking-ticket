
package BookingTicketManagement.Controller;

import BookingTicketManagement.Model.BookingDTO;
import BookingTicketManagement.Model.Route;
import BookingTicketManagement.Model.Type;
import BookingTicketManagement.Service.SellerManagementService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ManageTicket", urlPatterns = {"/seller/manage-ticket"})
public class ManageTicket extends HttpServlet {

   private static final long serialVersionUID = 1L;
    public ManageTicket() {
        super();
    }

    private SellerManagementService service = new SellerManagementService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        ArrayList<Type> types = service.getTypes();
        ArrayList<Route> routes = service.getRoutes();
        ArrayList<BookingDTO> listBooking = service.getBookings();
        
        request.setAttribute("listBooking", listBooking);
        request.setAttribute("types", types);
        request.setAttribute("routes", routes);
        
        request.getRequestDispatcher("/manageTicket.jsp").forward(request, response);
    }
    
}
