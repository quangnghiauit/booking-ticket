
package BookingTicketManagement.Model;


public class BusDTO {
    
    private int id;
    private String name;
    private String type;
    private String from;
    private String to;
    private String durationTime;
    private String departureTime;
    private String arrivalTime;
    private int totalSeat;
    private float price;

    public BusDTO(int id, String name, String type, String from, String to, String durationTime, String departureTime, String arrivalTime, int totalSeat, float price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.from = from;
        this.to = to;
        this.durationTime = durationTime;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeat = totalSeat;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public float getPrice() {
        return price;
    }
    
    
}
