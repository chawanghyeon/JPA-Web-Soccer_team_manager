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
      function step02() {
        axios
          .get('response.jsp', {
            params: {
              name: '유재석',
              age: 40,
            },
          })
          .then((resData) => {
            console.log(resData.data.name);
          })
          .catch((error) => {
            console.log(error);
          });
      }

      // 감독 상세보기 비동기 처리하는 함수 - 혜성

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
  </head>
  <body>
    <section>
      <nav>
        <jsp:include page="../logout.jsp"></jsp:include>
      </nav>
    </section>
    <br /><br /><br />
    <center>
      <h1>${sessionScope.team}</h1>

      &nbsp;&nbsp;&nbsp;<button onclick="players()">선수</button>

      &nbsp;&nbsp;&nbsp;<button onclick="managers()">감독</button>

      &nbsp;&nbsp;&nbsp;<button onclick="medicalStaffs()">의료진</button>

      &nbsp;&nbsp;&nbsp;<button onclick="trainers()">트레이너</button>
      <div id="content"></div>
      <br /><br /><br />
      <form
        action="${pageContext.request.contextPath}/soccerteam"
        method="post"
      >
        <input type="hidden" name="command" value="deleteTeam" />
        <input type="submit" value="팀 삭제하기" />
      </form>
      &nbsp;&nbsp;&nbsp;<a href="soccerteam?command=getLogin">팀 목록</a>
      &nbsp;&nbsp;&nbsp;<a
        href="${pageContext.request.contextPath}/login/detail.jsp"
        >메인페이지</a
      >
    </center>
  </body>
</html>
