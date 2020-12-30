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
 		<td>${requestScope.trainer.team}</td>
 		<td>${requestScope.trainer.number}</td>
 		<td>${requestScope.trainer.name}</td>
 		<td>${requestScope.trainer.age}</td>
 		<td>${requestScope.trainer.position}</td>
 	</tr>
</table>

<br><br><br>
<a href="soccerteam?command=requestUpdateTrainer&number=${requestScope.trainer.number}">수정하기</a>

<a href="soccerteam?command=deleteTrainer&number=${requestScope.trainer.number}&team=${requestScope.trainer.team}">탈퇴하기</a>

&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>

</center>
</body>
</html>







