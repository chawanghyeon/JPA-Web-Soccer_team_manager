package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.PatternLayout;

import soccerteam.model.dto.PlayerDTO;
import soccerteam.model.entity.PlayerEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.util.DBUtil;

public class PlayerDAO {

	private static PlayerDAO instance = new PlayerDAO();

	private PlayerDAO() {
	}

	public static PlayerDAO getInstance() {
		return instance;
	}

	public boolean addPlayer(PlayerDTO player) throws Exception {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			em.createNativeQuery("insert into players (p_age, p_name, p_position, t_name, p_number) values ("+player.getPage()+", '"+player.getPname()+"', '"+player.getPposition()+"', '"+player.getTname()+"', "+player.getPnumber()+")").executeUpdate();
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
			em.find(PlayerEntity.class, pNumber).setPPosition(pPosition);
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
			em.remove(em.find(PlayerEntity.class, pNumber));
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

	public PlayerDTO getPlayer(int pNumber) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		PlayerDTO players = null;

		try {
			PlayerEntity p = em.find(PlayerEntity.class, pNumber);
			players = new PlayerDTO(p.getPNumber(), p.getTeam().getTName(), p.getPName(), p.getPAge(),
					p.getPPosition());
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return players;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PlayerDTO> getAllPlayers(String tname) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		List<PlayerEntity> list = null;
		ArrayList<PlayerDTO> plist = new ArrayList<>();

		try {
			list = em.createNativeQuery("SELECT * FROM players where t_name='"+tname+"'").getResultList();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				plist.add(new PlayerDTO(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]),
						String.valueOf(obj[2]), Integer.parseInt(String.valueOf(obj[3])), String.valueOf(obj[4])));
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
