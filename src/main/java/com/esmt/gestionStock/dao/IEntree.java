package com.esmt.gestionStock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmt.gestionStock.domaine.Entree;

public interface IEntree extends JpaRepository<Entree,Long> {
	List<Entree> findTopByOrderByIdentreeDesc();

}
