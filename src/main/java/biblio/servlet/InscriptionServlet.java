package biblio.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

import biblio.controller.UserController;
import biblio.model.User;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/signIn")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserController userController;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		WebApplicationContext springContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("user");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String error = "";
		if (request.getParameter("user").equals("") || request.getParameter("password").equals("")
				|| request.getParameter("password2").equals("")) {
			error = "Veuillez remplir tous les champs";
			System.out.println(error);
			request.setAttribute("error", error);
			doGet(request, response);
		} else {
			List<User> liste = userController.getAll();
			Optional<User> test = liste.stream().filter(e -> e.getNom().equalsIgnoreCase(userName)).findAny();
			if (!test.isPresent()) {
				if (password.equals(password2)) {
					User user = userController
							.create(User.builder().nom(userName).password(password).admin(Boolean.FALSE).build());
					if (user.getId() != 0) {
						request.getRequestDispatcher("login").forward(request, response);
					} else {
						error = "Erreur veuillez réessayer ultérieurement";
						System.out.println(error);
						request.setAttribute("error", error);
						doGet(request, response);
					}
				} else {
					error = "Les mots de passes ne correspondent pas";
					System.out.println(error);
					request.setAttribute("error", error);
					doGet(request, response);
				}
			} else {
				error = "Ce nom est déjà utilisé";
				System.out.println(error);
				request.setAttribute("error", error);
				doGet(request, response);
			}
		}
	}

}
