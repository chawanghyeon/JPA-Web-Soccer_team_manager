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
		 	<td>${data.tname}</td>
		 	<td><a href="${url}soccerteam?command=getManager&mNumber=${data.mnumber}">${data.mnumber}</a></td>
		 	<td>${data.mname}</td>
		 	<td>${data.mage}</td>
		 	<td>${data.mposition}</td>
		 </tr>
	 </c:forEach>





</table>
<form action="${pageContext.request.contextPath}/manager/managerInsert.jsp">
	<input type="hidden" name="tname" value="${requestScope.allManagers[0].tname}">
	<input type="submit" value="추가">
</form>
<br><br><br>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/soccerteam?command=getTeam&tName=${requestScope.allManagers[0].tname}">팀 페이지로 이동</a><br>
<font color="blue">감독 번호를 클릭하면 상세 정보 확인이 가능합니다</font>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>

</center>
</body>
</html>