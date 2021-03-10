package biblio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import biblio.dto.CategorieDTO;
import biblio.dto.LivreDTO;
import biblio.service.impl.CategorieService;
import biblio.service.impl.LivreService;

@Controller
public class IndexController {
	
	@Autowired
	private LivreService livreService;
	
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping({"/","/index"})
	public String mainPage(ModelMap model) {
		List<LivreDTO> liste = livreService.getAll();
		model.addAttribute("livreList",liste);
		List<CategorieDTO> listeCategorie = this.categorieService.getAll();
		model.addAttribute("listeCategorie", listeCategorie);
		return "index";
	}
}
