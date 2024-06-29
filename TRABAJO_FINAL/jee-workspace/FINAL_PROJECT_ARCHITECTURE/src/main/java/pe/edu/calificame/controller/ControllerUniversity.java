package pe.edu.calificame.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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

	private List<University> listSearchUniversity;

	private String cnameSearched;

	@Inject
	UniversityServiceImpl universityServiceImpl;

	@Inject
	ControllerDetailUniversity controllerDetailUniversity;

	public ControllerUniversity() {
	}

	@PostConstruct
	public void initialize() {
		listUniversity = universityServiceImpl.listAll();
	}

	public List<University> getListUniversity() {
		listUniversity = universityServiceImpl.listAll();
		return listUniversity;
	}

	public void setListUniversity(List<University> listUniversity) {
		this.listUniversity = listUniversity;
	}

	public void searchUniversity() {
		listSearchUniversity = universityServiceImpl.findByCname(cnameSearched);
	}

	public List<University> getListSearchUniversity() {
		return listSearchUniversity;
	}

	public void setListSearchUniversity(List<University> listSearchUniversity) {
		this.listSearchUniversity = listSearchUniversity;
	}

	public String getCnameSearched() {
		return cnameSearched;
	}

	public void setCnameSearched(String cnameSearched) {
		this.cnameSearched = cnameSearched;
	}

	public String selectUniversity() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();		
		int iduniversity = Integer.parseInt(map.get("param"));
		controllerDetailUniversity.setIduniversity(iduniversity);
		return "/university/DetailUniversity";
	}

}