package com.esmt.gestionStock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmt.gestionStock.domaine.Utilisateur;

public interface ILoginDetails extends JpaRepository<Utilisateur, Long> {
//	@Query("SELECT u FROM Utilisateur WHERE u.login = ?1")
	Utilisateur findByLogin(String user);
}
