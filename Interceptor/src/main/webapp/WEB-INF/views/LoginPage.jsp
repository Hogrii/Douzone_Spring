<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
}

form {
	max-width: 300px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	color: #333;
}

label {
	display: block;
	margin-bottom: 10px;
	color: #666;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="submit"] {
	width: 100%;
	background-color: #4CAF50;
	color: #fff;
	padding: 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

::placeholder {
	color: #999;
}
</style>
</head>
<body>
	<h1>Login Form</h1>
	<form action="/interceptor/login/" method="get">
		<label for="id">ID:</label> 
		<input type="text" name="id" id="id" placeholder="ID"> 
		<label for="pwd">PWD:</label> 
		<input type="text" name="pwd" id="pwd" placeholder="PWD"> 
		<input type="submit" value="SUBMIT">
	</form>
</body>
</html>