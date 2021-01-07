<%@ page language="java" contentType="text/html; charset=utf-8"
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
	<section >
  		<nav>
    		<jsp:include page="../logout.jsp"></jsp:include>
  		</nav>
 	</section>
<br><br><br>
<center>
 	
<h1>${sessionScope.team}</h1>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllPlayers">선수</a>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllManagers">감독</a>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllMedicalStaffs">의료진</a>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllTrainers">트레이너</a>
<div id="a"></div>
<br><br><br>
<form action="${pageContext.request.contextPath}/soccerteam" method="post">
	<input type="hidden" name="command" value="deleteTeam">
	<input type="submit" value="팀 삭제하기">
</form>
&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getLogin">팀 목록</a>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/login/detail.jsp">메인페이지</a>
</center>
</body>
</html>







