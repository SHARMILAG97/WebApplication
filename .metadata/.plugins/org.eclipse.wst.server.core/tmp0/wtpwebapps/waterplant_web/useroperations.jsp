<%@page import="com.revature.model.User"%>
<html>
<head>
<title>UserOperations</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="headers.jsp"></jsp:include>
<%
User user = (User)session.getAttribute("LOGGED_IN_USER");
String name =  user != null ? user.getName() :"";
%>
<h3>Welcome <%=name%></h3>

<form >

<div class="container-fluid">
        <div class="row">
            <div class="col">
<a href="updatestock.jsp">Order Cans</a> <br/>
	<a href="viewuser.jsp">Reserve Cans</a> <br/>
	<a href="viewstock.jsp">Order Reserved Cans</a> <br/>
</div>
</div>
</div>


</form>


</body>
</html>