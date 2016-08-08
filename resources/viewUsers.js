function sum(){
    var s;
	for( i = 0; i < arguments.length; i++)
		s += arguments[i];
	return s;
}

console.log("we");

var serviceLoc =  "http://localhost:8090/servlet/users.do";

loadDoc(serviceLoc);

function loadDoc(url) {
    		var xhttp = new XMLHttpRequest();
    		xhttp.onreadystatechange = function() {
                   if( xhttp.readyState === 4 &&
						xhttp.status === 200){

							var json = xhttp.responseText;


							console.log(json);
							var content = JSON.parse(json);

						    var stuff = '';
	                        for( var i=0; i < content.length; i++){
	                        	
	
								    stuff += '<span class="glyphicon glyphicon-user">' +
									   '<a href="/servlet/login.do?user=' +
								       //content[i].id +
								       content[i].username  + 
								       '">' + content[i].username  + 
								       '</a>' +
								       //content[i].password +
								       //content[i].avatar  +
								       '</span></br>';
	                        }
	                        stuff += '';

							document.getElementById("users").innerHTML
							 = "<p>" + stuff + "</p>";
                            
                            for( var i=0; i < content.length; i++){
								myimg = document.getElementById('id' + i);
								myimg.style.height = "200px";
								myimg.style.width = "200px"; 
							}

							document.getElementById("success")
								.setAttribute("class","alert alert-success");
						}
    		     
            };
    		
    		xhttp.open("GET", url ,true);
    		xhttp.send();

    	}

