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
import com.esmt.gestionStock.domaine.Utilisateur;
import com.esmt.gestionStock.service.IRolesService;
import com.esmt.gestionStock.service.IUtilisateurService;
@Controller
public class UtilisateurController {
	@Autowired
	IUtilisateurService user;
	@Autowired
	IRolesService rlee;
	
	@GetMapping("/showNewUtilisateurForm")
	public String toAddUtilisateur(Model model) {
		Utilisateur utilisateur = new Utilisateur();
		List<Roles> listeroles;
		listeroles = rlee.findAll();
		model.addAttribute("listeroles", listeroles);
		model.addAttribute("utilisateur", utilisateur);
		return "/utilisateur/new_utilisateur";
	}

	@PostMapping("/saveUtilisateur")
	public String addUtilisateur(@ModelAttribute(value = "utilisateur") Utilisateur utilisateur) {
		user.EnregistrerUtilisateur(utilisateur);
		return "redirect:/utilisateurs";
	}
	@PostMapping("/process_register")
	public String processrRgister(@ModelAttribute(value = "utilisateur") Utilisateur utilisateur) {
		user.EnregistrerUtilisateur(utilisateur);
		return "redirect:/";
	}
	// display list of employees
	@GetMapping("/utilisateurs")
	public String viewHomePageuser(Model model) {
		return findPaginated(1, "nom", "asc", model);		
	}


	@GetMapping("/showFormForUtilisateurUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		Utilisateur utilisateur = user.getUtilisateurByIdutilisateur(id);
		List<Roles> listeroles;
		listeroles = rlee.findAll();
		model.addAttribute("listeroles", listeroles);
		model.addAttribute("utilisateur", utilisateur);
		return "/utilisateur/update_utilisateur";
	}

	@GetMapping("/deleteUtilisateur/{id}")
	public String deleteRoles(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.user.deleteUtilisateurById(id);
		return "redirect:/utilisateurs";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Utilisateur> page = user.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Utilisateur> listUtilisateur = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listUtilisateur", listUtilisateur);
		return "utilisateur/liste";
	}
	

}
