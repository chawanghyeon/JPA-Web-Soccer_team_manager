<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>선수 수정 페이지</title>
</head>
<body>
	<br>
	<br>
	<br>
	<center>

		<h3>선수 정보 수정하기 - 선수 포지션 수정</h3>
		<hr>
		<p>
		<form action="soccerteam?command=updatePlayer" method="post">
		<input type="hidden" name="number" value="${requestScope.player.number}">
		<input type="hidden" name="team" value="${requestScope.player.team}">
			<table border="1">
				<thead>
					<tr>
						<th>팀 이름</th><th>선수 번호</th><th>선수 이름</th><th>선수 나이</th><th>선수 포지션</th>
					</tr>
					<tr>
							 <td>${requestScope.player.team}</td>
 		                     <td>${requestScope.player.number}</td>
 		                     <td>${requestScope.player.name}</td>
 		                     <td>${requestScope.player.age}</td>
					 	<td><input type="text" name="position" value="${requestScope.player.position}"></td>
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