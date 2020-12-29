<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>트레이너 상세보기</title>
</head>
<body>
<br><br><br>
<center>

${requestScope.successMsg}

<h3>트레이너 상세보기</h3>
<hr><p> 
 
<table border="1">
	<tr>
		<th>팀 이름</th><th>트레이너 번호</th><th>트레이너 이름</th><th>트레이너 나이</th><th>트레이닝 분야</th>
	</tr>
 	<tr>
 		<td>${requestScope.trainer.tname}</td>
 		<td>${requestScope.trainer.trnumber}</td>
 		<td>${requestScope.trainer.trname}</td>
 		<td>${requestScope.trainer.trage}</td>
 		<td>${requestScope.trainer.trposition}</td>
 	</tr>
</table>

<br><br><br>
<a href="soccerteam?command=requestUpdateTrainer&trNumber=${requestScope.trainer.trnumber}">수정하기</a>

<a href="soccerteam?command=deleteTrainer&trNumber=${requestScope.trainer.trnumber}&tName=${requestScope.trainer.tname}">탈퇴하기</a>

&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>

</center>
</body>
</html>







