package BookingTicketManagement.Service;

import BookingTicketManagement.Model.Booking;
import BookingTicketManagement.Model.BookingDTO;
import BookingTicketManagement.Model.Bus;
import BookingTicketManagement.Model.Bus_Route;
import BookingTicketManagement.Model.Route;
import BookingTicketManagement.Model.Seat;
import BookingTicketManagement.Model.Type;
import BookingTicketManagement.Model.User;
import BookingTicketManagement.Repository.BookingRepository;
import BookingTicketManagement.Repository.BusRepository;
import BookingTicketManagement.Repository.BusRouteRepository;
import BookingTicketManagement.Repository.RouteRepository;
import BookingTicketManagement.Repository.SeatRepository;
import BookingTicketManagement.Repository.TypeRepository;
import BookingTicketManagement.Repository.UserRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class CustomerManagementService {
    
    private BookingRepository bookingRepository= new BookingRepository();
    
    private BusRepository busRepository = new BusRepository();
    
    private SeatRepository seatRepository = new SeatRepository();
    
    private TypeRepository typeRepository = new TypeRepository();
    
    private UserRepository userRepository = new UserRepository();
    
    private RouteRepository routeRepository = new RouteRepository();
    
    private BusRouteRepository busRouteRepository = new BusRouteRepository();


    public boolean bookingTicket(String username, int seatId, int route, String departureTime) {
        
        User user = userRepository.findByUsername(username);
        if(user == null)
            return false;
        
        return bookingRepository.save(user.getId(), seatId, route, departureTime); 
    }

    public ArrayList<BookingDTO> getBookings(String username) {

        User user = userRepository.findByUsername(username);
        
        ArrayList<Booking> bookings = bookingRepository.findByUserId(user.getId());
        
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

    public boolean cancelBooking(int id, String username) throws ParseException {

        User user = userRepository.findByUsername(username);
        
        Booking booking = bookingRepository.findById(id);
        
        Date createdDate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(booking.getCreatedDate());
        Date now = new Date();
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createdDate);
        calendar.add(Calendar.HOUR, 24);
        if(calendar.getTime().before(now)) {
            return false;
        }
        
        return bookingRepository.update(id,user.getId());
    }
}
