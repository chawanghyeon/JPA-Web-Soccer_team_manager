package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import soccerteam.model.dto.PeopleDTO;
import soccerteam.model.dto.TeamDTO;
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

		try {//네이티브 쿼리로 변경
			//강사님께 질문
			em.createNativeQuery("insert into team (user_id, t_name) values ('"+team.getUserID()+"', '"+team.getTeam()+"')").executeUpdate();
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

	public boolean updateTeam(String team, String newName) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;

		try {
			em.find(TeamEntity.class, team).setTeam(newName);
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

	public boolean deleteTeam(String team) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;

		try {
			em.createNativeQuery("delete from team where t_name='"+team+"'").executeUpdate();
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

	public TeamDTO getTeam(String team) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TeamDTO t2 = null;

		try {
			TeamEntity t = em.find(TeamEntity.class, team);
			t2 = new TeamDTO(t.getTeam(), t.getLogin().getUserID());
		} catch (Exception e) {
			tx.rollback();
			throw e;

		} finally {
			em.close();
		}
		return t2;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TeamDTO> getAllTeams(String userID) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		List<TeamEntity> list = null;
		ArrayList<TeamDTO> tlist = new ArrayList<>();
		
		try {
			list = em.createNativeQuery("SELECT * FROM team WHERE user_id='"+userID+"'").getResultList();
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
