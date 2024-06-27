package pe.edu.calificame.dao;

import java.util.List;

import model.ClarityStatus;
import model.DifficultyStatus;

public interface RatingDAO {

	List<ClarityStatus> listClarityStatus();

	List<DifficultyStatus> listDifficultyStatus();
}
