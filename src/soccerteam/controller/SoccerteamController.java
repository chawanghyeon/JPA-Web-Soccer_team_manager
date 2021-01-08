package soccerteam.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import soccerteam.model.dto.LoginDTO;
import soccerteam.model.dto.PeopleDTO;
import soccerteam.model.dto.TeamDTO;
import soccerteam.model.service.SoccerTeamService;

@Slf4j

@WebServlet("/soccerteam")
public class SoccerteamController extends HttpServlet {

	SoccerTeamService service = SoccerTeamService.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String command = request.getParameter("command");

		if (command == null) {
			log.trace("잘못된 접근");
			request.setAttribute("errorMsg", "잘못된 접근입니다.");
			request.getRequestDispatcher("showError.jsp").forward(request, response);
		} else {
			try {
				log.trace(command);
				if (command.equals("getLogin")) {// 특정 관리자 정보 검색
					getLogin(request, response);
				} else if ((String) session.getAttribute("userID") != null && (String) session.getAttribute("userPW") != null){
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
					} else if (command.equals("logout")) {// 로그아웃
						logout(request, response);
					}
				} else {
					log.trace("로그인 필요");
					request.setAttribute("errorMsg", "로그인 해주세요!");
					request.getRequestDispatcher("showError.jsp").forward(request, response);
				}
			} catch (Exception s) {
				log.trace("잘못된 접근");
				request.setAttribute("errorMsg", "잘못된 접근입니다.");
				request.getRequestDispatcher("showError.jsp").forward(request, response);
				s.printStackTrace();
			}
		}
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		log.trace("로그아웃");
		session.invalidate();
		session = null;
		request.getRequestDispatcher("index.html").forward(request, response);
	}
	
	// 모든 트레이너 검색
	public void getAllTrainers(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();
		
		try {
			String team = (String) session.getAttribute("team");
			session.setAttribute("peoples", service.getAllTrainers(team));
			log.trace("모든 트레이너 검색");
		} catch (Exception s) {
			log.trace(s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 트레이너 검색
	public void getTrainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			PeopleDTO p = service.getTrainer(Integer.parseInt(request.getParameter("number")));

			if (p != null) {
				session.setAttribute("people", p);
				log.trace("트레이너" + p.toString() + "검색");
				url = "trainer/detail.jsp";
			} else {
				log.trace("존재하지 않는 트레이너입니다.");
				request.setAttribute("errorMsg", "존재하지 않는 트레이너입니다.");
			}
		} catch (Exception s) {
			log.trace(s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 트레이너 가입 메소드
	protected void addTrainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		int number = Integer.parseInt(request.getParameter("number"));
		String team = (String) session.getAttribute("team");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String position = request.getParameter("position");

		if (number != 0) {
			PeopleDTO people = new PeopleDTO(number, team, name, age, position);

			try {
				if (service.addTrainer(people)) {
					session.setAttribute("people", people);
					request.setAttribute("successMsg", "가입 완료");
					log.trace("트레이너" + people.toString() + "wjwkd");
					url = "trainer/detail.jsp";
				} else {
					log.trace("트레이너" + people.toString() + "가입 실패");
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			} catch (Exception s) {
				log.trace(s.getMessage());
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 트레이너 수정 요구
	public void requestUpdateTrainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("트레이너 수정 요구");
		request.getRequestDispatcher("trainer/update.jsp").forward(request, response);
	}

	// 트레이너 수정
	public void updateTrainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			int number = ((PeopleDTO) session.getAttribute("people")).getNumber();
			String position = request.getParameter("position");

			if (service.updateTrainer(number, position)) {
				session.setAttribute("people", service.getTrainer(number));
				log.trace("트레이너 수정" + position);
				url = "trainer/detail.jsp";
			} else {
				log.trace("트레이너 수정 실패");
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			log.trace(s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 트레이너 삭제
	public void deleteTrainer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			int number = ((PeopleDTO) session.getAttribute("people")).getNumber();

			if (service.deleteTrainer(number)) {
				log.trace("트레이너 삭제");
				url = "team/detail.jsp";
			} else {
				log.trace("트레이너 삭제 실패");
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			log.trace(s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 특정 관리자 검색
	public void getLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			String userID = request.getParameter("userID");
			String userPW = request.getParameter("userPW");

			LoginDTO l = null;
			if (userID != null && userPW != null) {
				l = service.getLogin(userID, userPW);
			}

			if (l != null) {
				log.trace("메인페이지 이동");
				session.setAttribute("allTeams", service.getAllTeam(userID));
				session.setAttribute("userID", userID);
				session.setAttribute("userPW", userPW);
				url = "login/detail.jsp";
			} else if (session.getAttribute("userID") != null) {
				log.trace("메인페이지 이동");
				userID = (String) session.getAttribute("userID");
				session.setAttribute("allTeams", service.getAllTeam(userID));
				url = "login/detail.jsp";
			} else {
				log.trace("존재하지 않는 관리자입니다.");
				request.setAttribute("errorMsg", "존재하지 않는 관리자입니다.");
			}
		} catch (Exception s) {
			log.trace(s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 관리자 가입 메소드
	protected void addLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");

		try {
			if (userID != null) {
				LoginDTO login = new LoginDTO(userID, userPW);

				if (service.addLogin(login)) {
					session.setAttribute("userID", userID);
					session.setAttribute("userPW", userPW);
					request.setAttribute("successMsg", "가입 완료");
					log.trace("관리자" + login.toString() + "가입 완료");
					url = "login/detail.jsp";
				} else {
					log.trace("관리자" + login.toString() + "가입 실패");
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			}
		} catch (Exception s) {
			log.trace("회원가입 실패");
			request.setAttribute("errorMsg", "회원가입 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 관리자 비밀번호 수정 요구
	public void requestUpdateLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("관리자 비밀번호 수정 요구");
		request.getRequestDispatcher("login/update.jsp").forward(request, response);
	}

	// 관리자 수정
	public void updateLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			String userID = (String) session.getAttribute("userID");
			String newPW = request.getParameter("newPW");

			if (service.updateLogin(userID, newPW)) {
				session.setAttribute("userPW", newPW);
				url = "login/detail.jsp";
			} else {
				log.trace(newPW + "비밀번호 수정 실패");
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			log.trace(s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 관리자 삭제
	public void deleteLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			if (service.deleteLogin((String) session.getAttribute("userID"))) {
				session.invalidate();
				session = null;
				log.trace("관리자 삭제");
				url = "index.html";
			} else {
				log.trace("관리자 삭제 실패");
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			log.trace(s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 매니저 검색
	public void getAllManagers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			String team = (String) session.getAttribute("team");
			session.setAttribute("peoples", service.getAllManagers(team));
			log.trace("모든 감독 검색");
		} catch (Exception s) {
			log.trace("모든 감독 검색 실패");
			request.setAttribute("errorMsg", "모든 감독 검색 실패");
			s.printStackTrace();
			request.getRequestDispatcher("showError.jsp").forward(request, response);
		}
	}

	// 매니저 검색
	public void getManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			PeopleDTO m = service.getManager(Integer.parseInt(request.getParameter("number")));
			if (m != null) {
				session.setAttribute("people", m);
				log.trace("감독" + m.toString() + "검색");
				url = "manager/detail.jsp";
			} else {
				log.trace("존재하지 않는 감독입니다.");
				request.setAttribute("errorMsg", "존재하지 않는 감독입니다.");
			}
		} catch (Exception s) {
			log.trace(s.getMessage());
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 매니저 가입 메소드
	protected void addManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		int number = Integer.parseInt(request.getParameter("number"));
		String team = (String) session.getAttribute("team");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String position = request.getParameter("position");

		if (number != 0) {
			PeopleDTO people = new PeopleDTO(number, team, name, age, position);
			try {
				if (service.addManager(people)) {
					session.setAttribute("people", people);
					request.setAttribute("successMsg", "가입 완료");
					log.trace("감독" + people.toString() + "가입 완료");
					url = "manager/detail.jsp";
				} else {
					log.trace("감독" + people.toString() + "가입 실패");
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			} catch (Exception s) {
				log.trace("감독" + people.toString() + "가입 실패");
				request.setAttribute("errorMsg", "감독 등록 실패");
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 매니저 수정 요구
	public void requestUpdateManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("감독 수정 요구");
		request.getRequestDispatcher("manager/update.jsp").forward(request, response);
	}

	// 매니저 수정
	public void updateManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			int number = ((PeopleDTO) session.getAttribute("people")).getNumber();
			String position = request.getParameter("position");

			if (service.updateManager(number, position)) {
				session.setAttribute("people", service.getManager(number));
				log.trace("감독 수정");
				url = "manager/detail.jsp";
			} else {
				log.trace("감독 수정 실패");
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			log.trace("감독 수정 실패");
			request.setAttribute("errorMsg", "감독 수정 실패");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 매니저 삭제
	public void deleteManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			int number = ((PeopleDTO) session.getAttribute("people")).getNumber();

			if (service.deleteManager(number)) {
				String team = (String) session.getAttribute("team");
				request.setAttribute("peoples", service.getAllManagers(team));
				log.trace("감독 삭제");
				url = "team/detail.jsp";
			} else {
				log.trace("감독 삭제 실패");
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			log.trace("감독 삭제 실패");
			request.setAttribute("errorMsg", "삭제 실패");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 팀 검색
	public void getAllTeams(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			String userID = (String) session.getAttribute("userID");
			session.setAttribute("allTeams", service.getAllTeam(userID));
			log.trace("모든 팀 검색");
			url = "team/list.jsp";
		} catch (Exception s) {
			log.trace("모든 팀 검색 실패");
			request.setAttribute("errorMsg", "모든 팀 검색 실패");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 팀 검색
	public void getTeam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			TeamDTO t = null;
			String team = request.getParameter("team");

			if (team != null) {
				t = service.getTeam(team);
			} else {
				t = service.getTeam((String) session.getAttribute("team"));
			}
			if (t != null) {
				log.trace("팀 검색");
				session.setAttribute("team", t.getTeam());
				url = "team/detail.jsp";
			} else {
				log.trace("팀 검색 실패");
				request.setAttribute("errorMsg", "존재하지 않는 팀입니다.");
			}
		} catch (Exception s) {
			log.trace("팀 검색 실패");
			request.setAttribute("errorMsg", "팀 검색 실패");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 팀 가입 메소드
	protected void addTeam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		String team = request.getParameter("team");
		String userID = (String) session.getAttribute("userID");

		if (team != null) {
			TeamDTO t = new TeamDTO(team, userID);

			try {
				if (service.addTeam(t)) {
					session.setAttribute("team", t.getTeam());
					request.setAttribute("successMsg", "가입 완료");
					log.trace("팀 가입");
					url = "team/detail.jsp";
				} else {
					log.trace("팀 가입 실패");
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			} catch (Exception s) {
				log.trace("팀 가입 실패");
				request.setAttribute("errorMsg", "팀 가입 실패");
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 팀 수정 요구
	public void requestUpdateTeam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("팀 수정 요구");
		request.getRequestDispatcher("team/update.jsp").forward(request, response);
	}

	// 팀 수정
	public void updateTeam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			String team = (String) session.getAttribute("team");
			String newTeam = request.getParameter("newTeam");

			if (service.updateTeam(team, newTeam)) {
				session.setAttribute("team", service.getTeam(team));
				log.trace("팀 수정");
				url = "team/detail.jsp";
			} else {
				log.trace("팀 수정 실패");
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			log.trace("팀 수정 실패");
			request.setAttribute("errorMsg", "수정 실패");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 팀 삭제
	public void deleteTeam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			String team = (String) session.getAttribute("team");

			if (service.deleteTeam(team)) {
				String userID = (String) session.getAttribute("userID");
				session.setAttribute("allTeams", service.getAllTeam(userID));
				log.trace("팀 삭제");
				url = "login/detail.jsp";
			} else {
				log.trace("팀 삭제 실패");
				request.setAttribute("errorMsg", "팀 삭제 실패");
			}
		} catch (Exception s) {
			log.trace("팀 삭제 실패");
			request.setAttribute("errorMsg", "팀 삭제 실패");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 의료진 검색
	public void getAllMedicalStaffs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			String team = (String) session.getAttribute("team");
			session.setAttribute("peoples", service.getAllMedicalStaffs(team));
			log.trace("모든 의료진 검색");
		} catch (Exception s) {
			log.trace("모든 의료진 검색 실패");
			request.setAttribute("errorMsg", "모든 의료진 검색 실패");
			s.printStackTrace();
			request.getRequestDispatcher("showError.jsp").forward(request, response);
		}
	}

	// 의료진 검색
	public void getMedicalStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			int number = Integer.parseInt(request.getParameter("number"));
			PeopleDTO p = service.getMedicalStaff(number);

			if (p != null) {
				session.setAttribute("people", p);
				log.trace("의료진" + p.toString() + "검색");
				url = "medicalStaff/detail.jsp";
			} else {
				log.trace("의료진 검색 실패");
				request.setAttribute("errorMsg", "존재하지 않는 의료진입니다.");
			}
		} catch (Exception s) {
			log.trace("의료진 검색 실패");
			request.setAttribute("errorMsg", "의료진 검색 실패");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 의료진 가입 메소드
	protected void addMedicalStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		int number = Integer.parseInt(request.getParameter("number"));
		String team = (String) session.getAttribute("team");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String position = request.getParameter("position");

		if (number != 0) {
			PeopleDTO people = new PeopleDTO(number, team, name, age, position);

			try {
				if (service.addMedicalStaff(people)) {
					session.setAttribute("people", people);
					request.setAttribute("successMsg", "가입 완료");
					log.trace("의료진" + people.toString() + "가입");
					url = "medicalStaff/detail.jsp";
				} else {
					log.trace("의료진 가입 실패");
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			} catch (Exception s) {
				log.trace("의료진 가입 실패");
				request.setAttribute("errorMsg", "의료진 등록 실패");
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 의료진 수정 요구
	public void requestUpdateMedicalStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("의료진 수정 요구");
		request.getRequestDispatcher("medicalStaff/update.jsp").forward(request, response);
	}

	// 의료진 수정
	public void updateMedicalStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			int number = ((PeopleDTO) session.getAttribute("people")).getNumber();
			String position = request.getParameter("position");

			if (service.updateMedicalStaff(number, position)) {
				session.setAttribute("people", service.getMedicalStaff(number));
				log.trace("의료진 수정");
				url = "medicalStaff/detail.jsp";
			} else {
				log.trace("의료진 수정 실패");
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			log.trace("의료진 수정 실패");
			request.setAttribute("errorMsg", "의료진 수정 실패");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 의료진 삭제
	public void deleteMedicalStaff(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			int number = ((PeopleDTO) session.getAttribute("people")).getNumber();

			if (service.deleteMedicalStaff(number)) {
				log.trace("의료진 삭제");
				url = "team/detail.jsp";
			} else {
				log.trace("의료진 삭제 실패");
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			log.trace("의료진 삭제 실패");
			request.setAttribute("errorMsg", "의료진 삭제 실패");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 선수 검색
	public void getAllPlayers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			String team = (String) session.getAttribute("team");
			System.out.println(team);
			session.setAttribute("peoples", service.getAllPlayers(team));
			log.trace("모든 선수 검색");
		} catch (Exception s) {
			log.trace("모든 선수 검색 실패");
			request.setAttribute("errorMsg", "모든 선수 검색 실패");
			s.printStackTrace();
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 선수 검색
	public void getPlayer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			int number = Integer.parseInt(request.getParameter("number"));
			String team = (String) session.getAttribute("team");
			PeopleDTO p = service.getPlayer(number, team);

			if (p != null) {
				session.setAttribute("people", p);
				url = "player/detail.jsp";
				log.trace("선수 검색" + p.toString());
			} else {
				log.trace("선수 검색 실패");
				request.setAttribute("errorMsg", "존재하지 않는 선수입니다.");
			}
		} catch (Exception s) {
			log.trace("선수 검색 실패");
			request.setAttribute("errorMsg", "선수 검색 실패");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 선수 가입 메소드
	protected void addPlayer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		int number = Integer.parseInt(request.getParameter("number"));
		String team = (String) session.getAttribute("team");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String position = request.getParameter("position");

		if (number != 0) {
			PeopleDTO people = new PeopleDTO(number, team, name, age, position);

			try {
				if (service.addPlayer(people)) {
					request.setAttribute("peoples", service.getAllPlayers(team));
					request.setAttribute("successMsg", "가입 완료");
					log.trace("선수 가입");
					url = "player/list.jsp";
				} else {
					log.trace("선수 가입 실패");
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			} catch (Exception s) {
				log.trace("선수 가입 실패");
				request.setAttribute("errorMsg", "선수 등록 실패");
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	// 선수 수정 요구
	public void requestUpdatePlayer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("선수 수정 요구");
		request.getRequestDispatcher("player/update.jsp").forward(request, response);
	}

	// 선수 수정
	public void updatePlayer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			int number = ((PeopleDTO) session.getAttribute("people")).getNumber();
			String team = (String) session.getAttribute("team");
			String position = request.getParameter("position");

			if (service.updatePlayer(number, position, team)) {
				session.setAttribute("people", service.getPlayer(number, team));
				log.trace("선수 수정");
				url = "player/detail.jsp";
			} else {
				log.trace("선수 수정 실패");
				request.setAttribute("errorMsg", "수정 실패");
			}
		} catch (Exception s) {
			log.trace("선수 수정 실패");
			request.setAttribute("errorMsg", "선수 수정 실패");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 선수 삭제
	public void deletePlayer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		HttpSession session = request.getSession();

		try {
			String team = (String) session.getAttribute("team");
			int number = ((PeopleDTO) session.getAttribute("people")).getNumber();

			if (service.deletePlayer(number, team)) {
				request.setAttribute("peoples", service.getAllPlayers(team));
				log.trace("선수 삭제");
				url = "player/list.jsp";
			} else {
				log.trace("선수 삭제 실패");
				request.setAttribute("errorMsg", "삭제 실패");
			}
		} catch (Exception s) {
			log.trace("선수 삭제 실패");
			request.setAttribute("errorMsg", "선수 삭제 실패");
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
