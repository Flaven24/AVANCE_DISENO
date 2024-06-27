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

import model.ClarityStatus;
import model.Course;
import model.DifficultyStatus;
import model.University;
import pe.edu.calificame.dao.CourseDAO;
import pe.edu.calificame.dao.CourseDAOImpl;
import pe.edu.calificame.service.CourseService;
import pe.edu.calificame.service.CourseServiceImpl;
import pe.edu.calificame.service.RatingServiceImpl;
import pe.edu.dto.DtoUniversity;

/**
 * Session Bean implementation class BeanUniversity
 */
@Named
@SessionScoped
public class ControllerRating implements Serializable {
	private List<ClarityStatus> listClarity;
	private List<DifficultyStatus> listDifficulty;

	private ClarityStatus claritySelected= new ClarityStatus();
	private DifficultyStatus difficultySelected= new DifficultyStatus();

	@Inject
	RatingServiceImpl ratingServiceImpl;

	public ControllerRating() {
	}

	@PostConstruct
	public void initialize() {
		listClarity = ratingServiceImpl.listClarityStatus();
		listDifficulty = ratingServiceImpl.listDifficultyStatus();
	}

	public List<ClarityStatus> getListClarity() {
		return listClarity;
	}

	public void setListClarity(List<ClarityStatus> listClarity) {
		this.listClarity = listClarity;
	}

	public List<DifficultyStatus> getListDifficulty() {
		return listDifficulty;
	}

	public void setListDifficulty(List<DifficultyStatus> listDifficulty) {
		this.listDifficulty = listDifficulty;
	}

	public ClarityStatus getClaritySelected() {
		return claritySelected;
	}

	public void setClaritySelected(ClarityStatus claritySelected) {
		this.claritySelected = claritySelected;
	}

	public DifficultyStatus getDifficultySelected() {
		return difficultySelected;
	}

	public void setDifficultySelected(DifficultyStatus difficultySelected) {
		this.difficultySelected = difficultySelected;
	}

}