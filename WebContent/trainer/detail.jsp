<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>상세보기</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="./style.css" />
  </head>
  <body>
    <script>
      function trainerUpdate() {
        axios
          .get('http://localhost/soccer_team_manager/trainer/update.jsp')
          .then((resData) => {
            document.getElementById('content').innerHTML = resData.data;
          })
          .catch((error) => {
            console.log(error);
          });
      }
      function reset() {
        document.getElementById('content').innerHTML = `
        <table border="1">
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
            <td>${sessionScope.people.position}</td>
          </tr>
        </table>`;
      }
    </script>
    <div class="container">
      <div class="card">
        <div class="soccer">
          <div class="circle"></div>
          <img src="./soccer.gif" alt="soccer" />
        </div>
        <div class="info">
          <h1 class="title">상세보기</h1>
          <div class="login">
            <div id="content">
              <table class="type11" border="1">
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
                  <td>${sessionScope.people.position}</td>
                </tr>
              </table>
            </div>
          </div>
          <div class="purchase">
            <button onclick="trainerUpdate()">수정하기</button>
            <button
              onclick="location.href='http://localhost/soccer_team_manager/soccerteam?command=deleteTrainer'"
            >
              트레이너 삭제
            </button>
            <button
              onclick="location.href='http://localhost/soccer_team_manager/team/detail.jsp'"
            >
              메인페이지
            </button>
            <jsp:include page="../logout.jsp"></jsp:include>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
