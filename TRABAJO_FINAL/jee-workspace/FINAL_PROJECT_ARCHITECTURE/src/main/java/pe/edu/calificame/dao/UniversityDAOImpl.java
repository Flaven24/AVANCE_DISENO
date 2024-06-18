package pe.edu.calificame.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.University;

/**
 * Session Bean implementation class CourseDAOImpl
 */
@Stateless
@LocalBean
public class UniversityDAOImpl implements UniversityDAO {

	@PersistenceContext(unitName = "JPA_CALIFICAME")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public UniversityDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<University> listAll() {
		List<University> lista = em.createNamedQuery("University.findAll").getResultList();
		return lista;
	}
}
