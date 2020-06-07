
package BookingTicketManagement.Model;


public class Bus_Route {
    
    private int id;
    private int busId;
    private int roundId;
    private float price;

    public Bus_Route(int id, int busId, int roundId, float price) {
        this.id = id;
        this.busId = busId;
        this.roundId = roundId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getBusId() {
        return busId;
    }

    public int getRoundId() {
        return roundId;
    }

    public float getPrice() {
        return price;
    }
}
