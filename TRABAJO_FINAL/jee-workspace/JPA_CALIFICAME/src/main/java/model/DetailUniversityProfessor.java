package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the detail_university_professor database table.
 * 
 */
@Entity
@Table(name="detail_university_professor")
@NamedQuery(name="DetailUniversityProfessor.findAll", query="SELECT d FROM DetailUniversityProfessor d")
public class DetailUniversityProfessor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddetail;

	private Timestamp dregist;

	//bi-directional many-to-one association to Professor
	@ManyToOne
	@JoinColumn(name="idprofessor")
	private Professor professor;

	//bi-directional many-to-one association to University
	@ManyToOne
	@JoinColumn(name="iduniversity")
	private University university;

	public DetailUniversityProfessor() {
	}

	public Integer getIddetail() {
		return this.iddetail;
	}

	public void setIddetail(Integer iddetail) {
		this.iddetail = iddetail;
	}

	public Timestamp getDregist() {
		return this.dregist;
	}

	public void setDregist(Timestamp dregist) {
		this.dregist = dregist;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public University getUniversity() {
		return this.university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

}