<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserRegister</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>
</head>


<body>

<jsp:include page="headers.jsp"></jsp:include>
<%
String message = request.getParameter("message");
if (message != null){
	out.println("<font color='red'>" + message + "</font>");
}
%>

<script>

function register() {
    //alert('register');
    event.preventDefault();
    var name = document.getElementById("name").value;
    var mobileno = document.getElementById("mobileno").value;
    var password = document.getElementById("password").value;
    var address = document.getElementById("address").value;
    var formData = "name="+name+ "&mobileno=" + mobileno + "&password=" + password+ "&address="+address;
    console.log(formData);

    var url = "http://localhost:8080/waterplant_web/RegisterServlet?" + formData;
    console.log(url);
    var formData = {};
    $.get(url, function(response) {
        console.log(response);
        alert(response);
        var msg=JSON.parse(response);
       // alert(msg.errorMessage);
        if (msg.errorMessage!=null) {
            alert("Invalid Values");
            window.location.href = "userregister.jsp";
        } else {
            alert("successful Register");
            window.location.href = "userlogin.jsp";
        }
    });
}

    
</script>
<h3>USER REGISTER</h3>

<form onsubmit="register()">
<label>Name:</label>
<input type="text" name="name" id="name" placeholder="Enter Name" required autofocus/>
<br/>

<label>Mobile Number:</label>
<input type="number" name="mobileno" id="mobileno" placeholder="Enter Mobile No" required />
<br/>

<label>Password:</label>
<!--<input type="password" name="password" id="password" placeholder="Enter Password" required />  -->
<input type="password" name="password" id="password" placeholder="Enter Password" required
 pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
 title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters required "/>
<br/>
<label>Address:</label>
<input type="text" name="address" id="address" placeholder="Enter Address" required />
<br/>
<input type="submit" value="Submit" class="btn btn-success">
<button type="reset" class="btn btn-danger" value="clear">clear</button>
</form>

</body>
</html>