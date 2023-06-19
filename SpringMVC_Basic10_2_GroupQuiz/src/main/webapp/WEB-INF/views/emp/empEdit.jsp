<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update.htm" method="post">
		<h2>회원수정</h2>
		<h3 class="hidden">회원수정 폼</h3>
		<div id="join-form" class="join-form margin-large">
			<dl class="join-form-row">
				<dt class="join-form-title">사번</dt>
				<dd class="join-form-data">
					<input type="text" name="empno" value=${emp.empno } readonly/>
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">이름</dt>
				<dd class="join-form-data">
					<input type="text" name="ename" />
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">직종</dt>
				<dd class="join-form-data">
					<input type="text" name="job" />
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">매니저</dt>
				<dd class="join-form-data">
					<input type="text" name="mgr" />
				</dd>
			</dl>
			<!-- 
			<dl class="join-form-row">
				<dt class="join-form-title">입사일</dt>
				<dd class="join-form-data">
					<input type="text" name="hiredate" />
				</dd>
			</dl>
			 -->
			<dl class="join-form-row">
				<dt class="join-form-title">급여</dt>
				<dd class="join-form-data">
					<input type="text" name="sal" />
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">커미션</dt>
				<dd class="join-form-data">
					<input type="text" name="comm" />
				</dd>
			</dl>
			<dl class="join-form-row">
				<dt class="join-form-title">부서번호</dt>
				<dd class="join-form-data">
					<input type="text" name="deptno" />
				</dd>
			</dl>
		</div>
		<div id="buttonLine">
			<input class="btn-okay button" type="submit" value="등록" />
		</div>
	</form>
</body>
</html>