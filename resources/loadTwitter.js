var serviceLoc = "http://localhost:8090/servlet/tweets.do";


loadTweetdisplay();

function loadTweetdisplay()

{
	
	    var xhttp;
		var url = serviceLoc;
		
		var textval=new Array();
		var txtTwitter = document.getElementById("idtxtTwitter").value;  
		var currentdate = new Date().toGMTString();
		
		var updateUrl = url + '?user=user1&' ; //hard coded user
		
		
		
		
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
							
							for (i = 0; i < content.length; i++)
								{
								  var txtArr   = [];
									var txt = document.createElement('TEXTAREA');
									var table = document.createElement('table');
									var div1 = document.createElement('div');
									 txt.setAttribute("cols", 50);
									 txt.setAttribute("rows", 3);
								
									 txt.setAttribute("id","txtid");
									
									 //if (content[i].message !=="")
									 //{
										//alert(content[i].message); 
									 txt.innerHTML=content[i].message+"  "+ content[i].hitTime;
									 //}
									 div1.appendChild(txt);
									 
									 div1.setAttribute("class","jo");
									 
									 document.getElementById("content").appendChild(div1);
								
								}
							//document.getElementById("idtxtTwitter").value="";
						}
			};
		//Usage
			xhttp.open("GET", updateUrl ,true);
    		xhttp.send();
					
}

function loadTweet()

{
	
	    var xhttp;
		var url = serviceLoc;
		
		var textval=new Array();
		var txtTwitter = document.getElementById("idtxtTwitter").value;  
		var currentdate = new Date().toGMTString();
		
		var updateUrl = url + '?user=user1&message="' + txtTwitter + '"'; //hard coded user
		
		
		
		
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
							
							for (i = 0; i < content.length; i++)
								{
								  var txtArr   = [];
									var txt = document.createElement('TEXTAREA');
									var table = document.createElement('table');
									var div1 = document.createElement('div');
									 txt.setAttribute("cols", 50);
									 txt.setAttribute("rows", 3);
								
									 txt.setAttribute("id","txtid");
									
									
									 txt.innerHTML=content[i].message+"  "+ content[i].hitTime;
									 //}
									 div1.appendChild(txt);
									 
									 div1.setAttribute("class","jo");
									 
									 document.getElementById("content").appendChild(div1);
								
								document.getElementById("idtxtTwitter").value="";
								
								}
							
						}
			};
		//Usage
			xhttp.open("GET", updateUrl ,true);
    		xhttp.send();
					
}