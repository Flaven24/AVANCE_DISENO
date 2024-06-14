package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcourse;

	private Boolean bactive;

	private String cname;

	private Timestamp dregist;

	private Integer nsemester;

	//bi-directional many-to-one association to Career
	@ManyToOne
	@JoinColumn(name="idcareer")
	private Career career;

	//bi-directional many-to-one association to DetailCourseProfessor
	@OneToMany(mappedBy="course")
	private List<DetailCourseProfessor> detailCourseProfessors;

	public Course() {
	}

	public Integer getIdcourse() {
		return this.idcourse;
	}

	public void setIdcourse(Integer idcourse) {
		this.idcourse = idcourse;
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

	public Integer getNsemester() {
		return this.nsemester;
	}

	public void setNsemester(Integer nsemester) {
		this.nsemester = nsemester;
	}

	public Career getCareer() {
		return this.career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public List<DetailCourseProfessor> getDetailCourseProfessors() {
		return this.detailCourseProfessors;
	}

	public void setDetailCourseProfessors(List<DetailCourseProfessor> detailCourseProfessors) {
		this.detailCourseProfessors = detailCourseProfessors;
	}

	public DetailCourseProfessor addDetailCourseProfessor(DetailCourseProfessor detailCourseProfessor) {
		getDetailCourseProfessors().add(detailCourseProfessor);
		detailCourseProfessor.setCourse(this);

		return detailCourseProfessor;
	}

	public DetailCourseProfessor removeDetailCourseProfessor(DetailCourseProfessor detailCourseProfessor) {
		getDetailCourseProfessors().remove(detailCourseProfessor);
		detailCourseProfessor.setCourse(null);

		return detailCourseProfessor;
	}

}