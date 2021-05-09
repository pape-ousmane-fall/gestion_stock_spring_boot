package com.esmt.gestionStock.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.esmt.gestionStock.domaine.Categorie;


public interface ICategorieService {
	public void EnregistrerCategorie(Categorie role);
	public List<Categorie> findAll();
	public Categorie lastCategorie();
	public Categorie getRoleByIdcategorie(Long id);
	public void deleteCategorieById(Long id);
	Page<Categorie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}
