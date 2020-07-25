/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-25 14:19:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BookingTicketManagement.Model.Route;
import java.util.ArrayList;
import java.util.HashSet;
import BookingTicketManagement.Model.Type;
import BookingTicketManagement.Model.BookingDTO;
import java.util.ArrayList;

public final class manageTicket_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("      <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("      <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\">  \n");
      out.write("      <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("      <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("      <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("      <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.5.0/css/all.css\" integrity=\"sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU\" crossorigin=\"anonymous\">  \n");
      out.write("      <link rel='stylesheet' type='text/css' media='screen' href='../css/SearchTicket.css'>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("      <!-- Navigation bar-->\n");
      out.write("  <nav class=\"navbar navbar-expand-md navbar-light bg-light fixed-top\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("          <a class=\"navbar-branch\" href=\"#\">\n");
      out.write("          <img src=\"../images/logo4.png\" height=\"50\">\n");
      out.write("          </a>\n");
      out.write("          <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\">\n");
      out.write("             <span class=\"navbar-toggler-icon\"></span> \n");
      out.write("          </button>\n");
      out.write("          <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n");
      out.write("            <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                ");

                    out.print("<li class=\"nav-item\">");
                    out.print("<a class=\"nav-link active\" href=\""+request.getContextPath()+"/\">Home</a>");
                    out.print("</li>");
                    out.print("<li class=\"nav-item\">");
                    out.print("<a class=\"nav-link active\" href=\""+request.getContextPath()+"/seller/manage-ticket\">Manage tickets</a>");
                    out.print("</li>");
                    out.print("<li class=\"nav-item\">");
                    out.print("<a class=\"nav-link active\" href=\""+request.getContextPath()+"/seller/manage-seat\">Manage seats</a>");
                    out.print("</li>");
                    out.print("<div class=\"dropdown drd\">");
                    out.print("<button class=\"btn btn-default dropdown-toggle hl\" data-toggle=\"dropdown\">");
                    out.print("<i class=\"fas fa-user-alt\"></i>");
                    out.print(request.getSession().getAttribute("displayname"));
                    out.print("</button>");
                    out.print("<div class=\"dropdown-menu\">");
                    out.print("<a class=\"dropdown-item\" href=\""+request.getContextPath()+"/user/get-info-user\">Profile</a>");
                    out.print("<a class=\"dropdown-item\" onclick='toggleLogout()' href=\"#\">Logout</a>");
              
      out.write("\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("    </nav> \n");
      out.write("    <div class=\"col-12 text-center hd\"  style=\"margin-top: 7%;\">\n");
      out.write("      <h2>Booked ticket</h2>\n");
      out.write("    </div>\n");
      out.write("    <!-- animation search -->\n");
      out.write("    <div class=\"container h-100 anms\">\n");
      out.write("      <div class=\"d-flex justify-content-center h-100\">\n");
      out.write("        <div class=\"searchbar\">\n");
      out.write("          <input class=\"search_input\" id='search' type=\"text\" name=\"\" placeholder=\"Search...\">\n");
      out.write("          <a onclick='toggleSearch()' class=\"search_icon\"><i class=\"fas fa-search\"></i></a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- Filter -->\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/seller/filter-ticket\" method=\"get\">\n");
      out.write("    <div class=\"container-fluid filter\">\n");
      out.write("        <div class=\"row align-items-center justify-content-center\">\n");
      out.write("            <!--Departure-->\n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("                <div class=\"form-group \">\n");
      out.write("                    <span class=\"form-label\">From</span>\n");
      out.write("                    <select class=\"form-control\" name=\"from\" >\n");
      out.write("                        <option value='none'>none</option>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        ");
 ArrayList<Route> listRoute = (ArrayList<Route>) request.getAttribute("routes");
                          HashSet<String> cleanList = new HashSet();
                          for(Route route : listRoute) {
                               cleanList.add(route.getFrom());
                             }
                          for(String from : cleanList) {
                               out.println("<option value=\""+from+"\">"+from+"</option>");
                             }
                         
      out.write(" \n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--Arrival-->\n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <span class=\"form-label\">To</span>\n");
      out.write("                    <select class=\"form-control\" name=\"to\" >\n");
      out.write("                        <option value='none'>none</option>\n");
      out.write("                        ");
 
                          cleanList.clear();
                          for(Route route : listRoute) {
                               cleanList.add(route.getTo());
                             }
                          for(String to : cleanList) {
                               out.println("<option value=\""+to+"\">"+to+"</option>");
                             }
                         
      out.write(" \n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("             <!--Departure date-->\n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <span class=\"form-label\">Departure date</span>\n");
      out.write("                    <input class=\"form-control\" name=\"departureDate\" type=\"date\" >\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--Departure time-->\n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <span class=\"form-label\">Departure time</span>\n");
      out.write("                    <select class=\"form-control\" name=\"departureTime\" >\n");
      out.write("                        <option value='none'>none</option>\n");
      out.write("                        ");
 
                          cleanList.clear();
                          for(Route route : listRoute) {
                               cleanList.add(route.getTimeGo());
                             }
                          for(String timeGo : cleanList) {
                               out.println("<option value=\""+timeGo+"\">"+timeGo+"</option>");
                             }
                         
      out.write(" \n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                    \n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <span class=\"form-label\">Created date</span>\n");
      out.write("                    <input class=\"form-control\" name=\"createdDate\" type=\"date\" >\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-1\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                <span class=\"form-label\">Type</span>\n");
      out.write("                <select class=\"form-control\" name=\"type\" >\n");
      out.write("                    <option value='none'>none</option>\n");
      out.write("                    \n");
      out.write("                    ");
 ArrayList<Type> listType= (ArrayList<Type>) request.getAttribute("types");
                      for(Type type : listType) {
                           out.println("<option value=\""+type.getName()+"\">"+type.getName()+"</option>");
                         }
                    
      out.write(" \n");
      out.write("                </select>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <span class=\"form-label\">Pay</span>\n");
      out.write("                    <input class=\"form-control\" name=\"ispaid\" type=\"checkbox\" >\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-2\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <span class=\"form-label\">Active</span>\n");
      out.write("                    <input class=\"form-control\" name=\"isactive\" type=\"checkbox\" >\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-1\">\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary btn-block\"><i class=\"fas fa-filter\"></i> Filter</button>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("</form>\n");
      out.write("    <div class=\"col-12 tb\">\n");
      out.write("        <table id=\"table-booking\" class=\"table table-bordered\">\n");
      out.write("          <thead>\n");
      out.write("            <tr>\n");
      out.write("              <th>No.</th>\n");
      out.write("              <th>Customer's name</th>\n");
      out.write("              <th>Username</th>\n");
      out.write("              <th>Phone</th>\n");
      out.write("              <th>Date book</th>\n");
      out.write("              <th>Departure date</th>\n");
      out.write("              <th>Departure</th>\n");
      out.write("              <th>Destination</th>\n");
      out.write("              <th>Coach type</th>\n");
      out.write("              <th>Seat</th>\n");
      out.write("              <th>Action</th>\n");
      out.write("            </tr>\n");
      out.write("          </thead>\n");
      out.write("          <tbody>\n");
      out.write("            \n");
      out.write("                    \n");
      out.write("                    ");
 ArrayList<BookingDTO> list= (ArrayList<BookingDTO>) request.getAttribute("listBooking");
                    if(list != null)
                    for(BookingDTO booking : list) {
                        out.println("<tr id=\""+booking.getId()+"\">");
                        out.println("<td>"+booking.getId()+"</td>");
                        out.println("<td>"+booking.getUser()+"</td>");
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
                    
      out.write("\n");
      out.write("          </tbody>\n");
      out.write("        </table>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("   <form id='formPay' action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/seller/pay-booking\" method=\"post\" style=\"display: none\">\n");
      out.write("    <input type=\"text\" name=\"id\" id='bookingPay' name='id' class=\"form-control\">\n");
      out.write("    <button type='submit' id='submitPay'></button>\n");
      out.write("    </form>\n");
      out.write("    \n");
      out.write("    <form id='formCancel' action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/seller/cancel-booking\" method=\"post\" style=\"display: none\">\n");
      out.write("    <input type=\"text\" name=\"id\" id='bookingCancel' name='id' class=\"form-control\">\n");
      out.write("    <button type='submit' id='submitCancel'></button>\n");
      out.write("    </form>\n");
      out.write("    \n");
      out.write("    <form id='formLogout' action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/logout\" method=\"post\" style=\"display: none;\">\n");
      out.write("  \n");
      out.write("  </form>\n");
      out.write("    <script>\n");
      out.write("    function toggleCancel(id) {\n");
      out.write("      document.getElementById('bookingCancel').value=id;\n");
      out.write("      document.getElementById('formCancel').submit();\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    function togglePay(id) {\n");
      out.write("      document.getElementById('bookingPay').value=id;\n");
      out.write("      document.getElementById('formPay').submit();\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function toggleSearch() {\n");
      out.write("      let td, txtValue, display;\n");
      out.write("      const filter = document.getElementById(\"search\").value.toUpperCase();\n");
      out.write("      const table = document.getElementById(\"table-booking\");\n");
      out.write("      const tr = table.getElementsByTagName(\"tr\");\n");
      out.write("      for (let i = 1; i < tr.length; i++) {\n");
      out.write("        td = tr[i].getElementsByTagName(\"td\");\n");
      out.write("        display = false;\n");
      out.write("        for (let j = 0; j < td.length; j++) {\n");
      out.write("          txtValue = td[j].textContent || td[j].innerText;\n");
      out.write("          if (txtValue.toUpperCase().indexOf(filter) > -1) {\n");
      out.write("            display = true;\n");
      out.write("            break;\n");
      out.write("          }\n");
      out.write("        }\n");
      out.write("        if (display) {\n");
      out.write("          tr[i].style.display = \"\";\n");
      out.write("        } else {\n");
      out.write("          tr[i].style.display = \"none\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    function toggleLogout(){\n");
      out.write("        document.getElementById('formLogout').submit();\n");
      out.write("      }\n");
      out.write("  </script>\n");
      out.write("    </body>\n");
      out.write("  </html>");
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
