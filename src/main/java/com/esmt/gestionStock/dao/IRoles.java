package com.esmt.gestionStock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmt.gestionStock.domaine.Roles;

public interface IRoles extends JpaRepository<Roles, Long> {
	Roles findTopByOrderByIdrolesDesc();
}
