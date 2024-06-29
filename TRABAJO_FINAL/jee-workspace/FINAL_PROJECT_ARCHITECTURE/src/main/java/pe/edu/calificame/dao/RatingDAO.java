package pe.edu.calificame.dao;

import java.util.List;

import model.ClarityStatus;
import model.DifficultyStatus;
import model.Rating;

public interface RatingDAO {

	List<ClarityStatus> listClarityStatus();

	List<DifficultyStatus> listDifficultyStatus();

	List<Rating> listRatingByIduniversityByIdProfessor(Integer iduniversity, Integer idprofessor);
}
