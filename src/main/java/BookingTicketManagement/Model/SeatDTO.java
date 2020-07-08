
package BookingTicketManagement.Model;


public class SeatDTO {
    
    private int id;
    private String name;
    private String departure;
    private boolean status; //false : can't book, true : can book
    private int busId;
    private String busName;
    private String type;
    

    public SeatDTO(int id, String name, String departure, boolean status, int busId, String busName, String type) {
        this.id = id;
        this.name = name;
        this.departure = departure;
        this.status = status;
        this.busId = busId;
        this.busName = busName;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeparture() {
        return departure;
    }

    public boolean getStatus() {
        return status;
    }

    public int getBusId() {
        return busId;
    }

    public String getBusName() {
        return busName;
    }

    public String getType() {
        return type;
    }
    
}
