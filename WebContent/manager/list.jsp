<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<table border="1">
	<thead>
		<tr>
			<th>팀 이름</th><th>번호</th><th>이름</th><th>나이</th><th>분야</th>
		</tr>
	</thead>
		<c:forEach items="${sessionScope.peoples}" var="data">
		 <tr>
		 	<td>${data.team}</td>
		 	<td><a href="${pageContext.request.contextPath}/soccerteam?command=getManager&number=${data.number}">${data.number}</a></td>
		 	<td>${data.name}</td>
		 	<td>${data.age}</td>
		 	<td>${data.position}</td>
		 </tr>
	 	</c:forEach>
</table>
<form action="${pageContext.request.contextPath}/manager/insert.jsp">
	<input type="submit" value="추가">
</form>