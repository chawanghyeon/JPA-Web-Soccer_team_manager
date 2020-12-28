package soccerteam.model.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;

//import probono.model.ProbonoDAO;
import soccerteam.model.dto.LoginsDTO;
import soccerteam.model.util.DBUtil;
import soccerteam.model.entity.LoginsEntity;

public class LoginsDAO {
	
	private static LoginsDAO instance = new LoginsDAO();
	
	private LoginsDAO() {
	}

	public static LoginsDAO getInstance() {
		return instance;
	}
	
	public boolean addLogins(LoginsDTO logins) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		try {
			em.persist(logins);
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
