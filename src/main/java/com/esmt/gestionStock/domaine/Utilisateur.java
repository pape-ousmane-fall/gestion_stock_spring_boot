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
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idutilisateur;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String login;
	private String password;
	@ManyToOne
	@JoinColumn(name = "idroles")
	private Roles roles;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Boutique> boutique;
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(Long idutilisateur, String nom, String prenom, String adresse, String tel, String login,
			String password, Roles roles, List<Boutique> boutique) {
		super();
		this.idutilisateur = idutilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.login = login;
		this.password = password;
		this.roles = roles;
		this.boutique = boutique;
	}
	public Long getIdutilisateur() {
		return idutilisateur;
	}
	public void setIdutilisateur(Long idutilisateur) {
		this.idutilisateur = idutilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	public List<Boutique> getBoutique() {
		return boutique;
	}
	public void setBoutique(List<Boutique> boutique) {
		this.boutique = boutique;
	}


	

}
