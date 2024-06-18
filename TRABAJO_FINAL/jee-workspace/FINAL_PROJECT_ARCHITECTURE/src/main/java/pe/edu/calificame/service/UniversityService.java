package pe.edu.calificame.service;

import java.util.List;

import model.University;

public interface UniversityService {

	void register(University university);

	void update(University university);

	void delete(University university);

	List<University> listAll();
}
