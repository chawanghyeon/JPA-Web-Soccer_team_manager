package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

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
	
	public boolean addTeam(TeamDAO team) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
	
		try {
			em.persist(TeamDTO.toEntity());
			em.getTransaction().commit();

			result = true;

		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}
	
	
	public boolean updateTeam(TeamDAO team) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
	
		try {
			em.find(TeamEntity.class, tName).setTname(tName);
			em.getTransaction().commit();

			result = true;

		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}
	
	public boolean deleteTeam(String tName) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;

		try {
			em.remove(em.find(TeamEntity.class, tName));

			em.getTransaction().commit();

			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
		return result;
	}
	
	

	public TeamDTO getTeam(String tName) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		TeamDTO team = null;

		try {
			TeamEntity t = em.find(TeamEntity.class, tName);
		    team = new TeamDTO(t.getTName(), t.getUserId());
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return team;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TeamDTO> getAllTeam() throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		List<TeamEntity> list = null;
		ArrayList<TeamDTO> tlist = new ArrayList<>();
		try {
			list = em.createNativeQuery("SELECT * FROM Team").getResultList();
			Iterator it = list.iterator();
			while(it.hasNext()) {
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
