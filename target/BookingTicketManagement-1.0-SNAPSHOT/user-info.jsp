
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
      <link rel='stylesheet' type='text/css' media='screen' href='../css/Infocus.css'>
  </head>
  <body>
    <!-- Navigation bar-->
    <nav class="navbar navbar-expand-sm fixed-top">
            <div class="container-fluid">
          <a class="navbar-branch" href="${pageContext.request.contextPath}/">
                    <img src="../images/logo4.png" height="50">
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
    <section>
        <div class="container">
            <div class="card">
                <img src="../images/prof.png" alt="profile image" class="profile-img">
                <h3>Customer</h3>        
                <div class="col-sm-12">
                    <div class="col-12 form-input">
                    <%@ page import="BookingTicketManagement.Model.UserDTO" %>
                    <% UserDTO user= (UserDTO) request.getAttribute("user"); %>
                    <form action="${pageContext.request.contextPath}/user/update-info-user" onsubmit="return validate()" method="post">
                            <div class="row">
                                <div class="col-4">
                                        <div class="form-group">
                                                <span class="name">Id: </span><br>
                                                <% out.println("<input type=\"text\" name=\"id\" value=\""+user.getId()+"\" readonly>"); %>
                                        </div>
                                </div>
                            
                                <div class="col-4">
                                        <div class="form-group">
                                                <span class="name">Username: </span><br>
                                                <% out.println("<input id='un' type=\"text\" name=\"username\" value=\""+user.getUsername()+"\" readonly>"); %>
                                                <% out.println("<span id=\"unmes\" class=\"text-danger font-weight-bold\"> </span>"); %>
                                        </div>
                                </div>
                            

                            
                                    <div class="col-4">
                                            <div class="form-group">
                                                    <span class="name">Password: </span><br>
                                                    <% out.println("<input id='pw' type=\"text\" name=\"password\" value=\""+user.getPassword()+"\">"); %>
                                                    <% out.println("<span id=\"pwmes\" class=\"text-danger font-weight-bold\"> </span>"); %>
                                            </div>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="form-group col-md-4">
                                                <span class="name">Display name: </span> <br>
                                                <% out.println("<input id='dn' type=\"text\" name=\"displayname\" value=\""+user.getDisplayname()+"\">"); %>
                                                <% out.println("<span id=\"dnmes\" class=\"text-danger font-weight-bold\"> </span>"); %>
                                    </div>
                                    <div class="form-group col-md-4">
                                            <span class="name">Email: </span> <br>
                                            <% out.println("<input id='em' type=\"email\" name=\"email\" value=\""+user.getEmail()+"\">"); %>
                                            <% out.println("<span id=\"emmes\" class=\"text-danger font-weight-bold\"> </span>"); %>
                                    </div>
                                    <div class="form-group col-md-4">
                                            <span class="name">Phone: </span> <br>
                                            <% out.println("<input id='pn' type=\"text\" name=\"phonenumber\" value=\""+user.getPhonenumber()+"\">"); %>
                                            <% out.println("<span id=\"pnmes\" class=\"text-danger font-weight-bold\"> </span>"); %>
                                    </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                        <div class="form-group">
                                                <span class="name">Address: </span><br>
                                                <% out.println("<input id='ad' type=\"text\" name=\"address\" value=\""+user.getAddress()+"\">"); %>
                                                <% out.println("<span id=\"admes\" class=\"text-danger font-weight-bold\"> </span>"); %>
                                        </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <p>Contact:</p>
                                    <ul class="social-media">
                                                <li><a href="#"><i class="fab fa-facebook"></i> </a></li>
                                                <li><a href="#"><i class="fab fa-twitter"></i> </a></li>
                                                <li><a href="#"><i class="fab fa-instagram"></i> </a></li>
                                                <li><a href="#"><i class="fab fa-google-plus-g"></i> </a></li>
                                    </ul>
                                </div>
                                <div class="col-md-4">
                                </div>
                                <div class="col-md-4">
                                        <button type="submit" class="btn btn-primary">Update</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
      
    <form id='formLogout' action="${pageContext.request.contextPath}/logout" method="post" style="display: none;">
  
  </form>
    
    <script type="text/javascript">
        function validate(){
            var un = document.getElementById('un').value;
            var pw = document.getElementById('pw').value;
            var ad = document.getElementById('ad').value;
            var em = document.getElementById('em').value;
            var dn = document.getElementById('dn').value;
            var pn = document.getElementById('pn').value;
            if (un == ""){
                document.getElementById('unmes').innerHTML="Please fill the username"
                return false;
            }
            var iChars = "!`@#$%^&*()+=-[]\\\';,./{}|\":<>?~_";   
                    var data = document.getElementById("un").value;
                    for (var i = 0; i < data.length; i++)
                    {      
                        if (iChars.indexOf(data.charAt(i)) != -1)
                        {    
                            document.getElementById('unmes').innerHTML="The username contains special characters"
                return false;
                        } 
                    }
    
            if((un.length <= 4)||(un.length > 20)){
                document.getElementById('unmes').innerHTML="Username length must be 5 to 20 characters"
                return false;
            }
            if(!isNaN(un)){
                document.getElementById('unmes').innerHTML="Number are not allowed"
                return false;
            }
            if (pw == ""){
                document.getElementById('pwmes').innerHTML="Please fill the password"
                return false;
            }
            if((pw.length <= 5)||(pw.length > 20)){
                document.getElementById('pwmes').innerHTML="Password length must be 6 to 20 characters"
                return false;
            }
            if (ad == ""){
                document.getElementById('admes').innerHTML="Please fill the address"
                return false;
            }
            if (em == ""){
                document.getElementById('emmes').innerHTML="Please fill the email"
                return false;
            }
            if (em.indexOf('@') <= 0){
                document.getElementById('emmes').innerHTML="the @ invalid position"
                return false;
            }
            if (dn == ""){
                document.getElementById('dnmes').innerHTML="Please fill the display name"
                return false;
            }
            if (pn == ""){
                document.getElementById('pnmes').innerHTML="Please fill the phonenumber"
                return false;
            }
            if(isNaN(pn)){
                document.getElementById('pnmes').innerHTML="Only number are allowed"
                return false;
            }
            if(pn.length != 10){
                document.getElementById('pnmes').innerHTML="Phonenumber must be 10 degits"
                return false;
            }
            var x= document.form1.pn.value;
            if (x.charAt(0)!="0")
               {
                    document.getElementById('pnmes').innerHTML="Phonenumber should start with 0"
                    return false
               }
        }   
        
        function toggleLogout(){
        document.getElementById('formLogout').submit();
      }
    </script>
  </body>