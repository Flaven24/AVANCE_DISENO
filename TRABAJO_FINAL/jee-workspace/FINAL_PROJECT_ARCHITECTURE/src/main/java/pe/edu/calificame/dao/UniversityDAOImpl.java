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

	@Override
	public List<University> findByCname(String cname) {
		return (List<University>) em.createNamedQuery("University.findByCname").setParameter("cname", cname)
				.getResultList();
	}

	@Override
	public University findByIdUniversity(Integer iduniversity) {
		return (University) em.createNamedQuery("University.findByIdUniversity")
				.setParameter("iduniversity", iduniversity).getSingleResult();
	}

}
