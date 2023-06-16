<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<form action="signin.do" method="post">
		<label>ID:</label>
		<input type="text" name="id">
		<label>비번:</label>
		<input type="password" name="password">
		<input type="submit" value="버튼">
	</form>
	
	<p>${en_pass}</p>
</body>
</html>