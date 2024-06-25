package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the university database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="University.findAll", query="SELECT u FROM University u"),
	@NamedQuery(name="University.findByIdUniversity", query="SELECT u FROM University u WHERE u.iduniversity=:iduniversity "),
	@NamedQuery(name="University.findByCname", query="SELECT u FROM University u WHERE u.cname LIKE :cname")
})
public class University implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iduniversity;

	private Boolean bactive;

	private String cname;

	private String cwebpage;

	private Timestamp dregist;

	//bi-directional many-to-one association to Branch
	@OneToMany(mappedBy="university")
	private List<Branch> branches;

	//bi-directional many-to-one association to Career
	@OneToMany(mappedBy="university")
	private List<Career> careers;

	//bi-directional many-to-one association to DetailUniversityProfessor
	@OneToMany(mappedBy="university")
	private List<DetailUniversityProfessor> detailUniversityProfessors;

	public University() {
	}

	public Integer getIduniversity() {
		return this.iduniversity;
	}

	public void setIduniversity(Integer iduniversity) {
		this.iduniversity = iduniversity;
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

	public String getCwebpage() {
		return this.cwebpage;
	}

	public void setCwebpage(String cwebpage) {
		this.cwebpage = cwebpage;
	}

	public Timestamp getDregist() {
		return this.dregist;
	}

	public void setDregist(Timestamp dregist) {
		this.dregist = dregist;
	}

	public List<Branch> getBranches() {
		return this.branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public Branch addBranch(Branch branch) {
		getBranches().add(branch);
		branch.setUniversity(this);

		return branch;
	}

	public Branch removeBranch(Branch branch) {
		getBranches().remove(branch);
		branch.setUniversity(null);

		return branch;
	}

	public List<Career> getCareers() {
		return this.careers;
	}

	public void setCareers(List<Career> careers) {
		this.careers = careers;
	}

	public Career addCareer(Career career) {
		getCareers().add(career);
		career.setUniversity(this);

		return career;
	}

	public Career removeCareer(Career career) {
		getCareers().remove(career);
		career.setUniversity(null);

		return career;
	}

	public List<DetailUniversityProfessor> getDetailUniversityProfessors() {
		return this.detailUniversityProfessors;
	}

	public void setDetailUniversityProfessors(List<DetailUniversityProfessor> detailUniversityProfessors) {
		this.detailUniversityProfessors = detailUniversityProfessors;
	}

	public DetailUniversityProfessor addDetailUniversityProfessor(DetailUniversityProfessor detailUniversityProfessor) {
		getDetailUniversityProfessors().add(detailUniversityProfessor);
		detailUniversityProfessor.setUniversity(this);

		return detailUniversityProfessor;
	}

	public DetailUniversityProfessor removeDetailUniversityProfessor(DetailUniversityProfessor detailUniversityProfessor) {
		getDetailUniversityProfessors().remove(detailUniversityProfessor);
		detailUniversityProfessor.setUniversity(null);

		return detailUniversityProfessor;
	}

}