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
        System.out.println("Start booking ticket service....");

        User user = userRepository.findByUserNameCP(username);
        if(user == null)
            return false;
        System.out.println("End booking ticket service....");

        return bookingRepository.save(user.getId(), seatId, route, departureTime); 
    }

    public ArrayList<BookingDTO> getBookings(String username) {
        System.out.println("Start get ticket booked service....");

        User user = userRepository.findByUserNameCP(username);
        
        ArrayList<Booking> bookings = bookingRepository.findByUserIdCP(user.getId());
        
        ArrayList<BookingDTO> listBooking = new ArrayList<>();
                
        for(Booking booking : bookings) {
            
            Seat seat = seatRepository.findByIdCP(booking.getSeat());
            Bus bus = busRepository.findByIdCP(seat.getBus());
            Type type = typeRepository.findByIdCP(bus.getType());
            Route route = routeRepository.findByIdCP(booking.getRoute());
            Bus_Route busRoute = busRouteRepository.findCP(seat.getBus(),route.getId());
            
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
        System.out.println("End get ticket booked service....");

        return listBooking;
    }

    public boolean cancelBooking(int id, String username) throws ParseException {
        System.out.println("Start cancel booking service....");

        User user = userRepository.findByUserNameCP(username);
        
        Booking booking = bookingRepository.findByIdCP(id);
        
        Date createdDate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(booking.getCreatedDate());
        Date now = new Date();
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createdDate);
        calendar.add(Calendar.HOUR, 24);
        if(calendar.getTime().before(now)) {
            return false;
        }
        System.out.println("End cancel booking service....");

        return bookingRepository.update(id,user.getId());
    }
}
