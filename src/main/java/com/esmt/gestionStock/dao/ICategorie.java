package com.esmt.gestionStock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmt.gestionStock.domaine.Categorie;

public interface ICategorie extends JpaRepository<Categorie, Long> {
	Categorie findTopByOrderByIdcategorieDesc();

}
