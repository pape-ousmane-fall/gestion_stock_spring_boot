package com.esmt.gestionStock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esmt.gestionStock.dao.ICategorie;
import com.esmt.gestionStock.domaine.Categorie;
@Service
public class CategorieServiceImpl implements ICategorieService {
	@Autowired
	ICategorie ctg;

	public void EnregistrerCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		ctg.save(categorie);
	}

	@Override
	public List<Categorie> findAll() {
		// TODO Auto-generated method stub
		return ctg.findAll();
	}

	@Override
	public Categorie lastCategorie() {
		// TODO Auto-generated method stub
		return ctg.findTopByOrderByIdcategorieDesc();
	}

	@Override
	public Categorie getRoleByIdcategorie(Long id) {
		// TODO Auto-generated method stub
				Optional<Categorie> optional = ctg.findById(id);
				Categorie categorie = null;
				if (optional.isPresent()) {
					categorie = optional.get();
				} else {
					throw new RuntimeException(" Role not found for id :: " + id);
				}
				return categorie;
	}

	@Override
	public void deleteCategorieById(Long id) {
		// TODO Actuto-generated method stub
		ctg.deleteById(id);
	}

	@Override
	public Page<Categorie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.ctg.findAll(pageable);
	}

	

}
