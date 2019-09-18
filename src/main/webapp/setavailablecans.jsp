<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>
<meta charset="ISO-8859-1">
<body style ="text-align: center">
<title>Insert title here</title>
</head>
<body>
<br>
<h2>Set Available Cans</h2>
<br>
<form onsubmit = "list()"> 
Set Available Cans:<input type="number"name="setvailabecans"id="availablecans"placeholder="set the available cans" required>
<br>
<br>
<button type="submit">submit</button> <a href="index.jsp">Home</a>

</form>
<script>


function list(){
    
	alert("login");
	 event.preventDefault();
	 var availablecans = document.getElementById("availablecans").value;
	 var formData = "noOfCans=" + availablecans; 
	 console.log(formData);
	 var url="http://localhost:8080/htmlpagee/SetAvailableCans?"+formData;
	 console.log(url);
	 alert(url);
	 var formData = {};
	 $.get(url, function(response){
	         console.log(response);
	         console.log(response.errorMessage);
	         var msg = JSON.parse(response);
	         alert(msg);
	         if (msg.errorMessage!=null) {
	             alert("Invalid");
	         } else {
	             alert("valid");
	             window.location.href = "cansavailable.jsp";
	         }
	});
	}
</script>
</body>
</head>
</html>