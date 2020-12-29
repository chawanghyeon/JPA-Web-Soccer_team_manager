package soccerteam.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccerteam.model.dto.LoginDTO;
import soccerteam.model.dto.ManagerDTO;
import soccerteam.model.dto.MedicalStaffDTO;
import soccerteam.model.dto.PlayerDTO;
import soccerteam.model.dto.TeamDTO;
import soccerteam.model.dto.TrainerDTO;
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
				} else if (command.equals("getAllmedicalStaffs")) {// 모든 의료진 검색
					getAllMedicalStaffs(request, response);
				} else if (command.equals("getmedicalStaff")) {// 특정 의료진 정보 검색
					getMedicalStaff(request, response);
				} else if (command.equals("addmedicalStaff")) {// 의료진 추가 등록
					addMedicalStaff(request, response);
				} else if (command.equals("requestUpdatemedicalStaff")) {// 의료진 정보 수정요청
					requestUpdateMedicalStaff(request, response);
				} else if (command.equals("updatemedicalStaff")) {// 의료진 정보 수정
					updateMedicalStaff(request, response);
				} else if (command.equals("deletemedicalStaff")) {// 의료진삭제
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
			request.setAttribute("allTrainers", service.getAllTrainers());
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
			TrainerDTO tr = service.getTrainer(Integer.parseInt(request.getParameter("trNumber")));
			if (tr != null) {
				request.setAttribute("trainer", tr);
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

		int trNumber = Integer.parseInt(request.getParameter("trNumber"));
		String tName = request.getParameter("tName");
		String trName = request.getParameter("trName");
		int trAge = Integer.parseInt(request.getParameter("trAge"));
		String trPosition = request.getParameter("trPosition");

		if (trNumber != 0) {

			TrainerDTO trainer = new TrainerDTO(trNumber, tName, trName, trAge, trPosition);
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
			request.setAttribute("trainer", service.getTrainer(Integer.parseInt(request.getParameter("trNumber"))));
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
			int trNumber = Integer.parseInt(request.getParameter("trNumber"));

			if (service.updateTrainer(trNumber, request.getParameter("trPosition"))) {
				request.setAttribute("trainer", service.getTrainer(trNumber));
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
			if (service.deleteTrainer(Integer.parseInt(request.getParameter("trNumber")))) {
				request.setAttribute("allTrainers", service.getAllTrainers());
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
				request.setAttribute("allLogins", service.getAllLogins());
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

	// 모든 매니저 검색
	public void getAllManagers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("allManagers", service.getAllManagers());
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
			ManagerDTO m = service.getManager(Integer.parseInt(request.getParameter("mNumber")));
			if (m != null) {
				request.setAttribute("manager", m);
				url = "manager/managerList.jsp";
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

		int mNumber = Integer.parseInt(request.getParameter("mNumber"));
		String tName = request.getParameter("tName");
		String mName = request.getParameter("mName");
		int mAge = Integer.parseInt(request.getParameter("mAge"));
		String mPosition = request.getParameter("mPosition");

		if (mNumber != 0) {

			ManagerDTO manager = new ManagerDTO(mNumber, tName, mName, mAge, mPosition);
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
			request.setAttribute("manager", service.getManager(Integer.parseInt(request.getParameter("mNumber"))));
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
			int mNumber = Integer.parseInt(request.getParameter("mNumber"));

			if (service.updateManager(mNumber, request.getParameter("mPosition"))) {
				request.setAttribute("manager", service.getManager(mNumber));
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
			if (service.deleteManager(Integer.parseInt(request.getParameter("mNumber")))) {
				request.setAttribute("allManagers", service.getAllManagers());
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
			TeamDTO t = service.getTeam(request.getParameter("tName"));
			if (t != null) {
				request.setAttribute("team", t);
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

		String tName = request.getParameter("tName");
		String userID = request.getParameter("userID");

		if (tName != null) {

			TeamDTO team = new TeamDTO(tName, userID);
			try {
				boolean result = service.addTeam(team);
				if (result) {
					request.setAttribute("team", team);
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
			request.setAttribute("team", service.getTeam((request.getParameter("tName"))));
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
			String tName = (request.getParameter("tName"));

			if (service.updateTeam(tName, request.getParameter("tName"))) {
				request.setAttribute("team", service.getTeam(tName));
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
			if (service.deleteTeam((request.getParameter("tName")))) {
				String userID = request.getParameter("userID");
				request.setAttribute("allTeams", service.getAllTeam(userID));
				url = "team/teamList.jsp";
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
			request.setAttribute("allmedicalStaffs", service.getAllMedicalStaffs());
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
			MedicalStaffDTO d = service.getMedicalStaff(Integer.parseInt(request.getParameter("dNumber")));
			if (d != null) {
				request.setAttribute("medicalStaff", d);
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

		int dNumber = Integer.parseInt(request.getParameter("dNumber"));
		String tName = request.getParameter("tName");
		String dName = request.getParameter("dName");
		int dAge = Integer.parseInt(request.getParameter("dAge"));
		String dPosition = request.getParameter("dPosition");

		if (dNumber != 0) {

			MedicalStaffDTO medicalStaff = new MedicalStaffDTO(dNumber, tName, dName, dAge, dPosition);
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
					service.getMedicalStaff(Integer.parseInt(request.getParameter("dNumber"))));
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
			int dNumber = Integer.parseInt(request.getParameter("dNumber"));

			if (service.updateMedicalStaff(dNumber, request.getParameter("dPosition"))) {
				request.setAttribute("medicalStaff", service.getMedicalStaff(dNumber));
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
			if (service.deleteMedicalStaff(Integer.parseInt(request.getParameter("dNumber")))) {
				request.setAttribute("allmedicalStaff", service.getAllMedicalStaffs());
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
			request.setAttribute("allPlayers", service.getAllPlayers());
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
			PlayerDTO p = service.getPlayer(Integer.parseInt(request.getParameter("pNumber")));
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

		int pNumber = Integer.parseInt(request.getParameter("pNumber"));
		String tName = request.getParameter("tName");
		String pName = request.getParameter("pName");
		int pAge = Integer.parseInt(request.getParameter("pAge"));
		String pPosition = request.getParameter("pPosition");

		if (pNumber != 0) {

			PlayerDTO player = new PlayerDTO(pNumber, tName, pName, pAge, pPosition);
			try {
				boolean result = service.addPlayer(player);
				if (result) {
					request.setAttribute("player", player);
					request.setAttribute("successMsg", "가입 완료");
					url = "player/playerDetail.jsp";
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
			request.setAttribute("player", service.getPlayer(Integer.parseInt(request.getParameter("pNumber"))));
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
			int pNumber = Integer.parseInt(request.getParameter("pNumber"));

			if (service.updatePlayer(pNumber, request.getParameter("pPosition"))) {
				request.setAttribute("player", service.getPlayer(pNumber));
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
			if (service.deletePlayer(Integer.parseInt(request.getParameter("pNumber")))) {
				request.setAttribute("allPlayers", service.getAllPlayers());
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
