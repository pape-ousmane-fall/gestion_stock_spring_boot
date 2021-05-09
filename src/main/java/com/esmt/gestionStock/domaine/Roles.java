package com.esmt.gestionStock.domaine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idroles;
	private String status;
	@OneToMany(mappedBy = "roles")
	private List<Utilisateur> utilisateur;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(String status) {
		super();
		this.status = status;
	}

	public long getIdroles() {
		return idroles;
	}

	public void setIdroles(long idroles) {
		this.idroles = idroles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
