package biblio.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import biblio.service.impl.CategorieService;

@RestController
public class CategorieRest {
	@RequestMapping(value = "/Categories1", method = RequestMethod.GET)
	public String listeProduits() {
		CategorieService categorieService = null;
	
		
		return  categorieService.getAll().toString();

	}
}
