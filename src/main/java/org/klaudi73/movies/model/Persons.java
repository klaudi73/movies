package org.klaudi73.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Persons {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nconst")
	private String nconst;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "birth_year")
	private Long birthYear;
	
	@Column(name = "death_year")
	private Long deathYear;
	
	@Column(name = "idlogin")
	private Long idLogin;
	
	@Column(name = "rating")
	private Long rating;
	
	@Column(name = "description", length = 1000)
	private String description;

	public Persons() {
		super();
	}

	public Persons(String nconst, String primaryName, Long birthYear, Long deathYear, Long idLogin, Long rating,
			String description) {
		super();
		this.nconst = nconst;
		this.name = primaryName;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.idLogin = idLogin;
		this.rating = rating;
		this.description = description;
	}

	public Persons(Long id, String nconst, String primaryName, Long birthYear, Long deathYear, Long idLogin,
			Long rating, String description) {
		super();
		this.id = id;
		this.nconst = nconst;
		this.name = primaryName;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.idLogin = idLogin;
		this.rating = rating;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNconst() {
		return nconst;
	}

	public void setNconst(String nconst) {
		this.nconst = nconst;
	}

	public String getPrimaryName() {
		return name;
	}

	public void setPrimaryName(String primaryName) {
		this.name = primaryName;
	}

	public Long getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Long birthYear) {
		this.birthYear = birthYear;
	}

	public Long getDeathYear() {
		return deathYear;
	}

	public void setDeathYear(Long deathYear) {
		this.deathYear = deathYear;
	}

	public Long getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(Long idLogin) {
		this.idLogin = idLogin;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthYear == null) ? 0 : birthYear.hashCode());
		result = prime * result + ((deathYear == null) ? 0 : deathYear.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idLogin == null) ? 0 : idLogin.hashCode());
		result = prime * result + ((nconst == null) ? 0 : nconst.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persons other = (Persons) obj;
		if (birthYear == null) {
			if (other.birthYear != null)
				return false;
		} else if (!birthYear.equals(other.birthYear))
			return false;
		if (deathYear == null) {
			if (other.deathYear != null)
				return false;
		} else if (!deathYear.equals(other.deathYear))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idLogin == null) {
			if (other.idLogin != null)
				return false;
		} else if (!idLogin.equals(other.idLogin))
			return false;
		if (nconst == null) {
			if (other.nconst != null)
				return false;
		} else if (!nconst.equals(other.nconst))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persons [id=" + id + ", nconst=" + nconst + ", primaryName=" + name + ", birthYear=" + birthYear
				+ ", deathYear=" + deathYear + ", idLogin=" + idLogin + ", rating=" + rating + ", description="
				+ description + "]";
	}
}
