
package BookingTicketManagement.Model;


public class Route {
    private int id;
    private String from;
    private String to;
    private String timeGo;
    private String duration;

    public Route(int id, String from, String to, String timeGo, String duration) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.timeGo = timeGo;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getTimeGo() {
        return timeGo;
    }

    public String getDuration() {
        return duration;
    }
}
