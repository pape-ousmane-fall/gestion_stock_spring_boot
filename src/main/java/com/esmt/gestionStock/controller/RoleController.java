package com.esmt.gestionStock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.esmt.gestionStock.domaine.Roles;
import com.esmt.gestionStock.service.IRolesService;

@Controller
public class RoleController {
	@Autowired
	private IRolesService rle;

	@GetMapping("/showNewRolesForm")
	public String toAddRoles(Model model) {
		Roles role = new Roles();
		model.addAttribute("roles", role);
		return "/roles/new_role";
	}

	@PostMapping("/saveRole")
	public String addRoles(@ModelAttribute(value = "roles") Roles role) {
		rle.EnregistrerRoles(role);
		return "redirect:/role";
	}
	// display list of employees
	@GetMapping("/role")
	public String viewHomePage(Model model) {
		return findPaginated(1, "status", "asc", model);		
	}


	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		Roles roles = rle.getRoleByIdroles(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("roles", roles);
		return "/roles/update_roles";
	}

	@GetMapping("/deleteRole/{id}")
	public String deleteRoles(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.rle.deleteRolesById(id);
		return "redirect:/role";
	}

	@GetMapping("/pages/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Roles> page = rle.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Roles> listRoles = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listeroles", listRoles);
		return "roles/liste";
	}
}
