<html>
<head>
<title>Water Plant</title>
<!-- To include external JS  files -->
<script src="js/app.js"></script>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>


<style type="text/css">
   label{
  width: 125px;
  display: inline-block;
  text-align: right;
   }
</style>

</head>
<body style="text-align:center">
<jsp:include page="headers.jsp"></jsp:include>
<div class="jumbotron">
<h2>ONLINE WATERPLANT SERVICE</h2><br/>
</div>

<div class="view" id="view">
        <%
            String pageName = request.getParameter("pageName");

            if (pageName == null || "".equals(pageName)) {
                pageName = "home.jsp";
            }
            // out.println(pageName);
        %>

        <jsp:include page="<%=pageName%>"></jsp:include>
    </div>


</body>
</html>
