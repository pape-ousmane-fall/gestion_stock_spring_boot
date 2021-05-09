package com.esmt.gestionStock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esmt.gestionStock.dao.IFacture;
import com.esmt.gestionStock.domaine.Facture;
@Service
public class FactureServiceImpl implements IFactureService {
	@Autowired
	IFacture fct;

	@Override
	public void EnregistrerFacture(Facture facture) {
		// TODO Auto-generated method stub
		fct.save(facture);
	}

	@Override
	public List<Facture> findAll() {
		// TODO Auto-generated method stub
		return fct.findAll();
	}

	@Override
	public Facture lastFacture() {
		// TODO Auto-generated method stub
		return fct.findTopByOrderByIdfactureDesc();
	}

	@Override
	public Facture getRoleByIdfacture(Long id) {
		Optional<Facture> optional = fct.findById(id);
		Facture facture = null;
		if (optional.isPresent()) {
			facture = optional.get();
		} else {
			throw new RuntimeException(" Role not found for id :: " + id);
		}
		return facture;
	}

	@Override
	public void deleteFactureById(Long id) {
		// TODO Auto-generated method stub
		fct.deleteById(id);
	}

	@Override
	public Page<Facture> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.fct.findAll(pageable);
	}

	

}
