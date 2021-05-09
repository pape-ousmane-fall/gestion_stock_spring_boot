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

import com.esmt.gestionStock.domaine.Entree;
import com.esmt.gestionStock.domaine.Produit;
import com.esmt.gestionStock.service.IEntreeService;
import com.esmt.gestionStock.service.IProduitService;
@Controller
public class EntreeController {
	@Autowired
	private IEntreeService rle;
	@Autowired
	private IProduitService prod;

	@GetMapping("/showNewEntreeForm")
	public String toAddEntree(Model model) {
		Entree entree = new Entree();
		List<Produit> listesproduit;
		listesproduit = prod.findAll();
		model.addAttribute("listesproduit", listesproduit);
		model.addAttribute("entree", entree);
		return "/Entree/new_entree";
	}

	@PostMapping("/saveEntree")
	public String addEntree(@ModelAttribute(value = "entree") Entree entree) {
		rle.EnregistrerEntree(entree);
		return "redirect:/entrees";
	}
	// display list of employees
	@GetMapping("/entrees")
	public String viewHomePageuser(Model model) {
		return findPaginated(1, "montant", "asc", model);		
	}


	@GetMapping("/showFormForEntreeUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		Entree entree = rle.getRoleByIdEntree(id);

		List<Produit> listesproduit;
		listesproduit = prod.findAll();
		model.addAttribute("listesproduit", listesproduit);
		model.addAttribute("entree", entree);
		return "/entree/update_entree";
	}

	@GetMapping("/deleteEntree/{id}")
	public String deleteEntree(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.rle.deleteEntreeById(id);
		return "redirect:/entrees";
	}

	@GetMapping("/pagent/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Entree> page = rle.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Entree> listentree = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listentree", listentree);
		return "entree/liste";
	}
}
