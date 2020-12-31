<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원가입</title>
</head>
<body>
	<section >
  		<nav>
    		<jsp:include page="../logout.jsp"></jsp:include>
  		</nav>
 	</section>
<br><br><br>
<center>
<h3>회원 가입</h3>
<hr><p>

<form action="${pageContext.request.contextPath}/soccerteam" method="post">
	<input type="hidden" name="command" value="addLogin">
	<table border="1">
		<tr>
			<td>ID</td><td><input type="text" name="userID"></td>
		</tr>
		<tr>	
			<td>PW</td><td><input type="password" name="userPW"></td>
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