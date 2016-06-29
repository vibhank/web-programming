<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js">
  <head>
    <meta charset="utf-8">
    <title>Homework 3</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    
   
    <style type="text/css">
      #googleMap{
        height:380px;
        margin-top: 20px;
        margin-bottom: 20px;
      };

      .footer{
        padding-top: 20px;
      }
    </style>
    
  </head>
  <body>
    <!--[if lt IE 10]>
      <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

    <div class="container">
      
      <div class="page-header">
        <button id="btnLocateMe" class="btn btn-default pull-right">Locate Me</button>
        <h1>Coffee Shop Locator <small>CS 320</small></h1>
      </div>

      <form action="CoffeeShopController" method="get" class="form-inline text-center">
        <div class="form-group">
          <label for="lat">Latitude</label>
          <input type="text" class="form-control" name="latitude"  id="latitude" placeholder="Enter your latitude">
        </div>
        <div class="form-group">
          <label for="lon">Longitude</label>
          <input type="text" class="form-control" name="longitude" id="longitude" placeholder="Enter your longitude">
        </div>
        <div class="form-group">
          <label for="radius">Search Radius</label>
          <input type="text" class="form-control" name="radius" id="radius" placeholder="Enter your search radius">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
        
      </form>

      <hr />

      <p class="lead text-center" id="announcement"></p>

      <div id="googleMap"></div>

      <div class="row">
        <div class="col-xs-12">

          <div class="page-header">
        
        
            <h2>Search Results <small>${ CoffeeShopBeans.size() }</small></h2>

          </div>

          <table class="table table-striped table-bordered">
            <tr>
              <th>Distance</th>
              <th>Store Info</th>              
              <th>Map</th>
            </tr>

           <c:forEach items="${ CoffeeShopBeans }" var="user" varStatus="iterate">
           <c:set var = "value" value="${ iterate.index }" ></c:set>
           
			<tr>
				<td>${ CoffeeShopBeans.get(value).getDistance() }</td>
				  <td>${ CoffeeShopBeans.get(value).getName() }</br>
				    ${ CoffeeShopBeans.get(value).getStreet() }</br>
				    ${ CoffeeShopBeans.get(value).getCity() }</br>
				    ${ CoffeeShopBeans.get(value).getZip() }</br> 
				   <a href="tel:">${ CoffeeShopBeans.get(value).getPhone() }</a> 
				</td>
				<td class="text-center">
                <img src="https://maps.googleapis.com/maps/api/staticmap?center=${ CoffeeShopBeans.get(value).getLatitude()},${ CoffeeShopBeans.get(value).getLongitude() }&zoom=13&size=300x200&sensor=false&markers=color:red%7C+${ CoffeeShopBeans.get(value).getLatitude()},${ CoffeeShopBeans.get(value).getLongitude()})" />
     
              </td>
				
			</tr>		
		</c:forEach>

          </table>
        </div>
      </div>

      <div class="footer">
        <hr />
        <p><span class="glyphicon glyphicon-heart"></span> from the CS 320</p>
      </div>

    </div>

    <script src="http://maps.googleapis.com/maps/api/js"></script>
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>  
    <script type="text/javascript">
    
    function initialize() {
    	var map, myOptions, myCenter, myCenter2, mapProp, myMarker, myMarker2, infowindow2, searchArea, markers = [];
    	var lat, lon,rad;
    	var points = [];

    	//check if user has geo feature
    	if(navigator.geolocation){

    	navigator.geolocation.getCurrentPosition(
    	//get position
    	function(position){

    	    lat = <%=request.getParameter("latitude")%>
    	    lon = <%=request.getParameter("longitude")%>
    	    rad = <%=request.getParameter("radius")%>
    	    
    		// Initialize my location
    		myCenter = new google.maps.LatLng(lat, lon);

    	    //init map
    	    myOptions = {
    	       center: myCenter,
    	       zoom: 11,
    	       mapTypeId: google.maps.MapTypeId.ROADMAP
    	    };
    	    map = new google.maps.Map(document.getElementById("googleMap"),
    	        myOptions);
    	    
    		// Instantiate a marker
    		myMarker = new google.maps.Marker({
    			position : myCenter,
    	});

    		// Add the marker to the map
    		myMarker.setMap(map);
    		
    		var infowindow = new google.maps.InfoWindow({
    			  content:"You're here!"
    			  });
    		google.maps.event.addListener(myMarker, 'click', function() {
    			    infowindow.open(map,myMarker);
    			  });
    	 	
    		searchArea = new google.maps.Circle({
    			center : myCenter,
    			radius : rad * 1609.34, 
    			strokeColor : "#0000FF",
    			strokeOpacity : 0.8,
    			strokeWeight : 2,
    			fillColor : "#0000FF",
    			fillOpacity : 0.4
    		});
    		searchArea.setMap(map);
    		
    	 <c:forEach items="${ CoffeeShopBeans }" var="user" varStatus="iterate">
    	 <c:set var = "value" value="${ iterate.index }" ></c:set>;
    			myCenter2 = new google.maps.LatLng(${ CoffeeShopBeans.get(value).getLatitude() }, ${ CoffeeShopBeans.get(value).getLongitude() });
    			myMarker2 = new google.maps.Marker({
                          position : myCenter2,
    				animation:google.maps.Animation.BOUNCE
    				//icon:"http://maps.google.com/mapfiles/ms/icons/green-dot.png"
    			});
    			myMarker2.setMap(map);
    		
    			infowindow2 = new google.maps.InfoWindow({
    				  content:"${ CoffeeShopBeans.get(value).getName()}",
    				  });
    			google.maps.event.addListener(myMarker2, 'click', function() {
    					infowindow2.setContent("<strong>${ CoffeeShopBeans.get(value).getDistance() } Miles Apart</strong> ");
    		 		    infowindow2.open(map,this);
    				  });
    			
    		</c:forEach> 
    		
    		// Create event handler for the "Locate Me" button
    		$("#btnLocateMe").click(
    				function(e) {
    					var $out = $('#announcement');
    					// Does the User's browser support geolocation?
    					if (!navigator.geolocation) {
    						$out.html("<p>Geolocation is not supported by your browser</p>");
    						return;
    					}
    					// This function will be called when the position is successfully obtained
    					function success(position) {
    						var latitude = position.coords.latitude;
    						var longitude = position.coords.longitude;
    						$out.html('');
    						// Update the input boxes with the detected values
    						$('#latitude').val(latitude);
    						$('#longitude').val(longitude);
    					};
    					function error() {
    						$out.html("Unable to retrieve your location");
    					};
    					$out.html("Locating.....");
    					navigator.geolocation.getCurrentPosition(success, error);
    					e.stopPropagation();
    					e.preventDefault();
    				});
    	    
    	    
    	},
    	// if there was an error
    	function(error){
    	    alert('Permission Denied.!');
    	});
    	}
    	
    	}

    			google.maps.event.addDomListener(window, 'load', initialize);

    	 	</script>

    	</body>
    	</html>