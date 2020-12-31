<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="soccerteam.model.dto.TeamDTO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>팀 등록화면</title>
</head>
<body>
	<section >
  		<nav>
    		<jsp:include page="../logout.jsp"></jsp:include>
  		</nav>
 	</section>
<br><br><br>
<center>
<h3>팀 등록</h3>
<hr><p>
<form action="${pageContext.request.contextPath}/soccerteam" method="post">
	<input type="hidden" name="command" value="addTeam">
	<table border="1">
		<tr>
			<td>팀 이름</td><td><input type="text" name="team"></td>
	 	</tr>
	 	
	 	<tr>
	 		<td colspan="2"><input type="submit" value="가입">&nbsp;&nbsp;&nbsp;<input type="reset" value="취소"></td>
	 	</tr>
	</table>
</form>
<br><br><br>
<a href="${pageContext.request.contextPath}/login/detail.jsp">메인페이지</a>

</center>
</body>
</html>