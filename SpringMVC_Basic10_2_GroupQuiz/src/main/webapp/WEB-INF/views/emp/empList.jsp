<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>??</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse; /* 붕괴하다 , 무너지다 */
	width: 100%;
}

th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 8px;
}

td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) { /* even 짝수     odd 홀수 */
	background-color: #dddddd;
}
</style>
</head>
<body>
	<table>
		<a href="emp/enroll.htm"><input type="button" value="사원등록" /></a>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>mgr</th>
			<th>hiredate</th>
			<th>sal</th>
			<th>comm</th>
			<th>deptno</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="emp" items="${empList}">
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.job}</td>
				<td>${emp.mgr }</td>
				<td>${emp.hiredate }</td>
				<td>${emp.sal }</td>
				<td>${emp.comm }</td>
				<td>${emp.deptno }</td>
				<td><a href="emp/update.htm?empno=${emp.empno }">수정</a></td>
				<td><a href="emp/delete.htm?empno=${emp.empno }">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
