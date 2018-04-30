package org.klaudi73.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "view_person")
public class ViewPerson {
	
	@Id
	@Column(name = "nconst")
	private String nConst;
	
	@Column(name = "birth_year")
	private Long birthYear;
	
	@Column(name = "death_year")
	private Long deathYear;
	
	@Column(name = "primary_name", length = 1000)
	private String name;

	public ViewPerson() {
		super();
	}

	public ViewPerson(String nConst, Long birthYear, Long deathYear, String name) {
		super();
		this.nConst = nConst;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.name = name;
	}

	public String getnConst() {
		return nConst;
	}

	public void setnConst(String nConst) {
		this.nConst = nConst;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthYear == null) ? 0 : birthYear.hashCode());
		result = prime * result + ((deathYear == null) ? 0 : deathYear.hashCode());
		result = prime * result + ((nConst == null) ? 0 : nConst.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ViewPerson other = (ViewPerson) obj;
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
		if (nConst == null) {
			if (other.nConst != null)
				return false;
		} else if (!nConst.equals(other.nConst))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ViewActor [nConst=" + nConst + ", birthYear=" + birthYear + ", deathYear=" + deathYear + ", name="
				+ name + "]";
	}
}
