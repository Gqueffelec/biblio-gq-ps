package biblio.servlet;

import java.io.IOException;

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

import biblio.dto.UserDTO;
import biblio.service.impl.UserService;
import biblio.utils.Password;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Autowired
	UserService userService;

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
		request.getRequestDispatcher("WEB-INF/pageLogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("user");
		String password = request.getParameter("password");
		String passBDD = Password.getHash(password);
		String error = "Mauvais login ou mot de passe";
		if (request.getParameter("user").equals("") || request.getParameter("password").equals("")) {
			error = "Veuillez remplir tous les champs";
			request.setAttribute("error", error);
			doGet(request, response);
		} else {
			UserDTO loginUser = UserDTO.builder().name(userName).password(passBDD).build();
			loginUser = userService.login(loginUser);
			if (loginUser != null) {
				HttpSession session = request.getSession(Boolean.TRUE);
				session.setAttribute("connect", true);
				session.setAttribute("admin", loginUser.isAdmin());
				request.getRequestDispatcher("accueil").forward(request, response);
			} else {
				request.setAttribute("error", error);
				doGet(request, response);
			}
		}
	}

}
