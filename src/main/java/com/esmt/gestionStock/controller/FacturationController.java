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

import com.esmt.gestionStock.domaine.Facturation;
import com.esmt.gestionStock.domaine.Produit;
import com.esmt.gestionStock.service.IFacturationService;
import com.esmt.gestionStock.service.IProduitService;


@Controller
public class FacturationController {

	@Autowired
	private IFacturationService rle;
	@Autowired
	private IProduitService prod;

	@GetMapping("/showNewFacturationForm")
	public String toAddFacture(Model model) {
		Facturation facturation = new Facturation();
		List<Produit> listesproduit;
		listesproduit = prod.findAll();
		model.addAttribute("listesproduit", listesproduit);
		model.addAttribute("facturation", facturation);
		return "/facturation/new_facturation";
	}

	@PostMapping("/saveFacturation")
	public String addFacture(@ModelAttribute(value = "facturation") Facturation facturation) {
		rle.EnregistrerFacturation(facturation);
		return "redirect:/facturations";
	}
	// display list of employees
	@GetMapping("/facturations")
	public String viewHomePage(Model model) {
		return findPaginated(1, "idfacturation", "asc", model);		
	}


	@GetMapping("/showFormForFacturationUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		Facturation facturaton = rle.getRoleByIdfacturation(id);
		List<Produit> listesproduit;
		listesproduit = prod.findAll();
		model.addAttribute("listesproduit", listesproduit);
		model.addAttribute("facturation", facturaton);
		return "/facturation/update_facturation";
	}

	@GetMapping("/deleteFacturation/{id}")
	public String deleteFacture(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.rle.deleteFacturationById(id);
		return "redirect:/facturations";
	}

	@GetMapping("/pagefactu/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Facturation> page = rle.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Facturation> listfacturation = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listfacturation", listfacturation);
		return "facturation/liste";
	}

}
