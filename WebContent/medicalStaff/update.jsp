﻿<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>수정 페이지</title>
</head>
<body>
	<section >
  		<nav>
    		<jsp:include page="../logout.jsp"></jsp:include>
  		</nav>
 	</section>
	<br>
	<br>
	<br>
	<center>

		<h3>정보 수정하기 - 분야 수정</h3>
		<hr>
		<p>
		<form action="soccerteam?command=updateMedicalStaff" method="post">
		<input type="hidden" name="number" value="${sessionScope.people.number}">
			<table border="1">
				<thead>
					<tr>
						<th>팀 이름</th><th>번호</th><th>이름</th><th>나이</th><th>분야</th>
					</tr>
					<tr>
						<td>${sessionScope.people.team}</td>
					 	<td>${sessionScope.people.number}</td>
					 	<td>${sessionScope.people.name}</td>
					 	<td>${sessionScope.people.age}</td>
					 	<td><input type="text" name="position" value="${sessionScope.people.position}"></td>
					</tr>

					<tr>
						<td colspan="5"><input type="submit" value="수정">
							&nbsp;&nbsp;&nbsp; <input type="reset" value="취소"></td>
					</tr>
			</table>
		</form>
		<a href="${pageContext.request.contextPath}/login/detail.jsp">메인페이지</a>

	</center>
</body>
</html>