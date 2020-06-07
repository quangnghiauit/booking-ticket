
package BookingTicketManagement.Config.Authentication;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName = "CustomerAuthentication", urlPatterns = {"/customer/*"})
public class CustomerAuthentication implements Filter {
    
    
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        try{
            String role = (String) request.getSession(false).getAttribute("role");

            if (role.equals("CUSTOMER")) {
                chain.doFilter(req, res);

            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
        }
        catch(Exception e) {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {

    }
}
