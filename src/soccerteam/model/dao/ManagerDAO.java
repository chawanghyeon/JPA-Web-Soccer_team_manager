package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import soccerteam.model.dto.PeopleDTO;
import soccerteam.model.entity.ManagerEntity;
import soccerteam.model.util.DBUtil;

public class ManagerDAO {

	private static ManagerDAO instance = new ManagerDAO();

	private ManagerDAO() {
	}

	public static ManagerDAO getInstance() {
		return instance;
	}

	public boolean addManager(PeopleDTO manager) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			em.createNativeQuery("insert into managers (m_age, m_name, m_position, t_name, m_number) values ("+manager.getAge()+", '"+manager.getName()+"', '"+manager.getPosition()+"', '"+manager.getTeam()+"', "+manager.getNumber()+")").executeUpdate();
			tx.commit();

			result = true;

		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}

	public boolean updateManager(int number, String position) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;

		try {
			em.find(ManagerEntity.class, number).setPosition(position);
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

	public boolean deleteManager(int number) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;

		try {
			em.remove(em.find(ManagerEntity.class, number));
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

	public PeopleDTO getManager(int number) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		PeopleDTO managers = null;

		try {
			ManagerEntity m = em.find(ManagerEntity.class, number);
			managers = new PeopleDTO(number, m.getTeam().getTeam(), m.getName(), m.getAge(), m.getPosition());
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return managers;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PeopleDTO> getAllManagers(String team) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		List<ManagerEntity> list = null;
		ArrayList<PeopleDTO> mlist = new ArrayList<>();

		try {
			list = em.createNativeQuery("SELECT * FROM managers where t_name='"+team+"'").getResultList();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				mlist.add(new PeopleDTO(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]),
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
