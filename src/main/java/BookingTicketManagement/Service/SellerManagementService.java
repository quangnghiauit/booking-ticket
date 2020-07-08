package BookingTicketManagement.Service;

import BookingTicketManagement.Model.Booking;
import BookingTicketManagement.Model.BookingDTO;
import BookingTicketManagement.Model.Bus;
import BookingTicketManagement.Model.Bus_Route;
import BookingTicketManagement.Model.Route;
import BookingTicketManagement.Model.Seat;
import BookingTicketManagement.Model.SeatDTO;
import BookingTicketManagement.Model.Type;
import BookingTicketManagement.Model.User;
import BookingTicketManagement.Repository.BookingRepository;
import BookingTicketManagement.Repository.BusRepository;
import BookingTicketManagement.Repository.BusRouteRepository;
import BookingTicketManagement.Repository.RoleRepository;
import BookingTicketManagement.Repository.RouteRepository;
import BookingTicketManagement.Repository.SeatRepository;
import BookingTicketManagement.Repository.TypeRepository;
import BookingTicketManagement.Repository.UserRepository;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class SellerManagementService {
    
    private UserRepository userRepository = new UserRepository();
    private RoleRepository roleRepository = new RoleRepository();
    private TypeRepository typeRepository = new TypeRepository();
    private RouteRepository routeRepository = new RouteRepository();
    private BusRepository busRepository = new BusRepository();
    private SeatRepository seatRepository = new SeatRepository();
    private BookingRepository bookingRepository = new BookingRepository();
    private BusRouteRepository busRouteRepository = new BusRouteRepository();

    public ArrayList<Type> getTypes() {

        return typeRepository.findAll();
    }

    public ArrayList<Route> getRoutes() {

        return routeRepository.findAll();
    }

    public ArrayList<BookingDTO> getBookings() {
        
        
        ArrayList<Booking> bookings = bookingRepository.findAll();
        
        ArrayList<BookingDTO> listBooking = new ArrayList<>();
                
        for(Booking booking : bookings) {
            
            Seat seat = seatRepository.findById(booking.getSeat());
            Bus bus = busRepository.findById(seat.getBus());
            Type type = typeRepository.findById(bus.getType());
            Route route = routeRepository.findById(booking.getRoute());
            Bus_Route busRoute = busRouteRepository.find(seat.getBus(),route.getId());
            
            listBooking.add(new BookingDTO(
                    booking.getId(),
                    booking.getUser(),
                    seat.getId(),
                    seat.getName(),
                    bus.getName(),
                    type.getName(),
                    booking.getRoute(),
                    route.getFrom(),
                    route.getTo(),
                    booking.getDeparture(),
                    busRoute.getPrice(),
                    booking.getCreatedDate(),
                    booking.getUpdatedDate(),
                    booking.getUpdatedBy(),
                    booking.getIsactive(),
                    booking.getIspaid()
            ));
        }
        return listBooking;
    }

    public boolean cancelBooking(int id, String username) {

        User user = userRepository.findByUsername(username);
        
        return bookingRepository.update(id,user.getId());
    }

    public boolean payBooking(int id, String username) {

        User user = userRepository.findByUsername(username);
        
        return bookingRepository.update(id ,user.getId(),1);
    }

    public ArrayList<BookingDTO> filterBooking(String from, String to, String departureTime, 
            String departureDate, String type, String createdDate, String ispaid, String isactive) {

        ArrayList<BookingDTO> list = (new SellerManagementService()).getBookings();
        
        if(!from.equals("none"))
            for(int i=0;i<list.size();i++){
                if(!list.get(i).getFrom().equals(from))
                {
                    list.remove(i);
                    i--;
                }
            }
        
        if(!to.equals("none"))
            for(int i=0;i<list.size();i++){
                if(!list.get(i).getTo().equals(to))
                {
                    list.remove(i);
                    i--;
                }
            }
        
        if(!departureTime.equals("none"))
            for(int i=0;i<list.size();i++){
                Route route = routeRepository.findById(list.get(i).getRoute());
                if(!route.getTimeGo().equals(departureTime))
                {    
                    list.remove(i);
                    i--;
                }
            }
        
        if(!departureDate.equals(""))
            for(int i=0;i<list.size();i++){
                String time=list.get(i).getDepartureTime().substring(0,10);
                if(!time.equals(departureDate))
                {
                    list.remove(i);
                    i--;
                }
            }
        
        if(!type.equals("none"))
            for(int i=0;i<list.size();i++){
                if(!list.get(i).getType().equals(type))
                {
                    list.remove(i);
                    i--;
                }
            }
        
        if(!createdDate.equals(""))
            for(int i=0;i<list.size();i++) {
                if(!list.get(i).getCreatedDate().substring(0,10).equals(createdDate))
                {
                    list.remove(i);
                    i--;
                }
            }
        
        if(isactive != null)
            for(int i=0;i<list.size();i++)
                if(list.get(i).getIsactive()!=1)
                {
                    list.remove(i);
                    i--;
                }
        
        if(ispaid != null)
            for(int i=0;i<list.size();i++)
                if(list.get(i).getIspaid()!=1)
                {
                    list.remove(i);
                    i--;
                }
        return list;
    }

    public ArrayList<SeatDTO> filterSeat(String from, String to, String departureTime, String departureDate, String type) {

        ArrayList<SeatDTO> list = new ArrayList<>();
                
        Route route = routeRepository.find(from,to,departureTime);
        if(route==null)
            return list;
        
        String departure= departureDate+" "+departureTime;
        
        ArrayList<Bus_Route> listBusRoute = busRouteRepository.findByRouteId(route.getId());
        
        for(Bus_Route busRoute : listBusRoute) {
            
            Bus bus = busRepository.findById(busRoute.getBusId());
            Type typeSeat = typeRepository.findById(bus.getType());
            
            ArrayList<Seat> listSeat = seatRepository.findByBusId(bus.getId());
            
            for(Seat seat : listSeat) {
                        
                ArrayList<Booking> listBooking = bookingRepository.find(seat.getId(),departure);

                boolean status = true;
                for( Booking book : listBooking) {
                    if(book.getIsactive() == 1){
                        status = false;
                        break;
                    }
                }

                list.add(new SeatDTO(
                        seat.getId(),
                        seat.getName(),
                        departure, 
                        status,
                        bus.getId(),
                        bus.getName(),
                        typeSeat.getName()
                    ));
            }            
        }
        
        if(!type.equals(""))
            for(int i=0;i<list.size();i++)
                if(!list.get(i).getType().equals(type))
                {
                    list.remove(i);
                    i--;
                }
        
        return list;
    }

    public boolean cancelSeat(int seatId, String departureTime, String username) {

        User user = userRepository.findByUsername(username);
        
        ArrayList<Booking> listBooking = bookingRepository.find(seatId, departureTime);
        
        boolean rs = true;
        for(Booking booking : listBooking) {
            if(booking.getIsactive()==1)
                rs = bookingRepository.update(booking.getId(),user.getId());
            if(!rs)
                break;
        }
        
        return rs;
    }

    
}
