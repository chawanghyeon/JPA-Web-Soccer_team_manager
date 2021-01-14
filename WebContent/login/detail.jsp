<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ page
import="java.util.ArrayList"%> <%@ page import="soccerteam.model.dto.TeamDTO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>메인페이지</title>
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
          <h1 class="title">${sessionScope.userID}</h1>
          <div class="login">
            <c:forEach items="${sessionScope.allTeams}" var="data">
              <button
                onclick="location.href='http://localhost/soccer_team_manager/soccerteam?command=getTeam&team=${data.team}'"
              >
                ${data.team}
              </button>
            </c:forEach>
          </div>
          <div class="purchase">
            <button
              onclick="location.href='http://localhost/soccer_team_manager/team/insert.jsp'"
            >
              팀 생성
            </button>
            <button
              onclick="location.href='http://localhost/soccer_team_manager/soccerteam?command=requestUpdateLogin'"
            >
              비밀번호 수정
            </button>
            <button
              onclick="location.href='http://localhost/soccer_team_manager/soccerteam?command=deleteLogin'"
            >
              탈퇴
            </button>
            <jsp:include page="../logout.jsp"></jsp:include>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
