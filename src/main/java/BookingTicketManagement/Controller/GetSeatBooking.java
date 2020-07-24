
package BookingTicketManagement.Controller;

import BookingTicketManagement.Model.BusDTO;
import BookingTicketManagement.Model.Route;
import BookingTicketManagement.Model.SeatDTO;
import BookingTicketManagement.Service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "GetSeatBooking", urlPatterns = {"/get-seat-booking"})
public class GetSeatBooking extends HttpServlet {

    public GetSeatBooking() {
        super();
    }

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Start get seat booking controller....");

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        int busId = Integer.parseInt(request.getParameter("busId"));
        String busName = request.getParameter("busName");
        String departureTime = request.getParameter("departureTime");
        int routeId = Integer.parseInt(request.getParameter("route"));
        String price = request.getParameter("price");

        ArrayList<SeatDTO> listSeat = service.getSeat(busId,departureTime,routeId);
        Route route = null;
        for(Route item : service.getRoutes()){
            if(item.getId()==routeId){
                route = item;
                break;
            }
            /*route = item;
            break;*/
        }

        if(route == null)
        {
            response.getWriter().println("Route null");
            return;
        }

        request.setAttribute("busName", busName);
        request.setAttribute("price", price);
        request.setAttribute("listSeat", listSeat);
        request.setAttribute("route", route);
        request.setAttribute("departureTime", departureTime);

        request.getRequestDispatcher("/bookingSeat.jsp").forward(request, response);
        System.out.println("End get seat booking controller....");
    }
}
