package com.esmt.gestionStock.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.esmt.gestionStock.dao.IUtilisateur;
import com.esmt.gestionStock.domaine.Utilisateur;
@Service
public class UtilisateurServiceImpl implements IUtilisateurService {
	@Autowired
	IUtilisateur user;
	@Override
	public void EnregistrerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		user.save(utilisateur);
	}

	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return user.findAll();
	}

	@Override
	public Utilisateur lastUtilisateur() {
		// TODO Auto-generated method stub
		return user.findTopByOrderByIdutilisateurDesc();
	}

	@Override
	public Utilisateur getUtilisateurByIdutilisateur(Long id) {
		Optional<Utilisateur> optional = user.findById(id);
		Utilisateur user = null;
		if (optional.isPresent()) {
			user = optional.get();
		} else {
			throw new RuntimeException(" user not found for id :: " + id);
		}
		return user;
	}

	@Override
	public void deleteUtilisateurById(Long id) {
		// TODO Auto-generated method stub
		this.user.deleteById(id);
	}

	@Override
	public Page<Utilisateur> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.user.findAll(pageable);
	}


}
