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
import com.esmt.gestionStock.domaine.Categorie;
import com.esmt.gestionStock.domaine.Produit;
import com.esmt.gestionStock.service.IBoutiqueService;
import com.esmt.gestionStock.service.ICategorieService;
import com.esmt.gestionStock.service.IProduitService;

@Controller
public class ProduitController {
	@Autowired
	IProduitService user;
	@Autowired
	ICategorieService rlee;
	@Autowired
	IBoutiqueService btq;
	
	@GetMapping("/showNewProduitForm")
	public String toAddProduit(Model model) {
		Produit produit = new Produit();
		List<Categorie> listecategorie;
		listecategorie = rlee.findAll();
		List<Boutique> listeboutique;
		listeboutique = btq.findAll();
		model.addAttribute("listecategorie", listecategorie);
		model.addAttribute("listeboutique", listeboutique);
		model.addAttribute("produit", produit);
		return "/produit/new_produit";
	}

	@PostMapping("/saveProduit")
	public String addProduit(@ModelAttribute(value = "produit") Produit produit) {
		user.EnregistrerProduit(produit);
		return "redirect:/produits";
	}
	// display list of employees
	@GetMapping("/produits")
	public String viewHomePageuser(Model model) {
		return findPaginated(1, "libelle", "asc", model);		
	}


	@GetMapping("/showFormForProduitUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		Produit produit = user.getProduitByIdproduit(id);

		List<Categorie> listecategorie;
		listecategorie = rlee.findAll();
		List<Boutique> listeboutique;
		listeboutique = btq.findAll();
		model.addAttribute("listecategorie", listecategorie);
		model.addAttribute("listeboutique", listeboutique);
		model.addAttribute("produit", produit);
		return "/produit/update_produit";
	}

	@GetMapping("/deleteProduit/{id}")
	public String deleteRoles(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.user.deleteProduitById(id);
		return "redirect:/produits";
	}

	@GetMapping("/pageprod/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Produit> page = user.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Produit> listProduit = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listproduit", listProduit);
		return "produit/liste";
	}
	


}
