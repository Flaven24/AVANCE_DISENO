package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the difficulty_status database table.
 * 
 */
@Entity
@Table(name="difficulty_status")
@NamedQuery(name="DifficultyStatus.findAll", query="SELECT d FROM DifficultyStatus d")
public class DifficultyStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddifficulty;

	private String cstatus;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="difficultyStatus")
	private List<Rating> ratings;

	public DifficultyStatus() {
	}

	public Integer getIddifficulty() {
		return this.iddifficulty;
	}

	public void setIddifficulty(Integer iddifficulty) {
		this.iddifficulty = iddifficulty;
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
		rating.setDifficultyStatus(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setDifficultyStatus(null);

		return rating;
	}
	
	@Override
	public String toString() {
		return this.cstatus;
	}

}