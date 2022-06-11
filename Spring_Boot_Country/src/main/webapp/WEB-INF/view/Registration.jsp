<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<script type="text/javascript">


function newstate(){
	var request = new XMLHttpRequest();
	var cnid = document.getElementById("country").value;
	request.open("GET", "/state?country="+cnid);
	var data="";
	request.onreadystatechange = function() {
		 
        // Check if the request is compete and was successful
        if(this.readyState === 4 && this.status === 200) {
            // Inserting the response from server into an HTML element
           var jsn = JSON.parse(this.responseText);
            for(var i=0;i<jsn.length ; i++){
            	data = data + '<option value="'+ jsn[i].id+'">' + jsn[i].state_name  + '</option>' ;
            	console.log(jsn[i].cntry_name);
            }
            document.getElementById("state").innerHTML = data;
        }
    };
    
    //stage-4  // Sending the request to the server
    request.send();
}
</script>

<form action="" >
Country : <select id="country" onchange="newstate()">
		<c:forEach items="${ls}" var="i">
		<option value="${i.id}">${i.cntry_name}</option>
		</c:forEach>
		  
		  </select><br><br>
		  
State : <select id="state">

		</select>
</form>
</body>
</html>