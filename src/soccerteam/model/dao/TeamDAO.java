package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import soccerteam.model.dto.TeamDTO;
import soccerteam.model.entity.LoginEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.util.DBUtil;

public class TeamDAO {

	private static TeamDAO instance = new TeamDAO();

	private TeamDAO() {
	}

	public static TeamDAO getInstance() {
		return instance;
	}

	public boolean addTeam(TeamDTO team) throws Exception {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;

		try {
			em.persist(team.toEntity(em.find(LoginEntity.class, team.getUserID())));
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

	public boolean updateTeam(String tName, String newName) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;

		try {
			em.find(TeamEntity.class, tName).setTName(newName);
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

	public boolean deleteTeam(String tName) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;

		try {
			em.remove(em.find(TeamEntity.class, tName));
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

	public TeamDTO getTeam(String tName) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TeamDTO team = null;

		try {
			TeamEntity t = em.find(TeamEntity.class, tName);
			team = new TeamDTO(t.getTName(), t.getLogin().getUserID());
		} catch (Exception e) {
			tx.rollback();
			throw e;

		} finally {
			em.close();
		}
		return team;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TeamDTO> getAllTeams(String userID) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		List<TeamEntity> list = null;
		ArrayList<TeamDTO> tlist = new ArrayList<>();
		
		try {
			list = em.createNativeQuery("SELECT * FROM team WHERE user_id=" + "'"+userID+"'").getResultList();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				tlist.add(new TeamDTO(String.valueOf(obj[0]), String.valueOf(obj[1])));
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return tlist;
	}
}
