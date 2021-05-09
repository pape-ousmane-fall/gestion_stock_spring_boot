package com.esmt.gestionStock.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.esmt.gestionStock.domaine.Facture;

public interface IFactureService {
	public void EnregistrerFacture(Facture facture);
	public List<Facture> findAll();
	public Facture lastFacture();
	public Facture getRoleByIdfacture(Long id);
	public void deleteFactureById(Long id);
	Page<Facture> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
