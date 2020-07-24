<%--
  Created by IntelliJ IDEA.
  User: Corazon
  Date: 7/22/2020
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About Us</title>
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
                    if(role.equals("ADMIN")) {
                        out.print("<li class=\"nav-item\">");
                        out.print("<a class=\"nav-link active\" href=\""+request.getContextPath()+"/aboutUs\">About us</a>");
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
                        out.print("<a class=\"nav-link active\" href=\""+request.getContextPath()+"/aboutUs\">About us</a>");
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
                        out.print("<a class=\"nav-link active\" href=\""+request.getContextPath()+"/aboutUs\">About us</a>");
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
                    out.print("<a class=\"nav-link active\" href=\""+request.getContextPath()+"/aboutUs\">About us</a>");
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
</body>
</html>
