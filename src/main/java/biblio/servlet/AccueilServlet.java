package biblio.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblio.controller.CategorieController;
import biblio.controller.HibernateController;
import biblio.controller.IController;
import biblio.controller.LivreController;
import biblio.model.Livre;

@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LivreController livreDao;
	private CategorieController categorieDao;

	@Override
	public void init() throws ServletException {
		HibernateController.start();
		livreDao = new LivreController();
		categorieDao = new CategorieController();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List livreList = this.livreDao.getAll();
		List listeCategorie = this.categorieDao.getAll();
		request.setAttribute("livreList", livreList);
		request.setAttribute("listeCategorie", listeCategorie);

		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
