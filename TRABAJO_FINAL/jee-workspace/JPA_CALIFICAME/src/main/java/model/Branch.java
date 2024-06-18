package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the branch database table.
 * 
 */
@Entity
@NamedQuery(name="Branch.findAll", query="SELECT b FROM Branch b")
public class Branch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idbranch;

	private Boolean bactive;

	private String ccity;

	private String cname;

	private Timestamp dregist;

	//bi-directional many-to-one association to University
	@ManyToOne
	@JoinColumn(name="iduniversity")
	private University university;

	public Branch() {
	}

	public Integer getIdbranch() {
		return this.idbranch;
	}

	public void setIdbranch(Integer idbranch) {
		this.idbranch = idbranch;
	}

	public Boolean getBactive() {
		return this.bactive;
	}

	public void setBactive(Boolean bactive) {
		this.bactive = bactive;
	}

	public String getCcity() {
		return this.ccity;
	}

	public void setCcity(String ccity) {
		this.ccity = ccity;
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

}