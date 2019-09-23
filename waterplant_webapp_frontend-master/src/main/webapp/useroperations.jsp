

<div id="name"></div>
<form >

<div>
<br/><a href="?pageName=updatestock.jsp">Order Cans</a> <br/><br>
	<a href="?pageName=reserve.jsp">Reserve Cans</a> <br/><br/>
	<a href="?pageName=orderreserve.jsp">Order Reserved Cans</a> <br/><br/>
	<input type="button"  value="Logout" class="btn btn-danger" onclick= "logout()">
</div>

</form>

<script >

function displayName(){

	var user =JSON.parse(localStorage.getItem("LOGGED_IN_USER"));
	var name= user.Name;
	document.getElementById("name").innerHTML = "Welcome....."+ name;
	return name;
}

displayName();

function logout(){
    localStorage.clear();
    window.location.href = "?pageName=index.jsp";
    }
</script>
