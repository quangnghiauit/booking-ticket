
package BookingTicketManagement.Controller;

import BookingTicketManagement.Model.BookingDTO;
import BookingTicketManagement.Model.Route;
import BookingTicketManagement.Model.SeatDTO;
import BookingTicketManagement.Model.Type;
import BookingTicketManagement.Service.SellerManagementService;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ManageSeat", urlPatterns = {"/seller/manage-seat"})
public class ManageSeat extends HttpServlet {

   private static final long serialVersionUID = 1L;
    public ManageSeat() {
        super();
    }

    private SellerManagementService service = new SellerManagementService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        ArrayList<Type> types = service.getTypes();
        ArrayList<Route> routes = service.getRoutes();
        
        request.setAttribute("types", types);
        request.setAttribute("routes", routes);
        
        request.getRequestDispatcher("/manageSeat.jsp").forward(request, response);
    }
    
}
