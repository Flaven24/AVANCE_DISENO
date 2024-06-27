package pe.edu.calificame.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Course;
import model.Professor;
import pe.edu.calificame.dao.ProfessorDAOImpl;

/**
 * Session Bean implementation class CourseDAOImpl
 */
@Stateless
@LocalBean
public class ProfessorServiceImpl implements ProfessorService {

	@Inject
	ProfessorDAOImpl professorDAOImpl;

	/**
	 * Default constructor.
	 */
	public ProfessorServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Professor findByIdProfessor(Integer idprofessor) {
		return professorDAOImpl.findByIdProfessor(idprofessor);
	}

}
