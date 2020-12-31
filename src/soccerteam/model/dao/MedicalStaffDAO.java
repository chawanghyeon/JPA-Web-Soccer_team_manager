package soccerteam.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import soccerteam.model.dto.PeopleDTO;
import soccerteam.model.entity.MedicalStaffEntity;
import soccerteam.model.util.DBUtil;

public class MedicalStaffDAO {

	private static MedicalStaffDAO instance = new MedicalStaffDAO();

	private MedicalStaffDAO() {
	}

	public static MedicalStaffDAO getInstance() {
		return instance;
	}

	public boolean addMedicalStaff(PeopleDTO medicalStaff) throws Exception {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		boolean result = false;

		try {
			em.createNativeQuery("insert into medical_staff (d_age, d_name, d_position, t_name, d_number) values ("+medicalStaff.getAge()+", '"+medicalStaff.getName()+"', '"+medicalStaff.getPosition()+"', '"+medicalStaff.getTeam()+"', "+medicalStaff.getNumber()+")").executeUpdate();
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

	public boolean updateMedicalStaff(int number, String position) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			em.find(MedicalStaffEntity.class, number).setPosition(position);
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

	public boolean deleteMedicalStaff(int number) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {
			em.remove(em.find(MedicalStaffEntity.class, number));
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

	public PeopleDTO getMedicalStaff(int number) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		PeopleDTO medicalStaff = null;

		try {
			MedicalStaffEntity d = em.find(MedicalStaffEntity.class, number);
			medicalStaff = new PeopleDTO(d.getNumber(), d.getTeam().getTeam(), d.getName(), d.getAge(),
					d.getPosition());
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return medicalStaff;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PeopleDTO> getAllMedicalStaffs(String team) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		List<MedicalStaffEntity> list = null;
		ArrayList<PeopleDTO> dlist = new ArrayList<>();

		try {
			list = em.createNativeQuery("SELECT * FROM medical_staff where t_name='"+team+"'").getResultList();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				dlist.add(new PeopleDTO(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]),
						String.valueOf(obj[2]), Integer.parseInt(String.valueOf(obj[3])), String.valueOf(obj[4])));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return dlist;
	}
}
