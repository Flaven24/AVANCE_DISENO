package pe.edu.calificame.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Course;
import model.University;
import pe.edu.calificame.dao.CourseDAO;
import pe.edu.calificame.dao.CourseDAOImpl;
import pe.edu.calificame.service.CourseService;
import pe.edu.calificame.service.CourseServiceImpl;
import pe.edu.calificame.service.UniversityServiceImpl;
import pe.edu.dto.DtoUniversity;

/**
 * Session Bean implementation class BeanUniversity
 */
@Named
@SessionScoped
public class ControllerUniversity implements Serializable {
	private List<University> listUniversity;

	@Inject
	UniversityServiceImpl universityServiceImpl;

	public ControllerUniversity() {
	}

	@PostConstruct
	public void initialize() {
		listUniversity = universityServiceImpl.listAll();
	}

	public List<University> getListUniversity() {
		return listUniversity;
	}

	public void setListUniversity(List<University> listUniversity) {
		listUniversity = universityServiceImpl.listAll();
		this.listUniversity = listUniversity;
	}

}