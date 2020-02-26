var map;
var coords = {lat: -12.04318, lng: -77.02824};
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: coords,
        zoom: 10,
        scrollwheel: false
    });
    
    var image = {url:'frogicon.png', scaledSize: new google.maps.Size(50, 50)}; 
    
    var marker = new google.maps.Marker({
        position: coords,
        map: map,
        icon: image,
        animation: google.maps.Animation.BOUNCE
    })
    
    var contentString = '<h2>Lima, Peru</h2> <p>Where your dreams come true.</p>';
    
    var infowindow = new google.maps.InfoWindow({
    	   content: contentString
    	 });

    	 google.maps.event.addListener(marker, 'click', function() {
    	    infowindow.open(map,marker);
    	 });
    
   
}
