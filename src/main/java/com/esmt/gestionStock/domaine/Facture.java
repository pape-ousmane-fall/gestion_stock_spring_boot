package com.esmt.gestionStock.domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Facture implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idfacture;
	private Double quantitefact;
	@ManyToOne
	@JoinColumn(name = "idfacturation")
	private Facturation facturation;
	
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture(Long idfacture, Double quantitefact, Facturation facturation) {
		super();
		this.idfacture = idfacture;
		this.quantitefact = quantitefact;
		this.facturation = facturation;
	}

	public Long getIdfacture() {
		return idfacture;
	}

	public void setIdfacture(Long idfacture) {
		this.idfacture = idfacture;
	}

	public Double getQuantitefact() {
		return quantitefact;
	}

	public void setQuantitefact(Double quantitefact) {
		this.quantitefact = quantitefact;
	}

	public Facturation getFacturation() {
		return facturation;
	}

	public void setFacturation(Facturation facturation) {
		this.facturation = facturation;
	}

	
	

}
