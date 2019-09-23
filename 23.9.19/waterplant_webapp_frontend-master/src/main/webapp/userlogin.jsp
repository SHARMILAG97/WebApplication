<div>
<h2>USER LOGIN</h2>
<script type="text/javascript">
       function status() {
          
           window.location.href = "?pageName=useroperations.jsp";
       }
 </script>
 <script>

function register() {
   
    event.preventDefault();
   var mobileno = document.getElementById("mobileno").value;
    var password = document.getElementById("password").value;
    var formData = "mobileno=" + mobileno + "&password=" + password;
    console.log(formData);
  
    var url = "http://localhost:8080/waterplant_web/UserLoginServlet?" + formData;
    console.log(url);    
    var formData = {};
    $.get(url, function(response) {
        console.log(response);
        localStorage.setItem("LOGGED_IN_USER",response);
        console.log(response.errorMessage);
        var msg=JSON.parse(response);
     
        if (msg.errorMessage!=null) {
            alert("Invalid Username/Password");
            window.location.href = "?pageName=userlogin.jsp";
        } else {
            
           status();
        }
    });
}
</script>


<form onsubmit="register()">
<label>Mobile_Number:</label>
<input type="number" name="mobileno" id="mobileno" placeholder="Enter Mobile No" required autofocus/>
<br/><br/>

<label>Password:</label>
<input type="password" name="password" id="password" placeholder="Enter Password" required />
<br/><br/>

<input type="submit" value="LOGIN" class="btn btn-success">
<button type="reset" class="btn btn-danger" value="clear">CLEAR</button>
</form>

<script >

function displayName(){

	var user =JSON.parse(localStorage.getItem("LOGGED_IN_USER"));
	var name= user.Name;
	document.getElementById("name").innerHtml = "Welcome....."+ name;
	return name;
}

displayName();
</script>
</div>