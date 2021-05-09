package com.esmt.gestionStock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esmt.gestionStock.dao.IEntree;
import com.esmt.gestionStock.domaine.Entree;
@Service
public class EntreeServiceImpl implements IEntreeService {
	@Autowired
	IEntree ent;

	@Override
	public void EnregistrerEntree(Entree entree) {
		// TODO Auto-generated method stub
		ent.save(entree);
	}

	@Override
	public List<Entree> findAll() {
		// TODO Auto-generated method stub
		return ent.findAll();
	}

	@Override
	public Entree getRoleByIdEntree(Long id) {
		// TODO Auto-generated method stub
		Optional<Entree> optional = ent.findById(id);
		Entree entree = null;
		if (optional.isPresent()) {
			entree = optional.get();
		} else {
			throw new RuntimeException(" Role not found for id :: " + id);
		}
		return entree;
	}

	@Override
	public void deleteEntreeById(Long id) {
		// TODO Auto-generated method stub
		ent.deleteById(id);
		
	}

	@Override
	public Page<Entree> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.ent.findAll(pageable);
	}
	

	
}
