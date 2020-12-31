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
	<section >
  		<nav>
    		<jsp:include page="../logout.jsp"></jsp:include>
  		</nav>
 	</section>
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
				<td>${sessionScope.userID}</td>
			</tr>
		</table>
		<p>
			<%-- <c:forEach items="${requestScope.allTeams}" var="data">
					${data.team}<br>
			</c:forEach> --%>






			<%
				ArrayList<TeamDTO> list = (ArrayList<TeamDTO>) session.getAttribute("allTeams");
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
			%>
				<form action="${pageContext.request.contextPath}/soccerteam">
					<input type="hidden" name="command" value="getTeam"> 
					<input type="hidden" name="team" value="<%=list.get(i).getTeam()%>">
					<input type="submit" value="<%=list.get(i).getTeam()%>">
				</form>
			<%
					}
				}
			%>




		<br> <br>
		<form action="${pageContext.request.contextPath}/team/insert.jsp">
			<input type="submit" value="팀 생성하기">
		</form><br> 
		<a href="soccerteam?command=requestUpdateLogin">비밀번호 수정하기</a>
		<a href="soccerteam?command=deleteLogin">탈퇴하기</a>
	</center>
</body>
</html>