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

import biblio.dao.UserDAO;
import biblio.dto.CategorieDTO;
import biblio.dto.LivreDTO;
import biblio.model.User;
import biblio.service.impl.CategorieService;
import biblio.service.impl.LivreService;
import biblio.utils.Password;

public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private LivreService livreService;
	@Autowired
	private CategorieService categorieService;
	@Autowired
	private UserDAO userDao;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		WebApplicationContext springContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
		if (userDao.getById(1) == null) {
			User admin = User.builder().name("libraire").password(Password.getHash("admin")).admin(true).build();
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
		List<LivreDTO> livreList = this.livreService.getAll();
		List<CategorieDTO> listeCategorie = this.categorieService.getAll();
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
