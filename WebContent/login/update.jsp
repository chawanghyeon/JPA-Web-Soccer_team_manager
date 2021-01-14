<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>비밀번호 수정페이지</title>
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
				<h1 class="title">회원 가입</h1>
				<div class="login">
					<form action="soccerteam?command=updateLogin" method="post">
						<table class="type11" border="1">
							<thead>
								<tr>
									<th>사용자 ID</th>
									<th>사용자 PW</th>
								</tr>
								<tr>
									<td>${sessionScope.userID}</td>
									<td><input type="password" name="newPW"></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" value="수정">
										&nbsp;&nbsp;&nbsp; <input type="reset" value="취소"></td>
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