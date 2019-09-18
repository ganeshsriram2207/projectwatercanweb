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
<body style ="text-align: center">
<h1>USER LOGIN</h1>
<form onsubmit="login()" >

Name:<input type="text"name="name" id="username"placeholder="enter your name" required>
<br>
<br>
Password:<input type="text"name="password"id="password"placeholder="enter your password" required>
<br>
<br>

<button type="submit">submit</button> <a href="index.jsp">Home</a>
<script>

function login()
{
	alert("login");
 event.preventDefault();
 var username = document.getElementById("username").value;
 var password=document.getElementById("password").value;
 var formData = "username=" + username +"&password="+ password; 
 console.log(formData);
 var url="http://localhost:8080/htmlpagee/LoginServlet?"+formData;
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
             window.location.href = "viewstock.jsp";
         }
         
 });
}

</script>
</form>
</body>
</html>