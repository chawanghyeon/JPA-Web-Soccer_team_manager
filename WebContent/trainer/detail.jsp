<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>상세보기</title>
</head>
<body>
	<script>
		function medicalStaffs() {
        axios
          .get('http://localhost/soccer_team_manager/soccerteam', {
            params: {
              command: 'requestUpdateTrainer',
            },
          })
          .then(() => {
            axios
              .get('http://localhost/soccer_team_manager/medicalStaff/list.jsp')
              .then((resData) => {
                document.getElementById('content').innerHTML = resData.data;
              })
              .catch((error) => {
                console.log(error);
              });
          })
          .catch((error) => {
            console.log(error);
          });
      }
	</script>
	<section >
  		<nav>
    		<jsp:include page="../logout.jsp"></jsp:include>
  		</nav>
 	</section>
<br><br><br>
<center>

${requestScope.successMsg}

<h3>상세보기</h3>
<hr><p> 
<div id="content">
	<table border="1">
		<tr>
			<th>팀 이름</th><th>번호</th><th>이름</th><th>나이</th><th>분야</th>
		</tr>
		<tr>
			<td>${sessionScope.people.team}</td>
			<td>${sessionScope.people.number}</td>
			<td>${sessionScope.people.name}</td>
			<td>${sessionScope.people.age}</td>
			<td>${sessionScope.people.position}</td>
		</tr>
	</table>
</div>
<br><br><br>
<a href="soccerteam?command=requestUpdateTrainer">수정하기</a>

<a href="soccerteam?command=deleteTrainer">탈퇴하기</a>

&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/team/detail.jsp">메인페이지</a>

</center>
</body>
</html>







