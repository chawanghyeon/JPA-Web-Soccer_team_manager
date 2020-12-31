<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>비밀번호 수정페이지</title>
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

		<h3>사용자 비밀번호 수정페이지</h3>
		<hr>
		<p>
		<form action="soccerteam?command=updateLogin" method="post">
			<table border="1">
				<thead>
					<tr>
						<th>사용자 ID</th>
						<th>사용자 PW</th>
					</tr>
					<tr>
						<td>${sessionScope.userID}</td>
						<td><input type="password" name="newPW"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="수정">
							&nbsp;&nbsp;&nbsp; <input type="reset" value="취소"></td>
					</tr>
			</table>
		</form>
		<a href="${pageContext.request.contextPath}/login/detail.jsp">메인페이지</a>
	</center>
</body>
</html>