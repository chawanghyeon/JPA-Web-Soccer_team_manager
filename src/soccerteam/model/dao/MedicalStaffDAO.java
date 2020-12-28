package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import soccerteam.model.dto.MedicalStaffDTO;
import soccerteam.model.dto.TrainersDTO;
import soccerteam.model.entity.MedicalStaffEntity;
import soccerteam.model.entity.TeamEntity;
import soccerteam.model.entity.TrainersEntity;
import soccerteam.model.util.DBUtil;

public class MedicalStaffDAO {

	private static MedicalStaffDAO instance = new MedicalStaffDAO();

	private MedicalStaffDAO() {
	}

	public static MedicalStaffDAO getInstance() {
		return instance;
	}

	public boolean addMedicalStaff(MedicalStaffDTO medicalStaff) throws Exception {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		boolean result = false;

		try {
			em.persist(medicalStaff.toEntity(em.find(TeamEntity.class, medicalStaff.getTName())));
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

	public boolean updateMedicalStaff(int dNumber, String dPosition) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			em.find(MedicalStaffEntity.class, dNumber).setDPosition(dPosition);
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

	public boolean deleteMedicalStaff(int dNumber) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			em.remove(em.find(MedicalStaffEntity.class, dNumber));
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

	public MedicalStaffDTO getMedicalStaff(int dNumber) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		MedicalStaffDTO medicalStaff = null;

		try {
			MedicalStaffEntity d = em.find(MedicalStaffEntity.class, dNumber);
			medicalStaff = new MedicalStaffDTO(d.getDNumber(), d.getTeam().getTName(), d.getDName(), d.getDAge(),
					d.getDPosition());
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return medicalStaff;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<MedicalStaffDTO> getAllMedicalStaffs() throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		List<MedicalStaffEntity> list = null;
		ArrayList<MedicalStaffDTO> dlist = new ArrayList<>();

		try {
			list = em.createNativeQuery("SELECT * FROM medical_staff").getResultList();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				dlist.add(new MedicalStaffDTO(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]),
						String.valueOf(obj[2]), Integer.parseInt(String.valueOf(obj[3])), String.valueOf(obj[4])));
			}
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return dlist;
	}
}
