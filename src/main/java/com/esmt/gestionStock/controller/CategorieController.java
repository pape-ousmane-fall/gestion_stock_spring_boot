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

import com.esmt.gestionStock.domaine.Categorie;
import com.esmt.gestionStock.service.ICategorieService;

@Controller
public class CategorieController {

	@Autowired
	private ICategorieService ctg;

	@GetMapping("/showNewCategorieForm")
	public String toAddCategorie(Model model) {
		Categorie categorie = new Categorie();
		model.addAttribute("categorie", categorie);
		return "/Categorie/new_categorie";
	}

	@PostMapping("/saveCategorie")
	public String addCategorie(@ModelAttribute(value = "categorie") Categorie categorie) {
		ctg.EnregistrerCategorie(categorie);
		return "redirect:/categories";
	}
	// display list of employees
	@GetMapping("/categories")
	public String viewHomePage(Model model) {
		return findPaginated(1, "libelle", "asc", model);		
	}


	@GetMapping("/showFormForUpdateCategorie/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		Categorie Categorie = ctg.getRoleByIdcategorie(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("categorie", Categorie);
		return "/categorie/update_categorie";
	}

	@GetMapping("/deleteCategorie/{id}")
	public String deleteCategorie(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.ctg.deleteCategorieById(id);
		return "redirect:/categories";
	}

	@GetMapping("/pagesa/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Categorie> page = ctg.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Categorie> listCategorie = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listeCategorie", listCategorie);
		return "categorie/liste";
	}
}
