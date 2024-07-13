package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the professor database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Professor.findAll", query="SELECT p FROM Professor p"),
	@NamedQuery(name="Professor.findByIdprofessor", query="SELECT p FROM Professor p WHERE p.idprofessor=:idprofessor")
})
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idprofessor;

	private Boolean bactive;
	//@Column(name= "clastname")
	private String clastname;
	//@Column(name="cname")
	private String cname;

	private Timestamp dregist;

	//bi-directional many-to-one association to DetailCourseProfessor
	@OneToMany(mappedBy="professor")
	private List<DetailCourseProfessor> detailCourseProfessors;

	//bi-directional many-to-one association to DetailUniversityProfessor
	@OneToMany(mappedBy="professor")
	private List<DetailUniversityProfessor> detailUniversityProfessors;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="professor")
	private List<Rating> ratings;

	public Professor() {
	}

	public Integer getIdprofessor() {
		return this.idprofessor;
	}

	public void setIdprofessor(Integer idprofessor) {
		this.idprofessor = idprofessor;
	}

	public Boolean getBactive() {
		return this.bactive;
	}

	public void setBactive(Boolean bactive) {
		this.bactive = bactive;
	}

	public String getClastname() {
		return this.clastname;
	}

	public void setClastname(String clastname) {
		this.clastname = clastname;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Timestamp getDregist() {
		return this.dregist;
	}

	public void setDregist(Timestamp dregist) {
		this.dregist = dregist;
	}

	public List<DetailCourseProfessor> getDetailCourseProfessors() {
		return this.detailCourseProfessors;
	}

	public void setDetailCourseProfessors(List<DetailCourseProfessor> detailCourseProfessors) {
		this.detailCourseProfessors = detailCourseProfessors;
	}

	public DetailCourseProfessor addDetailCourseProfessor(DetailCourseProfessor detailCourseProfessor) {
		getDetailCourseProfessors().add(detailCourseProfessor);
		detailCourseProfessor.setProfessor(this);

		return detailCourseProfessor;
	}

	public DetailCourseProfessor removeDetailCourseProfessor(DetailCourseProfessor detailCourseProfessor) {
		getDetailCourseProfessors().remove(detailCourseProfessor);
		detailCourseProfessor.setProfessor(null);

		return detailCourseProfessor;
	}

	public List<DetailUniversityProfessor> getDetailUniversityProfessors() {
		return this.detailUniversityProfessors;
	}

	public void setDetailUniversityProfessors(List<DetailUniversityProfessor> detailUniversityProfessors) {
		this.detailUniversityProfessors = detailUniversityProfessors;
	}

	public DetailUniversityProfessor addDetailUniversityProfessor(DetailUniversityProfessor detailUniversityProfessor) {
		getDetailUniversityProfessors().add(detailUniversityProfessor);
		detailUniversityProfessor.setProfessor(this);

		return detailUniversityProfessor;
	}

	public DetailUniversityProfessor removeDetailUniversityProfessor(DetailUniversityProfessor detailUniversityProfessor) {
		getDetailUniversityProfessors().remove(detailUniversityProfessor);
		detailUniversityProfessor.setProfessor(null);

		return detailUniversityProfessor;
	}

	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Rating addRating(Rating rating) {
		getRatings().add(rating);
		rating.setProfessor(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setProfessor(null);

		return rating;
	}
	
	public String getFullname() {
		return this.cname+" "+this.clastname;
	}

}