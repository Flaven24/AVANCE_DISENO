package pe.edu.calificame.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import model.Course;
import pe.edu.calificame.dao.CourseDAO;
import pe.edu.calificame.dao.CourseDAOImpl;

/**
 * Session Bean implementation class CourseServiceImpl
 */

public interface CourseService {

	public List<Course> listAll();
	List<Object[]> findByName(String name);

}
