<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>의료진 수정 페이지</title>
</head>
<body>
	<br>
	<br>
	<br>
	<center>

		<h3>의료진 정보 수정하기 - 의료진 분야 수정</h3>
		<hr>
		<p>
		<form action="soccerteam?command=updateMedicalStaff" method="post">
			<table border="1">
				<thead>
					<tr>
						<th>팀 이름</th><th>의료진 번호</th><th>의료진 이름</th><th>의료진 나이</th><th>의료진 분야</th>
					</tr>
					<tr>
						<td>${requestScope.medicalstaff.tName}</td>
					 	<td>${requestScope.medicalstaff.dNumber}</td>
					 	<td>${requestScope.medicalstaff.dName}</td>
					 	<td>${requestScope.medicalstaff.dAge}</td>
					 	<td><input type="text" name="dPosition" value="${requestScope.medicalstaff.dPosition}"></td>
					</tr>

					<tr>
						<td colspan="5"><input type="submit" value="수정">
							&nbsp;&nbsp;&nbsp; <input type="reset" value="취소"></td>
					</tr>
			</table>
		</form>
		<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>

	</center>
</body>
</html>