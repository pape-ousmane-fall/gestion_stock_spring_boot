package com.esmt.gestionStock.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.esmt.gestionStock.domaine.Produit;

public interface IProduitService {
	public void EnregistrerProduit(Produit produit);
	public List<Produit> findAll();
	public Produit lastProduit();
	public Produit getProduitByIdproduit(Long id);
	public void deleteProduitById(Long id);
	Page<Produit> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}
