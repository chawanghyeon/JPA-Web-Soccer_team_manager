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
<a href="soccerteam?command=requestUpdateTeam&tName=<%=t.getTName()%>">수정하기</a>

<a href="soccerteam?command=deleteTeam&tName=<%=t.getTName()%>">탈퇴하기</a>

&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>

</center>
</body>
</html>







