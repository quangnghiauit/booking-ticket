/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-07 08:10:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BookingTicketManagement.Model.BookingDTO;
import java.util.ArrayList;

public final class tickBooked_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n");
      out.write("    integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\">\r\n");
      out.write("  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\r\n");
      out.write("    integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\r\n");
      out.write("    crossorigin=\"anonymous\"></script>\r\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\r\n");
      out.write("    integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\r\n");
      out.write("    crossorigin=\"anonymous\"></script>\r\n");
      out.write("  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\r\n");
      out.write("    integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\r\n");
      out.write("    crossorigin=\"anonymous\"></script>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.5.0/css/all.css\"\r\n");
      out.write("    integrity=\"sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU\" crossorigin=\"anonymous\">\r\n");
      out.write("  <link rel='stylesheet' type='text/css' media='screen' href='../css/HistoryCus.css'>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("  <!-- Navigation bar-->\r\n");
      out.write("  <nav class=\"navbar navbar-expand-sm \">\r\n");
      out.write("      <div class=\"container-fluid\">\r\n");
      out.write("          <a class=\"navbar-branch\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\">\r\n");
      out.write("          <img src=\"../images/logo4.png\" height=\"50\">\r\n");
      out.write("        </a>\r\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\">\r\n");
      out.write("           <span class=\"navbar-toggler-icon\"></span> \r\n");
      out.write("        </button>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\r\n");
      out.write("          <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("              ");

                    out.print("<li class=\"nav-item\">");
                    out.print("<a class=\"nav-link active\" href=\""+request.getContextPath()+"/\">Home</a>");
                    out.print("</li>");
                    out.print("<li class=\"nav-item\">");
                    out.print("<a class=\"nav-link active\" href=\""+request.getContextPath()+"/customer/tick-booked\">My Ticks</a>");
                    out.print("</li>");
                    out.print("<div class=\"dropdown drd\">");
                    out.print("<button class=\"btn btn-default dropdown-toggle hl\" data-toggle=\"dropdown\">");
                    out.print("<i class=\"fas fa-user-alt\"></i>");
                    out.print(request.getSession().getAttribute("displayname"));
                    out.print("</button>");
                    out.print("<div class=\"dropdown-menu\">");
                    out.print("<a class=\"dropdown-item\" href=\""+request.getContextPath()+"/user/get-info-user\">Profile</a>");
                    out.print("<a class=\"dropdown-item\" onclick='toggleLogout()' href=\"#\">Logout</a>");  
              
      out.write("\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("  </nav>\r\n");
      out.write("  <div class=\"col-12 text-center hd\">\r\n");
      out.write("    <h2>Booked ticket</h2>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- animation search -->\r\n");
      out.write("  \r\n");
      out.write("      <div class=\"searchbar\" style=\"margin-left:75%; margin-bottom: 2%;\">\r\n");
      out.write("        <input type=\"text\" class=\"search\" id=\"search\" placeholder=\"Search...\">\r\n");
      out.write("        <button onclick=\"toggleSearch()\" class=\"search_icon\"><i class=\"fas fa-search\"></i></button>\r\n");
      out.write("      </div>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("  <div class=\"col-12 tb\">\r\n");
      out.write("    <table id='table-booking' class=\"table table-bordered\">\r\n");
      out.write("      <thead>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <th>ID</th>\r\n");
      out.write("          <th>Departure time </th>\r\n");
      out.write("          <th>From</th>\r\n");
      out.write("          <th>To</th>\r\n");
      out.write("          <th>Seat</th>\r\n");
      out.write("          <th>Type seat</th>\r\n");
      out.write("          <th>Bus</th>\r\n");
      out.write("          <th>Created date</th>\r\n");
      out.write("          <th>Pay</th>\r\n");
      out.write("          <th>Action</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </thead>\r\n");
      out.write("      <tbody>\r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("          ");
 ArrayList<BookingDTO> list= (ArrayList<BookingDTO>) request.getAttribute("listBooking");
                   for(BookingDTO booking : list) {
                        out.println("<tr id=\""+booking.getId()+"\">");
                        out.println("<td scope=\"row\">"+booking.getId()+"</td>");
                        out.println("<td>"+booking.getDepartureTime()+"</td>");
                        out.println("<td>"+booking.getFrom()+"</td>");
                        out.println("<td>"+booking.getTo()+"</td>");
                        out.println("<td>"+booking.getSeatName()+"</td>");
                        out.println("<td>"+booking.getType()+"</td>");
                        out.println("<td>"+booking.getBusName()+"</td>");
                        out.println("<td>"+booking.getCreatedDate()+"</td>");
                        out.println("<td>");
                        if(booking.getIspaid()==1)
                            out.println("<button class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#updateModel\" disabled>Paied</button>");
                        else
                            out.println("<button onclick=\"togglePay('"+booking.getId()+"')\" class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#updateModel\">Pay</button>");
                        out.println("</td>");
                        out.println("<td>");
                        if(booking.getIsactive()==0)
                            out.println("<button class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#updateModel\" disabled >Cancel</button>");
                        else
                            out.println("<button onclick=\"toggleCancel('"+booking.getId()+"')\" class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#updateModel\">Cancel</button>");
                        out.println("</td>");
                        out.println("</tr>");     
                      }
                  
      out.write("\r\n");
      out.write("      </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("  </div>\r\n");
      out.write("  <form id='form' action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/cancel-booking\" method=\"post\" style=\"display: none\">\r\n");
      out.write("    <input type=\"text\" name=\"id\" id='booking' name='id' class=\"form-control\">\r\n");
      out.write("    <button type='submit' id='submitCancel'></button>\r\n");
      out.write("  </form>\r\n");
      out.write("    \r\n");
      out.write("    <form id='formLogout' action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/logout\" method=\"post\" style=\"display: none;\">\r\n");
      out.write("  \r\n");
      out.write("  </form>\r\n");
      out.write("  <script>\r\n");
      out.write("    function toggleCancel(id) {\r\n");
      out.write("      document.getElementById('booking').value=id;\r\n");
      out.write("      document.getElementById('form').submit();\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function toggleSearch() {\r\n");
      out.write("      let td, txtValue, display;\r\n");
      out.write("      const filter = document.getElementById(\"search\").value.toUpperCase();\r\n");
      out.write("      const table = document.getElementById(\"table-booking\");\r\n");
      out.write("      const tr = table.getElementsByTagName(\"tr\");\r\n");
      out.write("      for (let i = 1; i < tr.length; i++) {\r\n");
      out.write("        td = tr[i].getElementsByTagName(\"td\");\r\n");
      out.write("        display = false;\r\n");
      out.write("        for (let j = 0; j < td.length; j++) {\r\n");
      out.write("          txtValue = td[j].textContent || td[j].innerText;\r\n");
      out.write("          if (txtValue.toUpperCase().indexOf(filter) > -1) {\r\n");
      out.write("            display = true;\r\n");
      out.write("            break;\r\n");
      out.write("          }\r\n");
      out.write("        }\r\n");
      out.write("        if (display) {\r\n");
      out.write("          tr[i].style.display = \"\";\r\n");
      out.write("        } else {\r\n");
      out.write("          tr[i].style.display = \"none\";\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("      }\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    function toggleLogout(){\r\n");
      out.write("        document.getElementById('formLogout').submit();\r\n");
      out.write("      }\r\n");
      out.write("  </script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
