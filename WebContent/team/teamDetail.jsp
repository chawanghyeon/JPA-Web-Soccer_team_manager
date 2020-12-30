﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.util.ArrayList"%>
<%@ page import="soccerteam.model.dto.TeamDTO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>팀 상세보기 화면</title>
</head>
<body>
<br><br><br>
<center>

<h3>팀 상세보기</h3>
<hr><p> 
 
<table border="1">
	
 		<h1>${requestScope.team.team}</h1>
 
		
</table>

<br><br><br>
&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllPlayers&team=${requestScope.team.team}">선수</a>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllManagers&team=${requestScope.team.team}">감독</a>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllMedicalStaffs&team=${requestScope.team.team}">의료진</a>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllTrainers&team=${requestScope.team.team}">트레이너</a>
<br><br><br>
<form action="${pageContext.request.contextPath}/soccerteam" method="post">
	<input type="hidden" name="userID" value="${requestScope.userID}">
	<input type="hidden" name="team" value="${requestScope.team.team}">
	<input type="hidden" name="command" value="deleteTeam">
	<input type="submit" value="팀 삭제하기">
</form>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>
</center>
</body>
</html>







