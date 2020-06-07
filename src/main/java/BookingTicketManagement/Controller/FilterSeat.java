
package BookingTicketManagement.Controller;

import BookingTicketManagement.Model.BookingDTO;
import BookingTicketManagement.Model.Route;
import BookingTicketManagement.Model.SeatDTO;
import BookingTicketManagement.Model.Type;
import BookingTicketManagement.Service.SellerManagementService;
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


@WebServlet(name = "FilterSeat", urlPatterns = {"/seller/filter-seat"})
public class FilterSeat extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public FilterSeat() {
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
        String type = request.getParameter("type");
        
        ArrayList<SeatDTO> listSeat = service.filterSeat(from,to,departureTime,departureDate,type);
        
        ArrayList<Type> types = service.getTypes();
        ArrayList<Route> routes = service.getRoutes();
        
        request.setAttribute("listSeat", listSeat);
        request.setAttribute("types", types);
        request.setAttribute("routes", routes);

        request.getRequestDispatcher("/manageSeat.jsp").forward(request, response);
    }
}
