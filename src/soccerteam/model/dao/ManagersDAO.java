package soccerteam.model.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import soccerteam.model.dto.ManagersDTO;
import soccerteam.model.dto.TeamDTO;
import soccerteam.model.entity.ManagersEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.util.DBUtil;

public class ManagersDAO {

	
	
private static ManagersDAO instance = new ManagersDAO();
	
	private ManagersDAO() {
	}

	public static ManagersDAO getInstance() {
		return instance;
	}
	
	public boolean addManagers(ManagersDTO managers) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;
	
		try {
			em.persist(managers.toEntity(em.find(TeamEntity.class, managers.getTName())));
			tx.commit();

			result = true;

		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}
	
	public boolean updateManagers(int mNumber, String mPosition) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;
	
		try {
			em.find(ManagersEntity.class, mNumber).setMPosition(mPosition);
			tx.commit();

			result = true;

		} catch (Exception e) {
			tx.rollback();
			throw e;
			
		} finally {
			em.close();
		}
		return result;
	}
	
	public boolean deleteManagers(int mNumber) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;

		try {
			em.remove(em.find(ManagersEntity.class, mNumber));
			tx.commit();

			result = true;
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return result;
	}
	
	public ManagersDTO getPlayer(int mNumber) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ManagersDTO managers = null;

		try {
			ManagersEntity m = em.find(ManagersEntity.class, mNumber);
			managers = new ManagersDTO(m.getMNumber(), m.getTeam().getTName() , m.getMName(), m.getMAge(), m.getMPosition());
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return managers;
	}

	
}
