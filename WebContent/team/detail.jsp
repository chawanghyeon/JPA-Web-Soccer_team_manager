<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" isELIgnored="false"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
import="java.util.ArrayList"%> <%@ page import="soccerteam.model.dto.TeamDTO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>팀 상세보기 화면</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
      // 선수 상세보기 비동기 처리하는 함수 - 윤혜
      function players() {
        axios
          .get('http://localhost/soccer_team_manager/soccerteam', {
            params: {
              command: 'getAllPlayers',
            },
          })
          .then(() => {
            axios
              .get('http://localhost/soccer_team_manager/player/list.jsp')
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

      // 감독 상세보기 비동기 처리하는 함수 - 혜성
      function managers() {
        axios
          .get('http://localhost/soccer_team_manager/soccerteam', {
            params: {
              command: 'getAllManagers',
            },
          })
          .then(() => {
            axios
              .get('http://localhost/soccer_team_manager/manager/list.jsp')
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

      // 의료진 상세보기 비동기 처리하는 함수 - 왕현
      function medicalStaffs() {
        axios
          .get('http://localhost/soccer_team_manager/soccerteam', {
            params: {
              command: 'getAllMedicalStaffs',
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

      // 트레이너 상세보기 비동기 처리하는 함수 - 왕현
      function trainers() {
        axios
          .get('http://localhost/soccer_team_manager/soccerteam', {
            params: {
              command: 'getAllTrainers',
            },
          })
          .then(() => {
            axios
              .get('http://localhost/soccer_team_manager/trainer/list.jsp')
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
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="http://localhost/soccer_team_manager/style.css"
    />
  </head>
  <body>
    <div class="container">
      <div class="card">
        <div class="soccer">
          <div class="circle"></div>
          <img
            src="http://localhost/soccer_team_manager/soccer.gif"
            alt="soccer"
          />
        </div>
        <div class="info">
          <h1 class="title">${sessionScope.team}</h1>
          <div class="login">
            <button onclick="players()">선수</button>
            <button onclick="managers()">감독</button>
            <button onclick="medicalStaffs()">의료진</button>
            <button onclick="trainers()">트레이너</button>
          </div>
          <div id="content"></div>
          <div class="purchase">
            <button
              onclick="location.href='http://localhost/soccer_team_manager/soccerteam?command=deleteTeam'"
            >
              팀 삭제
            </button>
            <button
              onclick="location.href='http://localhost/soccer_team_manager/soccerteam?command=getLogin'"
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
