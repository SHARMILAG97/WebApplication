<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="headers.jsp"></jsp:include>

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
<form action="LoginAdminServlet">

<label>Name:</label>
<input type="text" name="name" id="name" placeholder="Enter Name" required autofocus/>
<br/>

<label>Password:</label>
<input type="password" name="password" id="password" placeholder="Enter Password" required />
<br/>
<button type="submit">Submit</button>
</form>
<a href="index.jsp">Home</a>
</body>
</html>