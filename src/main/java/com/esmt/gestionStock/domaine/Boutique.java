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
public class Boutique implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idboutique;
	private String libelle;
	private String adresse;
	
	@ManyToOne
	@JoinColumn(name = "idutilisateur")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "boutique")
	private List<Produit> produit;

	public Boutique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boutique(String libelle, String adresse, Utilisateur utilisateur, List<Produit> produit) {
		super();
		this.libelle = libelle;
		this.adresse = adresse;
		this.utilisateur = utilisateur;
		this.produit = produit;
	}

	public Long getIdboutique() {
		return idboutique;
	}

	public void setIdboutique(Long idboutique) {
		this.idboutique = idboutique;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Produit> getProduit() {
		return produit;
	}

	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}

	

	
	
}
