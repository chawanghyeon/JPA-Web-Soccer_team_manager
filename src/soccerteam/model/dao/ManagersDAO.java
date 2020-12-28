package soccerteam.model.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import soccerteam.model.dto.TeamDTO;
import soccerteam.model.entity.ManagersEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.util.DBUtil;

public class ManagersDAO {

	
	
private static ManagersDAO instance = new ManagersDAO();
	
	private ManagersDAO {
	}

	public static ManagersDAO getInstance() {
		return instance;
	}
	
	public boolean addManagers(ManagersDAO managers) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
	
		try {
			em.persist(ManagersDTO.toEntity());
			em.getTransaction().commit();

			result = true;

		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}
	
	public boolean updateManagers(ManagersDAO managers) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
	
		try {
			em.find(ManagersEntity.class, mNumber).setMname(mName);
			em.getTransaction().commit();

			result = true;

		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}
	
	
}
