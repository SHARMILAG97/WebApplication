<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserRegister</title>
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

<h3>USER REGISTER</h3>

<form action="RegisterUserServlet">

<label>Name:</label>
<input type="text" name="name" id="name" placeholder="Enter Name" required autofocus/>
<br/>

<label>Mobile Number:</label>
<input type="number" name="mobileno" id="mobileno" placeholder="Enter Mobile No" required />
<br/>

<label>Password:</label>
<input type="password" name="password" id="password" placeholder="Enter Password" required />
<br/>
<label>Address:</label>
<input type="text" name="address" id="address" placeholder="Enter Address" required />
<br/>
<button type="submit">Submit</button>

</form>

</body>
</html>