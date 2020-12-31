<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>list 화면</title>
</head>
<body>
	<section >
  		<nav>
    		<jsp:include page="../logout.jsp"></jsp:include>
  		</nav>
 	</section>
<br><br><br>
<center>
<h3>list 화면</h3>
<hr><p>

<table border="1">
	<thead>
		<tr>
			<th>팀 이름</th><th>번호</th><th>이름</th><th>나이</th><th>분야</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.peoples}" var="data">
		 <tr>
		 	<td>${data.team}</td>
		 	<td><a href="${url}soccerteam?command=getManager&number=${data.number}">${data.number}</a></td>
		 	<td>${data.name}</td>
		 	<td>${data.age}</td>
		 	<td>${data.position}</td>
		 </tr>
	 </c:forEach>





</table>
<form action="${pageContext.request.contextPath}/manager/insert.jsp">
	<input type="submit" value="추가">
</form>
<br><br><br>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/soccerteam?command=getTeam">팀 페이지로 이동</a>
<br>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/login/detail.jsp">메인페이지</a>

</center>
</body>
</html>