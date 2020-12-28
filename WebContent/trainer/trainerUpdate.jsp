<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>트레이너 수정 페이지</title>
</head>
<body>
	<br>
	<br>
	<br>
	<center>

		<h3>트레이너 정보 수정하기 - 트레이너 분야 수정</h3>
		<hr>
		<p>
		<form action="soccerteam?command=updateManager" method="post">
			<table border="1">
				<thead>
					<tr>
						<th>팀 이름</th><th>트레이너 번호</th><th>트레이너 이름</th><th>트레이너 나이</th><th>트레이너 분야</th>
					</tr>
					<tr>
						<td>${requestScope.trainer.tName}</td>
					 	<td>${requestScope.trainer.trNumber}</td>
					 	<td>${requestScope.trainer.trName}</td>
					 	<td>${requestScope.trainer.trAge}</td>
					 	<td><input type="text" name="trPosition" value="${requestScope.trainer.trPosition}"></td>
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