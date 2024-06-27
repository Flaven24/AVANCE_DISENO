package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clarity_status database table.
 * 
 */
@Entity
@Table(name="clarity_status")
@NamedQuery(name="ClarityStatus.findAll", query="SELECT c FROM ClarityStatus c")
public class ClarityStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idclarity;

	private String cstatus;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="clarityStatus")
	private List<Rating> ratings;

	public ClarityStatus() {
	}

	public Integer getIdclarity() {
		return this.idclarity;
	}

	public void setIdclarity(Integer idclarity) {
		this.idclarity = idclarity;
	}

	public String getCstatus() {
		return this.cstatus;
	}

	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Rating addRating(Rating rating) {
		getRatings().add(rating);
		rating.setClarityStatus(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setClarityStatus(null);

		return rating;
	}

	@Override
	public String toString() {
		return this.cstatus;
	}

	
}