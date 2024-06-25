package pe.edu.calificame.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.DetailUniversityProfessor;
import model.Professor;
import model.University;
import pe.edu.calificame.service.UniversityServiceImpl;

@Named
@SessionScoped
public class ControllerDetailUniversity implements Serializable {
	
	private University university;

	private List<Professor> listProfessor;

	private String cnameSearched;
	private int iduniversity;

	@Inject
	UniversityServiceImpl universityServiceImpl;

	public ControllerDetailUniversity() {
	}

//	@PostConstruct
//	public void initialize() {
//		
//	}

	public int getIduniversity() {
		return iduniversity;
	}

	public void setIduniversity(int iduniversity) {
		this.iduniversity = iduniversity;
		university = universityServiceImpl.findByIdUniversity(iduniversity);
		listProfessor = getProfessors();
	}

	private List<Professor> getProfessors() {
		List<Professor> professors = new ArrayList<Professor>();
		List<DetailUniversityProfessor> listDetail = universityServiceImpl.findProfessorByIdUniversity(iduniversity);
		for (DetailUniversityProfessor _detail : listDetail)
			professors.add(_detail.getProfessor());
		return professors;
	}

	public List<Professor> getListProfessor() {
		return listProfessor;
	}

	public void setListProfessor(List<Professor> listProfessor) {
		this.listProfessor = listProfessor;
	}
}
