<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

${requestScope.successMsg}

<h3>팀 상세보기</h3>
<hr><p> 
 
<table border="1">
	<tr>
		<th>팀이름</th>
	</tr>
 	<tr>
 		<%-- <td>${requestScope.team.tName}</td>
 		 --%>
 		
 		
 		<td>
 		<% TeamDTO t = (TeamDTO)request.getAttribute("team"); 
				if(t != null){
		%>
				<%=t.getTName()%>		
		<%			
				}
		%>
		</td>
		
		
		
 	</tr>
</table>

<br><br><br>
&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllPlayers&pName=${requestScope.player.pName}">선수</a>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllManagers&mName=${requestScope.manager.mName}">감독</a>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllMedicalStaff&dName=${requestScope.medicalstaff.dName}">의료진</a>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllTrainers&tName=${requestScope.trainer.tName}">트레이너</a>

<br><br><br>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/loginDetail.jsp">메인으로 이동</a>

</center>
</body>
</html>







