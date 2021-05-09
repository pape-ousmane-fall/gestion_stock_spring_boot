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

import com.esmt.gestionStock.domaine.Boutique;
import com.esmt.gestionStock.domaine.Utilisateur;
import com.esmt.gestionStock.service.IBoutiqueService;
import com.esmt.gestionStock.service.IUtilisateurService;

@Controller
public class BoutiqueController {
	@Autowired
	IUtilisateurService users;
	@Autowired
	IBoutiqueService btq;
	
	@GetMapping("/showNewBoutiqueForm")
	public String toAddBoutique(Model model) {
		Boutique boutique = new Boutique();
		List<Utilisateur> listesutilisateur;
		listesutilisateur = users.findAll();
		model.addAttribute("listesutilisateur", listesutilisateur);
		model.addAttribute("boutique", boutique);
		return "/boutique/new_boutique";
	}

	@PostMapping("/saveBoutique")
	public String addBoutique(@ModelAttribute(value = "boutique") Boutique boutique) {
		btq.EnregistrerBoutique(boutique);
		return "redirect:/boutiques";
	}
	// display list of employees
	@GetMapping("/boutiques")
	public String viewHomePageuser(Model model) {
		return findPaginated(1, "libelle", "asc", model);		
	}


	@GetMapping("/showFormForBoutiqueUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		Boutique boutique = btq.getBoutiqueByIdboutique(id);

		List<Utilisateur> listesutilisateur;
		listesutilisateur = users.findAll();
		model.addAttribute("listesutilisateur", listesutilisateur);
		model.addAttribute("boutique", boutique);
		return "/boutique/update_boutique";
	}

	@GetMapping("/deleteBoutique/{id}")
	public String deleteBoutique(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.btq.deleteBoutiqueById(id);
		return "redirect:/boutiques";
	}

	@GetMapping("/pagess/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Boutique> page = btq.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Boutique> listBoutique = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listBoutique", listBoutique);
		return "boutique/liste";
	}

}
