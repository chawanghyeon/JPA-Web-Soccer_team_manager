package soccerteam.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccerteam.model.dto.LoginDTO;
import soccerteam.model.dto.PeopleDTO;
import soccerteam.model.dto.TeamDTO;
import soccerteam.model.service.SoccerTeamService;

@WebServlet("/soccerteam")
public class SoccerteamController extends HttpServlet {

	SoccerTeamService service = SoccerTeamService.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// command pattern
		String command = request.getParameter("command");

		if (command == null) {
			request.setAttribute("errorMsg", "잘못된 접근입니다.");
			request.getRequestDispatcher("showError.jsp").forward(request, response);
		} else {
			try {
				if (command.equals("getAllTrainers")) {// 모든 트레이너 검색
					getAllTrainers(request, response);
				} else if (command.equals("getTrainer")) {// 특정 트레이너 정보 검색
					getTrainer(request, response);
				} else if (command.equals("addTrainer")) {// 트레이너 추가 등록
					addTrainer(request, response);
				} else if (command.equals("requestUpdateTrainer")) {// 트레이너 정보 수정요청
					requestUpdateTrainer(request, response);
				} else if (command.equals("updateTrainer")) {// 트레이너 정보 수정
					updateTrainer(request, response);
				} else if (command.equals("deleteTrainer")) {// 트레이너 삭제
					deleteTrainer(request, response);
				} else if (command.equals("getAllLogins")) {// 모든 관리자 검색
					getAllLogins(request, response);
				} else if (command.equals("getLogin")) {// 특정 관리자 정보 검색
					getLogin(request, response);
				} else if (command.equals("addLogin")) {// 관리자 추가 등록
					addLogin(request, response);
				} else if (command.equals("requestUpdateLogin")) {// 관리자 정보 수정요청
					requestUpdateLogin(request, response);
				} else if (command.equals("updateLogin")) {// 관리자 정보 수정
					updateLogin(request, response);
				} else if (command.equals("deleteLogin")) {// 관리자 삭제
					deleteLogin(request, response);
				} else if (command.equals("getAllTeams")) {// 모든 팀 검색
					getAllTeams(request, response);
				} else if (command.equals("getTeam")) {// 특정 팀 정보 검색
					getTeam(request, response);
				} else if (command.equals("addTeam")) {// 팀 추가 등록
					addTeam(request, response);
				} else if (command.equals("requestUpdateTeam")) {// 팀 정보 수정요청
					requestUpdateTeam(request, response);
				} else if (command.equals("updateTeam")) {// 팀 정보 수정
					updateTeam(request, response);
				} else if (command.equals("deleteTeam")) {// 팀 삭제
					deleteTeam(request, response);
				} else if (command.equals("getAllManagers")) {// 모든 매니저 검색
					getAllManagers(request, response);
				} else if (command.equals("getManager")) {// 특정 매니저 정보 검색
					getManager(request, response);
				} else if (command.equals("addManager")) {// 매니저 추가 등록
					addManager(request, response);
				} else if (command.equals("requestUpdateManager")) {// 매니저 정보 수정요청
					requestUpdateManager(request, response);
				} else if (command.equals("updateManager")) {// 매니저 정보 수정
					updateManager(request, response);
				} else if (command.equals("deleteManager")) {// 매니저 삭제
					deleteManager(request, response);
				} else if (command.equals("getAllMedicalStaffs")) {// 모든 의료진 검색
					getAllMedicalStaffs(request, response);
				} else if (command.equals("getMedicalStaff")) {// 특정 의료진 정보 검색
					getMedicalStaff(request, response);
				} else if (command.equals("addMedicalStaff")) {// 의료진 추가 등록
					addMedicalStaff(request, response);
				} else if (command.equals("requestUpdateMedicalStaff")) {// 의료진 정보 수정요청
					requestUpdateMedicalStaff(request, response);
				} else if (command.equals("updateMedicalStaff")) {// 의료진 정보 수정
					updateMedicalStaff(request, response);
				} else if (command.equals("deleteMedicalStaff")) {// 의료진삭제
					deleteMedicalStaff(request, response);
				} else if (command.equals("getAllPlayers")) {// 모든 선수 검색
					getAllPlayers(request, response);
				} else if (command.equals("getPlayer")) {// 특정 선수 정보 검색
					getPlayer(request, response);
				} else if (command.equals("addPlayer")) {// 선수 추가 등록
					addPlayer(request, response);
				} else if (command.equals("requestUpdatePlayer")) {// 선수 정보 수정요청
					requestUpdatePlayer(request, response);
				} else if (command.equals("updatePlayer")) {// 선수 정보 수정
					updatePlayer(request, response);
				} else if (command.equals("deletePlayer")) {// 선수 삭제
					deletePlayer(request, response);
				}
			} catch (Exception s) {
				request.setAttribute("errorMsg", s.getMessage());
				request.getRequestDispatcher("showError.jsp").forward(request, response);
				s.printStackTrace();
			}
		}
	}

	// 모든 트레이너 검색
	public void getAllTrainers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String team = request.getParameter("team");
			request.setAttribute("allTrainers", service.getAllTrainers(team));
			url = "trainer/trainerList.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 트레이너 검색
	public void getTrainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			PeopleDTO p = service.getTrainer(Integer.parseInt(request.getParameter("number")));
			if (p != null) {
				request.setAttribute("trainer", p);
				url = "trainer/trainerDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "존재하지 않는 트레이너입니다.");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 트레이너 가입 메소드
	protected void addTrainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		int number = Integer.parseInt(request.getParameter("number"));
		String team = request.getParameter("team");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String position = request.getParameter("position");

		if (number != 0) {

			PeopleDTO trainer = new PeopleDTO(number, team, name, age, position);
			try {
				boolean result = service.addTrainer(trainer);
				if (result) {
					request.setAttribute("trainer", trainer);
					request.setAttribute("successMsg", "가입 완료");
					url = "trainer/trainerDetail.jsp";
				} else {
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			} catch (Exception s) {
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 트레이너 수정 요구
	public void requestUpdateTrainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("trainer", service.getTrainer(Integer.parseInt(request.getParameter("number"))));
			url = "trainer/trainerUpdate.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 트레이너 수정
	public void updateTrainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			int number = Integer.parseInt(request.getParameter("number"));

			if (service.updateTrainer(number, request.getParameter("position"))) {
				request.setAttribute("trainer", service.getTrainer(number));
				url = "trainer/trainerDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 트레이너 삭제
	public void deleteTrainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			if (service.deleteTrainer(Integer.parseInt(request.getParameter("number")))) {
				String team = request.getParameter("team");
				request.setAttribute("allTrainers", service.getAllTrainers(team));
				url = "trainer/trainerList.jsp";
			} else {
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 관리자 전체 검색
	public void getAllLogins(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("allLogins", service.getAllLogins());
			url = "login/loginList.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 특정 관리자 검색
	public void getLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String userID = request.getParameter("userID");
			String userPW = request.getParameter("userPW");
			
			LoginDTO l = service.getLogin(userID, userPW);
			
			if (l != null) {
				request.setAttribute("allTeams", service.getAllTeam(userID));
				request.setAttribute("login", l);
				url = "login/loginDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "존재하지 않는 관리자입니다.");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 관리자 가입 메소드
	protected void addLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");

		// 질문 아이디랑 비밀번호가 둘다
			
			try {
				if (userID != null) {
					LoginDTO login = new LoginDTO(userID, userPW);
					boolean result = service.addLogin(login);
					
					if (result) {
						request.setAttribute("login", login);
						request.setAttribute("successMsg", "가입 완료");
						url = "login/loginDetail.jsp";
					} else {
						request.setAttribute("errorMsg", "다시 시도하세요");
					}
				}
			} catch (Exception s) {
				request.setAttribute("errorMsg", s.getMessage());
			}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 관리자 비밀번호 수정 요구
	public void requestUpdateLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String userID = request.getParameter("userID");
			String userPW = request.getParameter("userPW");
			System.out.println(userID);
			request.setAttribute("login", service.getLogin(userID, userPW));
			url = "login/loginUpdate.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 관리자 수정
	public void updateLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			String userID = request.getParameter("userID");
			String newPW = request.getParameter("userPW");

			if (service.updateLogin(userID, newPW)) {
				request.setAttribute("login", service.getLogin(userID, newPW));
				url = "login/loginDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 관리자 삭제
	public void deleteLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			if (service.deleteLogin(request.getParameter("userID"))) {
				url = "index.html";
			} else {
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 매니저 검색
	public void getAllManagers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String team = request.getParameter("team");
			request.setAttribute("allManagers", service.getAllManagers(team));
			url = "manager/managerList.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 매니저 검색
	public void getManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			PeopleDTO m = service.getManager(Integer.parseInt(request.getParameter("number")));
			if (m != null) {
				request.setAttribute("manager", m);
				url = "manager/managerDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "존재하지 않는 감독입니다.");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 매니저 가입 메소드
	protected void addManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		int number = Integer.parseInt(request.getParameter("number"));
		String team = request.getParameter("team");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String position = request.getParameter("position");

		if (number != 0) {

			PeopleDTO manager = new PeopleDTO(number, team, name, age, position);
			try {
				boolean result = service.addManager(manager);
				if (result) {
					request.setAttribute("manager", manager);
					request.setAttribute("successMsg", "가입 완료");
					url = "manager/managerDetail.jsp";
				} else {
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			} catch (Exception s) {
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 매니저 수정 요구
	public void requestUpdateManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("manager", service.getManager(Integer.parseInt(request.getParameter("number"))));
			url = "manager/managerUpdate.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 매니저 수정
	public void updateManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			int number = Integer.parseInt(request.getParameter("number"));

			if (service.updateManager(number, request.getParameter("position"))) {
				request.setAttribute("manager", service.getManager(number));
				url = "manager/managerDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 매니저 삭제
	public void deleteManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			if (service.deleteManager(Integer.parseInt(request.getParameter("number")))) {
				String team = request.getParameter("team");
				request.setAttribute("allManagers", service.getAllManagers(team));
				url = "manager/managerList.jsp";
			} else {
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 팀 검색
	public void getAllTeams(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String userID = request.getParameter("userID");
			request.setAttribute("allTeams", service.getAllTeam(userID));
			url = "team/teamList.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 팀 검색
	public void getTeam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			TeamDTO t = service.getTeam(request.getParameter("team"));
			if (t != null) {
				request.setAttribute("team", t);
				request.setAttribute("userID", request.getParameter("userID"));
				url = "team/teamDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "존재하지 않는 팀입니다.");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 팀 가입 메소드
	protected void addTeam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		String team = request.getParameter("team");
		String userID = request.getParameter("userID");

		if (team != null) {

			TeamDTO t = new TeamDTO(team, userID);
			try {
				boolean result = service.addTeam(t);
				if (result) {
					request.setAttribute("team", t);
					request.setAttribute("successMsg", "가입 완료");
					url = "team/teamDetail.jsp";
				} else {
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			} catch (Exception s) {
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 팀 수정 요구
	public void requestUpdateTeam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("team", service.getTeam((request.getParameter("team"))));
			url = "team/teamUpdate.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 팀 수정
	public void updateTeam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			String team = (request.getParameter("team"));

			if (service.updateTeam(team, request.getParameter("team"))) {
				request.setAttribute("team", service.getTeam(team));
				url = "team/teamDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 팀 삭제
	public void deleteTeam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			if (service.deleteTeam((request.getParameter("team")))) {
				String userID = service.getLogin(userID, userPW);
				request.setAttribute("login", userID);
				request.setAttribute("allTeams", service.getAllTeam(userID));
				url = "login/loginDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 의료진 검색
	public void getAllMedicalStaffs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String team = request.getParameter("team");
			request.setAttribute("allMedicalStaffs", service.getAllMedicalStaffs(team));
			url = "medicalStaff/medicalStaffList.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 의료진 검색
	public void getMedicalStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			PeopleDTO p = service.getMedicalStaff(Integer.parseInt(request.getParameter("number")));
			if (p != null) {
				request.setAttribute("medicalStaff", p);
				url = "medicalStaff/medicalStaffDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "존재하지 않는 의료진입니다.");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 의료진 가입 메소드
	protected void addMedicalStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		int number = Integer.parseInt(request.getParameter("number"));
		String team = request.getParameter("team");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String position = request.getParameter("position");

		if (number != 0) {

			PeopleDTO medicalStaff = new PeopleDTO(number, team, name, age, position);
			try {
				boolean result = service.addMedicalStaff(medicalStaff);
				if (result) {
					request.setAttribute("medicalStaff", medicalStaff);
					request.setAttribute("successMsg", "가입 완료");
					url = "medicalStaff/medicalStaffDetail.jsp";
				} else {
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			} catch (Exception s) {
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 의료진 수정 요구
	public void requestUpdateMedicalStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("medicalStaff",
					service.getMedicalStaff(Integer.parseInt(request.getParameter("number"))));
			url = "medicalStaff/medicalStaffUpdate.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 의료진 수정
	public void updateMedicalStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			int number = Integer.parseInt(request.getParameter("number"));

			if (service.updateMedicalStaff(number, request.getParameter("position"))) {
				request.setAttribute("medicalStaff", service.getMedicalStaff(number));
				url = "medicalStaff/medicalStaffDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 의료진 삭제
	public void deleteMedicalStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			if (service.deleteMedicalStaff(Integer.parseInt(request.getParameter("number")))) {
				String team = request.getParameter("team");
				request.setAttribute("allMedicalStaffs", service.getAllMedicalStaffs(team));
				url = "medicalStaff/medicalStaffList.jsp";
			} else {
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 선수 검색
	public void getAllPlayers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String team = request.getParameter("team");
			request.setAttribute("allPlayers", service.getAllPlayers(team));
			url = "player/playerList.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 선수 검색
	public void getPlayer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			int number = Integer.parseInt(request.getParameter("number"));
			String team = request.getParameter("team");
			PeopleDTO p = service.getPlayer(number, team);
			if (p != null) {
				request.setAttribute("player", p);
				url = "player/playerDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "존재하지 않는 선수입니다.");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 선수 가입 메소드
	protected void addPlayer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		int number = Integer.parseInt(request.getParameter("number"));
		String team = request.getParameter("team");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String position = request.getParameter("position");

		if (number != 0) {

			PeopleDTO player = new PeopleDTO(number, team, name, age, position);
			try {
				if (service.addPlayer(player)) {
					ArrayList<PeopleDTO> plist = service.getAllPlayers(team);
					request.setAttribute("allPlayers", plist);
					request.setAttribute("successMsg", "가입 완료");
					url = "player/playerList.jsp";
				} else {
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			} catch (Exception s) {
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 선수 수정 요구
	public void requestUpdatePlayer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			int number = Integer.parseInt(request.getParameter("number"));
			String team = request.getParameter("team");
			request.setAttribute("player", service.getPlayer(number, team));
			url = "player/playerUpdate.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 선수 수정
	public void updatePlayer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		try {
			int number = Integer.parseInt(request.getParameter("number"));
			String team = request.getParameter("team");
			String position = request.getParameter("position");
			if (service.updatePlayer(number, position, team)) {
				request.setAttribute("player", service.getPlayer(number, team));
				url = "player/playerDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 선수 삭제
	public void deletePlayer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String team = request.getParameter("team");
			int number = Integer.parseInt(request.getParameter("number"));
			if (service.deletePlayer(number, team)) {
				request.setAttribute("allPlayers", service.getAllPlayers(team));
				url = "player/playerList.jsp";
			} else {
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
