package com.esmt.gestionStock.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.esmt.gestionStock.domaine.Boutique;


public interface IBoutiqueService {
	public void EnregistrerBoutique(Boutique boutique);
	public List<Boutique> findAll();
	public Boutique lastBoutique();
	public Boutique getBoutiqueByIdboutique(Long id);
	public void deleteBoutiqueById(Long id);
	Page<Boutique> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
