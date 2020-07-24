package BookingTicketManagement.Service;

import BookingTicketManagement.Model.Booking;
import BookingTicketManagement.Model.Bus;
import BookingTicketManagement.Model.BusDTO;
import BookingTicketManagement.Model.Bus_Route;
import BookingTicketManagement.Model.Role;
import BookingTicketManagement.Model.Route;
import BookingTicketManagement.Model.Seat;
import BookingTicketManagement.Model.SeatDTO;
import BookingTicketManagement.Model.Type;
import BookingTicketManagement.Model.User;
import BookingTicketManagement.Model.UserDTO;
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
import java.util.Calendar;
import java.util.Date;

public class UserService {

	private UserRepository userRepository = new UserRepository();
	private RoleRepository roleRepository = new RoleRepository();
    private TypeRepository typeRepository = new TypeRepository();
    private RouteRepository routeRepository = new RouteRepository();
    private BusRepository busRepository = new BusRepository();
    private SeatRepository seatRepository = new SeatRepository();
    private BookingRepository bookingRepository = new BookingRepository();
    private BusRouteRepository busRoundRepository = new BusRouteRepository();
        
	public boolean login(String username, String password) {
		
		User user = userRepository.findByUserNameCP(username);
		if(user == null)
			return false;
		
		if(user.getPassword().equals(password))
			return true;
		else
			return false;
	}

	public UserDTO getUser(String username) {

		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByID(user.getRoleID());
		
		return new UserDTO(
				user.getId(),
				user.getRoleID(),
				role.getRole(),
				user.getUsername(),
				user.getPassword(),
				user.getDisplayname(),
				user.getIsactive(),
				user.getCreatedDate(),
				user.getCreatedBy(),
				user.getUpdatedDate(),
				user.getUpdatedBy(),
				user.getPhonenumber(),
				user.getAddress(),
				user.getEmail());
	}

    public boolean register(String username, String password, String displayname, String phonenumber, String address, String email) {

        User user = userRepository.findByUsername(username);
        if(user != null)
            return false;
        
        Role role = roleRepository.findByName("CUSTOMER");
        if(role==null)
            return false;
        
        return userRepository.save(username,password,role.getId(),displayname,
                phonenumber,address,email,-1);
    }

    public boolean updateInfoUser(int id, String password, String displayname, String phonenumber, String address, String email) {

        User user = userRepository.findByID(id);
        if(user == null)
            return false;
        
        return userRepository.updateUser(id,password,user.getRoleID(),displayname,phonenumber,address,email,id);
  
    }

    public ArrayList<Type> getTypes() {

        return typeRepository.findAll();
    }

    public ArrayList<Route> getRoutes() {

        //return routeRepository.findAll();
        return routeRepository.findAllCP(); //connection pool here
    }


    public ArrayList<BusDTO> getBus(String departure, int route, int type) throws ParseException {

        ArrayList<Bus_Route> listBusRoute = busRoundRepository.findByRouteId(route);
        
        ArrayList<BusDTO> list = new ArrayList<>();
        
        for(Bus_Route busRoute : listBusRoute) {
            
            Bus bus = busRepository.findByIdCP(busRoute.getBusId()); //connection pool here
            Type typeBus = typeRepository.findById(bus.getType());
            Route routeBus = routeRepository.findById(busRoute.getRoundId());
            ArrayList<Seat> listSeat = seatRepository.findByBusId(bus.getId());

            Time durationTime = Time.valueOf(routeBus.getDuration());
            
            Date d_departure = (new SimpleDateFormat("yyyy-MM-dd")).parse(departure);
            Time t_departure = Time.valueOf(routeBus.getTimeGo());
            d_departure.setHours(t_departure.getHours());
            d_departure.setMinutes(t_departure.getMinutes());
            d_departure.setSeconds(t_departure.getSeconds());
            String departureTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(d_departure);
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d_departure);
            calendar.setTime(d_departure);
            calendar.add(Calendar.SECOND, durationTime.getSeconds());
            calendar.add(Calendar.MINUTE, durationTime.getMinutes());
            calendar.add(Calendar.HOUR, durationTime.getHours());
            
            String arrivalTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calendar.getTime());

            if(type != -1 && bus.getType()== type)
                list.add(new BusDTO(
                    bus.getId(),
                    bus.getName(),
                    typeBus.getName(),
                    routeBus.getFrom(),
                    routeBus.getTo(),
                    routeBus.getDuration(),
                    departureTime,
                    arrivalTime,
                    listSeat.size(),
                    busRoute.getPrice()
                ));
        }
        
        return list;
    }

    public ArrayList<SeatDTO> getSeat(int busId, String departure, int route) {
        System.out.println("Start get seat service....");

        Bus bus = busRepository.findByIdCP(busId); // connection pool here
        
        Type type = typeRepository.findById(bus.getType());
        
        ArrayList<Seat> listSeat = seatRepository.findByBusId(busId);
        
        ArrayList<SeatDTO> list = new ArrayList<>();
        
        for(Seat seat : listSeat) {
            if (list.size() == 4) return list;

            System.out.println("Start find " + list.size() + " seats");
            ArrayList<Booking> listBooking = bookingRepository.findCP(seat.getId(),departure);
            
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
                    type.getName()
            ));
            System.out.println("End Find " + list.size() + " seats");
        }
        System.out.println("End get seat service....");
        return list;
    }
}
