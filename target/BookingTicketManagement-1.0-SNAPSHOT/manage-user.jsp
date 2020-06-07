<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <title>Booking Ticket</title>
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
  <link rel='stylesheet' type='text/css' media='screen' href='../css/manageUser.css'>
</head>

<body>
  <!-- Navigation bar-->
  <nav class="navbar navbar-expand-sm">
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
              %>
        </ul>
      </div>
    </div>
  </nav>
  <!--Container-->
  <div class="container">
    <!--View-->
    <div class="view">
      <h2 style="text-align: center;">Manage users</h2>
    </div>


    <!--Search information-->
    <div class="search-container">
      <div class="form-group">
        <input class="search_input" id='search' type="text" name="" placeholder="Search...">
        <a onclick='toggleSearch()' class="search_icon"><i class="fas fa-search"></i></a>
      </div>
    </div>
    <!-- Trigger the modal with a button -->
    <div class="btn-add-user">
      <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Add User</button>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <!--Modal content-->
          <div class="modal-header">
            <h4 class="modal-title">Create New User</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <!--Modal body-->
          <div class="modal-body">
            <form action="${pageContext.request.contextPath}/admin/create-user" onsubmit="return validateC()"
              method="post">
              <div class="form-group">
                <label>Username</label>
                <input type="text" id="usernameNew" name="username" class="form-control">
                <span id="unmesNew" class="text-danger font-weight-bold"> </span>
              </div>
              <div class="form-group">
                <label>Password</label>
                <input type="password" id="passwordNew" name="password" class="form-control">
                <span id="pwmesNew" class="text-danger font-weight-bold"> </span>
              </div>
              <div class="form-group">
                <label>Display Name</label>
                <input type="text" id="displaynameNew" name="displayname" class="form-control">
                <span id="dnmesNew" class="text-danger font-weight-bold"> </span>
              </div>
              <div class="form-group">
                <label>Phone Number</label>
                <input type="text" id="phonenumberNew" name="phonenumber" class="form-control">
                <span id="pnmesNew" class="text-danger font-weight-bold"> </span>
              </div>
              <div class="form-group">
                <label>Address</label>
                <input type="text" id="addressNew" name="address" class="form-control">
                <span id="admesNew" class="text-danger font-weight-bold"> </span>
              </div>
              <div class="form-group">
                <label>Email</label>
                <input type="email" id="emailNew" name="email" class="form-control">
                <span id="emmesNew" class="text-danger font-weight-bold"> </span>
              </div>
              <div class="form-group">
                <label>Role</label>
                <select class="form-control" id="roleNew" name="role">
                  <%@ page import="BookingTicketManagement.Model.Role" %>
                  <%@ page import="java.util.ArrayList" %>
                  <% ArrayList<Role> listRole = (ArrayList<Role>) request.getAttribute("listRole");
                          for(Role role : listRole) {
                               out.println("<option value=\""+role.getRole()+"\">"+role.getRole()+"</option>");
                             }
                         %>
                </select>
              </div>
              <button type="submit" class="btn btn-success">Create</button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!--Display Table-->
    <table class="table table-responsive" id="table-users">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Username</th>
          <th scope="col">Password</th>
          <th scope="col">Displayname</th>
          <th scope="col">Phone Number</th>
          <th scope="col">Address</th>
          <th scope="col">Email</th>
          <th scope="col">Role</th>
          <th scope="col">CreatedDate</th>
          <th scope="col">CreatedBy</th>
          <th scope="col">UpdatedDate</th>
          <th scope="col">UpdatedBy</th>
          <th scope="col">Action</th>
        </tr>
      </thead>
      <tbody>
        <%@ page import="BookingTicketManagement.Model.UserDTO" %>
        <%@ page import="java.util.ArrayList" %>
        <% ArrayList<UserDTO> list= (ArrayList<UserDTO>) request.getAttribute("listUser");
           for(UserDTO user : list) {
                out.println("<tr id=\""+user.getId()+"\">");
                out.println("<td scope=\"row\">"+user.getId()+"</td>");
                out.println("<td>"+user.getUsername()+"</td>");
                out.println("<td>"+user.getPassword()+"</td>");
                out.println("<td>"+user.getDisplayname()+"</td>");
                out.println("<td>"+user.getPhonenumber()+"</td>");
                out.println("<td>"+user.getAddress()+"</td>");
                out.println("<td>"+user.getEmail()+"</td>");
                out.println("<td>"+user.getRole()+"</td>");
                out.println("<td>"+user.getCreatedDate()+"</td>");
                out.println("<td>"+user.getCreatedBy()+"</td>");
                out.println("<td>"+user.getUpdatedDate()+"</td>");
                out.println("<td>"+user.getUpdatedBy()+"</td>");
                out.println("<td>");
                out.println("<button onclick=\"toggleUpdate('"+user.getId()+"')\" class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#updateModel\">UPDATE</button>");
                out.println("</td>");
                out.println("</tr>");     
              }
          %>
      </tbody>
    </table>
    <!-- Modal -->
    <div class="modal fade" id="updateModel" role="dialog">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <!--Modal content-->
          <div class="modal-header">
            <h4 class="modal-title">Update User</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <!--Modal body-->
          <div class="modal-body">
            <form action="${pageContext.request.contextPath}/admin/update-user" onsubmit="return validateU()"
              method="post">
              <div class="form-group">
                <label for="id">ID</label>
                <input type="text" id="id" name="id" class="form-control" readonly>
              </div>
              <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" class="form-control" readonly>
                <span id="unmes" class="text-danger font-weight-bold"> </span>
              </div>
              <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" class="form-control">
                <span id="pwmes" class="text-danger font-weight-bold"> </span>
              </div>
              <div class="form-group">
                <label for="displayname">Display Name</label>
                <input type="text" id="displayname" name="displayname" class="form-control">
                <span id="dnmes" class="text-danger font-weight-bold"> </span>
              </div>
              <div class="form-group">
                <label for="phonenumber">Phone Number</label>
                <input type="text" id="phonenumber" name="phonenumber" class="form-control">
                <span id="pnmes" class="text-danger font-weight-bold"> </span>
              </div>
              <div class="form-group">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" class="form-control">
                <span id="admes" class="text-danger font-weight-bold"> </span>
              </div>
              <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" class="form-control">
                <span id="emmes" class="text-danger font-weight-bold"> </span>
              </div>
              <div class="form-group">
                <label for="email">Role</label>
                <select class="form-control" id="role" name="role">
                  <%
                  for(Role role : listRole) {
                       out.println("<option value=\""+role.getRole()+"\">"+role.getRole()+"</option>");
                     }
                 %>
                </select>
              </div>
              <button type="submit" class="btn btn-success">Update</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
   <form id='formLogout' action="${pageContext.request.contextPath}/logout" method="post" style="display: none;">
  
  </form>             
  <script>
    function toggleUpdate(id) {

      const tr = document.getElementById(id);
      const td = tr.getElementsByTagName("td");
      document.getElementById("id").value = td[0].textContent;
      document.getElementById("username").value = td[1].textContent;
      document.getElementById("password").value = td[2].textContent;
      document.getElementById("displayname").value = td[3].textContent;
      document.getElementById("phonenumber").value = td[4].textContent;
      document.getElementById("address").value = td[5].textContent;
      document.getElementById("email").value = td[6].textContent;
      document.getElementById("role").selected = td[7].textContent;
    }

    function toggleSearch() {
      let td, txtValue, display;
      const filter = document.getElementById("search").value.toUpperCase();
      const table = document.getElementById("table-users");
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

    function validateC() {
      var un = document.getElementById('usernameNew').value;
      var pw = document.getElementById('passwordNew').value;
      var ad = document.getElementById('addressNew').value;
      var em = document.getElementById('emailNew').value;
      var dn = document.getElementById('displaynameNew').value;
      var pn = document.getElementById('phonenumberNew').value;
      if (un == "") {
        document.getElementById('unmesNew').innerHTML = "Please fill the username"
        return false;
      }
      var iChars = "!`@#$%^&*()+=-[]\\\';,./{}|\":<>?~_";
      var data = document.getElementById("usernameNew").value;
      for (var i = 0; i < data.length; i++) {
        if (iChars.indexOf(data.charAt(i)) != -1) {
          document.getElementById('unmesNew').innerHTML = "The username contains special characters"
          return false;
        }
      }

      if ((un.length <= 4) || (un.length > 20)) {
        document.getElementById('unmesNew').innerHTML = "Username length must be 5 to 20 characters"
        return false;
      }
      if (!isNaN(un)) {
        document.getElementById('unmesNew').innerHTML = "Number are not allowed"
        return false;
      }
      if (pw == "") {
        document.getElementById('pwmesNew').innerHTML = "Please fill the password"
        return false;
      }
      if ((pw.length <= 5) || (pw.length > 20)) {
        document.getElementById('pwmesNew').innerHTML = "Password length must be 6 to 20 characters"
        return false;
      }
      if (ad == "") {
        document.getElementById('admesNew').innerHTML = "Please fill the address"
        return false;
      }
      if (em == "") {
        document.getElementById('emmesNew').innerHTML = "Please fill the email"
        return false;
      }
      if (em.indexOf('@') <= 0) {
        document.getElementById('emmesNew').innerHTML = "the @ invalid position"
        return false;
      }
      if (dn == "") {
        document.getElementById('dnmesNew').innerHTML = "Please fill the display name"
        return false;
      }
      if (pn == "") {
        document.getElementById('pnmesNew').innerHTML = "Please fill the phonenumber"
        return false;
      }
      if (isNaN(pn)) {
        document.getElementById('pnmesNew').innerHTML = "Only number are allowed"
        return false;
      }
      if (pn.length != 10) {
        document.getElementById('pnmesNew').innerHTML = "Phonenumber must be 10 degits"
        return false;
      }
      var x = document.form1.pn.value;
      if (x.charAt(0) != "0") {
        document.getElementById('pnmesNew').innerHTML = "Phonenumber should start with 0"
        return false
      }
    }

    function validateU() {
      var un = document.getElementById('username').value;
      var pw = document.getElementById('password').value;
      var ad = document.getElementById('address').value;
      var em = document.getElementById('email').value;
      var dn = document.getElementById('displayname').value;
      var pn = document.getElementById('phonenumber').value;
      if (un == "") {
        document.getElementById('unmes').innerHTML = "Please fill the username"
        return false;
      }
      var iChars = "!`@#$%^&*()+=-[]\\\';,./{}|\":<>?~_";
      var data = document.getElementById("username").value;
      for (var i = 0; i < data.length; i++) {
        if (iChars.indexOf(data.charAt(i)) != -1) {
          document.getElementById('unmes').innerHTML = "The username contains special characters"
          return false;
        }
      }

      if ((un.length <= 4) || (un.length > 20)) {
        document.getElementById('unmes').innerHTML = "Username length must be 5 to 20 characters"
        return false;
      }
      if (!isNaN(un)) {
        document.getElementById('unmes').innerHTML = "Number are not allowed"
        return false;
      }
      if (pw == "") {
        document.getElementById('pwmes').innerHTML = "Please fill the password"
        return false;
      }
      if ((pw.length <= 5) || (pw.length > 20)) {
        document.getElementById('pwmes').innerHTML = "Password length must be 6 to 20 characters"
        return false;
      }
      if (ad == "") {
        document.getElementById('admes').innerHTML = "Please fill the address"
        return false;
      }
      if (em == "") {
        document.getElementById('emmes').innerHTML = "Please fill the email"
        return false;
      }
      if (em.indexOf('@') <= 0) {
        document.getElementById('emmes').innerHTML = "the @ invalid position"
        return false;
      }
      if (dn == "") {
        document.getElementById('dnmes').innerHTML = "Please fill the display name"
        return false;
      }
      if (pn == "") {
        document.getElementById('pnmes').innerHTML = "Please fill the phonenumber"
        return false;
      }
      if (isNaN(pn)) {
        document.getElementById('pnmes').innerHTML = "Only number are allowed"
        return false;
      }
      if (pn.length != 10) {
        document.getElementById('pnmes').innerHTML = "Phonenumber must be 10 degits"
        return false;
      }
      var x = document.form1.pn.value;
      if (x.charAt(0) != "0") {
        document.getElementById('pnmes').innerHTML = "Phonenumber should start with 0"
        return false
      }
    }   
    
    function toggleLogout(){
        document.getElementById('formLogout').submit();
      }
  </script>
</body>

</html>