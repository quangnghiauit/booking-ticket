
package BookingTicketManagement.Controller;

import BookingTicketManagement.Model.BusDTO;
import BookingTicketManagement.Model.Route;
import BookingTicketManagement.Model.SeatDTO;
import BookingTicketManagement.Model.Type;
import BookingTicketManagement.Service.UserService;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetBusBooking", urlPatterns = {"/get-bus-booking"})
public class GetBusBooking extends HttpServlet {
    
    public GetBusBooking() {
        super();
    }
    
    private UserService service = new UserService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Start get bus booking controller....");

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String departureTime = request.getParameter("departureTime");
        String departureDate = request.getParameter("departureDate");
        int type = Integer.parseInt(request.getParameter("type"));
        
        Route route = null;
        
        for(Route item : service.getRoutes()) {
            /*if(item.getFrom().equals(from) && item.getTo().equals(to) && item.getTimeGo().equals(departureTime)){
                route = item;
                break;
            }*/
            route = item;
            break;
        }
        
        if(route == null) {
            
            request.setAttribute("listBus", null);
            ArrayList<Type> types = service.getTypes();
            ArrayList<Route> listRoute = service.getRoutes();

            request.setAttribute("types", types);
            request.setAttribute("listRoute", listRoute);
            request.getRequestDispatcher("/bookingBus.jsp").forward(request, response);
            return;
        }
        
        ArrayList<BusDTO> listBus = null;
        try {
            listBus = service.getBus(departureDate,route.getId(),type);
        } catch (ParseException ex) {
            Logger.getLogger(GetBusBooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HashMap<Integer, ArrayList<SeatDTO>> listSeatByBusId = new HashMap<>();
        
        /*for(BusDTO bus : listBus) {
            
            ArrayList<SeatDTO> listSeat = service.getSeat(bus.getId(),bus.getDepartureTime(),route.getId());
            listSeatByBusId.put(bus.getId(), listSeat);
        }*/
        
        ArrayList<Type> types = service.getTypes();
        ArrayList<Route> listRoute = service.getRoutes();
        
        request.setAttribute("types", types);
        request.setAttribute("listRoute", listRoute);
        
        request.setAttribute("route", route);
        request.setAttribute("listBus", listBus);
        request.setAttribute("listSeatByBusId", listSeatByBusId);
                
        request.getRequestDispatcher("/bookingBus.jsp").forward(request, response);
        System.out.println("End get bus booking controller....");
    }
}
