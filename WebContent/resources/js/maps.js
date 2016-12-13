var mapsModule = (function() {
	
	var testBasicMaps = function() {
		
		$.ajax({
			type: 'GET',
	        url: '/Java8/maps/basics',
	        contentType: 'application/json',
	        dataType: 'json',
			success: function(response) {
				console.log(response);
			},
			error: function(error) {
				console.log(error);
			}
		});
		
	};
	
	return {
		testBasicMaps: testBasicMaps
	}
	
})();