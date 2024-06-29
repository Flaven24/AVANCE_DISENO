package pe.edu.calificame.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import model.ClarityStatus;
import model.DifficultyStatus;
import model.Rating;
import pe.edu.calificame.dao.CourseDAO;
import pe.edu.calificame.dao.CourseDAOImpl;

/**
 * Session Bean implementation class CourseServiceImpl
 */

public interface RatingService {

	void register(Rating rating);

	List<ClarityStatus> listClarityStatus();

	List<DifficultyStatus> listDifficultyStatus();

	List<Rating> listRatingByIduniversityByIdProfessor(Integer iduniversity, Integer idprofessor);

}
