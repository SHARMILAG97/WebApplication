<html>
<head>
<title>UsersList</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.4.1.min.js">
</script>
<script type="text/javascript">

function View()
{
	var url = "http://localhost:8080/waterplant_web/ViewUsersServlet";
	$.getJSON(url, function(response){
		var data = response;
var content="";
		
		document.getElementById("tbl").innerHTML="";

		for(let user of data){

	        content += "<tr>";
	        content += "<td>" + user.Id + "</td>";
	        content += "<td>" + user.Name + "</td>";
	        content += "<td>" + user.Mobileno+ "</td>";
	        content += "<td>" + user.Address+ "</td>";
	        content += "</tr>";
	    }
	  
		document.getElementById("tbl").innerHTML = content;
	});
}



</script>
</head>
<body style="text-align:center">
	<div id="users-section">
		<table border="1" class="table table-condensed">
			<thead>
				<tr>
					<th>Date</th>
					<th>StockId</th>
					<th>Updated Cans</th>
					<th>Ordered Cans</th>
					<th>Reserved Cans</th>
					<th>Available Cans</th>
				</tr>
			</thead>
			<tbody id="tbl">

			</tbody>
		</table>


	</div>

	<script>
View();
</script>

</body>
</html>