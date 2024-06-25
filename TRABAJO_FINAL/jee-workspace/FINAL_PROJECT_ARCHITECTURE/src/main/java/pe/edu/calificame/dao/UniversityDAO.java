package pe.edu.calificame.dao;

import java.util.List;

import model.University;

public interface UniversityDAO {
	List<University> listAll();

	List<University> findByCname(String cname);

	University findByIdUniversity(Integer iduniversity);
}
