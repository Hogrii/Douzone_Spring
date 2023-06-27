<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
	<script type="text/javascript">
		$(function () {
			console.log("여긴 오니?");
			$('#sibal').on('click', function() {
				$.ajax({
					url : "test.do",
					type : "GET",
					dataType : "json",
					success : function (data) {
						console.log("제발 와라");	
						console.log(data);
					},
					 error: function(xhr, status, error) {
						console.log("제발 나오지마라");
					    console.log("Error: " + error);
					    console.log("Status: " + status);
					    console.log(xhr);
					}
				});
			});
		});
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<button id="sibal">제발 나와라</button>
</body>
</html>
