<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>모든 트레이너 list 화면</title>
</head>
<body>
<br><br><br>
<center>
<h3>트레이너 list</h3>
<hr><p>

<table border="1">
	<thead>
		<tr>
			<th>팀 이름</th><th>트레이너 번호</th><th>트레이너 이름</th><th>트레이너 나이</th><th>트레이너 분야</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.allTrainers}" var="data">
		 <tr>
		 	<td>${data.team}</td>
		 	<td><a href="${url}soccerteam?command=getTrainer&number=${data.number}">${data.number}</a></td>
		 	<td>${data.name}</td>
		 	<td>${data.age}</td>
		 	<td>${data.position}</td>
		 </tr>
	 </c:forEach>





</table>
<form action="${pageContext.request.contextPath}/trainer/trainerInsert.jsp">
	<input type="hidden" name="team" value="${requestScope.allTrainers[0].team}">
	<input type="submit" value="추가">
</form>
<br><br><br>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/soccerteam?command=getTeam&team=${requestScope.allTrainers[0].team}">팀 페이지로 이동</a>
<br>
<font color="blue">트레이너 번호를 클릭하면 상세 정보 확인이 가능합니다</font>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">로그아웃</a>

</center>
</body>
</html>