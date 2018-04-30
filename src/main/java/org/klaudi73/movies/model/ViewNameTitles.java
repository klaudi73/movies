package org.klaudi73.movies.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "view_name_titles")
public class ViewNameTitles {

	@Column(name = "primary_title", length = 1000)
	private String title;
	
	@Column(name = "start_year")
	private String startYear;
	
	@Column(name = "genres")
	private String genres;
	
	@Column(name = "title_type")
	private String titleType;
	
	@Column(name = "end_year")
	private String endYear;
	
	@Column(name = "is_adult")
	private String isAdult;
	
	@Column(name = "primary_name", length = 1000)
	private String primaryName;
	
	@Column(name = "nconst")
	private String nconst;
	
	@Id
	@Column(name = "tconst")
	private String tconst;

	public ViewNameTitles() {
		super();
	}

	public ViewNameTitles(String title, String startYear, String genres, String titleType, String endYear,
			String isAdult, String primaryName, String nconst, String tconst) {
		super();
		this.title = title;
		this.startYear = startYear;
		this.genres = genres;
		this.titleType = titleType;
		this.endYear = endYear;
		this.isAdult = isAdult;
		this.primaryName = primaryName;
		this.nconst = nconst;
		this.tconst = tconst;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public String getIsAdult() {
		return isAdult;
	}

	public void setIsAdult(String isAdult) {
		this.isAdult = isAdult;
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}

	public String getNconst() {
		return nconst;
	}

	public void setNconst(String nconst) {
		this.nconst = nconst;
	}

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endYear == null) ? 0 : endYear.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + ((isAdult == null) ? 0 : isAdult.hashCode());
		result = prime * result + ((nconst == null) ? 0 : nconst.hashCode());
		result = prime * result + ((primaryName == null) ? 0 : primaryName.hashCode());
		result = prime * result + ((startYear == null) ? 0 : startYear.hashCode());
		result = prime * result + ((tconst == null) ? 0 : tconst.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		ViewNameTitles other = (ViewNameTitles) obj;
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
		if (isAdult == null) {
			if (other.isAdult != null)
				return false;
		} else if (!isAdult.equals(other.isAdult))
			return false;
		if (nconst == null) {
			if (other.nconst != null)
				return false;
		} else if (!nconst.equals(other.nconst))
			return false;
		if (primaryName == null) {
			if (other.primaryName != null)
				return false;
		} else if (!primaryName.equals(other.primaryName))
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
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
		return "ViewNameTitles [title=" + title + ", startYear=" + startYear + ", genres=" + genres + ", titleType="
				+ titleType + ", endYear=" + endYear + ", isAdult=" + isAdult + ", primaryName=" + primaryName
				+ ", nconst=" + nconst + ", tconst=" + tconst + "]";
	}
}
