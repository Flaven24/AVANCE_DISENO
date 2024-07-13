package pe.edu.calificame.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.DetailUniversityProfessor;
import model.Professor;
import model.Rating;
import model.University;
import pe.edu.calificame.service.ProfessorServiceImpl;
import pe.edu.calificame.service.RatingServiceImpl;
import pe.edu.calificame.service.UniversityServiceImpl;

@Named
@SessionScoped
public class ControllerDetailProfessor implements Serializable {
	
	private Professor professor;
	private University university;
	
	private int idprofessor;
	
	private List<Rating> listRatings = new ArrayList<Rating>();

	@Inject
	UniversityServiceImpl universityServiceImpl;
	@Inject
	ProfessorServiceImpl professorServiceImpl;
	@Inject
	ControllerRating controllerRating;
	@Inject
	RatingServiceImpl ratingServiceImpl;

	public ControllerDetailProfessor() {
	}

//	@PostConstruct
//	public void initialize() {
//		
//	}

	public int getIdprofessor() {
		return idprofessor;
	}

	public void setIdprofessor(int idprofessor) {
		this.idprofessor = idprofessor;
		professor = professorServiceImpl.findByIdProfessor(idprofessor);
		controllerRating.getRating().setProfessor(professor);
		controllerRating.getRating().setUniversity(university);
	}

	public List<Rating> getListRatings() {
		listRatings=getRatings();
		return listRatings;
	}

	public void setListRatings(List<Rating> listRatings) {
		this.listRatings = listRatings;
	}

	private List<Rating> getRatings() {
		List<Rating> ratings= new ArrayList();
		ratings=ratingServiceImpl.listRatingByIduniversityByIdProfessor(university.getIduniversity(), professor.getIdprofessor());
		return ratings;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	

	
	
}
