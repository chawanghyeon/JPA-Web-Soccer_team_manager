<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>모든 감독 list 화면</title>
</head>
<body>
<br><br><br>
<center>
<h3>감독 list</h3>
<hr><p>

<table border="1">
	<thead>
		<tr>
			<th>팀 이름</th><th>감독 번호</th><th>감독 이름</th><th>감독 나이</th><th>감독 분야</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.allManagers}" var="data">
		 <tr>
		 	<td>${data.tName}</td>
		 	<td><a href="${url}soccerteam?command=getManager&mNumber=${data.mNumber}">${data.mNumber}</a></td>
		 	<td>${data.mName}</td>
		 	<td>${data.mAge}</td>
		 	<td>${data.mPosition}</td>
		 </tr>
	 </c:forEach>





</table>

<br><br><br>
<font color="blue">감독 번호를 클릭하면 상세 정보 확인이 가능합니다</font>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>

</center>
</body>
</html>