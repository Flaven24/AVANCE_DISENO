package pe.edu.calificame.dao;

import java.util.List;

import model.Professor;

public interface ProfessorDAO {
	
	Professor findByIdProfessor(Integer idprofessor);
}
