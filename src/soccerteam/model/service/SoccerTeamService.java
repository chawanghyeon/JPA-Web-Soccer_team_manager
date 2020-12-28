package soccerteam.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import soccerteam.exception.NotExistException;
import soccerteam.model.dao.MedicalStaffDAO;
import soccerteam.model.dao.PlayersDAO;
import soccerteam.model.dao.TrainersDAO;
import soccerteam.model.dto.PlayersDTO;
import soccerteam.model.dto.TrainersDTO;

public class SoccerTeamService {
	
	private static SoccerTeamService instance = new SoccerTeamService();
	
	private SoccerTeamService() {
	}
	
	public static SoccerTeamService getInstance() {
		return instance;
	}
	
	private static MedicalStaffDAO medicalStaffDAO = MedicalStaffDAO.getInstance();
	private static PlayersDAO playersDAO = PlayersDAO.getInstance();
	private static TrainersDAO trainersDAO = TrainersDAO.getInstance();
	
		//Trainers - CRUD
		public static void notExistTrainer(int trNumber) throws NotExistException, SQLException{
			TrainersDTO trainer = trainersDAO.getTrainer(trNumber);
			if(trainer == null){
				throw new NotExistException("검색하진 재능기부 정보가 없습니다.");
			}
		}
		
		public static ArrayList<TrainersDTO> getAllTrainers() throws SQLException{
			return trainersDAO.getAllTrainers();
		}
		
		public static TrainersDTO getTrainer(int trNumber) throws SQLException, NotExistException{
			TrainersDTO trainer = trainersDAO.getTrainer(trNumber);
			if(trainer == null){
				throw new NotExistException("검색하신 재능기부 정보가 없습니다.");
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
				throw new NotExistException("검색하진 재능기부 정보가 없습니다.");
			}
		}
		
		public static ArrayList<PlayersDTO> getAllPlayers() throws SQLException{
			return playersDAO.getAllPlayers();
		}
		
		public static PlayersDTO getPlayer(int pNumber) throws SQLException, NotExistException{
			PlayersDTO player = playersDAO.getPlayer(pNumber);
			if(player == null){
				throw new NotExistException("검색하신 재능기부 정보가 없습니다.");
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
		
		
}
