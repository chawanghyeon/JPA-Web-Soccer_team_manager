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
import soccerteam.model.dto.ManagerDTO;
import soccerteam.model.dto.MedicalStaffDTO;
import soccerteam.model.dto.PlayerDTO;
import soccerteam.model.dto.TeamDTO;
import soccerteam.model.dto.TrainerDTO;

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
		LoginDTO login = loginDAO.getLogin(userID);
		
		if(login.getUserPW().equals(userPW)) {
			return login;
		}
		
		throw new MessageException("아이디나 비밀번호가 틀렸습니다.");
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
	public void notExistTrainer(int trNumber) throws NotExistException, SQLException {
		TrainerDTO trainer = trainerDAO.getTrainer(trNumber);
		if (trainer == null) {
			throw new NotExistException("검색하신 트레이너 정보가 없습니다.");
		}
	}

	public ArrayList<TrainerDTO> getAllTrainers(String tname) throws SQLException {
		return trainerDAO.getAllTrainers(tname);
	}

	public TrainerDTO getTrainer(int trNumber) throws SQLException, NotExistException {
		TrainerDTO trainer = trainerDAO.getTrainer(trNumber);
		if (trainer == null) {
			throw new NotExistException("검색하신 트레이너 정보가 없습니다.");
		}
		return trainer;
	}

	public boolean addTrainer(TrainerDTO trainer) throws Exception {
		return trainerDAO.addTrainer(trainer);
	}

	public boolean updateTrainer(int trNumber, String trPosition) throws SQLException, NotExistException {
		notExistTrainer(trNumber);
		return trainerDAO.updateTrainer(trNumber, trPosition);
	}

	public boolean deleteTrainer(int trNumber) throws SQLException, NotExistException {
		notExistTrainer(trNumber);
		return trainerDAO.deleteTrainer(trNumber);
	}

	// Players - CRUD
	public void notExistPlayer(int pNumber) throws NotExistException, SQLException {
		PlayerDTO player = playerDAO.getPlayer(pNumber);
		if (player == null) {
			throw new NotExistException("검색하신 선수 정보가 없습니다.");
		}
	}

	public ArrayList<PlayerDTO> getAllPlayers(String tname) throws SQLException {
		return playerDAO.getAllPlayers(tname);
	}

	public PlayerDTO getPlayer(int pNumber) throws SQLException, NotExistException {
		PlayerDTO player = playerDAO.getPlayer(pNumber);
		if (player == null) {
			throw new NotExistException("검색하신 선수 정보가 없습니다.");
		}
		return player;
	}

	public boolean addPlayer(PlayerDTO player) throws Exception {
		return playerDAO.addPlayer(player);
	}

	public boolean updatePlayer(int pNumber, String pPosition) throws SQLException, NotExistException {
		notExistPlayer(pNumber);
		return playerDAO.updatePlayer(pNumber, pPosition);
	}

	public boolean deletePlayer(int pNumber) throws SQLException, NotExistException {
		notExistPlayer(pNumber);
		return playerDAO.deletePlayer(pNumber);
	}

	// Team - CRUD
	public void notExistTeam(String tName) throws NotExistException, SQLException {
		TeamDTO team = teamDAO.getTeam(tName);
		if (team == null) {
			throw new NotExistException("검색하신 팀 정보가 없습니다.");
		}
	}

	public ArrayList<TeamDTO> getAllTeam(String userID) throws SQLException {
		return teamDAO.getAllTeams(userID);
	}

	public TeamDTO getTeam(String tName) throws SQLException, NotExistException {
		TeamDTO team = teamDAO.getTeam(tName);
		if (team == null) {
			throw new NotExistException("검색하신 팀 정보가 없습니다.");
		}
		return team;
	}

	public boolean addTeam(TeamDTO team) throws Exception {
		return teamDAO.addTeam(team);
	}

	public boolean updateTeam(String tName, String newName) throws SQLException, NotExistException {
		notExistTeam(tName);
		return teamDAO.updateTeam(tName, newName);
	}

	public boolean deleteTeam(String tName) throws SQLException, NotExistException {
		notExistTeam(tName);
		return teamDAO.deleteTeam(tName);
	}

	// Managers - CRUD
	public void notExistManager(int mNumber) throws NotExistException, SQLException {
		ManagerDTO manager = managerDAO.getManager(mNumber);
		if (manager == null) {
			throw new NotExistException("검색하신 감독 정보가 없습니다.");
		}
	}

	public ArrayList<ManagerDTO> getAllManagers(String tname) throws SQLException {
		return managerDAO.getAllManagers(tname);
	}

	public ManagerDTO getManager(int mNumber) throws SQLException, NotExistException {
		ManagerDTO manager = managerDAO.getManager(mNumber);
		if (manager == null) {
			throw new NotExistException("검색하신 감독 정보가 없습니다.");
		}
		return manager;
	}

	public boolean addManager(ManagerDTO manager) throws Exception {
		return managerDAO.addManager(manager);
	}

	public boolean updateManager(int mNumber, String mPosition) throws SQLException, NotExistException {
		notExistManager(mNumber);
		return managerDAO.updateManager(mNumber, mPosition);
	}

	public boolean deleteManager(int mNumber) throws SQLException, NotExistException {
		notExistManager(mNumber);
		return managerDAO.deleteManager(mNumber);
	}

	// MedicalStaff - CRUD
	public void notExistMedicalStaff(int dNumber) throws NotExistException, SQLException {
		MedicalStaffDTO medicalStaff = medicalStaffDAO.getMedicalStaff(dNumber);
		if (medicalStaff == null) {
			throw new NotExistException("검색하신 의료진 정보가 없습니다.");
		}
	}

	public ArrayList<MedicalStaffDTO> getAllMedicalStaffs(String tname) throws SQLException {
		return medicalStaffDAO.getAllMedicalStaffs(tname);
	}

	public MedicalStaffDTO getMedicalStaff(int dNumber) throws SQLException, NotExistException {
		MedicalStaffDTO medicalStaff = medicalStaffDAO.getMedicalStaff(dNumber);
		if (medicalStaff == null) {
			throw new NotExistException("검색하신 의료진 정보가 없습니다.");
		}
		return medicalStaff;
	}

	public boolean addMedicalStaff(MedicalStaffDTO medicalStaff) throws Exception {
		return medicalStaffDAO.addMedicalStaff(medicalStaff);
	}

	public boolean updateMedicalStaff(int dNumber, String dPosition) throws SQLException, NotExistException {
		notExistMedicalStaff(dNumber);
		return medicalStaffDAO.updateMedicalStaff(dNumber, dPosition);
	}

	public boolean deleteMedicalStaff(int dNumber) throws SQLException, NotExistException {
		notExistMedicalStaff(dNumber);
		return medicalStaffDAO.deleteMedicalStaff(dNumber);
	}

}
