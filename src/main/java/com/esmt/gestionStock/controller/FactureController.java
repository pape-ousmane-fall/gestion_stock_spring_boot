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

import com.esmt.gestionStock.dao.IFacturation;
import com.esmt.gestionStock.domaine.Facturation;
import com.esmt.gestionStock.domaine.Facture;
import com.esmt.gestionStock.domaine.Utilisateur;
import com.esmt.gestionStock.service.IFactureService;
@Controller
public class FactureController {
	@Autowired
	private IFactureService rle;
	@Autowired
	private IFacturation fc;

	@GetMapping("/showNewFactureForm")
	public String toAddFacture(Model model) {
		Facture facture = new Facture();
		List<Facturation> listesfacturation;
		listesfacturation = fc.findAll();
		model.addAttribute("listesfacturation", listesfacturation);
		model.addAttribute("facture", facture);
		return "/facture/new_facture";
	}

	@PostMapping("/saveFacture")
	public String addFacture(@ModelAttribute(value = "facture") Facture facture) {
		rle.EnregistrerFacture(facture);
		return "redirect:/factures";
	}
	// display list of employees
	@GetMapping("/factures")
	public String viewHomePage(Model model) {
		return findPaginated(1, "quantitefact", "asc", model);		
	}


	@GetMapping("/showFormForFactureUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		Facture Facture = rle.getRoleByIdfacture(id);
		List<Facturation> listesfacturation;
		listesfacturation = fc.findAll();
		model.addAttribute("listesfacturation", listesfacturation);
		model.addAttribute("facture", Facture);
		return "/facture/update_facture";
	}

	@GetMapping("/deleteFacture/{id}")
	public String deleteFacture(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.rle.deleteFactureById(id);
		return "redirect:/factures";
	}

	@GetMapping("/pagefac/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Facture> page = rle.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Facture> listFacture = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listefacture", listFacture);
		return "facture/liste";
	}

}
