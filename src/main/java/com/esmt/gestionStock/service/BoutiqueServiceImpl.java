package com.esmt.gestionStock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esmt.gestionStock.dao.IBoutique;
import com.esmt.gestionStock.domaine.Boutique;

@Service
public class BoutiqueServiceImpl implements IBoutiqueService {
	@Autowired
	IBoutique btq;

	@Override
	public void EnregistrerBoutique(Boutique boutique) {
		// TODO Auto-generated method stub
		btq.save(boutique);
	}

	@Override
	public List<Boutique> findAll() {
		// TODO Auto-generated method stub
		return btq.findAll();
	}

	@Override
	public Boutique lastBoutique() {
		// TODO Auto-generated method stub
		return btq.findTopByOrderByIdboutiqueDesc();
	}

	@Override
	public Boutique getBoutiqueByIdboutique(Long id) {
		Optional<Boutique> optional = btq.findById(id);
		Boutique boutique = null;
		if (optional.isPresent()) {
			boutique = optional.get();
		} else {
			throw new RuntimeException(" user not found for id :: " + id);
		}
		return boutique;
	}

	@Override
	public void deleteBoutiqueById(Long id) {
		// TODO Auto-generated method stub
		btq.deleteById(id);
	}

	@Override
	public Page<Boutique> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.btq.findAll(pageable);
	}


	
	
}
