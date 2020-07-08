
package BookingTicketManagement.Model;


public class Seat {
    
    private int id;
    private String name;
    private int bus;

    public Seat(int id, String name, int bus) {
        this.id = id;
        this.name = name;
        this.bus = bus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBus() {
        return bus;
    }
    
}
