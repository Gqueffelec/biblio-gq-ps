package biblio.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import biblio.dto.UserDTO;
import biblio.service.impl.UserService;
import biblio.utils.Password;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String test() {
		return "pageLogin";
	}

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String testFormLogin(@RequestParam("user") String userName, @RequestParam("password") String password,
			ModelMap model, HttpSession session) {
		String passBDD = Password.getHash(password);
		String error = "Mauvais login ou mot de passe";
		if (userName.equals("") || password.equals("")) {
			error = "Veuillez remplir tous les champs";
			model.addAttribute("error", error);
		} else {
			UserDTO loginUser = UserDTO.builder().name(userName).password(passBDD).build();
			loginUser = userService.login(loginUser);
			if (loginUser != null) {
				session.setAttribute("connect", true);
				session.setAttribute("admin", loginUser.isAdmin());
				return "index";
			} else {
				model.addAttribute("error", error);
			}
		}
		return "pageLogin";

	}
}
