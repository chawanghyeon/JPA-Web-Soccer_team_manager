package soccerteam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccerteam.model.dto.TrainerDTO;
import soccerteam.model.service.SoccerTeamService;

@WebServlet("/Soccerteam")
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
			TrainerDTO t = service.getTrainer(Integer.parseInt(request.getParameter("trNumber")));
			if (t != null) {
				request.setAttribute("trainer", t);
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
}
