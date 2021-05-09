package com.esmt.gestionStock.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.esmt.gestionStock.domaine.Produit;

public interface IProduit extends JpaRepository<Produit, Long> {
	Produit findTopByOrderByIdproduitDesc();
}
