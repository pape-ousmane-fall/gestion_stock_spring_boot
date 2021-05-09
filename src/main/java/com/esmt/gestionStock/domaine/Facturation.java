package com.esmt.gestionStock.domaine;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Facturation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idfacturation;
	private Double montant;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@OneToMany(mappedBy = "facturation")
	private List<Facture> facture;

	@ManyToOne
	@JoinColumn(name = "idproduit")
	private Produit produits;

	public Facturation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facturation(Long idfacturation, Double montant, Date date, List<Facture> facture, Produit produits) {
		super();
		this.idfacturation = idfacturation;
		this.montant = montant;
		this.date = date;
		this.facture = facture;
		this.produits = produits;
	}

	public Long getIdfacturation() {
		return idfacturation;
	}

	public void setIdfacturation(Long idfacturation) {
		this.idfacturation = idfacturation;
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

	public List<Facture> getFacture() {
		return facture;
	}

	public void setFacture(List<Facture> facture) {
		this.facture = facture;
	}

	public Produit getProduits() {
		return produits;
	}

	public void setProduits(Produit produits) {
		this.produits = produits;
	}

	


}
