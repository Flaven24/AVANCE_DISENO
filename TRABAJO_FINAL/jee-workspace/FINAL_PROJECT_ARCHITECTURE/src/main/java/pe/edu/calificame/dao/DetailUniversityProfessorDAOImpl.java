package pe.edu.calificame.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.DetailUniversityProfessor;
import model.University;

/**
 * Session Bean implementation class CourseDAOImpl
 */
@Stateless
@LocalBean
public class DetailUniversityProfessorDAOImpl implements DetailUniversityProfessorDAO {

	@PersistenceContext(unitName = "JPA_CALIFICAME")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public DetailUniversityProfessorDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DetailUniversityProfessor> findProfessorByIdUniversity(Integer iduniversity) {
		return (List<DetailUniversityProfessor>) em.createNamedQuery("DetailUniversityProfessor.findByIdUniversity")
				.setParameter("iduniversity", iduniversity).getResultList();
	}

}
