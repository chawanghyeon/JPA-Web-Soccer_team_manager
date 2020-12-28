package soccerteam.model.service;

import soccerteam.model.dao.MedicalStaffDAO;
import soccerteam.model.dao.PlayersDAO;
import soccerteam.model.dao.TrainersDAO;

public class SoccerTeamService {
	
	private static SoccerTeamService instance = new SoccerTeamService();
	
	private SoccerTeamService() {
	}
	
	public static SoccerTeamService getInstance() {
		return instance;
	}
	
	MedicalStaffDAO medicalStaffDAO = MedicalStaffDAO.getInstance();
	PlayersDAO playersDAO = PlayersDAO.getInstance();
	TrainersDAO trainersDAO = TrainersDAO.getInstance();
}
