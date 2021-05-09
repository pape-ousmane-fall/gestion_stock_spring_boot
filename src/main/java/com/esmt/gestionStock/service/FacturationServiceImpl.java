package com.esmt.gestionStock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esmt.gestionStock.dao.IFacturation;
import com.esmt.gestionStock.domaine.Facturation;
@Service
public class FacturationServiceImpl implements IFacturationService {
	@Autowired
	IFacturation fct;

	@Override
	public void EnregistrerFacturation(Facturation facturation) {
		// TODO Auto-generated method stub
		fct.save(facturation);
	}

	@Override
	public List<Facturation> findAll() {
		// TODO Auto-generated method stub
		return fct.findAll();
	}

	@Override
	public Facturation getRoleByIdfacturation(Long id) {
		// TODO Auto-generated method stub
		Optional<Facturation> optional = fct.findById(id);
		Facturation facturation = null;
		if (optional.isPresent()) {
			facturation = optional.get();
		} else {
			throw new RuntimeException(" Role not found for id :: " + id);
		}
		return facturation;
	}

	@Override
	public void deleteFacturationById(Long id) {
		// TODO Auto-generated method stub
		fct.deleteById(id);
	}

	@Override
	public Page<Facturation> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.fct.findAll(pageable);
	}
	

}
