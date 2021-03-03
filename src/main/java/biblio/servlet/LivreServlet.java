package biblio.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import biblio.controller.HibernateController;
import biblio.controller.LivreController;

@WebServlet("/LivreServlet")
public class LivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LivreController controller;   
    
    @Override
    public void init() throws ServletException {
    	controller = new LivreController();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("actionLivre");
		switch (action) {
		case "create":
			
			break;
		case "remove":
			
			break;
		case "update":
			
			break;
		case "getid":
			
			break;
		case "getall":
			
			break;
		default:
			response.sendRedirect("accueil");
			break;
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
