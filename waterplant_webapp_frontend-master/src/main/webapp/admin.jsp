<div>

<h2>Welcome Admin</h2><br/>

<div>
<a href="?pageName=updatestock.jsp">Update Stock</a> <br/><br/>
	<a href="?pageName=viewusers.jsp">View Users</a> <br/><br/>
	<a href="?pageName=viewstock.jsp">View Stock</a> <br/><br/>
	<input type="button"  value="Logout" class="btn btn-danger" onclick= "logout()">
	
</div>

<script>
function logout(){
    localStorage.clear();
    window.location.href = "?pageName=index.jsp";
    }
</script>
</div>