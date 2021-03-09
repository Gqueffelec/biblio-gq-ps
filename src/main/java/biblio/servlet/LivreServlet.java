package biblio.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import biblio.dto.CategorieDTO;
import biblio.dto.LivreDTO;
import biblio.service.CategorieService;
import biblio.service.LivreService;

@WebServlet("/livreServlet")
public class LivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private LivreService livreService;
	@Autowired
	private CategorieService categorieService;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		WebApplicationContext springContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);

		List<LivreDTO> listeLivre = this.livreService.getAll();
		List<CategorieDTO> listeCategorie = this.categorieService.getAll();
		request.setAttribute("listeLivre", listeLivre);
		request.setAttribute("listeCategorie", listeCategorie);

		switch (action) {
		case "create":

			String titre = request.getParameter("titre");
			String dateEdition = request.getParameter("dateEdition");
			System.out.println(dateEdition);
			String[] date = dateEdition.split("-");
			Arrays.asList(date).stream().forEach(System.out::println);
			int annee = Integer.parseInt(date[0]);
			int mois = Integer.parseInt(date[1]);
			int jour = Integer.parseInt(date[2]);
			Double prix = Double.parseDouble(request.getParameter("prix"));
			String label = request.getParameter("label");
			int stock = Integer.parseInt(request.getParameter("stock"));
			CategorieDTO categorie = categorieService.getById(Integer.parseInt(request.getParameter("categorie")));
			this.livreService.add(LivreDTO.builder().categorie(categorie).titre(titre)
					.date_edition(Date.valueOf(LocalDate.of(annee, mois, jour))).prix(prix).label(label).stock(stock)
					.build());
			break;
		case "remove":

			int livreSuppr = Integer.parseInt(request.getParameter("livre"));
			this.livreService.deleteById(livreSuppr);

			break;
		case "update":

			int livreModif = Integer.parseInt(request.getParameter("livre"));
			Double nouveauPrix = Double.parseDouble(request.getParameter("prix"));
			int nouveauStock = Integer.parseInt(request.getParameter("stock"));
			LivreDTO update = this.livreService.getById(livreModif);
			update.setPrix(nouveauPrix);
			update.setStock(nouveauStock);
			this.livreService.update(update);

			break;
		case "getid":

			break;
		case "getall":

			break;
		default:

			break;
		}
		response.sendRedirect("accueil");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}