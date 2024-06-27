package pe.edu.calificame.service;

import java.util.List;

import model.DetailUniversityProfessor;
import model.Professor;
import model.University;

public interface UniversityService {

	void register(University university);

	void update(University university);

	void delete(University university);

	List<University> listAll();

	List<University> findByCname(String cname);

	University findByIdUniversity(Integer iduniversity);

	List<DetailUniversityProfessor> findProfessorByIdUniversity(Integer iduniversity);
	
	void registerProfessor(Professor professor, University university);

}
