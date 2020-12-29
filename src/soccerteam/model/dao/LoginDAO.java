package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import soccerteam.model.dto.LoginDTO;
import soccerteam.model.entity.LoginEntity;
import soccerteam.model.util.DBUtil;

public class LoginDAO {

	private static LoginDAO instance = new LoginDAO();

	private LoginDAO() {
	}

	public static LoginDAO getInstance() {
		return instance;
	}

	public boolean addLogin(LoginDTO login) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		boolean result = false;

		try {
			em.persist(login.toEntity());
			tx.commit();

			result = true;

		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
		return result;
	}

	public boolean updateLogin(String userID, String newPw) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			em.find(LoginEntity.class, userID).setUserPW(newPw);
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

	public boolean deleteLogin(String userID) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			em.remove(em.find(LoginEntity.class, userID));
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

	public LoginDTO getLogin(String userID) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		LoginDTO login = null;

		try {
			LoginEntity l = em.find(LoginEntity.class, userID);
			login = new LoginDTO(userID, l.getUserPW());
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return login;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<LoginDTO> getAllLogins() throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		List<LoginEntity> list = null;
		ArrayList<LoginDTO> llist = new ArrayList<>();
		
		try {
			list = em.createNativeQuery("SELECT * FROM logins").getResultList();
			Iterator it = list.iterator();
			while(it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				llist.add(new LoginDTO(String.valueOf(obj[0]), String.valueOf(obj[1])));
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return llist;
	}
	
}
