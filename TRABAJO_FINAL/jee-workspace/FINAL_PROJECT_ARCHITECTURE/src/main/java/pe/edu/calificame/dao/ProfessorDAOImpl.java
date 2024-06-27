package pe.edu.calificame.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Course;
import model.Professor;

/**
 * Session Bean implementation class CourseDAOImpl
 */
@Stateless
@LocalBean
public class ProfessorDAOImpl implements ProfessorDAO {

	@PersistenceContext(unitName = "JPA_CALIFICAME")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ProfessorDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Professor findByIdProfessor(Integer idprofessor) {
		return (Professor) em.createNamedQuery("Professor.findByIdprofessor").setParameter("idprofessor", idprofessor).getSingleResult();
	}

}
