
package BookingTicketManagement.Controller;

import BookingTicketManagement.Service.SellerManagementService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CancelSeat", urlPatterns = {"/seller/cancel-seat"})
public class CancelSeat extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public CancelSeat() {
        super();
    }

    private SellerManagementService service = new SellerManagementService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("seatId"));
        String departureTime = (String) request.getParameter("departureTimeCancel");
        String user = (String) request.getSession().getAttribute("username");
        
        service.cancelSeat(id,departureTime,user);
        response.sendRedirect(request.getContextPath() + "/seller/manage-seat");
    }
}
