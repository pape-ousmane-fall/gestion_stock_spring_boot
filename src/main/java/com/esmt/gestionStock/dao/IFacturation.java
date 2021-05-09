package com.esmt.gestionStock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmt.gestionStock.domaine.Facturation;

public interface IFacturation extends JpaRepository<Facturation, Long> {
	Facturation findTopByOrderByIdfacturationDesc();

}
