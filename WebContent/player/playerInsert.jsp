﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>재능 기부자 등록화면</title>
</head>
<body>
<br><br><br>
<center>
<h3>재능 기부자</h3>
<hr><p>

<form action="${pageContext.request.contextPath}/soccerteam" method="post">
	<input type="hidden" name="command" value="addManager">
	<table border="1">
		<tr>
			<td>감독 번호</td><td><input type="text" name="mNumber"></td>
		</tr>
		<tr>
	 		<td>${requestScope.team.tName}</td><td><input type="text" name="tName"></td>
		</tr>
		<tr>	
			<td>감독 이름</td><td><input type="text" name="mName"></td>
	 	</tr>
	 	<tr>
	 		<td>감독 나이</td><td><input type="text" name="mAge"></td>
	 	</tr>
	 	<tr>
	 		<td>감독 분야</td><td><input type="text" name="mPosition"></td>
	 	</tr>
	 	<tr>
	 		<td colspan="2"><input type="submit" value="가입">&nbsp;&nbsp;&nbsp;<input type="reset" value="취소"></td>
	 	</tr>
	</table>
</form>
<br><br><br>
<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>

</center>
</body>
</html>