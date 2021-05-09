package com.esmt.gestionStock.domaine;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idproduit;
	private String libelle;
	private Double prix;
	private Double quantite;

	@ManyToOne
	@JoinColumn(name = "idcategorie")
	private Categorie categorie;

	@ManyToOne
	@JoinColumn(name = "idboutique")
	private Boutique boutique;

	@OneToMany(mappedBy = "produits")
	private List<Facturation> facturation;
	
	@OneToMany(mappedBy = "produits")
	private List<Entree> entree;

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(String libelle, Double prix, Double quantite, Categorie categorie, Boutique boutique,
			List<Facturation> facturation, List<Entree> entree) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.quantite = quantite;
		this.categorie = categorie;
		this.boutique = boutique;
		this.facturation = facturation;
		this.entree = entree;
	}

	public Long getIdproduit() {
		return idproduit;
	}

	public void setIdproduit(Long idproduit) {
		this.idproduit = idproduit;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Double getQuantite() {
		return quantite;
	}

	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Boutique getBoutique() {
		return boutique;
	}

	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}

	public List<Facturation> getFacturation() {
		return facturation;
	}

	public void setFacturation(List<Facturation> facturation) {
		this.facturation = facturation;
	}

	public List<Entree> getEntree() {
		return entree;
	}

	public void setEntree(List<Entree> entree) {
		this.entree = entree;
	}

	

}
