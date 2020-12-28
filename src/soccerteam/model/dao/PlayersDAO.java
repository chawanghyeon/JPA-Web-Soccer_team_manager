package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.PatternLayout;

import soccerteam.model.dto.PlayersDTO;
import soccerteam.model.entity.PlayersEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.util.DBUtil;

public class PlayersDAO {

	private static PlayersDAO instance = new PlayersDAO();

	private PlayersDAO() {
	}

	public static PlayersDAO getInstance() {
		return instance;
	}

	public boolean addPlayer(PlayersDTO player) throws Exception {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean result = false;

		try {
			em.persist(player.toEntity(em.find(TeamEntity.class, player.getTName())));
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

	public boolean updatePlayer(int pNumber, String pPosition) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;

		try {
			em.find(PlayersEntity.class, pNumber).setPPosition(pPosition);;
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

	public boolean deletePlayer(int pNumber) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		boolean result = false;

		try {
			em.remove(em.find(PlayersEntity.class, pNumber));
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

	public PlayersDTO getPlayer(int pNumber) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		PlayersDTO players = null;

		try {
			PlayersEntity p = em.find(PlayersEntity.class, pNumber);
			players = new PlayersDTO(p.getPNumber(), p.getTeam().getTName(), p.getPName(), p.getPAge(), p.getPPosition());
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return players;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PlayersDTO> getAllPlayers() throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		List<PlayersEntity> list = null;
		ArrayList<PlayersDTO> plist = new ArrayList<>();
		
		try {
			list = em.createNativeQuery("SELECT * FROM players").getResultList();
			Iterator it = list.iterator();
			while(it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				plist.add(new PlayersDTO(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]), String.valueOf(obj[2]), Integer.parseInt(String.valueOf(obj[3])), String.valueOf(obj[4])));
			}
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return plist;
	}
}
