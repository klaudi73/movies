package org.klaudi73.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "titles_priv")
public class TitlesPriv {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tconst")
	private String tconst;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "start_year")
	private Long startYear;
	
	@Column(name = "end_year")
	private Long endYear;
	
	@Column(name = "title_type")
	private String titleType;
	
	@Column(name = "runtime_minutes")
	private Long runtimeMinutes;
	
	@Column(name = "genres")
	private String genres;
	
	@Column(name = "idlogin")
	private Long idLogin;
	
	@Column(name = "rating")
	private Long rating;
	
	@Column(name = "description", length = 1000)
	private String description;

	public TitlesPriv() {
		super();
	}

	public TitlesPriv(String tconst, String name, Long startYear, Long endYear, String titleType, Long runtimeMinutes,
			String genres, Long idLogin, Long rating, String description) {
		super();
		this.tconst = tconst;
		this.name = name;
		this.startYear = startYear;
		this.endYear = endYear;
		this.titleType = titleType;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
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

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStartYear() {
		return startYear;
	}

	public void setStartYear(Long startYear) {
		this.startYear = startYear;
	}

	public Long getEndYear() {
		return endYear;
	}

	public void setEndYear(Long endYear) {
		this.endYear = endYear;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public Long getRuntimeMinutes() {
		return runtimeMinutes;
	}

	public void setRuntimeMinutes(Long runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}
	
	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endYear == null) ? 0 : endYear.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idLogin == null) ? 0 : idLogin.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((runtimeMinutes == null) ? 0 : runtimeMinutes.hashCode());
		result = prime * result + ((startYear == null) ? 0 : startYear.hashCode());
		result = prime * result + ((tconst == null) ? 0 : tconst.hashCode());
		result = prime * result + ((titleType == null) ? 0 : titleType.hashCode());
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
		TitlesPriv other = (TitlesPriv) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endYear == null) {
			if (other.endYear != null)
				return false;
		} else if (!endYear.equals(other.endYear))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
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
		if (runtimeMinutes == null) {
			if (other.runtimeMinutes != null)
				return false;
		} else if (!runtimeMinutes.equals(other.runtimeMinutes))
			return false;
		if (startYear == null) {
			if (other.startYear != null)
				return false;
		} else if (!startYear.equals(other.startYear))
			return false;
		if (tconst == null) {
			if (other.tconst != null)
				return false;
		} else if (!tconst.equals(other.tconst))
			return false;
		if (titleType == null) {
			if (other.titleType != null)
				return false;
		} else if (!titleType.equals(other.titleType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TitlesPriv [id=" + id + ", tconst=" + tconst + ", name=" + name + ", startYear=" + startYear
				+ ", endYear=" + endYear + ", titleType=" + titleType + ", runtimeMinutes=" + runtimeMinutes
				+ ", genres=" + genres + ", idLogin=" + idLogin + ", rating=" + rating + ", description=" + description
				+ "]";
	}	
}
