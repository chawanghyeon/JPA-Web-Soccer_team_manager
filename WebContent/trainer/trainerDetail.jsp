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
 		<td>${requestScope.trainer.tName}</td>
 		<td>${requestScope.trainer.trNumber}</td>
 		<td>${requestScope.trainer.trName}</td>
 		<td>${requestScope.trainer.trAge}</td>
 		<td>${requestScope.trainer.trPosition}</td>
 	</tr>
</table>

<br><br><br>
<a href="soccerteam?command=requestUpdateTrainer&trNumber=${requestScope.trainer.trNumber}">수정하기</a>

<a href="soccerteam?command=deleteTrainer&trNumber=${requestScope.trainer.trNumber}">탈퇴하기</a>

&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>

</center>
</body>
</html>







