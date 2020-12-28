package soccerteam.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import soccerteam.exception.NotExistException;
import soccerteam.model.dao.LoginsDAO;
import soccerteam.model.dao.ManagersDAO;
import soccerteam.model.dao.MedicalStaffDAO;
import soccerteam.model.dao.PlayersDAO;
import soccerteam.model.dao.TeamDAO;
import soccerteam.model.dao.TrainersDAO;
import soccerteam.model.dto.LoginsDTO;
import soccerteam.model.dto.ManagersDTO;
import soccerteam.model.dto.PlayersDTO;
import soccerteam.model.dto.TeamDTO;
import soccerteam.model.dto.TrainersDTO;

public class SoccerTeamService {
	
	private static SoccerTeamService instance = new SoccerTeamService();
	
	private SoccerTeamService() {
	}
	
	public static SoccerTeamService getInstance() {
		return instance;
	}
	
	
	private static loginsDAO loginsDAO = LoginsDAO.getInstance();
	private static MedicalStaffDAO medicalStaffDAO = MedicalStaffDAO.getInstance();
	private static PlayersDAO playersDAO = PlayersDAO.getInstance();
	private static TrainersDAO trainersDAO = TrainersDAO.getInstance();
	private static TeamDAO teamDAO = TeamDAO.getInstance();
	private static ManagersDAO managersDAO = ManagersDAO.getInstance();
	
	
	//Logins - CRUD 
	
			public static void notExistLogins(String userId) throws NotExistException, SQLException{
				LoginsDTO logins = LoginsDAO.getLogins(userId);
				if(logins == null){
					throw new NotExistException("검색하신 회원 정보가 없습니다.");
				}
			}
			
			public static ArrayList<LoginsDTO> getAllLogins() throws SQLException{
				return LoginsDAO.getAllLogins();
			}
			
			public static LoginsDTO getLogins(String userId) throws SQLException, NotExistException{
				LoginsDTO logins = LoginsDAO.getLogins(userId);
				if(logins == null){
					throw new NotExistException("검색하신 회원 정보가 없습니다.");
				}
				return logins;
			}
			
			public static boolean addLogins(LoginsDTO userId) throws Exception{
				return loginsDAO.addLogins(userId);
			}
			
			public static boolean updateLogins(String userId, String userPw ) throws SQLException, NotExistException{
				notExistLogins(userId);
				return loginsDAO.updateLogins(userId, userPw);
			}

			public boolean deleteLogins(String userId) throws SQLException, NotExistException{
				notExistTeam(userId);;
				return loginsDAO.deleteLogins(userId);
			}
	
	
	
	
		//Trainers - CRUD
		public static void notExistTrainer(int trNumber) throws NotExistException, SQLException{
			TrainersDTO trainer = trainersDAO.getTrainer(trNumber);
			if(trainer == null){
				throw new NotExistException("검색하신 트레이너 정보가 없습니다.");
			}
		}
		
		public static ArrayList<TrainersDTO> getAllTrainers() throws SQLException{
			return trainersDAO.getAllTrainers();
		}
		
		public static TrainersDTO getTrainer(int trNumber) throws SQLException, NotExistException{
			TrainersDTO trainer = trainersDAO.getTrainer(trNumber);
			if(trainer == null){
				throw new NotExistException("검색하신 트레이너 정보가 없습니다.");
			}
			return trainer;
		}
		
		public static boolean addTrainer(TrainersDTO trainer) throws Exception{
			return trainersDAO.addTrainer(trainer);
		}
		
		public static boolean updateTrainer(int trNumber, String trPosition) throws SQLException, NotExistException{
			notExistTrainer(trNumber);
			return trainersDAO.updateTrainer(trNumber, trPosition);
		}

		public boolean deleteTrainer(int trNumber) throws SQLException, NotExistException{
			notExistTrainer(trNumber);;
			return trainersDAO.deleteTrainer(trNumber);
		}
			
		//Players - CRUD
		public static void notExistPlayer(int pNumber) throws NotExistException, SQLException{
			PlayersDTO player = playersDAO.getPlayer(pNumber);
			if(player == null){
				throw new NotExistException("검색하신 선수 정보가 없습니다.");
			}
		}
		
		public static ArrayList<PlayersDTO> getAllPlayers() throws SQLException{
			return playersDAO.getAllPlayers();
		}
		
		public static PlayersDTO getPlayer(int pNumber) throws SQLException, NotExistException{
			PlayersDTO player = playersDAO.getPlayer(pNumber);
			if(player == null){
				throw new NotExistException("검색하신 선수 정보가 없습니다.");
			}
			return player;
		}
		
		public static boolean addPlayer(PlayersDTO player) throws Exception{
			return playersDAO.addPlayer(player);
		}
		
		public static boolean updatePlayer(int pNumber, String pPosition) throws SQLException, NotExistException{
			notExistPlayer(pNumber);
			return playersDAO.updatePlayer(pNumber, pPosition);
		}

		public boolean deletePlayer(int pNumber) throws SQLException, NotExistException{
			notExistPlayer(pNumber);
			return playersDAO.deletePlayer(pNumber);
		}
		
		//Team - CRUD
		public static void notExistTeam(String tName) throws NotExistException, SQLException{
			TeamDTO team = teamDAO.getTeam(tName);
			if(team == null){
				throw new NotExistException("검색하신 팀 정보가 없습니다.");
			}
		}
		
		public static ArrayList<TeamDTO> getAllTeam() throws SQLException{
			return teamDAO.getAllTeam();
		}
		
		public static TeamDTO getTeam(String tName) throws SQLException, NotExistException{
			TeamDTO team = teamDAO.getTeam(tName);
			if(team == null){
				throw new NotExistException("검색하신 팀 정보가 없습니다.");
			}
			return team;
		}
		
		public static boolean addTeam(TeamDTO team) throws Exception{
			return teamDAO.addTeam(team);
		}
		
		public static boolean updateTeam(String tName, String userId ) throws SQLException, NotExistException{
			notExistTeam(tName);
			return teamDAO.updateTeam(tName, userId);
		}

		public boolean deleteTeam(String tName) throws SQLException, NotExistException{
			notExistTeam(tName);;
			return teamDAO.deleteTeam(tName);
		}
		
		
		//Managers - CRUD
		public static void notExistManagers(int mNumber) throws NotExistException, SQLException{
			ManagersDTO managers = managersDAO.getManagers(mNumber);
			if(managers == null){
				throw new NotExistException("검색하신 감독 정보가 없습니다.");
			}
		}
		
		public static ArrayList<ManagersDTO> getAllManagers() throws SQLException{
			return managersDAO.getAllManagers();
		}
		
		public static ManagersDTO getManagers(int mNumber) throws SQLException, NotExistException{
			ManagersDTO managers = managersDAO.getManagers(mNumber);
			if(managers == null){
				throw new NotExistException("검색하신 감독 정보가 없습니다.");
			}
			return managers;
		}
		
		public static boolean addManagers(ManagersDTO managers) throws Exception{
			return managersDAO.addManagers(managers);
		}
		
		public static boolean updateManagers(int mNumber, String pPosition) throws SQLException, NotExistException{
			notExistManagers(mNumber);
			return managersDAO.updateManagers(mNumber, pPosition);
		}

		public boolean deleteManagers(int mNumber) throws SQLException, NotExistException{
			notExistManagers(mNumber);
			return managersDAO.deleteManagers(mNumber);
		}
			
		
		
}
