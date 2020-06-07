
package BookingTicketManagement.Model;


public class Booking {
    
    private int id;
    private int user;
    private int seat;
    private String departure;
    private int route;
    private String createdDate;
    private String updatedDate;
    private String updatedBy;
    private int isactive;
    private int ispaid;

    public Booking(int id, int user, int seat, String departure, int route, String createdDate, String updatedDate, String updatedBy, int isactive, int ispaid) {
        this.id = id;
        this.user = user;
        this.seat = seat;
        this.departure = departure;
        this.route = route;
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

    public String getDeparture() {
        return departure;
    }

    public int getRoute() {
        return route;
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
