<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRATION PAGE</title>
</head>
<script>
function check(){
	// alert("click event");
	// stage-0  // Creating the XMLHttpRequest object  stag-1
	var request = new XMLHttpRequest();
	var fn = document.getElementById("firstname").value;
	
	//  stage-3  Instantiating the request object
    request.open("GET", "verifyuser?firstname='"+fn+"'");  //3rd parameter defaulr true for asynchronization
    
 // Defining event listener for readystatechange event
    request.onreadystatechange = function() {
	 
        // Check if the request is compete and was successful
        if(this.readyState === 4 && this.status === 200) {
            // Inserting the response from server into an HTML element
           
            	if(this.responseText =="true"){
            		document.getElementById("demo").innerHTML = '<p style="color:red">Firstname already exist!!</p>';
            		
            	}	
            	else{
            		document.getElementById("demo").innerHTML = '<p style="color:green">Firstname available</p>';
            	}
        	
        }
    	};
    
    //stage-4  // Sending the request to the server
    request.send();
	
}
</script>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<body>
	<f:form action="insert" method="post" modelAttribute="RegVO">
	
	FIRST_NAME:<f:input path="firstName" id="firstname" onblur="check()" />
	<div id="demo">  </div>
		<br />
		<br />
	
	LAST_NAME:<f:input path="lastName"  />
		<br />

		<f:hidden path="id" />

		<input type="submit" value="Submit">
	</f:form>
	<br />
	<a href="search">SEARCH</a>
	<br />
</body>
</html>