<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!--Style css-->
<link rel='stylesheet' type='text/css' media='screen'
	href='./css/BookingSeat.css'>
<title>Booking Ticket Bus</title>
</head>

<body>
	<nav class="navbar navbar-expand-sm">
		<div class="container-fluid">
			<a class="navbar-branch" href="${pageContext.request.contextPath}/">
				<img src="./images/logo4.png" height="50">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<% try{
            
    String role = (String)request.getSession().getAttribute("role");
    if(role.equals("ADMIN"))
    {
        out.print("<li class=\"nav-item\">");
        out.print("<a class=\"nav-link \" href=\""+request.getContextPath()+"/\">Home</a>");
        out.print("</li>");
        out.print("<li class=\"nav-item\">");
        out.print("<a class=\"nav-link \" href=\""+request.getContextPath()+"/manage-user\">Manage user</a>");
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
        out.print("<a class=\"nav-link \" href=\""+request.getContextPath()+"/\">Home</a>");
        out.print("</li>");
        out.print("<li class=\"nav-item\">");
        out.print("<a class=\"nav-link \" href=\""+request.getContextPath()+"/customer/tick-booked\">My Ticks</a>");
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
        out.print("<a class=\"nav-link \" href=\""+request.getContextPath()+"/\">Home</a>");
        out.print("</li>");
        out.print("<li class=\"nav-item\">");
        out.print("<a class=\"nav-link \" href=\""+request.getContextPath()+"/seller/manage-ticket\">Manage tickets</a>");
        out.print("</li>");
        out.print("<li class=\"nav-item\">");
        out.print("<a class=\"nav-link \" href=\""+request.getContextPath()+"/seller/manage-seat\">Manage seats</a>");
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
        out.print("<a class=\"nav-link \" href=\""+request.getContextPath()+"/\">Home</a>");
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

        <!--Instruction-->
	<div class="row step-booking">
		<a href="#" id="step1">Step 1.Select the route </a> 
		<a href="#" id="step2"><i class="fas fa-angle-double-right"></i> Step 2.Select the seat</a> 
		<a href="#" id="step3"><i class="fas fa-angle-double-right"></i> Step 3.Payment</a>
	</div>

	<!--Search-->
	<div class="search">
		<input type="text" id="search" class="form-search"
			placeholder="Search...">
		<button onclick="toggleSearch()"><i class="fa fa-search"></i></button>
	</div>

	<!--Select the seat-->
	<div class="view-seat">
		<div class="row">
			<div class="col-sm-6">
				<div class="card select-seat">
					<div class="card-body">
						<h5 class="card-title">Select the seat</h5>
						<div class="form-check form-check-inline ">
							<input type="checkbox" id="checkbox1" disabled> 
							<label class="form-check-label checkbox1" for="checkbox1"> Available</label>
						</div>
						<div class="form-check form-check-inline">
							<input type="checkbox" id="checkbox2" disabled> 
							<label class="form-check-label checkbox2" for="checkbox2"> Unavailable</label>
						</div>
                                                <div class="form-check form-check-inline ">
							<input type="checkbox" id="checkbox3" disabled> 
							<label class="form-check-label checkbox3" for="checkbox3"> Active</label>
						</div>
						<%@page import="BookingTicketManagement.Model.Route"%>
						<%@page import="BookingTicketManagement.Model.SeatDTO"%>
						<%@ page import="java.util.ArrayList"%>
						<% 
                            
                            String price = (String)request.getAttribute("price");
                            ArrayList<SeatDTO> listSeat = (ArrayList<SeatDTO>)request.getAttribute("listSeat");
                            Route route = (Route)request.getAttribute("route");
                            String departureTime = (String)request.getAttribute("departureTime");
                            String busName = (String) request.getAttribute("busName");
                            int index=0;
                            while(true){
                                out.println("<div class=\"row row-seat\">");
                                for(int i=0;i<7;i++){
                                    if(listSeat.get(index).getStatus())
                                        out.println("<button id="+listSeat.get(index).getId()+" onclick=\"toggleSeat('"+listSeat.get(index).getId()+"')\" class='btn-seat col available'>"+listSeat.get(index).getName()+":"+listSeat.get(index).getId()+"</button>");
                                    else
                                        out.println("<button id="+listSeat.get(index).getId()+" onclick=\"toggleSeat('"+listSeat.get(index).getId()+"')\" class='btn-seat col ' disabled>"+listSeat.get(index).getName()+":"+listSeat.get(index).getId()+"</button>");
                                    index++;
                                    if(index>=listSeat.size())
                                        break;
                                }
                                out.println("</div>");
                                if(index>=listSeat.size())
                                    break;
                            }
                        %>

					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="card info-bus">
					<div class="card-body">
						<h5 class="card-title title">Infomation bus</h5>
						<form action="${pageContext.request.contextPath}/customer/booking-ticket" method="post">
							<div class="form-row">
								<div class="form-group col-md-3">
									<label for="busid">Bus</label> <input type="text"
										class="form-control" value="<%=busName%>" placeholder="BusID">
								</div>
								<div class="form-group col-md-3">
									<label for="seat">Seat</label> <input name="listSeat"
										type="text" id="seat" class="form-control" min="1" max="5"
										required>
								</div>
								<div class="form-group col-md-6">
									<label for="departuretime">Departure time</label> <input
										name="departureTime" type="text" class="form-control"
										value="<%=departureTime%>" placeholder="Departure time">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="departure">From</label> <input type="text"
										class="form-control" value="<%=route.getFrom()%>"
										placeholder="Departure">
								</div>
								<div class="form-group col-md-6">
									<label for="arrival">To</label> <input type="text"
										class="form-control" value="<%=route.getTo()%>"
										placeholder="Arrival">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="price">Price (VND)</label> <input id='price'
										type="currency" class="form-control" value="<%=price%>"
										placeholder="Price">
								</div>
								<div class="form-group col-md-6">
									<label for="total">Total (VND)</label> <input id="total"
										type="currency" class="form-control" value="0"
										placeholder="Total">
								</div>
							</div>
							<input type="text" name="route" value="<%=route.getId()%>"
								style="display: none;">
						
						 <button class="btn btn-danger btn-close" data-dismiss="modal"><i class="fas fa-times"></i> CLOSE</button> 
						 <button class="btn btn-primary btn-submit"><i class="far fa-check-circle"></i> SUBMIT</button>
				</form>
			</div>
		</div>
	</div>
	</div>
	</div>
        <form id='formLogout' action="${pageContext.request.contextPath}/logout" method="post" style="display: none;">
        </form>                                                       
	<!--Active of seat-->
	<script>
        function toggle(id) {
              if (document.getElementById(id).classList.contains("active"))
              {
                  document.getElementById(id).classList.remove("active");
                  document.getElementById(id).classList.add("available");
              }
              else
                {
                  document.getElementById(id).classList.remove("available");
                  document.getElementById(id).classList.add("active");
              }
          }
        function toggleSeat(id) {
            let seat = document.getElementById("seat");
            if(seat.value == id){
                seat.value='';
                document.getElementById('total').value = 0;
                toggle(id);
                return;
            }

            listSeat = seat.value.split(",") ;
            if (listSeat.includes(id)){
            	listSeat = listSeat.filter(item => item !== id );
            	
            }
            else {
                if (seat.value.split(",").length >= 5)
                    return;
                listSeat.push(id);
            }

            seat.value = listSeat.reduce((value, cur) => value.length >0 && cur.length > 0 ? cur += ',' + value : cur ,'');

            
            document.getElementById('total').value = seat.value.split(',').length*<%=price%>;
            
            toggle(id);

        }
        function toggleLogout(){
        document.getElementById('formLogout').submit();
      }
    </script>
</body>

</html>