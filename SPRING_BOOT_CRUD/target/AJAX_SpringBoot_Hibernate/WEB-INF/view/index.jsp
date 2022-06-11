<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">

function fun(){
	// alert("click event");
	// stage-0  // Creating the XMLHttpRequest object  stag-1
	var request = new XMLHttpRequest();
	
	//  stage-3  Instantiating the request object
    request.open("GET", "/user");  //3rd parameter defaulr true for asynchronization
    
 // Defining event listener for readystatechange event
    request.onreadystatechange = function() {
	 
        // Check if the request is compete and was successful
        if(this.readyState === 4 && this.status === 200) {
            // Inserting the response from server into an HTML element
           var jsn = JSON.parse(this.responseText);
            for(var i=0;i<jsn.length ; i++){
            	console.log(jsn[i]);
            }
        }
    };
    
    //stage-4  // Sending the request to the server
    request.send();
	
}
</script>
<button name="save" id="save" onclick="fun()">Click</button>
</body>
</html>