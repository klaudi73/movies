package org.klaudi73.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "title_principals_imdb")
public class TitlePrincipalsIMDB {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tconst")
	private String tConst;
	
	@Column(name = "ordering")
	private Long ordering;
	
	@Column(name = "nconst")
	private String nConst;
	
	@Column(name = "category", length = 1000)
	private String category;
	
	@Column(name = "job_characters", length = 1000)
	private String jobCharacters;

	public TitlePrincipalsIMDB() {
		super();
	}

	public TitlePrincipalsIMDB(String tConst, Long ordering, String nConst, String category, String jobCharacters) {
		super();
		this.tConst = tConst;
		this.ordering = ordering;
		this.nConst = nConst;
		this.category = category;
		this.jobCharacters = jobCharacters;
	}

	public String gettConst() {
		return tConst;
	}

	public void settConst(String tConst) {
		this.tConst = tConst;
	}

	public Long getOrdering() {
		return ordering;
	}

	public void setOrdering(Long ordering) {
		this.ordering = ordering;
	}

	public String getnConst() {
		return nConst;
	}

	public void setnConst(String nConst) {
		this.nConst = nConst;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getJobCharacters() {
		return jobCharacters;
	}

	public void setJobCharacters(String jobCharacters) {
		this.jobCharacters = jobCharacters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jobCharacters == null) ? 0 : jobCharacters.hashCode());
		result = prime * result + ((nConst == null) ? 0 : nConst.hashCode());
		result = prime * result + ((ordering == null) ? 0 : ordering.hashCode());
		result = prime * result + ((tConst == null) ? 0 : tConst.hashCode());
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
		TitlePrincipalsIMDB other = (TitlePrincipalsIMDB) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jobCharacters == null) {
			if (other.jobCharacters != null)
				return false;
		} else if (!jobCharacters.equals(other.jobCharacters))
			return false;
		if (nConst == null) {
			if (other.nConst != null)
				return false;
		} else if (!nConst.equals(other.nConst))
			return false;
		if (ordering == null) {
			if (other.ordering != null)
				return false;
		} else if (!ordering.equals(other.ordering))
			return false;
		if (tConst == null) {
			if (other.tConst != null)
				return false;
		} else if (!tConst.equals(other.tConst))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TitlePrincipalsIMDB [id=" + id + ", tConst=" + tConst + ", ordering=" + ordering + ", nConst=" + nConst
				+ ", category=" + category + ", jobCharacters=" + jobCharacters + "]";
	}
}
