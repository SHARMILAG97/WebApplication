<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserLogin</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js">


</script>
</head>


<body>

<jsp:include page="headers.jsp"></jsp:include>
<h2>USER LOGIN</h2>
<%
String message = request.getParameter("message");
if (message != null){
	out.println("<font color='red'>" + message + "</font>");
}
%>


<form action="LoginUserServlet">
<label>Mobile Number:</label>
<input type="number" name="mobileno" id="mobileno" placeholder="Enter Mobile No" required autofocus/>
<br/>

<label>Password:</label>
<input type="password" name="password" id="password" placeholder="Enter Password" required />
<br/>
<button type="submit">Submit</button>
</form>

</body>
</html>