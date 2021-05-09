package com.esmt.gestionStock.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.esmt.gestionStock.domaine.Facture;

public interface IFacture extends JpaRepository<Facture, Long> {
	Facture	findTopByOrderByIdfactureDesc();

}
