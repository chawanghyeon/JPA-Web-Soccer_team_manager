<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<form action="soccerteam?command=updateManager" method="post">
	<input type="hidden" name="number"
		value="${sessionScope.people.number}">
	<table border="1">
		<thead>
			<tr>
				<th>팀 이름</th>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>분야</th>
			</tr>
			<tr>
				<td>${sessionScope.people.team}</td>
				<td>${sessionScope.people.number}</td>
				<td>${sessionScope.people.name}</td>
				<td>${sessionScope.people.age}</td>
				<td><input type="text" name="position"
					value="${sessionScope.people.position}"></td>
			</tr>

			<tr>
				<td colspan="5"><input type="submit" value="수정">
					&nbsp;&nbsp;&nbsp; <button onclick="reset()">취소</button>
			</tr>
	</table>
</form>
