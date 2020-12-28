﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>의료진 상세보기 화면</title>
</head>
<body>
<br><br><br>
<center>

${requestScope.successMsg}

<h3>의료진  상세보기</h3>
<hr><p> 
 
<table border="1">
	<tr>
		<th>의료진 이름</th><th>의료진 나이</th><th>의료진 분야</th>
	</tr>
 	<tr>
 		<td>${requestScope.medicalstaff.dName}</td>
 		<td>${requestScope.medicalstaff.dAge}</td>
 		<td>${requestScope.medicalstaff.dPosition}</td>
 	</tr>
</table>

<br><br><br>
<a href="soccerteam?command=requestUpdateMedicalStaff&dNumber=${requestScope.medicalstaff.dNumber}">수정하기</a>

<a href="soccerteam?command=deleteMedicalStaff&dNumber=${requestScope.medicalstaff.dNumber}">탈퇴하기</a>

&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>

</center>
</body>
</html>







