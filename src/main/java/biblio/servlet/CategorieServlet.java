package biblio.servlet;

import java.io.IOException;
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

import com.google.gson.Gson;

import biblio.controller.CategorieController;
import biblio.model.Categorie;

/**
 * Servlet implementation class CategorieServlet
 */
@WebServlet("/CategorieServlet")
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CategorieController controller;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		WebApplicationContext springContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("actionCategorie");
		System.out.println("asset :"+action);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		int id =0;
		String json = null;
		Categorie temp = null;
		switch (action) {
		case "create":
			if (request.getParameter("nom").equals("")||request.getParameter("label").equals("")||request.getParameter("info").equals("")){
				response.getWriter().write("Veuillez remplir tous les champs");
				System.out.println("Veuillez remplir tous les champs");
				break;
			}
			List<Categorie> listeTemp = controller.getAll();
			if (listeTemp.stream().anyMatch(e -> e.getNom().equalsIgnoreCase(request.getParameter("nom")))) {
				response.getWriter().write("Ce nom éxiste déjà");
				System.out.println("Ce nom éxiste déjà");
				break;
			}
			if (listeTemp.stream().anyMatch(e -> e.getLabel().equalsIgnoreCase(request.getParameter("label")))) {
				response.getWriter().write("Ce label éxiste déjà");
				break;
			}
			temp = controller.create(Categorie.builder().nom(request.getParameter("nom")).label(request.getParameter("label")).information_technique(request.getParameter("info")).build());
			System.out.println(temp);
			if (temp.getId()!=0) {
				response.getWriter().write("Catégorie ajoutée");
			} else {
				response.getWriter().write("Problème d'ajout");
			}
			break;
		case "remove":
			if (request.getParameter("id").equals("")){
				response.getWriter().write("Id invalide");
			}
			try {
				id = Integer.parseInt(request.getParameter("id"));
				if (id <1) {
					response.getWriter().write("L'id doit être positif");
					break;
				}
			} catch (NumberFormatException nfe) {
				response.getWriter().write("L'id doit être un nombre");
				break;
			}
			if (controller.remove(id)) {
				response.getWriter().write("Catégorie supprimée");
			} else {
				response.getWriter().write("Problème de suppresion");
			}
			break;
		case "update":
			if (request.getParameter("nom").equals("")||request.getParameter("label").equals("")||request.getParameter("info").equals("")){
				response.getWriter().write("Veuillez remplir tous les champs");
			}
			try {
				id = Integer.parseInt(request.getParameter("id"));
				if (id <1) {
					response.getWriter().write("L'id doit être positif");
					break;
				}
			} catch (NumberFormatException nfe) {
				response.getWriter().write("L'id doit être un nombre");
				break;
			}
			temp = Categorie.builder().id(id).nom(request.getParameter("nom")).label(request.getParameter("label")).information_technique(request.getParameter("info")).build();
			if (controller.update(temp)) {
				response.getWriter().write("Catégorie modifiée");
			} else {
				response.getWriter().write("Problème de modification");
			}
			break;
		case "getid":	
			if (request.getParameter("id").equals("")) {
				response.getWriter().write("ID inexistant");
				break;
			}
			try {
				id = Integer.parseInt(request.getParameter("id"));
				temp = controller.getById(id);
			} catch (NumberFormatException nfe) {
				response.getWriter().write("L'id doit être un nombre");
				break;
			}
			json = new Gson().toJson(temp);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			break;
		case "getall":
			System.out.println("get liste");
			List<Categorie> liste = controller.getAll();
			json = new Gson().toJson(liste);
			response.setContentType("application/json");
			response.getWriter().write(json);
			break;
		default:
			response.sendRedirect("accueil");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
