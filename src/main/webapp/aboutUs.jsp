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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Kaushan+Script">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
</head>
<body id="page-top">
<nav class="navbar navbar-expand-sm fixed-top" style="background-color: black">
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
<header class="masthead" style="background-image:url('assets/img/header-bg.jpg');">
    <div class="container">
        <div class="intro-text">
            <div class="intro-lead-in"><span>Welcome To ITravel!</span></div>
            <div class="intro-heading text-uppercase"><span>It's Nice To Meet You</span></div><a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" role="button" href="#services">JOIN WITH US</a></div>
    </div>
</header>
<section id="team" class="bg-light">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <div class="team-member"><img class="rounded-circle mx-auto" src="assets/img/team/nghia.png">
                    <h4>Nguyễn Quang Nghĩa</h4>
                    <p class="text-muted">Admin features developer</p>
                    <ul class="list-inline social-buttons">
                        <li class="list-inline-item"><a href="https://www.facebook.com/quangnghia.ng"><i class="fa fa-twitter"></i></a></li>
                        <li class="list-inline-item"><a href="https://www.facebook.com/quangnghia.ng"><i class="fa fa-facebook"></i></a></li>
                        <li class="list-inline-item"><a href="https://www.facebook.com/quangnghia.ng"><i class="fa fa-linkedin"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="team-member"><img class="rounded-circle mx-auto" src="assets/img/team/luyen.png">
                    <h4>Nguyễn Cao Luyện</h4>
                    <p class="text-muted">Customer features developer</p>
                    <ul class="list-inline social-buttons">
                        <li class="list-inline-item"><a href="https://www.facebook.com/luyen2k2"><i class="fa fa-twitter"></i></a></li>
                        <li class="list-inline-item"><a href="https://www.facebook.com/luyen2k2"><i class="fa fa-facebook"></i></a></li>
                        <li class="list-inline-item"><a href="https://www.facebook.com/luyen2k2"><i class="fa fa-linkedin"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="team-member"><img class="rounded-circle mx-auto" src="assets/img/team/tan.png">
                    <h4>Nguyễn Duy Tân</h4>
                    <p class="text-muted">Seller features developer</p>
                    <ul class="list-inline social-buttons">
                        <li class="list-inline-item"><a href="https://www.facebook.com/tan.nd98/"><i class="fa fa-twitter"></i></a></li>
                        <li class="list-inline-item"><a href="https://www.facebook.com/tan.nd98/"><i class="fa fa-facebook"></i></a></li>
                        <li class="list-inline-item"><a href="https://www.facebook.com/tan.nd98/"><i class="fa fa-linkedin"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<section id="contact" style="background-image:url('assets/img/map-image.png');">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="text-uppercase section-heading">Contact Us</h2>
                <h3 class="section-subheading text-muted">Lorem ipsum dolor sit amet consectetur.</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <form id="contactForm" name="contactForm" novalidate="novalidate">
                    <div class="form-row">
                        <div class="col col-md-6">
                            <div class="form-group"><input class="form-control" type="text" id="name" placeholder="Your Name *" required=""><small class="form-text text-danger flex-grow-1 help-block lead"></small></div>
                            <div class="form-group"><input class="form-control" type="email" id="email" placeholder="Your Email *" required=""><small class="form-text text-danger help-block lead"></small></div>
                            <div class="form-group"><input class="form-control" type="tel" placeholder="Your Phone *" required=""><small class="form-text text-danger help-block lead"></small></div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group"><textarea class="form-control" id="message" placeholder="Your Message *" required=""></textarea><small class="form-text text-danger help-block lead"></small></div>
                        </div>
                        <div class="col">
                            <div class="clearfix"></div>
                        </div>
                        <div class="col-lg-12 text-center">
                            <div id="success"></div><button class="btn btn-primary btn-xl text-uppercase" id="sendMessageButton" type="submit">Send Message</button></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<footer style="background-color: #f8f9fa">
    <div class="container">
        <div class="row">
            <div class="col-md-4"><span class="copyright">Copyright&nbsp;© Brand 2018</span></div>
            <div class="col-md-4">
                <ul class="list-inline social-buttons">
                    <li class="list-inline-item"><a href="#"><i class="fa fa-twitter"></i></a></li>
                    <li class="list-inline-item"><a href="#"><i class="fa fa-facebook"></i></a></li>
                    <li class="list-inline-item"><a href="#"><i class="fa fa-linkedin"></i></a></li>
                </ul>
            </div>
            <div class="col-md-4">
                <ul class="list-inline quicklinks">
                    <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
                    <li class="list-inline-item"><a href="#">Terms of Use</a></li>
                </ul>
            </div>
        </div>
    </div>
</footer>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src="assets/js/agency.js"></script>
</body>
</html>
