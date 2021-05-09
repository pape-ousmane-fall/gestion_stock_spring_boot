package com.esmt.gestionStock.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.esmt.gestionStock.domaine.Facturation;

public interface IFacturationService {
	public void EnregistrerFacturation(Facturation facturation);
	public List<Facturation> findAll();
	public Facturation getRoleByIdfacturation(Long id);
	public void deleteFacturationById(Long id);
	Page<Facturation> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
