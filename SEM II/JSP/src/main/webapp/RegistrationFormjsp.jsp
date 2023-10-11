<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="style.css" >
</head>

<body>

  <div id="overlay">
        <form action="RegistrationConfirmation.jsp" id="retruneasyform">
            <div class="alert"> Your request has been submitted</div>
            <h1>Registration Form</h1><br>
            <label for="fullname">Name</label><br>
            <input type="text" id="fullname" placeholder="Enter your name" size="45" ><br><br>
            <label for="emailid">Email Id:</label><br>
            <input type="email" id="email" placeholder="Enter Email ID" size="45" ><br><br>
            <label for="orderid">Date of Birth</label><br>
            <input type="date" id="" placeholder="Enter password" size="45" ><br><br>
            <label for="orderid" size="45" >Gender</label><br>
            <input type="radio" value="Male" size="45" >
            <label for="html">Male</label>&ensp;&ensp;
            <input type="radio" value="Female" size="45"  >
            <label for="html">Female</label><br><br>

            <div class="center">
                <button  onclick="login()" id="login" >Register</button>
                <p id="success"></p>

            </div>
        </form>
    </div>

</body>
</html>