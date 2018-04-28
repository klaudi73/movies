package org.klaudi73.movies.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "name")
public class Names {

	//nconst	primaryName	birthYear	deathYear	primaryProfession	knownForTitles
	
	@Id
	@Column(name = "nconst", nullable = false, unique = true)
	private String nconst;
	
	@Column(name = "primary_name")
	private String primaryName;
	
	@Column(name = "birth_year")
	private Long birthYear;
	
	@Column(name = "death_year")
	private Long deathYear;
	
	public Names() {
		super();
	}

	public Names(String nconst, String primaryName, Long birthYear, Long deathYear) {
		super();
		this.nconst = nconst;
		this.primaryName = primaryName;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
	}
	
	public Names(String name[]) {
		super();
		nconst = name[0];
		primaryName = name[1];
		if (!Objects.isNull(name[2])) {
			if(!"".equals(name[2])) {
				birthYear = Long.valueOf(name[2]);
			} else {
				birthYear = null;
			}
		} else {
			birthYear = null;
		}
		if (!Objects.isNull(name[3])) {
			if(!"".equals(name[3])) {
				deathYear = Long.valueOf(name[3]);
			} else {
				deathYear = null;
			}
		} else {
			deathYear = null;
		}
		
	}


	public String getNconst() {
		return nconst;
	}

	public void setNconst(String nconst) {
		this.nconst = nconst;
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthYear == null) ? 0 : birthYear.hashCode());
		result = prime * result + ((deathYear == null) ? 0 : deathYear.hashCode());
		result = prime * result + ((nconst == null) ? 0 : nconst.hashCode());
		result = prime * result + ((primaryName == null) ? 0 : primaryName.hashCode());
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
		Names other = (Names) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "Names [nconst=" + nconst + ", primaryName=" + primaryName + ", birthYear=" + birthYear + ", deathYear="
				+ deathYear + "]";
	}

		
}
