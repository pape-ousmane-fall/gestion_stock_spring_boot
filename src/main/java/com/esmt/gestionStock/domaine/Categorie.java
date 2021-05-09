package com.esmt.gestionStock.domaine;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idcategorie;
	private String libelle;
	
	@OneToMany(mappedBy = "categorie")
	private List<Produit> produit;

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(Long idcategorie, String libelle) {
		super();
		this.idcategorie = idcategorie;
		this.libelle = libelle;
	}

	public Long getIdcategorie() {
		return idcategorie;
	}

	public void setIdcategorie(Long idcategorie) {
		this.idcategorie = idcategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

	
}
