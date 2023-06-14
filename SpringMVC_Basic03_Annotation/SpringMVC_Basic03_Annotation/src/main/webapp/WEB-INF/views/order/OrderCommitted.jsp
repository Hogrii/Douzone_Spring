<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상품목록 출력하기(EL & JSTL)</h3>
	<c:forEach var="item" items="${orderCommand.orderItem}" >
		<li>${item.itemid } - ${item.number } - ${item.remark }</li>
	</c:forEach>
</body>
</html>