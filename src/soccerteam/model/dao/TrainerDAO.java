package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import soccerteam.model.dto.PlayerDTO;
import soccerteam.model.dto.TrainerDTO;
import soccerteam.model.entity.PlayerEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.entity.TrainerEntity;
import soccerteam.model.util.DBUtil;

public class TrainerDAO {

	private static TrainerDAO instance = new TrainerDAO();

	private TrainerDAO() {
	}

	public static TrainerDAO getInstance() {
		return instance;
	}

	public boolean addTrainer(TrainerDTO trainer) throws Exception {
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
			em.find(TrainerEntity.class, trNumber).setTrPosition(trPosition);
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
			em.remove(em.find(TrainerEntity.class, trNumber));
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

	public TrainerDTO getTrainer(int trNumber) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		TrainerDTO trainer = null;

		try {
			TrainerEntity t = em.find(TrainerEntity.class, trNumber);
			trainer = new TrainerDTO(t.getTrNumber(), t.getTeam().getTName(), t.getTrName(), t.getTrAge(),
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
	public ArrayList<TrainerDTO> getAllTrainers() throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		List<TrainerEntity> list = null;
		ArrayList<TrainerDTO> tlist = new ArrayList<>();

		try {
			list = em.createNativeQuery("SELECT * FROM trainers").getResultList();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				tlist.add(new TrainerDTO(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]),
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
