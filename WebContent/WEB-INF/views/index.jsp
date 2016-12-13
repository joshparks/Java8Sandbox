 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>

<html>

<head>
	
	<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
	<title>${pageTitle}</title>
	
	<!-- jquery -->
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	
	<!-- bootstrap -->
	<!-- <link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
		integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
		crossorigin="anonymous">
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
		crossorigin="anonymous"></script> -->
	
	<!-- page specific -->
	<link rel="stylesheet" type="text/css" href="resources/css/index.css" media="all" />
	
	<script type="text/javascript" src="resources/js/index.js"></script>

</head>

<body>
	
	<p onclick="indexModule.testStreamBasics()">Stream Basics()</p>
	<p onclick="indexModule.testStreamReuse()">Stream Reuse()</p>
	<p onclick="indexModule.testStreamMaps()">Stream Maps()</p>
	<p onclick="indexModule.testStreamFilters()">Stream Filters()</p>
	<p onclick="indexModule.testStreamCollectors()">Stream Collectors()</p>
	<p onclick="indexModule.testStreamPredicates()">Stream Predicates()</p>
	
</body>

</html>