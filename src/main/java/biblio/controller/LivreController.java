package biblio.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import biblio.dto.CategorieDTO;
import biblio.dto.LivreDTO;
import biblio.service.impl.CategorieService;
import biblio.service.impl.LivreService;

@Controller
public class LivreController {

	@Autowired
	LivreService livreService;
	@Autowired
	CategorieService categorieService;

	@GetMapping({ "/", "/index" })
	public String listes(ModelMap model) {
		List<LivreDTO> listeLivre = this.livreService.getAll();
		List<CategorieDTO> listeCategorie = this.categorieService.getAll();
		model.addAttribute("listeLivre", listeLivre);
		model.addAttribute("listeCategorie", listeCategorie);
		return "index";
	}

	@PostMapping("/addLivre")
	public String add(@RequestParam("categorie") String categorieS, @RequestParam("stock") String stockS,
			@RequestParam("label") String label, @RequestParam("titre") String titre,
			@RequestParam("dateEdition") String dateEdition, @RequestParam("prix") String prixS) {

		String[] date = dateEdition.split("-");
		Arrays.asList(date).stream().forEach(System.out::println);
		int annee = Integer.parseInt(date[0]);
		int mois = Integer.parseInt(date[1]);
		int jour = Integer.parseInt(date[2]);
		Double prix = Double.parseDouble(prixS);
		int stock = Integer.parseInt(stockS);
		CategorieDTO categorie = categorieService.getById(Integer.parseInt(categorieS));
		this.livreService.add(LivreDTO.builder().categorie(categorie).titre(titre)
				.date_edition(Date.valueOf(LocalDate.of(annee, mois, jour))).prix(prix).label(label).stock(stock)
				.build());

		return "redirect:index";

	}

	@PostMapping("/updateLivre")
	public String update(@RequestParam("livre") String livre, @RequestParam("prix") String prix,
			@RequestParam("stock") String stock) {

		int livreModif = Integer.parseInt(livre);
		Double nouveauPrix = Double.parseDouble(prix);
		int nouveauStock = Integer.parseInt(stock);
		LivreDTO update = this.livreService.getById(livreModif);
		update.setPrix(nouveauPrix);
		update.setStock(nouveauStock);
		this.livreService.update(update);

		return "redirect:index";

	}

	@PostMapping("/removeLivre")
	public String remove(@RequestParam("livre") String livre) {

		int livreSuppr = Integer.parseInt(livre);
		this.livreService.deleteById(livreSuppr);

		return "redirect:index";

	}
}
