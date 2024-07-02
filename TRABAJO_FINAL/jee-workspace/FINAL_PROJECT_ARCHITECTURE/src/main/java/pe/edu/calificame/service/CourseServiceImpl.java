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
@Stateless
@LocalBean
public class CourseServiceImpl implements CourseService{

	@Inject
	CourseDAOImpl courseDAOImpl;
	
    /**
     * Default constructor. 
     */
    public CourseServiceImpl() {
        // TODO Auto-generated constructor stub
    }

       
	public List<Course> listAll() {
    	return courseDAOImpl.listAll();
//    	return null;
	}


	@Override
	public List<Object[]> findByName(String name) {
		return courseDAOImpl.findByName("%"+name+"%");
	}


}
