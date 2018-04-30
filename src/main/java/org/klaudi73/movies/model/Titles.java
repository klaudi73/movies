package org.klaudi73.movies.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "titles")
public class Titles {
	
	@Id
	@Column(name = "tconst", nullable = false, unique = true)
	private String tconst;
	
	@Column(name = "title_type")
	private String titleType;
	
	@Column(name = "primary_title", length = 1000)
	private String primaryTitle;
	
	@Column(name = "original_title", length = 1000)
	private String originalTitle;
	
	@Column(name = "is_adult")
	private Long isAdult;
	
	@Column(name = "start_year")
	private Long startYear;
	
	@Column(name = "end_year")
	private Long endYear;
	
	@Column(name = "runtime_minutes")
	private Long runtimeMinutes;
	
	@Column(name = "genres")
	private String genres;

	public Titles() {
		super();
	}

	public Titles(String tconst, String titleType, String primaryTitle, String originalTitle, Long isAdult,
			Long startYear, Long endYear, Long runtimeMinutes, String genres) {
		super();
		this.tconst = tconst;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.originalTitle = originalTitle;
		this.isAdult = isAdult;
		this.startYear = startYear;
		this.endYear = endYear;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
	}
	
	public Titles(String title[]) {
		super();
		tconst = title[0];
		titleType = title[1];
		if (!Objects.isNull(title[2])) {
			primaryTitle=title[2];
		} else {
			primaryTitle = null;
		}
		if (!Objects.isNull(title[3])) {
			originalTitle = title[3];
		} else {
			originalTitle = null;
		}
		if (!Objects.isNull(title[4])) {
			if(!"".equals(title[5])) {
				isAdult = Long.valueOf(title[4]);
			} else {
				isAdult = null;
			}
		} else {
			isAdult = null;
		}
		if (!Objects.isNull(title[5])) {
			if(!"".equals(title[5])) {
				startYear = Long.valueOf(title[5]);
			} else {
				startYear = null;
			}
		}
		if (!Objects.isNull(title[6])) {
			if(!"".equals(title[6])) {
				endYear = Long.valueOf(title[6]);
			} else {
				endYear = null;
			}
		}
		if (!Objects.isNull(title[7])) {
			if(!"".equals(title[7])) {
				runtimeMinutes = Long.valueOf(title[7]);
			} else {
				runtimeMinutes = null;
			}
		}
		genres = title[8];
	}

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getPrimaryTitle() {
		return primaryTitle;
	}

	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public Long getIsAdult() {
		return isAdult;
	}

	public void setIsAdult(Long isAdult) {
		this.isAdult = isAdult;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endYear == null) ? 0 : endYear.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + ((isAdult == null) ? 0 : isAdult.hashCode());
		result = prime * result + ((originalTitle == null) ? 0 : originalTitle.hashCode());
		result = prime * result + ((primaryTitle == null) ? 0 : primaryTitle.hashCode());
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
		Titles other = (Titles) obj;
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
		if (originalTitle == null) {
			if (other.originalTitle != null)
				return false;
		} else if (!originalTitle.equals(other.originalTitle))
			return false;
		if (primaryTitle == null) {
			if (other.primaryTitle != null)
				return false;
		} else if (!primaryTitle.equals(other.primaryTitle))
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
		return "Titles [tconst=" + tconst + ", titleType=" + titleType + ", primaryTitle=" + primaryTitle
				+ ", originalTitle=" + originalTitle + ", isAdult=" + isAdult + ", startYear=" + startYear
				+ ", endYear=" + endYear + ", runtimeMinutes=" + runtimeMinutes + ", genres=" + genres + "]";
	}
	
	
	
}
