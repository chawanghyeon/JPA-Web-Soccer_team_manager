package soccerteam.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import soccerteam.exception.MessageException;
import soccerteam.exception.NotExistException;
import soccerteam.model.dao.LoginDAO;
import soccerteam.model.dao.ManagerDAO;
import soccerteam.model.dao.MedicalStaffDAO;
import soccerteam.model.dao.PlayerDAO;
import soccerteam.model.dao.TeamDAO;
import soccerteam.model.dao.TrainerDAO;
import soccerteam.model.dto.LoginDTO;
import soccerteam.model.dto.PeopleDTO;
import soccerteam.model.dto.TeamDTO;

public class SoccerTeamService {

	private static SoccerTeamService instance = new SoccerTeamService();

	private SoccerTeamService() {
	}

	public static SoccerTeamService getInstance() {
		return instance;
	}

	private LoginDAO loginDAO = LoginDAO.getInstance();
	private MedicalStaffDAO medicalStaffDAO = MedicalStaffDAO.getInstance();
	private PlayerDAO playerDAO = PlayerDAO.getInstance();
	private TrainerDAO trainerDAO = TrainerDAO.getInstance();
	private TeamDAO teamDAO = TeamDAO.getInstance();
	private ManagerDAO managerDAO = ManagerDAO.getInstance();

	// Logins - CRUD
	public void notExistLogin(String userID) throws NotExistException, SQLException {
		LoginDTO login = loginDAO.getLogin(userID);
		if (login == null) {
			throw new NotExistException("검색하신 로그인 정보가 없습니다.");
		}
	}

	public ArrayList<LoginDTO> getAllLogins() throws SQLException {
		return loginDAO.getAllLogins();
	}

	public LoginDTO getLogin(String userID, String userPW) throws SQLException, NotExistException, MessageException {
		LoginDTO login = null;
		try {
			login = loginDAO.getLogin(userID);
			
			if(login.getUserPW().equals(userPW)) {
				return login;
			}
		} catch(Exception e) {
			throw new MessageException("로그인 실패");
		}
		return null;
	}

	public boolean addLogin(LoginDTO login) throws Exception {
		return loginDAO.addLogin(login);
	}

	public boolean updateLogin(String userID, String newPw) throws SQLException, NotExistException {
		return loginDAO.updateLogin(userID, newPw);
	}

	public boolean deleteLogin(String userID) throws Exception {
		notExistLogin(userID);
		return loginDAO.deleteLogin(userID);
	}

	// Trainers - CRUD
	public void notExistTrainer(int number) throws NotExistException, SQLException {
		PeopleDTO trainer = trainerDAO.getTrainer(number);
		if (trainer == null) {
			throw new NotExistException("검색하신 트레이너 정보가 없습니다.");
		}
	}

	public ArrayList<PeopleDTO> getAllTrainers(String team) throws SQLException {
		return trainerDAO.getAllTrainers(team);
	}

	public PeopleDTO getTrainer(int number) throws SQLException, NotExistException {
		PeopleDTO trainer = trainerDAO.getTrainer(number);
		if (trainer == null) {
			throw new NotExistException("검색하신 트레이너 정보가 없습니다.");
		}
		return trainer;
	}

	public boolean addTrainer(PeopleDTO trainer) throws Exception {
		return trainerDAO.addTrainer(trainer);
	}

	public boolean updateTrainer(int number, String position) throws SQLException, NotExistException {
		notExistTrainer(number);
		return trainerDAO.updateTrainer(number, position);
	}

	public boolean deleteTrainer(int number) throws SQLException, NotExistException {
		notExistTrainer(number);
		return trainerDAO.deleteTrainer(number);
	}

	// Players - CRUD
	public void notExistPlayer(int number, String team) throws NotExistException, SQLException {
		PeopleDTO player = playerDAO.getPlayer(number, team);
		if (player == null) {
			throw new NotExistException("검색하신 선수 정보가 없습니다.");
		}
	}

	public ArrayList<PeopleDTO> getAllPlayers(String team) throws SQLException {
		return playerDAO.getAllPlayers(team);
	}

	public PeopleDTO getPlayer(int number, String team) throws SQLException, NotExistException {
		PeopleDTO player = playerDAO.getPlayer(number, team);
		if (player == null) {
			throw new NotExistException("검색하신 선수 정보가 없습니다.");
		}
		return player;
	}

	public boolean addPlayer(PeopleDTO player) throws Exception {
		return playerDAO.addPlayer(player);
	}

	public boolean updatePlayer(int number, String position, String team) throws SQLException, NotExistException {
		notExistPlayer(number, team);
		return playerDAO.updatePlayer(number, position);
	}

	public boolean deletePlayer(int number, String team) throws SQLException, NotExistException {
		notExistPlayer(number, team);
		return playerDAO.deletePlayer(number);
	}

	// Team - CRUD
	public void notExistTeam(String team) throws NotExistException, SQLException {
		TeamDTO t = teamDAO.getTeam(team);
		if (t == null) {
			throw new NotExistException("검색하신 팀 정보가 없습니다.");
		}
	}

	public ArrayList<TeamDTO> getAllTeam(String userID) throws SQLException {
		return teamDAO.getAllTeams(userID);
	}

	public TeamDTO getTeam(String team) throws SQLException, NotExistException {
		TeamDTO t = teamDAO.getTeam(team);
		if (t == null) {
			throw new NotExistException("검색하신 팀 정보가 없습니다.");
		}
		return t;
	}

	public boolean addTeam(TeamDTO team) throws Exception {
		return teamDAO.addTeam(team);
	}

	public boolean updateTeam(String team, String newName) throws SQLException, NotExistException {
		notExistTeam(team);
		return teamDAO.updateTeam(team, newName);
	}

	public boolean deleteTeam(String team) throws SQLException, NotExistException {
		notExistTeam(team);
		return teamDAO.deleteTeam(team);
	}

	// Managers - CRUD
	public void notExistManager(int number) throws NotExistException, SQLException {
		PeopleDTO manager = managerDAO.getManager(number);
		if (manager == null) {
			throw new NotExistException("검색하신 감독 정보가 없습니다.");
		}
	}

	public ArrayList<PeopleDTO> getAllManagers(String team) throws SQLException {
		return managerDAO.getAllManagers(team);
	}

	public PeopleDTO getManager(int number) throws SQLException, NotExistException {
		PeopleDTO manager = managerDAO.getManager(number);
		if (manager == null) {
			throw new NotExistException("검색하신 감독 정보가 없습니다.");
		}
		return manager;
	}

	public boolean addManager(PeopleDTO manager) throws Exception {
		return managerDAO.addManager(manager);
	}

	public boolean updateManager(int number, String position) throws SQLException, NotExistException {
		notExistManager(number);
		return managerDAO.updateManager(number, position);
	}

	public boolean deleteManager(int number) throws SQLException, NotExistException {
		notExistManager(number);
		return managerDAO.deleteManager(number);
	}

	// MedicalStaff - CRUD
	public void notExistMedicalStaff(int number) throws NotExistException, SQLException {
		PeopleDTO medicalStaff = medicalStaffDAO.getMedicalStaff(number);
		if (medicalStaff == null) {
			throw new NotExistException("검색하신 의료진 정보가 없습니다.");
		}
	}

	public ArrayList<PeopleDTO> getAllMedicalStaffs(String team) throws SQLException {
		return medicalStaffDAO.getAllMedicalStaffs(team);
	}

	public PeopleDTO getMedicalStaff(int number) throws SQLException, NotExistException {
		PeopleDTO medicalStaff = medicalStaffDAO.getMedicalStaff(number);
		if (medicalStaff == null) {
			throw new NotExistException("검색하신 의료진 정보가 없습니다.");
		}
		return medicalStaff;
	}

	public boolean addMedicalStaff(PeopleDTO medicalStaff) throws Exception {
		return medicalStaffDAO.addMedicalStaff(medicalStaff);
	}

	public boolean updateMedicalStaff(int number, String position) throws SQLException, NotExistException {
		notExistMedicalStaff(number);
		return medicalStaffDAO.updateMedicalStaff(number, position);
	}

	public boolean deleteMedicalStaff(int number) throws SQLException, NotExistException {
		notExistMedicalStaff(number);
		return medicalStaffDAO.deleteMedicalStaff(number);
	}

}
