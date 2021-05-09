package com.esmt.gestionStock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.esmt.gestionStock.dao.IRoles;
import java.util.Optional;
import com.esmt.gestionStock.domaine.Roles;

@Service
public class RolesServiceImpl implements IRolesService {
	@Autowired
	IRoles rl;

	public List<Roles> findAll() {
		// TODO Auto-generated method stub
		return rl.findAll();
	}

	public Roles lastRoles() {
		// TODO Auto-generated method stub
		return rl.findTopByOrderByIdrolesDesc();
	}

	@Override
	public Roles getRoleByIdroles(Long id) {
		// TODO Auto-generated method stub
		Optional<Roles> optional = rl.findById(id);
		Roles role = null;
		if (optional.isPresent()) {
			role = optional.get();
		} else {
			throw new RuntimeException(" Role not found for id :: " + id);
		}
		return role;
	}

	@Override
	public void deleteRolesById(Long id) {
		// TODO Auto-generated method stub
		this.rl.deleteById(id);
	}

	@Override
	public Page<Roles> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.rl.findAll(pageable);
	}

	@Override
	public void EnregistrerRoles(Roles role) {
		// TODO Auto-generated method stub
		rl.save(role);
	}

}
