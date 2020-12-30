package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import soccerteam.model.dto.PeopleDTO;
import soccerteam.model.entity.PlayerEntity;
import soccerteam.model.util.DBUtil;

public class PlayerDAO {

	private static PlayerDAO instance = new PlayerDAO();

	private PlayerDAO() {
	}

	public static PlayerDAO getInstance() {
		return instance;
	}

	public boolean addPlayer(PeopleDTO player) throws Exception {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			em.createNativeQuery("insert into players (p_age, p_name, p_position, t_name, p_number) values ("+player.getAge()+", '"+player.getName()+"', '"+player.getPosition()+"', '"+player.getTeam()+"', "+player.getNumber()+")").executeUpdate();
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

	public boolean updatePlayer(int number, String position) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			em.find(PlayerEntity.class, number).setPosition(position);
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

	public boolean deletePlayer(int number) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			em.remove(em.find(PlayerEntity.class, number));
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

	@SuppressWarnings("unchecked")
	public PeopleDTO getPlayer(int number, String team) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		PeopleDTO player = null;
		List<PlayerEntity> list = null;
		try {
			list = em.createNativeQuery("select * from players where p_number ='"+number+"' and t_name ='"+team+"'").getResultList();
			Iterator it = list.iterator();
	
			Object[] obj = (Object[]) it.next();
			player = new PeopleDTO(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]),
					String.valueOf(obj[2]), Integer.parseInt(String.valueOf(obj[3])), String.valueOf(obj[4]));
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return player;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PeopleDTO> getAllPlayers(String team) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		List<PlayerEntity> list = null;
		ArrayList<PeopleDTO> plist = new ArrayList<>();

		try {
			list = em.createNativeQuery("SELECT * FROM players where t_name='"+team+"'").getResultList();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				plist.add(new PeopleDTO(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]),
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
