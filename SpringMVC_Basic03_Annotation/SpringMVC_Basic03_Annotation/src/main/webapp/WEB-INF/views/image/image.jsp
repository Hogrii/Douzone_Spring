<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- enctype : form 태그의 기본 encoding 값을 정의 -->
	<!-- 아래의 form은 문자만 보낼때 사용 -->
	<!-- <form action="" method="post" enctype="application/x-www-form-urlencoded"></form>  -->
	<!-- 
		application/x-www-form-urlencoded : 모든 문자들은 서버로 보내기 전 인코딩된다
		multipart-form-data : 파일과 텍스트를 모두 보낼 때 사용 
	 -->
	<form method="post" enctype="multipart/form-data">
		이름:<input type="text" name="name"><br>
		나이:<input type="text" name="age"><br>
		사진:<input type="file" name="file"><br>
		<input type="submit" value="파일업로드">
	</form>
</body>
</html>