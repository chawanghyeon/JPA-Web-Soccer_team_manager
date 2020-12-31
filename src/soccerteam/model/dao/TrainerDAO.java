package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import soccerteam.model.dto.PeopleDTO;
import soccerteam.model.entity.TrainerEntity;
import soccerteam.model.util.DBUtil;

public class TrainerDAO {

	private static TrainerDAO instance = new TrainerDAO();

	private TrainerDAO() {
	}

	public static TrainerDAO getInstance() {
		return instance;
	}

	public boolean addTrainer(PeopleDTO trainer) throws Exception {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			em.createNativeQuery("insert into trainers (tr_age, tr_name, tr_position, t_name, tr_number) values ("+trainer.getAge()+", '"+trainer.getName()+"', '"+trainer.getPosition()+"', '"+trainer.getTeam()+"', "+trainer.getNumber()+")").executeUpdate();
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

	public boolean updateTrainer(int number, String position) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			em.find(TrainerEntity.class, number).setPosition(position);
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

	public boolean deleteTrainer(int number) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			em.remove(em.find(TrainerEntity.class, number));
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

	public PeopleDTO getTrainer(int number) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();

		PeopleDTO trainer = null;

		try {
			TrainerEntity t = em.find(TrainerEntity.class, number);
			trainer = new PeopleDTO(t.getNumber(), t.getTeam().getTeam(), t.getName(), t.getAge(),
					t.getPosition());
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return trainer;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PeopleDTO> getAllTrainers(String team) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		List<TrainerEntity> list = null;
		ArrayList<PeopleDTO> tlist = new ArrayList<>();

		try {
			list = em.createNativeQuery("SELECT * FROM trainers where t_name='"+team+"'").getResultList();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				tlist.add(new PeopleDTO(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]),
						String.valueOf(obj[2]), Integer.parseInt(String.valueOf(obj[3])), String.valueOf(obj[4])));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return tlist;
	}
}
