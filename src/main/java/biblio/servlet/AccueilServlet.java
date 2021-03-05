package biblio.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import biblio.controller.CategorieController;
import biblio.controller.LivreController;
import biblio.controller.UserController;
import biblio.model.Categorie;
import biblio.model.Livre;
import biblio.model.User;

@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private LivreController livreDao;
	@Autowired
	private CategorieController categorieDao;
	@Autowired
	private UserController userDao;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		WebApplicationContext springContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
		if (userDao.getById(1) == null) {
			User admin = User.builder().nom("libraire").password("admin").admin(true).build();
			userDao.create(admin);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("test Get");
		System.out.println("signout :" + request.getParameter("signOut"));
		if (request.getParameter("signOut") != null && request.getParameter("signOut").equals("true")) {
			HttpSession session = request.getSession();
			session.invalidate();
		}
		List<Livre> livreList = this.livreDao.getAll();
		List<Categorie> listeCategorie = this.categorieDao.getAll();
		request.setAttribute("livreList", livreList);
		request.setAttribute("listeCategorie", listeCategorie);
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("test post");
		doGet(request, response);
	}

}
