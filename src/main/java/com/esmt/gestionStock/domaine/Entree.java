package com.esmt.gestionStock.domaine;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Entree implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long identree;
	private Double montant;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "idproduit")
	private Produit produits;

	public Entree(Long identree, Double montant, Date date, Produit produits) {
		super();
		this.identree = identree;
		this.montant = montant;
		this.date = date;
		this.produits = produits;
	}

	public Long getIdentree() {
		return identree;
	}

	public void setIdentree(Long identree) {
		this.identree = identree;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Produit getProduits() {
		return produits;
	}

	public void setProduits(Produit produits) {
		this.produits = produits;
	}

	public Entree() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
