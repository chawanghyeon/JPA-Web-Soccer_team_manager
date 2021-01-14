<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>등록화면</title>
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
          <h1 class="title">등록</h1>
          <div class="login">
            <form
              action="${pageContext.request.contextPath}/soccerteam"
              method="post"
            >
              <input type="hidden" name="command" value="addMedicalStaff" />
              <table class="type11" border="1">
                <tr>
                  <td>번호</td>
                  <td><input type="text" name="number" /></td>
                </tr>
                <tr>
                  <td>이름</td>
                  <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                  <td>나이</td>
                  <td><input type="text" name="age" /></td>
                </tr>
                <tr>
                  <td>분야</td>
                  <td><input type="text" name="position" /></td>
                </tr>
                <tr>
                  <td colspan="2">
                    <input type="submit" value="가입" />&nbsp;&nbsp;&nbsp;<input
                      type="reset"
                      value="취소"
                    />
                  </td>
                </tr>
              </table>
            </form>
          </div>
          <div class="purchase">
            <button
              onclick="location.href='http://localhost/soccer_team_manager/login/detail.jsp'"
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
