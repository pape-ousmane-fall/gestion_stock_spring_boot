package com.esmt.gestionStock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esmt.gestionStock.dao.IProduit;
import com.esmt.gestionStock.domaine.Produit;
@Service
public class ProduitServiceImpl implements IProduitService {
	@Autowired
	IProduit pdt;

	@Override
	public void EnregistrerProduit(Produit produit) {
		// TODO Auto-generated method stub
		pdt.save(produit);
	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return pdt.findAll();
	}

	@Override
	public Produit lastProduit() {
		// TODO Auto-generated method stub
		return pdt.findTopByOrderByIdproduitDesc();
	}

	@Override
	public Produit getProduitByIdproduit(Long id) {
		Optional<Produit> optional = pdt.findById(id);
		Produit produit = null;
		if (optional.isPresent()) {
			produit = optional.get();
		} else {
			throw new RuntimeException(" user not found for id :: " + id);
		}
		return produit;
	}

	@Override
	public void deleteProduitById(Long id) {
		// TODO Auto-generated method stub
		pdt.deleteById(id);
	}

	@Override
	public Page<Produit> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
				Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
					Sort.by(sortField).descending();
				
				Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
				return this.pdt.findAll(pageable);
	}
	
}
