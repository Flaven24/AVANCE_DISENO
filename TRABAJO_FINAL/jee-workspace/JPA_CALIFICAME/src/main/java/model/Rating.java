package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Rating.findAll", query="SELECT r FROM Rating r"),
	@NamedQuery(name="Rating.findByIdUniversityByIdProfessor", query="SELECT r FROM Rating r WHERE r.professor.idprofessor=:idprofessor AND r.university.iduniversity=:iduniversity ")
	
})
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idrating;

	private Boolean brecommendation;

	private String ccomment;

	private Timestamp dregist;

	//bi-directional many-to-one association to ClarityStatus
	@ManyToOne
	@JoinColumn(name="idclarity")
	private ClarityStatus clarityStatus;

	//bi-directional many-to-one association to DifficultyStatus
	@ManyToOne
	@JoinColumn(name="iddifficulty")
	private DifficultyStatus difficultyStatus;

	//bi-directional many-to-one association to Professor
	@ManyToOne
	@JoinColumn(name="idprofessor")
	private Professor professor;

	//bi-directional many-to-one association to University
	@ManyToOne
	@JoinColumn(name="iduniversity")
	private University university;

	public Rating() {
	}

	public Integer getIdrating() {
		return this.idrating;
	}

	public void setIdrating(Integer idrating) {
		this.idrating = idrating;
	}

	public Boolean getBrecommendation() {
		return this.brecommendation;
	}

	public void setBrecommendation(Boolean brecommendation) {
		this.brecommendation = brecommendation;
	}

	public String getCcomment() {
		return this.ccomment;
	}

	public void setCcomment(String ccomment) {
		this.ccomment = ccomment;
	}

	public Timestamp getDregist() {
		return this.dregist;
	}

	public void setDregist(Timestamp dregist) {
		this.dregist = dregist;
	}

	public ClarityStatus getClarityStatus() {
		return this.clarityStatus;
	}

	public void setClarityStatus(ClarityStatus clarityStatus) {
		this.clarityStatus = clarityStatus;
	}

	public DifficultyStatus getDifficultyStatus() {
		return this.difficultyStatus;
	}

	public void setDifficultyStatus(DifficultyStatus difficultyStatus) {
		this.difficultyStatus = difficultyStatus;
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