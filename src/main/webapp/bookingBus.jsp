<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!--Style css-->
    <link rel='stylesheet' type='text/css' media='screen' href='./css/route.css'>
    <title>Booking Ticket Bus</title>
</head>

<body>
    <div class="container-fluid" style="text-align: -webkit-center;">
        <!-- Navigation bar-->
        <nav class="navbar navbar-expand-sm">
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

        <h1 style="text-align: center;margin-top:10px;">Routes</h1>


        <!--Filter-->
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
                                <% ArrayList<Route> listRoute = (ArrayList<Route>) request.getAttribute("listRoute");
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
                        <button type="submit" class="btn btn-primary btn-block"><i class="fas fa-filter"></i>
                        </button>
                    </div>
                </div>
            </div>
        </form>

        <table class="table table-bordered" id="table-bus" style="width: 80%;">
            <thead>
                <tr>
                    <th>Bus</th>
                    <th>Route</th>
                    <th>Departure</th>
                    <th>Arrival</th>
                    <th>Departure time</th>
                    <th>Duration</th>
                    <th>Arrival time</th>
                    <th>Seat</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%@ page import="BookingTicketManagement.Model.BusDTO" %>
                <%@ page import="java.util.ArrayList" %>
                <% ArrayList<BusDTO> list= (ArrayList<BusDTO>) request.getAttribute("listBus");
           Route route = (Route) request.getAttribute("route");
           if(list != null)
           for(BusDTO bus : list) {
                out.println("<tr id=\""+bus.getId()+"\">");
                out.println("<td>"+bus.getName()+"</td>");
                out.println("<td>"+route.getId()+"</td>");
                out.println("<td>"+bus.getFrom()+"</td>");
                out.println("<td>"+bus.getTo()+"</td>");
                out.println("<td>"+bus.getDepartureTime()+"</td>");
                out.println("<td>"+bus.getDurationTime()+"</td>");
                out.println("<td>"+bus.getArrivalTime()+"</td>");
                out.println("<td>"+bus.getType()+"</td>");
                out.println("<td>"+bus.getPrice()+"</td>");
                out.println("<td>");
                out.println("<button onclick=\"toggleSubmit('"+bus.getId()+"')\" class=\"btn btn-danger\">View seats</button>");
                out.println("</td>");
                out.println("</tr>");     
              }
          %>
            </tbody>
        </table>
        <form id='form' action="${pageContext.request.contextPath}/get-seat-booking" method="get" style="display: none">
            <input type="text" name="busId" id='busId' class="form-control">
            <input type="text" name="busName" id='busName' class="form-control">
            <input type="text" name="departureTime" id='departureTime' class="form-control">
            <input type="text" name="route" id='route' class="form-control">
            <input type="text" name="price" id='price' class="form-control">
            <button type='submit' id='btnSubmit'></button>
        </form>
        <form id='formLogout' action="${pageContext.request.contextPath}/logout" method="post" style="display: none;">
        </form>
    </div>

    <script>

        function toggleSubmit(id) {
            const tr = document.getElementById(id);
            const td = tr.getElementsByTagName("td");

            document.getElementById('busId').value = id;
            document.getElementById('busName').value = td[0].innerText;
            document.getElementById('departureTime').value = td[4].innerText;
            document.getElementById('route').value = td[1].innerText;
            document.getElementById('price').value = td[8].innerText;
            document.getElementById('form').submit();
        }

        function toggleSearch() {
            let td, txtValue, display;
            const filter = document.getElementById("search").value.toUpperCase();
            const table = document.getElementById("table-booking");
            const tr = table.getElementsByTagName("tr");
            for (let i = 1; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td");
                display = false;
                for (let j = 0; j < td.length; j++) {
                    txtValue = td[j].textContent || td[j].innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        display = true;
                        break;
                    }
                }
                if (display) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }

            }
        }
        
        function toggleLogout(){
        document.getElementById('formLogout').submit();
        }
    </script>
</body>

</html>