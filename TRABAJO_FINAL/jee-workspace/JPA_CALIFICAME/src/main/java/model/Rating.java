package model;

import java.io.Serializable;
import javax.persistence.*;

import pattern.IPrototype;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Rating.findAll", query = "SELECT r FROM Rating r"),
		@NamedQuery(name = "Rating.findByIdUniversityByIdProfessor", query = "SELECT r FROM Rating r WHERE r.professor.idprofessor=:idprofessor AND r.university.iduniversity=:iduniversity ")

})
public class Rating implements Serializable, IPrototype {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idrating;

	private Boolean brecommendation;

	private String ccomment;

	private Timestamp dregist;

	// bi-directional many-to-one association to ClarityStatus
	@ManyToOne
	@JoinColumn(name = "idclarity")
	private ClarityStatus clarityStatus;

	// bi-directional many-to-one association to DifficultyStatus
	@ManyToOne
	@JoinColumn(name = "iddifficulty")
	private DifficultyStatus difficultyStatus;

	// bi-directional many-to-one association to Professor
	@ManyToOne
	@JoinColumn(name = "idprofessor")
	private Professor professor;

	// bi-directional many-to-one association to University
	@ManyToOne
	@JoinColumn(name = "iduniversity")
	private University university;

	private String cclass;
	private Boolean bassistance;
	private Integer nqualification;

	public Rating() {
	}

	public Rating(Rating rating) {
		this.ccomment = rating.ccomment;
		this.dregist = new Timestamp(new Date().getTime());
		this.clarityStatus = rating.clarityStatus;
		this.difficultyStatus = rating.difficultyStatus;
		this.professor = rating.professor;
		this.university = rating.university;
		this.bassistance = rating.bassistance;
		this.brecommendation = rating.brecommendation;
		this.cclass = rating.cclass;
		this.nqualification = rating.nqualification;
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
	
	public String getCclass() {
		return cclass;
	}

	public void setCclass(String cclass) {
		this.cclass = cclass;
	}

	public Boolean getBassistance() {
		return bassistance;
	}

	public void setBassistance(Boolean bassistance) {
		this.bassistance = bassistance;
	}

	public Integer getNqualification() {
		return nqualification;
	}

	public void setNqualification(Integer nqualification) {
		this.nqualification = nqualification;
	}

	@Override
	public Rating Clone() {
		return new Rating(this);
	}
	
	public String getNameRecommendation() {
		return this.brecommendation?"Recomendado":"No recomendado";
	}
	
	public String getNameAssistance() {
		return this.bassistance?"Obligatorio":"Opcional";
	}

	
	
	public String getConvertirFecha() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(this.dregist);
	}

}