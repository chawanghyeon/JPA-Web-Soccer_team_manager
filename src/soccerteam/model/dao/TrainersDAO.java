package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import soccerteam.model.dto.PlayersDTO;
import soccerteam.model.dto.TrainersDTO;
import soccerteam.model.entity.PlayersEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.entity.TrainersEntity;
import soccerteam.model.util.DBUtil;

public class TrainersDAO {

	private static TrainersDAO instance = new TrainersDAO();

	private TrainersDAO() {
	}

	public static TrainersDAO getInstance() {
		return instance;
	}

	public boolean addTrainer(TrainersDTO trainer) throws Exception {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		boolean result = false;

		try {
			em.persist(trainer.toEntity(em.find(TeamEntity.class, trainer.getTName())));
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

	public boolean updateTrainer(int trNumber, String trPosition) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			em.find(TrainersEntity.class, trNumber).setTrPosition(trPosition);
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

	public boolean deleteTrainer(int trNumber) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			em.remove(em.find(TrainersEntity.class, trNumber));
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

	public TrainersDTO getTrainer(int trNumber) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		TrainersDTO trainer = null;

		try {
			TrainersEntity t = em.find(TrainersEntity.class, trNumber);
			trainer = new TrainersDTO(t.getTrNumber(), t.getTeam().getTName(), t.getTrName(), t.getTrAge(),
					t.getTrPosition());
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return trainer;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TrainersDTO> getAllTrainers() throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		List<TrainersEntity> list = null;
		ArrayList<TrainersDTO> tlist = new ArrayList<>();

		try {
			list = em.createNativeQuery("SELECT * FROM trainers").getResultList();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				tlist.add(new TrainersDTO(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]),
						String.valueOf(obj[2]), Integer.parseInt(String.valueOf(obj[3])), String.valueOf(obj[4])));
			}
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return tlist;
	}
}
