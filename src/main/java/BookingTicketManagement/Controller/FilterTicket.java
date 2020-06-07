
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


@WebServlet(name = "FilterTicket", urlPatterns = {"/seller/filter-ticket"})
public class FilterTicket extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public FilterTicket() {
        super();
    }

    private SellerManagementService service = new SellerManagementService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String departureTime = request.getParameter("departureTime");
        String departureDate = request.getParameter("departureDate");
        String createdDate = request.getParameter("createdDate");
        String type = request.getParameter("type");
        String ispaid = request.getParameter("ispaid");
        String isactive = request.getParameter("isactive");
        
        ArrayList<BookingDTO> listBooking = service.filterBooking(from,to,departureTime,departureDate,type,createdDate,ispaid,isactive);
        
        ArrayList<Type> types = service.getTypes();
        ArrayList<Route> routes = service.getRoutes();
        
        request.setAttribute("listBooking", listBooking);
        request.setAttribute("types", types);
        request.setAttribute("routes", routes);

        request.getRequestDispatcher("/manageTicket.jsp").forward(request, response);
    }
    
    
}
