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
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
    integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
  <link rel='stylesheet' type='text/css' media='screen' href='../css/HistoryCus.css'>
</head>

<body>
  <!-- Navigation bar-->
  <nav class="navbar navbar-expand-sm ">
      <div class="container-fluid">
          <a class="navbar-branch" href="${pageContext.request.contextPath}/">
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
              %>
          </ul>
        </div>
      </div>
  </nav>
  <div class="col-12 text-center hd">
    <h2>Booked ticket</h2>
  </div>
  <!-- animation search -->
  
      <div class="searchbar" style="margin-left:75%; margin-bottom: 2%;">
        <input type="text" class="search" id="search" placeholder="Search...">
        <button onclick="toggleSearch()" class="search_icon"><i class="fas fa-search"></i></button>
      </div>
    

  <div class="col-12 tb">
    <table id='table-booking' class="table table-bordered">
      <thead>
        <tr>
          <th>ID</th>
          <th>Departure time </th>
          <th>From</th>
          <th>To</th>
          <th>Seat</th>
          <th>Type seat</th>
          <th>Bus</th>
          <th>Created date</th>
          <th>Pay</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
          <%@ page import="BookingTicketManagement.Model.BookingDTO" %>
          <%@ page import="java.util.ArrayList" %>
          <% ArrayList<BookingDTO> list= (ArrayList<BookingDTO>) request.getAttribute("listBooking");
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
                  %>
      </tbody>
    </table>
  </div>
  <form id='form' action="${pageContext.request.contextPath}/customer/cancel-booking" method="post" style="display: none">
    <input type="text" name="id" id='booking' name='id' class="form-control">
    <button type='submit' id='submitCancel'></button>
  </form>
    
    <form id='formLogout' action="${pageContext.request.contextPath}/logout" method="post" style="display: none;">
  
  </form>
  <script>
    function toggleCancel(id) {
      document.getElementById('booking').value=id;
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