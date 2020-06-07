
package BookingTicketManagement.Controller;

import BookingTicketManagement.Service.SellerManagementService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CancelBookingSeller", urlPatterns = {"/seller/cancel-booking"})
public class CancelBookingSeller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public CancelBookingSeller() {
        super();
    }

    private SellerManagementService service = new SellerManagementService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String user = (String) request.getSession().getAttribute("username");
        
        service.cancelBooking(id,user);
        response.sendRedirect(request.getContextPath() + "/seller/manage-ticket");
    }
}
