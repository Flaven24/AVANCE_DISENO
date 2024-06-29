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
	@Inject
	ControllerDetailProfessor controllerDetailProfessor;
	

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
		controllerDetailProfessor.setUniversity(university);
		listProfessor = getProfessors();
	}	
	
	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	private List<Professor> getProfessors() {
		List<Professor> professors = new ArrayList<Professor>();
		List<DetailUniversityProfessor> listDetail = universityServiceImpl.findProfessorByIdUniversity(iduniversity);
		for (DetailUniversityProfessor _detail : listDetail)
			professors.add(_detail.getProfessor());
		return professors;
	}

	public List<Professor> getListProfessor() {
		listProfessor = getProfessors();
		return listProfessor;
	}

	public void setListProfessor(List<Professor> listProfessor) {
		this.listProfessor = listProfessor;
	}
	
	public String selectProfessor() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();		
		int idprofessor = Integer.parseInt(map.get("param"));
		controllerDetailProfessor.setIdprofessor(idprofessor);
		return "/professor/DetailProfessor";
	}
}
