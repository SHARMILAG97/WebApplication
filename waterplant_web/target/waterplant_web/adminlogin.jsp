<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
<jsp:include page="headers.jsp"></jsp:include>

<script type="text/javascript">
       function status() {
           alert("Logged successfully");
           window.location.href = "admin.jsp";
       }
       </script>
       <script>

function register() {
    //alert('register');
    event.preventDefault();
    var name = document.getElementById("name").value;
    var password = document.getElementById("password").value;
    var formData = "name=" + name + "&password=" + password;
    console.log(formData);
   // alert(formData);
    var url = "http://localhost:8080/waterplant_web/AdminLoginServlet?" + formData;
    console.log(url);
    //alert(url);
    var formData = {};
    $.get(url, function(response) {
        console.log(response);
        //alert(response);
        console.log(response.errorMessage);
        var msg=JSON.parse(response);
       // alert(msg.errorMessage);
        if (msg.errorMessage!=null) {
            alert("Invalid Username/Password");
            window.location.href = "adminlogin.jsp";
        } else {
            alert("valid Username/Password");
           status();
        }
    });
}
</script>

<%
String message = request.getParameter("message");
if (message != null){
	out.println("<font color='red'>" + message + "</font>");
}
%>
<script type="text/javascript">



function login(name,password){
	

		console.log("Admin Login");
		var formdata="name="+name+"password="+password;
	}
}
	
</script>
<form onsubmit=register()>

<label>Name:</label>
<input type="text" name="name" id="name" placeholder="Enter Name" required autofocus/>
<br/>

<label>Password:</label>
<input type="password" name="password" id="password" placeholder="Enter Password" required />
<br/>
<input type="submit" value="Submit" class="btn btn-success">
<button type="reset" class="btn btn-danger" value="clear">clear</button>
</form>
<a href="index.jsp">Home</a>
</body>
</html>