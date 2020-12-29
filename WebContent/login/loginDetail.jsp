<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="soccerteam.model.dto.TeamDTO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>메인페이지</title>
</head>
<body>
	<br>
	<br>
	<br>
	<center>

		${requestScope.successMsg}

		<h3>메인페이지</h3>
		<hr>
		<p>
		<table border="1">
			<tr>
				<th>사용자 ID</th>
			</tr>
			<tr>
				<td>${requestScope.login.userID}</td>
			</tr>
		</table>
		<p>
			<%-- <c:forEach items="${requestScope.allTeams}" var="data">
					${data.tName}<br>
			</c:forEach> --%>
			
			
			
			
			
			
			<% ArrayList<TeamDTO> list = (ArrayList<TeamDTO>)request.getAttribute("allTeams"); 
				for(int i = 0; i < list.size(); i++){
			%>
					<%-- <a href="soccerteam?command=getTeam&tName=${requestScope.allTeams[i].tName}"><%= list.get(i).getTName() %></a> --%>
					<form action="${pageContext.request.contextPath}/soccerteam">
						<input type="hidden" name="command" value="getTeam">
						<input type="hidden" name="tName" value="<%=list.get(i).getTName()%>">
						<input type="submit" value="<%= list.get(i).getTName() %>">
					</form>
			<%
				}
			%>
			
			
			
			
			<br>
			<br>
			<br> <a href="soccerteam?command=requestUpdateLogin&uesrID=${requestScope.login.userID}">비밀번호 수정하기</a> 
			<a href="soccerteam?command=deleteLogin&userID=${requestScope.login.userID}">탈퇴하기</a>

			&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>
	</center>
</body>
</html>







