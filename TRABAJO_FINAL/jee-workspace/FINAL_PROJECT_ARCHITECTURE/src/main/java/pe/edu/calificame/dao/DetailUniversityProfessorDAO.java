package pe.edu.calificame.dao;

import java.util.List;

import model.DetailUniversityProfessor;

public interface DetailUniversityProfessorDAO {

	List<DetailUniversityProfessor> findProfessorByIdUniversity(Integer iduniversity);
	
}
