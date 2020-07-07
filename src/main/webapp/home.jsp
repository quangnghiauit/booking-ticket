<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
  <link rel='stylesheet' type='text/css' media='screen' href='./css/style.css'>
</head>

<body>

  <nav class="navbar navbar-expand-sm fixed-top">
    <div class="container-fluid">
      <a class="navbar-branch" href="${pageContext.request.contextPath}/">
        <img src="./images/logo4.png" height="50">
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <% try{
            
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
}%>
        </ul>
      </div>
    </div>
  </nav>
  <!-- Carousel -->
  <div id="slides" class="carousel slide" data-ride="carousel">
    <ul class="carousel-indicators">
      <li data-target="#slides" data-slide-to="0" class="active"></li>
      <li data-target="#slides" data-slide-to="1"></li>
      <li data-target="#slides" data-slide-to="2"></li>
    </ul>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="./images/bus2.jpg">
        <div class="carousel-caption">
          <h1 class="display-3">Wherever you want</h1>
          <a class="btn btn-primary btn-lg" href="#" role="button">Book now!!!</a>
        </div>
      </div>
      <div class="carousel-item">
        <img src="./images/maldive.jpg">
        <div class="carousel-caption">
          <h1 class="display-3">Affordable</h1>
          <button type="button" class="btn btn-primary btn-lg">
            Book now
          </button>
        </div>
      </div>
      <div class="carousel-item">
        <img src="./images/comf.jpg">
        <div class="carousel-caption">
          <h1 class="display-3">Comfortable</h1>
          <button type="button" class="btn btn-primary btn-lg">
            Book now
          </button>
        </div>
      </div>
    </div>
  </div>
  <div class="container-fluid padding">
    <div class="row welcom text-center">
      <div class="col-12">
        <h1 class="display-4">Know where you're going? Book</h1>
        <br>
      </div>
    </div>
    <!-- Container -->
    <form action="${pageContext.request.contextPath}/get-bus-booking" method="get">
      <div class="container-fluid filter">
        <div class="row align-items-center justify-content-center">
          <!--Departure-->
          <div class="col-md-2">
            <div class="form-group ">
              <span class="form-label">From</span>
              <select class="form-control" name="from" required>
                <option value="">Choose departure place</option>
                <%@ page import="BookingTicketManagement.Model.Route" %>
                <%@ page import="java.util.ArrayList" %>
                <%@ page import="java.util.HashSet" %>
                <% ArrayList<Route> listRoute = (ArrayList<Route>) request.getAttribute("routes");
                          HashSet<String> cleanList = new HashSet();
                          for(Route route : listRoute) {
                               cleanList.add(route.getFrom());
                             }
                          for(String from : cleanList) {
                               out.println("<option value=\""+from+"\">"+from+"</option>");
                             }
                         %>
              </select>
            </div>
          </div>
          <!--Arrival-->
          <div class="col-md-2">
            <div class="form-group">
              <span class="form-label">To</span>
              <select class="form-control" name="to" required>
                <option value="">Choose arrival place</option>
                <% 
                          cleanList.clear();
                          for(Route route : listRoute) {
                               cleanList.add(route.getTo());
                             }
                          for(String to : cleanList) {
                               out.println("<option value=\""+to+"\">"+to+"</option>");
                             }
                         %>
              </select>
            </div>
          </div>
          <!--Departure date-->
          <div class="col-md-2">
            <div class="form-group">
              <span class="form-label">Departure date</span>
              <input class="form-control" name="departureDate" type="date" required>
            </div>
          </div>
          <!--Departure time-->
          <div class="col-md-2">
            <div class="form-group">
              <span class="form-label">Departure time</span>
              <select class="form-control" name="departureTime" required>
                <option value="">Choose departure time</option>
                <% 
                          cleanList.clear();
                          for(Route route : listRoute) {
                               cleanList.add(route.getTimeGo());
                             }
                          for(String timeGo : cleanList) {
                               out.println("<option value=\""+timeGo+"\">"+timeGo+"</option>");
                             }
                         %>
              </select>
            </div>
          </div>

          <!--Seat type-->
          <div class="col-md-2">
            <div class="form-group">
              <span class="form-label">Seat</span>
              <select class="form-control" name="type" required>
                <option value="">Choose type seat</option>
                <%@ page import="BookingTicketManagement.Model.Type" %>
                <% ArrayList<Type> listType= (ArrayList<Type>) request.getAttribute("types");
                      for(Type type : listType) {
                           out.println("<option value=\""+type.getId()+"\">"+type.getName()+"</option>");
                         }
                    %>
              </select>
            </div>
          </div>
          <div class="col-md-1">
            <button type="submit" class="btn btn-primary btn-block">Book</button>
          </div>
        </div>
      </div>
    </form>
  </div>
  <hr class="hrb">
  <div class="Des col-12 text-center">
    <h1>Destinations</h1>
  </div>
  <div class="container-fluid padding">
    <div class="ides row padding">
      <div class="fhcm col-xs-12 col-sm-6 col-md-4">
        <img src="./images/BenThanh.jpg" class="img-fluid">
        <p> <i class="fas fa-bus"></i> <b>Origin:</b> <span class="badge badge-secondary">SÀI GÒN</span></p>
        <P> <i class="fas fa-map-marker-alt"></i> <b>Destination:</b>Cần Thơ, Cà Mau, Đà Lạt, Nha Trang,...</P>
        <p> <i class="fas fa-phone-square"></i> <b>Hotline:</b> 0982 765 999</p>
        <a href="#"><i>Detail>></i></a>
      </div>
      <div class="fhn col-xs-12 col-sm-6 col-md-4">
        <img src="./images/hn.jpg" class="img-fluid">
        <p> <i class="fas fa-bus"></i> <b>Origin:</b> <span class="badge badge-secondary">HÀ NỘI</span></p>
        <P> <i class="fas fa-map-marker-alt"></i> <b>Destination:</b>Đà Nẵng, Nam Định, Huế, Phan Thiết,...</P>
        <p> <i class="fas fa-phone-square"></i> <b>Hotline:</b> 0243 776 142</p>
        <a href="#"><i>Detail>></i></a>
      </div>
      <div class="fdn col-xs-12 col-sm-6 col-md-4">
        <img src="./images/dn.jpg" class="img-fluid">
        <p> <i class="fas fa-bus"></i> <b>Origin:</b> <span class="badge badge-secondary">ĐÀ NẴNG</span></p>
        <P> <i class="fas fa-map-marker-alt"></i> <b>Destination:</b>Đà Lạt, Sài Gòn, Nha Trang, Hà Nội, Bảo Lộc,...</P>
        <p> <i class="fas fa-phone-square"></i> <b>Hotline:</b> 0243 798 332</p>
        <a href="#"><i>Detail>></i></a>
      </div>
      <div class="fdl col-xs-12 col-sm-6 col-md-4">
        <img src="./images/dl.png" class="img-fluid">
        <p> <i class="fas fa-bus"></i> <b>Origin:</b> <span class="badge badge-secondary">ĐÀ LẠT</span></p>
        <P> <i class="fas fa-map-marker-alt"></i> <b>Destination:</b>Nha Trang, Đà Nẵng, Huế, Sài Gòn, Cần Thơ,...</P>
        <p> <i class="fas fa-phone-square"></i> <b>Hotline:</b> 0989 018 999</p>
        <a href="#"><i>Detail>></i></a>
      </div>
      <div class="fnt col-xs-12 col-sm-6 col-md-4">
        <img src="./images/nt.jpg" class="img-fluid">
        <p> <i class="fas fa-bus"></i> <b>Origin:</b> <span class="badge badge-secondary">NHA TRANG</span></p>
        <P> <i class="fas fa-map-marker-alt"></i> <b>Destination:</b>Đà Nẵng, Huế, Sài Gòn, Cần Thơ, Quy Nhơn,...</P>
        <p> <i class="fas fa-phone-square"></i> <b>Hotline:</b> 0234 928 009</p>
        <a href="#"><i>Detail>></i></a>
      </div>
      <div class="fct col-xs-12 col-sm-6 col-md-4">
        <img src="./images/ct.jpg" class="img-fluid">
        <p> <i class="fas fa-bus"></i> <b>Origin:</b> <span class="badge badge-secondary">CẦN THƠ</span></p>
        <P> <i class="fas fa-map-marker-alt"></i> <b>Destination:</b>Sài Gòn, Cà Mau, Rạch Giá, Đà Lạt,...</P>
        <p> <i class="fas fa-phone-square"></i> <b>Hotline:</b> 0247 908 012</p>
        <a href="#"><i>Detail>></i></a>
      </div>
      <div class="flx col-xs-12 col-sm-6 col-md-4">
        <img src="./images/lx.jpg" class="img-fluid">
        <p> <i class="fas fa-bus"></i> <b>Origin:</b> <span class="badge badge-secondary">LONG XUYÊN</span></p>
        <P> <i class="fas fa-map-marker-alt"></i> <b>Destination:</b>Sài Gòn, Cần Thơ,...</P>
        <p> <i class="fas fa-phone-square"></i> <b>Hotline:</b> 0987 118 212</p>
        <br>
        <a href="#"><i>Detail>></i></a>
      </div>
      <div class="fht col-xs-12 col-sm-6 col-md-4">
        <img src="./images/ht.jpg" class="img-fluid">
        <p> <i class="fas fa-bus"></i> <b>Origin:</b> <span class="badge badge-secondary">HÀ TIÊN</span></p>
        <P> <i class="fas fa-map-marker-alt"></i> <b>Destination:</b>Sài Gòn, Cần Thơ,...</P>
        <p> <i class="fas fa-phone-square"></i> <b>Hotline:</b> 0987 888 319</p>
        <br>
        <a href="#"><i>Detail>></i></a>
      </div>
      <div class="fcm col-xs-12 col-sm-6 col-md-4">
        <img src="./images/cm.jpg" class="img-fluid">
        <p> <i class="fas fa-bus"></i> <b>Origin:</b> <span class="badge badge-secondary">CÀ MAU</span></p>
        <P> <i class="fas fa-map-marker-alt"></i> <b>Destination:</b>Sài Gòn, Cần Thơ,...</P>
        <p> <i class="fas fa-phone-square"></i> <b>Hotline:</b> 0989 718 919</p>
        <br>
        <a href="#"><i>Detail>></i></a>
      </div>
      <hr class="hrdes">
    </div>
  </div>
  <div class="ser col-12 text-center">
    <h1>Free Services</h1>
  </div>
  <div class="row text-center padding">
    <div class="col-xs-12 col-sm-6 col-md-4">
      <img src="./images/wifi.png">
      <h3>Wifi</h3>
      <p>Free wifi is available on every bus with speeds from 2-4 Mb and unlimited data, so you'll be able to stay
        connected during your trip.</p>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-4">
      <img src="./images/food.png">
      <h3>Complimentary Snacks</h3>
      <p>We'll provide a complimentary Blue Pumpkin pastry on our long haul trips to tide you over until lunch. You'll
        get water and cold towels too. Our VN buses even have free coffee!</p>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-4">
      <img src="./images/temp.png">
      <h3>Air Conditioning</h3>
      <p>Sometimes taken for granted, but not always guaranteed when traveling in Cambodia. Our buses nice cold air
        conditioning will keep you comfortable the whole way.</p>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-4">
      <img src="./images/seatb.png">
      <h3>Seatbelt</h3>
      <p>Every seat on every bus is equipped with lap seat belts for your safety.</p>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-4">
      <img src="./images/elec.png">
      <h3>Electrical Outlets</h3>
      <p>Bring your charger and plug in so you're able to actually use the free wifi and leave the bus with a full
        charge. You won't be able to take any great photos with a dead phone!</p>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-4">
      <img src="./images/legr.png">
      <h3>Legroom</h3>
      <p>We have more legroom than our competitors because we gave up one row of seats on each bus so that you could be
        more comfortable.</p>
    </div>
  </div>
  </div>
  <!-- Footer -->
  <footer>
    <div class="container-fluid padding ft">
      <div class="row text-center">
        <div class="social col-md-6">
          <h1>Contact us</h1>
          <p>24 Hours Service Support</p>
          <a href="#"><i class="fab fa-facebook"></i>
            <i class="fab fa-youtube"></i>
            <i class="fab fa-instagram"></i>
            <i class="fab fa-google-plus-g"></i>
          </a>
        </div>
        <div class="service col-md-6">
          <h1>About us</h1>
          <img src="./images/logo4.png">
        </div>
      </div>
    </div>
  </footer>

  <form id='formLogout' action="${pageContext.request.contextPath}/logout" method="post" style="display: none;">
  
  </form>
  <script>
      function toggleLogout(){
        document.getElementById('formLogout').submit();
      }
  </script>
</body>

</html>