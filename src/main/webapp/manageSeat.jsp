<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">  
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      <link rel='stylesheet' type='text/css' media='screen' href='../css/SearchTicket.css'>
  </head>
  <body>
      <!-- Navigation bar-->
    <nav class="navbar navbar-expand-sm fixed-top">
        <div class="container-fluid">
            <a class="navbar-branch" href="#">
          <img src="../images/logo4.png" height="50">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                <span class="navbar-toggler-icon"></span> 
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <%
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
              %>
                </ul>
            </div>
        </div>
    </nav>
    <div class="content">
        <div class="col-12 text-center hd" style="margin-top: 7%;">
                <h2>List of seats</h2>
        </div>
        <!-- animation search -->
        <div class="container h-100 anms">
                <div class="d-flex justify-content-center h-100">
                    <div class="searchbar">
                        <input class="search_input" id='search' type="text" name="" placeholder="Search...">
                        <a onclick='toggleSearch()' class="search_icon"><i class="fas fa-search"></i></a>
                    </div>
                </div>
            </div>
        <!-- Filter -->
        <form action="${pageContext.request.contextPath}/seller/filter-seat" method="get">
    <div class="container-fluid filter">
        <div class="row align-items-center justify-content-center">
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
            <div class="col-md-1">
                <div class="form-group">
                <span class="form-label">Type</span>
                <select class="form-control" name="type">
                    <option value="">none</option>
                    <%@ page import="BookingTicketManagement.Model.Type" %>
                    <% ArrayList<Type> listType= (ArrayList<Type>) request.getAttribute("types");
                      for(Type type : listType) {
                           out.println("<option value=\""+type.getName()+"\">"+type.getName()+"</option>");
                         }
                    %> 
                </select>
                </div>
            </div>
            <div class="col-md-1">
                <button type="submit" class="btn btn-primary btn-block"><i class="fas fa-filter"></i> Filter</button>
            </div>
          </div>
        </div>
</form>
       <div class="col-12 tb">
        <table id='table-booking' class="table table-bordered">
          <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Bus</th>
                <th>Type</th>
                <th>Departure</th>
                <th>Status</th>
                <th>Active</th>
            </tr>
          </thead>
          <tbody>
                    <%@ page import="BookingTicketManagement.Model.SeatDTO" %>
                    <%@ page import="java.util.ArrayList" %>
                    <% ArrayList<SeatDTO> list= (ArrayList<SeatDTO>) request.getAttribute("listSeat");
                    if(list != null)
                    for(SeatDTO seat : list) {
                        out.println("<tr>");
                        out.println("<td>"+seat.getId()+"</td>");
                        out.println("<td>"+seat.getName()+"</td>");
                        out.println("<td>"+seat.getBusName()+"</td>");
                        out.println("<td>"+seat.getType()+"</td>");
                        out.println("<td id=\""+seat.getId()+"\">"+seat.getDeparture()+"</td>");
                        if(seat.getStatus())
                            out.println("<td>Available</td>");
                        else
                            out.println("<td>Unavailable</td>");
                        out.println("<td>");
                        if(seat.getStatus())
                            out.println("<button class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#updateModel\" disabled>Cancel</button>");
                        else
                            out.println("<button onclick=\"toggleCancel('"+seat.getId()+"')\" class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#updateModel\">Cancel</button>");
                        out.println("</td>");
                        out.println("</tr>");     
                     }
                    %>
          </tbody>
        </table>
      </div>
    </div>
 
    <form id='formCancel' action="${pageContext.request.contextPath}/seller/cancel-seat" method="post" style="display: none">
    <input type="text" name="seatId" id='seatId' class="form-control">
    <input type="text" name="departureTimeCancel" id='departureTimeCancel' class="form-control">
    <button type='submit' id='submitCancel'></button>
    </form>
    
    <form id='formLogout' action="${pageContext.request.contextPath}/logout" method="post" style="display: none;">
  
  </form>
    
    <script>
    function toggleCancel(id) {
      document.getElementById('seatId').value=id;
      document.getElementById('departureTimeCancel').value=document.getElementById(id).innerHTML;
      document.getElementById('formCancel').submit();
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