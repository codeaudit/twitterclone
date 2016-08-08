var serviceLoc = "http://localhost:8090/servlet/tweets.do";
// "http://localhost:8090/bootcamp/twittermessage.json";

/*
// create data object to contain form data
function AddressBookEntry(name,currentdate) {
    this.name = name;
	this.currentdate=currentdate;
    
}

function go(){
    // create data structure
    var addressBook = {entries:[]};  // this should be JSON array object

    // create onclick function for button
    document.getElementById("submit").onclick = function() {
        // get values from each form field
        var name = document.getElementById("idtxtTwitter").value;
       var currentdate = new Date().toGMTString();

        // create new object using consturctor
        var newAddress = new AddressBookEntry(name,currentdate);
		
        //var jAddress = JSON.stringify(newAddress);

        // push new object into array
        addressBook.entries.push(newAddress);
        localStorage.setItem("addressBook", JSON.stringify(addressBook));

        // add information to page

        // write data to the page
        console.log(addressBook);
        // store the data
		//alert(name);
        // read from storage and write to page if data found
		var newloadtext = new loadText(name,addressBook);
        return true;
    }
}*/
 /*function saveDataInLS(){
    var obj={};
        obj.name=document.getElementById('idtxtTwitter').value;
        alert(obj.name);

    var listObj=localStorage.getItem('DATA');
    if(listObj!=null){
      listObj=JSON.parse(listObj); //this will give array of object
      listObj.push(obj);
    }else{
      listObj=[obj]; //first time 
    }
   // Save Data in Local Storage 
    localStorage.setItem('DATA',JSON.stringify(listObj)); 
   //Please check Local Storage which will be like
    //[{"name":"Anand","phone":"6546456456"}{"name":"Andy","phone":"78688"}]
}*/


function loadTweet()
{
	//alert(txtTwitter);
	    var xhttp;
		var url = serviceLoc;
		//alert("url")
		var textval=new Array();
		var txtTwitter = document.getElementById("idtxtTwitter").value;  
		var currentdate = new Date().toGMTString();
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
									
									
								
								//if (txtTwitter === content[i].message)
								//{
									//alert("1");
								//txtArr.push( txtTwitter.value );
								//alert(txtArr.length);
								
									 txt.setAttribute("cols", 50);
									 txt.setAttribute("rows", 3);
									//txt.setAttribute("value",txtTwitter+"  "+currentdate);
									 txt.setAttribute("id","txtid");
									 
									 txt.innerHTML=content[i].message+"  "+currentdate;
									 div1.appendChild(txt);
									 
									 div1.setAttribute("class","jo");
									 //content.sort( predicatBy("id") );
									 document.getElementById("content").appendChild(div1);
									// break;
								//}else
								//{
										 //alert("2");
									// txt.setAttribute("cols", 50);
									// txt.setAttribute("rows", 3);
									//txt.setAttribute("value",txtTwitter+"  "+currentdate);
									// txt.setAttribute("id","txtid");
									// txt.innerHTML=content[i].message+"  "+currentdate;
									// div1.appendChild(txt);
									 
									// div1.setAttribute("class","jo");
									
									// document.getElementById("content").appendChild(div1);
									// }
									// content.sort(SortByID).reverse();
								}
							
					
						}
			};
		
//Usage

					
					 
			xhttp.open("GET", url ,true);
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