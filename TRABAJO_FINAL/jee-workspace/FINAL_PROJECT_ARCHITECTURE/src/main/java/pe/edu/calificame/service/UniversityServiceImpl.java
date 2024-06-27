package pe.edu.calificame.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import model.DetailUniversityProfessor;
import model.Professor;
import model.University;
import pe.edu.calificame.dao.CrudDAOImpl;
import pe.edu.calificame.dao.DetailUniversityProfessorDAOImpl;
import pe.edu.calificame.dao.UniversityDAOImpl;

/**
 * Session Bean implementation class UniversityServiceImpl
 */
@Stateless
@LocalBean
public class UniversityServiceImpl implements UniversityService {

	@Inject
	UniversityDAOImpl universityDAOImpl;
	@Inject
	DetailUniversityProfessorDAOImpl detailUniversityProfessorDAOImpl;

	@Inject
	CrudDAOImpl crudDAOImpl;
	
	/**
	 * Default constructor.
	 */
	public UniversityServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void register(University university) {
		crudDAOImpl.register(university);
	}


	@Override
	public void update(University university) {
		crudDAOImpl.update(university);		
	}

	@Override
	public void delete(University university) {
		crudDAOImpl.delete(university);
		
	}
	
	@Override
	public List<University> listAll() {
		return universityDAOImpl.listAll();
	}

	@Override
	public List<University> findByCname(String cname) {
		return universityDAOImpl.findByCname("%"+cname.toUpperCase()+"%");
	}

	@Override
	public University findByIdUniversity(Integer iduniversity) {
		return universityDAOImpl.findByIdUniversity(iduniversity);
	}

	@Override
	public List<DetailUniversityProfessor> findProfessorByIdUniversity(Integer iduniversity) {
		return detailUniversityProfessorDAOImpl.findProfessorByIdUniversity(iduniversity);
	}

	public void registerProfessor(Professor professor, University university) {
		crudDAOImpl.register(professor);
		System.out.println("ID PROFSSOR: "+professor.getIdprofessor());
		
		DetailUniversityProfessor detail = new DetailUniversityProfessor();
		detail.setProfessor(professor);
		detail.setUniversity(university);
		crudDAOImpl.register(detail);
	}
	
	

}
