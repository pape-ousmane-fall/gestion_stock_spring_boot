package com.esmt.gestionStock.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.esmt.gestionStock.domaine.Utilisateur;

public interface IUtilisateur extends JpaRepository<Utilisateur, Long> {
	Utilisateur findTopByOrderByIdutilisateurDesc();
}
