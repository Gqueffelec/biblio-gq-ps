package biblio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import biblio.dto.CategorieDTO;
import biblio.service.impl.CategorieService;

@Controller
public class CategorieController {

	@Autowired
	private CategorieService categorieService;

	@GetMapping("getAllCategorie")
	public @ResponseBody List<CategorieDTO> getAllCategorie() {
		List<CategorieDTO> liste = categorieService.getAll();
		String json = new Gson().toJson(liste);
		System.out.println(json);
		return liste;
	}

	@GetMapping("getCategorie")
	public ResponseEntity<CategorieDTO> getOneCategorie(@RequestParam("id") String idStr) {
		if (idStr.equals("")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException nfe) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		CategorieDTO categorie = categorieService.getById(id);
		return ResponseEntity.ok(categorie);
	}

	@GetMapping("removeCategorie")
	public @ResponseBody String removeCategorie(@RequestParam("id") String idStr) {
		if (idStr.equals("")) {
			return "Aucun ID saisi";
		}
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException nfe) {
			return "L'ID doit être un nombre";
		}
		categorieService.deleteById(id);
		return "Catégorie supprimée avec succès";
	}

	@GetMapping("createCategorie")
	public @ResponseBody String removeCategorie(@RequestParam("nom") String nom, @RequestParam("label") String label,
			@RequestParam("info") String info) {
		if (nom.equals("") || label.equals("") || info.equals("")) {
			return "Veuillez remplir tous les champs";
		}
		List<CategorieDTO> listeTemp = categorieService.getAll();
		if (listeTemp.stream().anyMatch(e -> e.getNom().equalsIgnoreCase(nom))) {
			return "Ce nom éxiste déjà";
		}
		if (listeTemp.stream().anyMatch(e -> e.getLabel().equalsIgnoreCase(label))) {
			return "Ce label éxiste déjà";
		}
		categorieService.add(CategorieDTO.builder().nom(nom).label(label).information_technique(info).build());
		return "Catégorie ajoutée";
	}

	@GetMapping("updateCategorie")
	public @ResponseBody String updateCategorie(@RequestParam("id") String idStr, @RequestParam("nom") String nom,
			@RequestParam("label") String label, @RequestParam("info") String info) {
		if (nom.equals("") || label.equals("") || info.equals("") || idStr.equals("")) {
			return "Veuillez remplir tous les champs";
		}
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
			if (id < 1) {
				return "L'id doit être positif";
			}
		} catch (NumberFormatException nfe) {
			return "L'id doit être un nombre";
		}
		categorieService.update(CategorieDTO.builder().id(id).nom(nom).label(label)
				.information_technique(info).build());
		return "Catégorie modifiée";
	}

}
