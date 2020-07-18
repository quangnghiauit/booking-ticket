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
    <link rel='stylesheet' type='text/css' media='screen' href='./css/Signup.css'>
</head>

<body>
    <!-- Navigation bar-->
    <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
        <div class="container-fluid">
            <a class="navbar-branch" href="${pageContext.request.contextPath}/">
                <img src="./images/logo4.png" height="50">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/login">Sign in</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="modal-dialog text-center">
        <div class="col-sm-12 main-section">
            <div class="modal-content">
                <div class="col-12 user-img">
                    <img src="./images/sign.png">
                </div>
                <div class="col-12 form-iput">
                    <form action="${pageContext.request.contextPath}/register" onsubmit="return validate()"
                        method="post">
                        <h2>SIGN UP</h2>
                        <div class="form-group">
                            <input id='username' type="text" name="username" class="form-control"
                                placeholder="Enter Username">
                            <span id="unmes" class="text-danger font-weight-bold"> </span>
                        </div>
                        <div class="form-group">
                            <input id='password' type="password" name="password" class="form-control"
                                placeholder="Enter Password">
                            <span id="pwmes" class="text-danger font-weight-bold"> </span>
                        </div>
                        <div class="form-group">
                            <input id='displayname' type="text" name="displayname" class="form-control"
                                placeholder="Enter DisplayName">
                            <span id="dnmes" class="text-danger font-weight-bold"> </span>
                        </div>
                        <div class="form-group">
                            <input id='address' type="text" name="address" class="form-control"
                                placeholder="Enter Address">
                            <span id="admes" class="text-danger font-weight-bold"> </span>
                        </div>
                        <div class="form-group">
                            <input id='email' type="email" name="email" class="form-control" placeholder="Enter Email">
                            <span id="emmes" class="text-danger font-weight-bold"> </span>
                        </div>
                        <div class="form-group">
                            <input id='phonenumber' type="text" name="phonenumber" class="form-control"
                                placeholder="Enter Phonenumber">
                            <span id="pnmes" class="text-danger font-weight-bold"> </span>
                        </div>
                </div>
                <button type="submit" class="btn btn-success">Sign up</button>
                </form>
            </div>
        </div>
    </div>
    </div>
    <script>
        function validate() {
            var un = document.getElementById('username').value;
            var pw = document.getElementById('password').value;
            var ad = document.getElementById('displayname').value;
            var em = document.getElementById('email').value;
            var dn = document.getElementById('address').value;
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
    </script>
</body>

</html>