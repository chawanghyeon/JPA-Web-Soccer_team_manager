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
<br><br><br>
<center>

${requestScope.successMsg}

<h3>팀 상세보기</h3>
<hr><p> 
 
<table border="1">
	
 		<td>${requestScope.team.tname}</td>
 		 
 		
 		
 		<%-- <% TeamDTO t = (TeamDTO)request.getAttribute("team"); 
				if(t != null){
		%>
				<h2><%=t.getTName()%></h2>		
		<%			
				}
		%> --%>
		
</table>
<%-- 
<br><br><br>
&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllPlayers&pName=<%=t.getTName()%>">선수</a>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllManagers&mName=<%=t.getTName()%>">감독</a>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllMedicalStaff&dName=<%=t.getTName()%>">의료진</a>

&nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getAllTrainers&tName=<%=t.getTName()%>">트레이너</a>

<br><br><br>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/loginDetail.jsp">메인으로 이동</a>
 --%>
</center>
</body>
</html>







