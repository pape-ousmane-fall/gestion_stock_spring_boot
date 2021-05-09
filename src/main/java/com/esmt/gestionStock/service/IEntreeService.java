package com.esmt.gestionStock.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.esmt.gestionStock.domaine.Entree;


public interface IEntreeService {
	public void EnregistrerEntree(Entree entree);
	public List<Entree> findAll();
	public Entree getRoleByIdEntree(Long id);
	public void deleteEntreeById(Long id);
	Page<Entree> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}
