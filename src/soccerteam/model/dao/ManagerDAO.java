package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import soccerteam.model.dto.ManagerDTO;
import soccerteam.model.entity.ManagerEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.util.DBUtil;

public class ManagerDAO {

	private static ManagerDAO instance = new ManagerDAO();

	private ManagerDAO() {
	}

	public static ManagerDAO getInstance() {
		return instance;
	}

	public boolean addManager(ManagerDTO manager) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;

		try {
			em.persist(manager.toEntity(em.find(TeamEntity.class, manager.getTName())));
			tx.commit();

			result = true;

		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}

	public boolean updateManager(int mNumber, String mPosition) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;

		try {
			em.find(ManagerEntity.class, mNumber).setMPosition(mPosition);
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

	public boolean deleteManager(int mNumber) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;

		try {
			em.remove(em.find(ManagerEntity.class, mNumber));
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

	public ManagerDTO getManager(int mNumber) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ManagerDTO managers = null;

		try {
			ManagerEntity m = em.find(ManagerEntity.class, mNumber);
			managers = new ManagerDTO(mNumber, m.getTeam().getTName(), m.getMName(), m.getMAge(), m.getMPosition());
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return managers;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ManagerDTO> getAllManagers() throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		List<ManagerEntity> list = null;
		ArrayList<ManagerDTO> mlist = new ArrayList<>();

		try {
			list = em.createNativeQuery("SELECT * FROM managers").getResultList();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				mlist.add(new ManagerDTO(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]),
						String.valueOf(obj[2]), Integer.parseInt(String.valueOf(obj[3])), String.valueOf(obj[4])));
			}
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return mlist;
	}

}
