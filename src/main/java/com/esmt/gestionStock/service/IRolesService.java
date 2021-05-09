package com.esmt.gestionStock.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.esmt.gestionStock.domaine.Roles;

public interface IRolesService {
	public void EnregistrerRoles(Roles role);
	public List<Roles> findAll();
	public Roles lastRoles();
	public Roles getRoleByIdroles(Long id);
	public void deleteRolesById(Long id);
	Page<Roles> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
