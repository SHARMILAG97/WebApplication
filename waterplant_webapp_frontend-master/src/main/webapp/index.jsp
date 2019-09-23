<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>

<style type="text/css">
   label{
  width: 100px;
  display: inline-block;
  text-align: right;
   }
</style>
</head>
<body  bgcolor="#green"
  style="text-align:center">
<jsp:include page="headers.jsp"></jsp:include>


<div class="jumbotron">
    <h2> Online WaterPlant Service </h2>
 
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
