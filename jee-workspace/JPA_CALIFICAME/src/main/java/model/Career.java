package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the career database table.
 * 
 */
@Entity
@NamedQuery(name="Career.findAll", query="SELECT c FROM Career c")
public class Career implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcareer;

	private Boolean bactive;

	private String cname;

	private Timestamp dregist;

	//bi-directional many-to-one association to University
	@ManyToOne
	@JoinColumn(name="iduniversity")
	private University university;

	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="career")
	private List<Course> courses;

	public Career() {
	}

	public Integer getIdcareer() {
		return this.idcareer;
	}

	public void setIdcareer(Integer idcareer) {
		this.idcareer = idcareer;
	}

	public Boolean getBactive() {
		return this.bactive;
	}

	public void setBactive(Boolean bactive) {
		this.bactive = bactive;
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

	public University getUniversity() {
		return this.university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course addCours(Course cours) {
		getCourses().add(cours);
		cours.setCareer(this);

		return cours;
	}

	public Course removeCours(Course cours) {
		getCourses().remove(cours);
		cours.setCareer(null);

		return cours;
	}

}