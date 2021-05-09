package com.esmt.gestionStock.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.esmt.gestionStock.domaine.Utilisateur;

public interface IUtilisateurService {
	
	public void EnregistrerUtilisateur(Utilisateur utilisateur);
	public List<Utilisateur> findAll();
	public Utilisateur lastUtilisateur();
	public Utilisateur getUtilisateurByIdutilisateur(Long id);
	public void deleteUtilisateurById(Long id);
	Page<Utilisateur> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

	

}
