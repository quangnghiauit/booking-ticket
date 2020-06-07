
package BookingTicketManagement.Model;


public class BookingDTO {
    
    private int id;
    private int user;
    private int seat;
    private String seatName;
    private String busName;
    private String type;
    private int route;
    private String from;
    private String to;
    private String departureTime;
    private float price;
    private String createdDate;
    private String updatedDate;
    private String updatedBy;
    private int isactive;
    private int ispaid;

    public BookingDTO(int id, int user, int seat, String seatName, String busName, String type, int route, String from, String to, String departureTime, float price, String createdDate, String updatedDate, String updatedBy, int isactive, int ispaid) {
        this.id = id;
        this.user = user;
        this.seat = seat;
        this.seatName = seatName;
        this.busName = busName;
        this.type = type;
        this.route = route;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.price = price;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
        this.isactive = isactive;
        this.ispaid = ispaid;
    }

    public int getId() {
        return id;
    }

    public int getUser() {
        return user;
    }

    public int getSeat() {
        return seat;
    }

    public String getSeatName() {
        return seatName;
    }

    public String getBusName() {
        return busName;
    }

    public String getType() {
        return type;
    }

    public int getRoute() {
        return route;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public float getPrice() {
        return price;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public int getIsactive() {
        return isactive;
    }

    public int getIspaid() {
        return ispaid;
    }

    
}
