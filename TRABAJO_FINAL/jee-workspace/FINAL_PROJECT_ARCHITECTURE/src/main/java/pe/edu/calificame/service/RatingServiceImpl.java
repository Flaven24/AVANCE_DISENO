package pe.edu.calificame.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import model.ClarityStatus;
import model.Course;
import model.DifficultyStatus;
import pe.edu.calificame.dao.CourseDAO;
import pe.edu.calificame.dao.CourseDAOImpl;
import pe.edu.calificame.dao.RatingDAOImpl;

/**
 * Session Bean implementation class CourseServiceImpl
 */
@Stateless
@LocalBean
public class RatingServiceImpl implements RatingService {

	@Inject
	RatingDAOImpl ratingDAOImpl;

	/**
	 * Default constructor.
	 */
	public RatingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ClarityStatus> listClarityStatus() {
		return ratingDAOImpl.listClarityStatus();
	}

	@Override
	public List<DifficultyStatus> listDifficultyStatus() {
		return ratingDAOImpl.listDifficultyStatus();
	}

}
