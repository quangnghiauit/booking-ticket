/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-16 14:47:26 UTC
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

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <link rel='stylesheet' type='text/css' media='screen' href='./css/style.css'>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <nav class=\"navbar navbar-expand-sm fixed-top\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("      <a class=\"navbar-branch\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/\">\r\n");
      out.write("        <img src=\"./images/logo4.png\" height=\"50\">\r\n");
      out.write("      </a>\r\n");
      out.write("      <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\">\r\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("      </button>\r\n");
      out.write("      <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\r\n");
      out.write("        <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("          ");
 try{
            
    String role = (String)request.getSession().getAttribute("role");
    if(role.equals("ADMIN"))
    {
        out.print("<li class=\"nav-item\">");
        out.print("<a class=\"nav-link active\" href=\""+request.getContextPath()+"/\">Home</a>");
        out.print("</li>");
        out.print("<li class=\"nav-item\">");
        out.print("<a class=\"nav-link active\" href=\""+request.getContextPath()+"/manage-user\">Manage user</a>");
        out.print("</li>");
        out.print("<div class=\"dropdown drd\">");
        out.print("<button class=\"btn btn-default dropdown-toggle hl\" data-toggle=\"dropdown\">");
        out.print("<i class=\"fas fa-user-alt\"></i>");
        out.print(request.getSession().getAttribute("displayname"));
        out.print("</button>");
        out.print("<div class=\"dropdown-menu\">");
        out.print("<a class=\"dropdown-item\" href=\""+request.getContextPath()+"/user/get-info-user\">Profile</a>");
        out.print("<a class=\"dropdown-item\" onclick='toggleLogout()' href=\"#\">Logout</a>");        
        
    }
    else if(role.equals("CUSTOMER")){
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

    }
    else if(role.equals("SELLER")){
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

    }
    }
    catch(Exception e) {
        out.print("<li class=\"nav-item\">");
        out.print("<a class=\"nav-link active\" href=\""+request.getContextPath()+"/\">Home</a>");
        out.print("</li>");
        out.print("<li class=\"nav-item\">");
        out.print("<a class=\"nav-link\" href=\""+request.getContextPath()+"/login\">Sign in</a>");
        out.print("</li>");
        out.print("<li class=\"nav-item\">");
        out.print("<a class=\"nav-link\" href=\""+request.getContextPath()+"/register\">Sign up</a>");
        out.print("</li>");
}
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </nav>\r\n");
      out.write("  <!-- Carousel -->\r\n");
      out.write("  <div id=\"slides\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("    <ul class=\"carousel-indicators\">\r\n");
      out.write("      <li data-target=\"#slides\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("      <li data-target=\"#slides\" data-slide-to=\"1\"></li>\r\n");
      out.write("      <li data-target=\"#slides\" data-slide-to=\"2\"></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("    <div class=\"carousel-inner\">\r\n");
      out.write("      <div class=\"carousel-item active\">\r\n");
      out.write("        <img src=\"./images/bus2.jpg\">\r\n");
      out.write("        <div class=\"carousel-caption\">\r\n");
      out.write("          <h1 class=\"display-3\">Wherever you want</h1>\r\n");
      out.write("          <a class=\"btn btn-primary btn-lg\" href=\"#\" role=\"button\">Book now!!!</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"carousel-item\">\r\n");
      out.write("        <img src=\"./images/maldive.jpg\">\r\n");
      out.write("        <div class=\"carousel-caption\">\r\n");
      out.write("          <h1 class=\"display-3\">Affordable</h1>\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-primary btn-lg\">\r\n");
      out.write("            Book now\r\n");
      out.write("          </button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"carousel-item\">\r\n");
      out.write("        <img src=\"./images/comf.jpg\">\r\n");
      out.write("        <div class=\"carousel-caption\">\r\n");
      out.write("          <h1 class=\"display-3\">Comfortable</h1>\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-primary btn-lg\">\r\n");
      out.write("            Book now\r\n");
      out.write("          </button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"container-fluid padding\">\r\n");
      out.write("    <div class=\"row welcom text-center\">\r\n");
      out.write("      <div class=\"col-12\">\r\n");
      out.write("        <h1 class=\"display-4\">Where are you going? Book now!</h1>\r\n");
      out.write("        <br>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Container -->\r\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/get-bus-booking\" method=\"get\">\r\n");
      out.write("      <div class=\"container-fluid filter\">\r\n");
      out.write("        <div class=\"row align-items-center justify-content-center\">\r\n");
      out.write("          <!--Departure-->\r\n");
      out.write("          <div class=\"col-md-2\">\r\n");
      out.write("            <div class=\"form-group \">\r\n");
      out.write("              <span class=\"form-label\">From</span>\r\n");
      out.write("              <select class=\"form-control\" name=\"from\" required>\r\n");
      out.write("                <option value=\"\">Choose departure place</option>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                ");
 ArrayList<Route> listRoute = (ArrayList<Route>) request.getAttribute("routes");
                          HashSet<String> cleanList = new HashSet();
                          for(Route route : listRoute) {
                               cleanList.add(route.getFrom());
                             }
                          for(String from : cleanList) {
                               out.println("<option value=\""+from+"\">"+from+"</option>");
                             }
                         
      out.write("\r\n");
      out.write("              </select>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <!--Arrival-->\r\n");
      out.write("          <div class=\"col-md-2\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <span class=\"form-label\">To</span>\r\n");
      out.write("              <select class=\"form-control\" name=\"to\" required>\r\n");
      out.write("                <option value=\"\">Choose arrival place</option>\r\n");
      out.write("                ");
 
                          cleanList.clear();
                          for(Route route : listRoute) {
                               cleanList.add(route.getTo());
                             }
                          for(String to : cleanList) {
                               out.println("<option value=\""+to+"\">"+to+"</option>");
                             }
                         
      out.write("\r\n");
      out.write("              </select>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <!--Departure date-->\r\n");
      out.write("          <div class=\"col-md-2\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <span class=\"form-label\">Departure date</span>\r\n");
      out.write("              <input class=\"form-control\" name=\"departureDate\" type=\"date\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <!--Departure time-->\r\n");
      out.write("          <div class=\"col-md-2\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <span class=\"form-label\">Departure time</span>\r\n");
      out.write("              <select class=\"form-control\" name=\"departureTime\" required>\r\n");
      out.write("                <option value=\"\">Choose departure time</option>\r\n");
      out.write("                ");
 
                          cleanList.clear();
                          for(Route route : listRoute) {
                               cleanList.add(route.getTimeGo());
                             }
                          for(String timeGo : cleanList) {
                               out.println("<option value=\""+timeGo+"\">"+timeGo+"</option>");
                             }
                         
      out.write("\r\n");
      out.write("              </select>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <!--Seat type-->\r\n");
      out.write("          <div class=\"col-md-2\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <span class=\"form-label\">Seat</span>\r\n");
      out.write("              <select class=\"form-control\" name=\"type\" required>\r\n");
      out.write("                <option value=\"\">Choose type seat</option>\r\n");
      out.write("                \r\n");
      out.write("                ");
 ArrayList<Type> listType= (ArrayList<Type>) request.getAttribute("types");
                      for(Type type : listType) {
                           out.println("<option value=\""+type.getId()+"\">"+type.getName()+"</option>");
                         }
                    
      out.write("\r\n");
      out.write("              </select>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-md-1\">\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary btn-block\">Book</button>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </form>\r\n");
      out.write("  </div>\r\n");
      out.write("  <hr class=\"hrb\">\r\n");
      out.write("  <div class=\"Des col-12 text-center\">\r\n");
      out.write("    <h1>Location</h1>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"container-fluid padding\">\r\n");
      out.write("    <div class=\"ides row padding\">\r\n");
      out.write("      <div class=\"fhcm col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("        <img src=\"./images/BenThanh.jpg\" class=\"img-fluid\">\r\n");
      out.write("        <p> <i class=\"fas fa-bus\"></i> <b>Origin:</b> <span class=\"badge badge-secondary\">SÀI GÒN</span></p>\r\n");
      out.write("        <P> <i class=\"fas fa-map-marker-alt\"></i> <b>Destination:</b>Cần Thơ, Cà Mau, Đà Lạt, Nha Trang,...</P>\r\n");
      out.write("        <p> <i class=\"fas fa-phone-square\"></i> <b>Hotline:</b> 0982 765 999</p>\r\n");
      out.write("        <a href=\"#\"><i>Detail>></i></a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"fhn col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("        <img src=\"./images/hn.jpg\" class=\"img-fluid\">\r\n");
      out.write("        <p> <i class=\"fas fa-bus\"></i> <b>Origin:</b> <span class=\"badge badge-secondary\">HÀ NỘI</span></p>\r\n");
      out.write("        <P> <i class=\"fas fa-map-marker-alt\"></i> <b>Destination:</b>Đà Nẵng, Nam Định, Huế, Phan Thiết,...</P>\r\n");
      out.write("        <p> <i class=\"fas fa-phone-square\"></i> <b>Hotline:</b> 0243 776 142</p>\r\n");
      out.write("        <a href=\"#\"><i>Detail>></i></a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"fdn col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("        <img src=\"./images/dn.jpg\" class=\"img-fluid\">\r\n");
      out.write("        <p> <i class=\"fas fa-bus\"></i> <b>Origin:</b> <span class=\"badge badge-secondary\">ĐÀ NẴNG</span></p>\r\n");
      out.write("        <P> <i class=\"fas fa-map-marker-alt\"></i> <b>Destination:</b>Đà Lạt, Sài Gòn, Nha Trang, Hà Nội, Bảo Lộc,...</P>\r\n");
      out.write("        <p> <i class=\"fas fa-phone-square\"></i> <b>Hotline:</b> 0243 798 332</p>\r\n");
      out.write("        <a href=\"#\"><i>Detail>></i></a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"fdl col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("        <img src=\"./images/dl.png\" class=\"img-fluid\">\r\n");
      out.write("        <p> <i class=\"fas fa-bus\"></i> <b>Origin:</b> <span class=\"badge badge-secondary\">ĐÀ LẠT</span></p>\r\n");
      out.write("        <P> <i class=\"fas fa-map-marker-alt\"></i> <b>Destination:</b>Nha Trang, Đà Nẵng, Huế, Sài Gòn, Cần Thơ,...</P>\r\n");
      out.write("        <p> <i class=\"fas fa-phone-square\"></i> <b>Hotline:</b> 0989 018 999</p>\r\n");
      out.write("        <a href=\"#\"><i>Detail>></i></a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"fnt col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("        <img src=\"./images/nt.jpg\" class=\"img-fluid\">\r\n");
      out.write("        <p> <i class=\"fas fa-bus\"></i> <b>Origin:</b> <span class=\"badge badge-secondary\">NHA TRANG</span></p>\r\n");
      out.write("        <P> <i class=\"fas fa-map-marker-alt\"></i> <b>Destination:</b>Đà Nẵng, Huế, Sài Gòn, Cần Thơ, Quy Nhơn,...</P>\r\n");
      out.write("        <p> <i class=\"fas fa-phone-square\"></i> <b>Hotline:</b> 0234 928 009</p>\r\n");
      out.write("        <a href=\"#\"><i>Detail>></i></a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"fct col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("        <img src=\"./images/ct.jpg\" class=\"img-fluid\">\r\n");
      out.write("        <p> <i class=\"fas fa-bus\"></i> <b>Origin:</b> <span class=\"badge badge-secondary\">CẦN THƠ</span></p>\r\n");
      out.write("        <P> <i class=\"fas fa-map-marker-alt\"></i> <b>Destination:</b>Sài Gòn, Cà Mau, Rạch Giá, Đà Lạt,...</P>\r\n");
      out.write("        <p> <i class=\"fas fa-phone-square\"></i> <b>Hotline:</b> 0247 908 012</p>\r\n");
      out.write("        <a href=\"#\"><i>Detail>></i></a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"flx col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("        <img src=\"./images/lx.jpg\" class=\"img-fluid\">\r\n");
      out.write("        <p> <i class=\"fas fa-bus\"></i> <b>Origin:</b> <span class=\"badge badge-secondary\">LONG XUYÊN</span></p>\r\n");
      out.write("        <P> <i class=\"fas fa-map-marker-alt\"></i> <b>Destination:</b>Sài Gòn, Cần Thơ,...</P>\r\n");
      out.write("        <p> <i class=\"fas fa-phone-square\"></i> <b>Hotline:</b> 0987 118 212</p>\r\n");
      out.write("        <br>\r\n");
      out.write("        <a href=\"#\"><i>Detail>></i></a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"fht col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("        <img src=\"./images/ht.jpg\" class=\"img-fluid\">\r\n");
      out.write("        <p> <i class=\"fas fa-bus\"></i> <b>Origin:</b> <span class=\"badge badge-secondary\">HÀ TIÊN</span></p>\r\n");
      out.write("        <P> <i class=\"fas fa-map-marker-alt\"></i> <b>Destination:</b>Sài Gòn, Cần Thơ,...</P>\r\n");
      out.write("        <p> <i class=\"fas fa-phone-square\"></i> <b>Hotline:</b> 0987 888 319</p>\r\n");
      out.write("        <br>\r\n");
      out.write("        <a href=\"#\"><i>Detail>></i></a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"fcm col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("        <img src=\"./images/cm.jpg\" class=\"img-fluid\">\r\n");
      out.write("        <p> <i class=\"fas fa-bus\"></i> <b>Origin:</b> <span class=\"badge badge-secondary\">CÀ MAU</span></p>\r\n");
      out.write("        <P> <i class=\"fas fa-map-marker-alt\"></i> <b>Destination:</b>Sài Gòn, Cần Thơ,...</P>\r\n");
      out.write("        <p> <i class=\"fas fa-phone-square\"></i> <b>Hotline:</b> 0989 718 919</p>\r\n");
      out.write("        <br>\r\n");
      out.write("        <a href=\"#\"><i>Detail>></i></a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <hr class=\"hrdes\">\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"ser col-12 text-center\">\r\n");
      out.write("    <h1>Free Services</h1>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"row text-center padding\">\r\n");
      out.write("    <div class=\"col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("      <img src=\"./images/wifi.png\">\r\n");
      out.write("      <h3>Wifi</h3>\r\n");
      out.write("      <p>Free wifi is available on every bus with speeds from 2-4 Mb and unlimited data, so you'll be able to stay\r\n");
      out.write("        connected during your trip.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("      <img src=\"./images/food.png\">\r\n");
      out.write("      <h3>Complimentary Snacks</h3>\r\n");
      out.write("      <p>We'll provide a complimentary Blue Pumpkin pastry on our long haul trips to tide you over until lunch. You'll\r\n");
      out.write("        get water and cold towels too. Our VN buses even have free coffee!</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("      <img src=\"./images/temp.png\">\r\n");
      out.write("      <h3>Air Conditioning</h3>\r\n");
      out.write("      <p>Sometimes taken for granted, but not always guaranteed when traveling in Cambodia. Our buses nice cold air\r\n");
      out.write("        conditioning will keep you comfortable the whole way.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("      <img src=\"./images/seatb.png\">\r\n");
      out.write("      <h3>Seatbelt</h3>\r\n");
      out.write("      <p>Every seat on every bus is equipped with lap seat belts for your safety.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("      <img src=\"./images/elec.png\">\r\n");
      out.write("      <h3>Electrical Outlets</h3>\r\n");
      out.write("      <p>Bring your charger and plug in so you're able to actually use the free wifi and leave the bus with a full\r\n");
      out.write("        charge. You won't be able to take any great photos with a dead phone!</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"col-xs-12 col-sm-6 col-md-4\">\r\n");
      out.write("      <img src=\"./images/legr.png\">\r\n");
      out.write("      <h3>Legroom</h3>\r\n");
      out.write("      <p>We have more legroom than our competitors because we gave up one row of seats on each bus so that you could be\r\n");
      out.write("        more comfortable.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- Footer -->\r\n");
      out.write("  <footer>\r\n");
      out.write("    <div class=\"container-fluid padding ft\">\r\n");
      out.write("      <div class=\"row text-center\" style=\"padding-top: 40px\">\r\n");
      out.write("        <div class=\"social col-md-6\">\r\n");
      out.write("          <h1>Contact us</h1>\r\n");
      out.write("          <p>24 Hours Service Support</p>\r\n");
      out.write("          <a href=\"#\"><i class=\"fab fa-facebook\"></i>\r\n");
      out.write("            <i class=\"fab fa-youtube\"></i>\r\n");
      out.write("            <i class=\"fab fa-instagram\"></i>\r\n");
      out.write("            <i class=\"fab fa-google-plus-g\"></i>\r\n");
      out.write("          </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"service col-md-6\">\r\n");
      out.write("          <h1>About us</h1>\r\n");
      out.write("          <img src=\"./images/logo4.png\">\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </footer>\r\n");
      out.write("\r\n");
      out.write("  <form id='formLogout' action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/logout\" method=\"post\" style=\"display: none;\">\r\n");
      out.write("  \r\n");
      out.write("  </form>\r\n");
      out.write("  <script>\r\n");
      out.write("      function toggleLogout(){\r\n");
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
