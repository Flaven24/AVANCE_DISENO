package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the detail_course_professor database table.
 * 
 */
@Entity
@Table(name="detail_course_professor")
@NamedQuery(name="DetailCourseProfessor.findAll", query="SELECT d FROM DetailCourseProfessor d")
public class DetailCourseProfessor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddetail;

	private Timestamp dregist;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="idcourse")
	private Course course;

	//bi-directional many-to-one association to Professor
	@ManyToOne
	@JoinColumn(name="idprofessor")
	private Professor professor;

	public DetailCourseProfessor() {
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

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}