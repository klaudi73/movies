package org.klaudi73.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "name_to_title")
public class NameToTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nconst")
	private String nconst;

	@Column(name = "tconst")
	private String tconst;

	public NameToTitle() {
		super();
	}

	public NameToTitle(String nconst, String tconst) {
		super();
		this.nconst = nconst;
		this.tconst = tconst;
	}

	public NameToTitle(Long id, String nconst, String tconst) {
		super();
		this.id = id;
		this.nconst = nconst;
		this.tconst = tconst;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nconst == null) ? 0 : nconst.hashCode());
		result = prime * result + ((tconst == null) ? 0 : tconst.hashCode());
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
		NameToTitle other = (NameToTitle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nconst == null) {
			if (other.nconst != null)
				return false;
		} else if (!nconst.equals(other.nconst))
			return false;
		if (tconst == null) {
			if (other.tconst != null)
				return false;
		} else if (!tconst.equals(other.tconst))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NameToTitle [id=" + id + ", nconst=" + nconst + ", tconst=" + tconst + "]";
	}
	
	
}
