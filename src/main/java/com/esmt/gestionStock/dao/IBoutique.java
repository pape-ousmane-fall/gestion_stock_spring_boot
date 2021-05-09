package com.esmt.gestionStock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmt.gestionStock.domaine.Boutique;

public interface IBoutique extends JpaRepository<Boutique, Long> {
	
	Boutique findTopByOrderByIdboutiqueDesc();

}
