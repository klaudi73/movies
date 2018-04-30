package org.klaudi73.movies.service;

import org.klaudi73.movies.model.Login;
import org.klaudi73.movies.model.Persons;

public class DataToTransferBtweenScenes {
	private String data;
	private Persons person;
	private Long loginId;
	
	public DataToTransferBtweenScenes() {
		super();
	}

	public DataToTransferBtweenScenes(String data) {
		super();
		this.data = data;
	}
	
	public DataToTransferBtweenScenes(Persons person) {
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
	
	public Persons getPerson() {
		return person;
	}

	public void setPerson(Persons person) {
		this.person = person;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

}
