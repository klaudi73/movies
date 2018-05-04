package org.klaudi73.movies.service;

import org.klaudi73.movies.model.PersonsPriv;

public class DataToTransferBtweenScenes {
	private String data;
	private PersonsPriv person;
	private Long loginId;
	
	public DataToTransferBtweenScenes() {
		super();
	}

	public DataToTransferBtweenScenes(String data) {
		super();
		this.data = data;
	}
	
	public DataToTransferBtweenScenes(PersonsPriv person) {
		super();
		this.person = person;
	}

	public DataToTransferBtweenScenes(Long loginId) {
		super();
		this.loginId = loginId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public PersonsPriv getPerson() {
		return person;
	}

	public void setPerson(PersonsPriv person) {
		this.person = person;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

}
