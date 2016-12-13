var indexModule = (function() {
	
	var testStreamBasics = function() {
		
		$.ajax({
			type: 'GET',
	        url: '/Java8/stream/basics',
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
	
	var testStreamReuse = function() {
		$.ajax({
			type: 'GET',
	        url: '/Java8/stream/reuse',
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
	
	var testStreamMaps = function() {
		$.ajax({
			type: 'GET',
	        url: '/Java8/stream/maps',
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
	
	var testStreamFilters = function() {
		$.ajax({
			type: 'GET',
	        url: '/Java8/stream/filters',
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

	var testStreamCollectors = function() {
		$.ajax({
			type: 'GET',
			url: '/Java8/stream/collectors',
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

	var testStreamPredicates = function() {
		$.ajax({
			type: 'GET',
			url: '/Java8/stream/predicates',
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
		testStreamBasics: testStreamBasics,
		testStreamReuse: testStreamReuse,
		testStreamMaps: testStreamMaps,
		testStreamFilters: testStreamFilters,
		testStreamCollectors: testStreamCollectors,
		testStreamPredicates: testStreamPredicates
	}
	
})();