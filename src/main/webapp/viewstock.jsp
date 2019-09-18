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
<script>
<body style ="text-align: center">
function listDonation(){
    
var url="http://localhost:8080/Charity_app/ListRequest";
$.getJSON(url,function(response){
    var list = response;
     document.getElementById("tbody").innerHTML="";
    var content=" ";
for(let ld of list){
    console.log(list);
    content += "<tr>";
    content += "<td>" + ld.availablecans + "</td>";
    content += "</tr>";
}
console.log(content);
document.getElementById("tbody").innerHTML =  content;
});
}
</script>
</head>
<body style ="text-align: center">
<h2>STOCK AVAILABLE</h2>
<form onsubmit = "listDonation()"> </form> 
<div class="container-fluid">
   <div class="row">
       <div class="col">
           
           <table border="1" class="table table-condensed" id="tbl">
               <thead>
                   <tr>
                       <th>Cans Available</th> 
                                     
                   </tr>
               </thead>
               <thead>
                   <tr>
                       <th>1000</th> 
                                     
                   </tr>
               </thead>
               <tbody id="tbody"></tbody>
           </table>
       </div>
   </div>
</div>
<script>
listDonation();
</script>

<a href="index.jsp">Home</a>
<br>
<br>
<a href="ordercans.jsp">Order</a>
</body>

</html>