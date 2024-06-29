package pe.edu.calificame.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.ClarityStatus;
import model.Course;
import model.DifficultyStatus;
import model.Rating;

/**
 * Session Bean implementation class CourseDAOImpl
 */
@Stateless
@LocalBean
public class RatingDAOImpl implements RatingDAO {

	@PersistenceContext(unitName = "JPA_CALIFICAME")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public RatingDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ClarityStatus> listClarityStatus() {
		return (List<ClarityStatus>) em.createNamedQuery("ClarityStatus.findAll").getResultList();
	}

	@Override
	public List<DifficultyStatus> listDifficultyStatus() {
		return (List<DifficultyStatus>) em.createNamedQuery("DifficultyStatus.findAll").getResultList();
	}

	@Override
	public List<Rating> listRatingByIduniversityByIdProfessor(Integer iduniversity, Integer idprofessor) {
		return (List<Rating>) em.createNamedQuery("Rating.findByIdUniversityByIdProfessor")
				.setParameter("iduniversity", iduniversity).setParameter("idprofessor", idprofessor).getResultList();
	}

}
