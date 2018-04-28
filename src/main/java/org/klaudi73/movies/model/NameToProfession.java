package org.klaudi73.movies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "name_to_profession")
public class NameToProfession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nconst")
	private String nconst;

	@Column(name = "id_profession")
	private Long idProfession;

	public NameToProfession() {
		super();
	}

	public NameToProfession(String nconst, Long idProfession) {
		super();
		this.nconst = nconst;
		this.idProfession = idProfession;
	}

	public NameToProfession(Long id, String nconst, Long idProfession) {
		super();
		this.id = id;
		this.nconst = nconst;
		this.idProfession = idProfession;
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

	public Long getIdProfession() {
		return idProfession;
	}

	public void setIdProfession(Long idProfession) {
		this.idProfession = idProfession;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idProfession == null) ? 0 : idProfession.hashCode());
		result = prime * result + ((nconst == null) ? 0 : nconst.hashCode());
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
		NameToProfession other = (NameToProfession) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idProfession == null) {
			if (other.idProfession != null)
				return false;
		} else if (!idProfession.equals(other.idProfession))
			return false;
		if (nconst == null) {
			if (other.nconst != null)
				return false;
		} else if (!nconst.equals(other.nconst))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NameToProfession [id=" + id + ", nconst=" + nconst + ", idProfession=" + idProfession + "]";
	}
	
	
	
}
