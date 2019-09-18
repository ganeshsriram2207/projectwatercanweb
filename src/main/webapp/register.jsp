<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>

</head>
<br>
<h2>REGISTER LOGIN</h2>
<br>
<br>
<body style ="text-align: center">
<form onsubmit="register()" >
<label>Username:</label>
<input type="text" name="username" id="username" placeholder="Enter your username" required autofocus />
<br/>
<br>
<label>Phone Number</label>
<input type="text" name="phonenumber" id="phonenumber" placeholder="Enter your phone number"required  />
<br/>
<br>
<label>Email_id</label>
<input type="text" name="Email_id" id="Email_id" placeholder="Enter your Email_id"required  />
<br/>
<br>
<label>Password:</label>
<input type="password" name="password" id="password" placeholder="Enter your Password" required />
<br/>
<br>
<button type="submit">Submit</button>
<br/>
Existing User ? <a href="index.jsp">Login</a> <br/>
<a href="index.jsp">Home</a>
</form>
<script>
function register()
{
 event.preventDefault();
 var username = document.getElementById("username").value;
 var phonenumber=document.getElementById("phonenumber").value;
 var password=document.getElementById("password").value;
 var Email_id=document.getElementById("Email_id").value;
 var formData = "username=" + username + "&phonenumber="+ phonenumber +"&Email_id="+ Email_id +"&password="+ password; 
 console.log(formData);
 var url="http://localhost:8080/htmlpagee/RegisterServlet?"+formData;
 console.log(url);
 alert(url);
 var formData = {};
 $.get(url, function(response){
         console.log(response);
         console.log(response.errorMessage);
         var msg = JSON.parse(response);
         alert(msg);
         if (msg.errorMessage!=null) {
             alert("Invalid Username/Password");
         } else {
             alert("valid Username/Password");
             window.location.href = "userlogin.jsp";
         }
         
 });
}
</script>
</body>
</html>
