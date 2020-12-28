<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>모든 의료진 list 화면</title>
</head>
<body>
<br><br><br>
<center>
<h3>의료진 list</h3>
<hr><p>

<table border="1">
	<thead>
		<tr>
			<th>팀 이름</th><th>의료진 번호</th><th>의료진 이름</th><th>의료진 나이</th><th>의료진 분야</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.allMedicalStaffs}" var="data">
		 <tr>
		 	<td>${data.tName}</td>
		 	<td><a href="${url}soccerteam?command=getMedicalStaff&dNumber=${data.pNumber}">${data.pNumber}</a></td>
		 	<td>${data.dName}</td>
		 	<td>${data.dAge}</td>
		 	<td>${data.dPosition}</td>
		 </tr>
	 </c:forEach>





</table>

<br><br><br>
<font color="blue">의료진 번호를 클릭하면 상세 정보 확인이 가능합니다</font>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>

</center>
</body>
</html>