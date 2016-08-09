var serviceLoc = "http://localhost:8090/servlet/tweets.do";

loadText();

function getCookie(name)
{
	var lines = document.cookie.split(";");
	for( var l in lines )
		{
		if( l.indexOf(name) != -1 )
			{
			var w = l.split("=");
			return w[1];
			}
		}
	return "";
}



function loadText()
{
	//alert(txtTwitter);
	    var xhttp;
		var url = serviceLoc;
		var textval=new Array();
		var txtTwitter = document.getElementById("idtxtTwitter").value;  
		var currentdate = new Date().toGMTString();
		
		//var user =  getCookie("user");
	
		var updateUrl = url + '?message="' + txtTwitter + '"'
		//+ '?user=' + user + '&message="' + txtTwitter + '"'; //hard coded user
		
		var xhttp = new XMLHttpRequest();
    		xhttp.onreadystatechange = function() {
                   if( xhttp.readyState === 4 &&
						xhttp.status === 200){
							
							var json = xhttp.responseText;
							var myimgs= document.getElementById("content");
									  var last;
									  while(last= myimgs.lastChild){
									  myimgs.removeChild(last);
									  }

							console.log(json);
							var content = JSON.parse(json);
							//alert(content.length);
							for (i = 0; i < content.length; i++)
								{
								  var txtArr   = [];
									var txt = document.createElement('TEXTAREA');
									var table = document.createElement('table');
									var div1 = document.createElement('div');
									
									
								
										 //alert("2");
									 txt.setAttribute("cols", 50);
									 txt.setAttribute("rows", 3);
									//txt.setAttribute("value",txtTwitter+"  "+currentdate);
									 txt.setAttribute("id","txtid");
									 txt.innerHTML=content[i].message+"  "+currentdate;
									 div1.appendChild(txt);
									 
									 div1.setAttribute("class","jo");
									
									 document.getElementById("content").appendChild(div1);
									 }
									// content.sort(SortByID).reverse();
								
							
					
						}
			};
		
			
					 
			xhttp.open("GET", updateUrl ,true);
    		xhttp.send();
					
}
/*function loadText(){
	var txtTwitter = document.getElementById("idtxtTwitter").value;    
    var url = serviceLoc;
    loadDoc(url);
}
function loadDoc(url) {
	
	var xhttp = new XMLHttpRequest();
    		xhttp.onreadystatechange = function() {
                   if( xhttp.readyState === 4 &&
						xhttp.status === 200){

							var json = xhttp.responseText;


							console.log(json);
							var content = JSON.parse(json);

							


						    var stuff = "";
	                        for( var i=0; i < content.length; i++){
	                        	
								//for( var attr in content[i]){
									//stuff += "<li>" + attr + ":" + content[i][attr]  + "</li>";
								   //  stuff += '<img src="' + 
								   //          'http://localhost:8080' + "/images/" +
											// content[i].url +
								   //  		'" title="' +
								   //  		content[i].description  +  '"/>';

								    stuff += '<a href="' +
								       'http://localhost:8080' + "/images/" +
									   content[i].url +
								       '" data-lightbox="image-1" data-title="' +
								       content[i].description  + 
								       '">' +
								       '<img class="img-thumbnail"' + 
								       	    ' id="id' + i  + '" ' +
								            'src="' + 
								            'http://localhost:8080' + "/images/" +
											content[i].url +
								    		'" title="' +
								    		content[i].description  +  '"/>'
								       '</a>';

								//}

								
	                        }

							document.getElementById("content").innerHTML
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
}*/