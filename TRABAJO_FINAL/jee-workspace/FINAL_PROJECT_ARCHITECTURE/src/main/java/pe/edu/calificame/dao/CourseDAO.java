package pe.edu.calificame.dao;

import java.util.List;

import model.Course;

public interface CourseDAO {
	List<Course> listAll();
	List<Course> findByName(String name);
}
