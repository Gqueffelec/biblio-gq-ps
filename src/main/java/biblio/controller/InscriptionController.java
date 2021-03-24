package biblio.controller;

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
public class InscriptionController {

	@Autowired
	UserService userService;

	@GetMapping("/signIn")
	public String getPage() {
		return "inscription";
	}

	@PostMapping("/signIn")
	public String inscriptionForm(@RequestParam("user") String user, @RequestParam("password") String password,
			@RequestParam("password2") String password2, ModelMap model) {
		String error = "";
		if (user.equals("") || password.equals("") || password2.equals("")) {
			error = "Veuillez remplir tous les champs";
		} else {
			if (password.equals(password2)) {
				if (this.userService.getAll().stream().anyMatch(e -> e.getName().equals(user))) {
					error = "Ce nom est déjà utilisé";
				} else {
					UserDTO temp = UserDTO.builder().name(user).admin(false).password(Password.getHash(password))
							.build();
					userService.save(temp);
					return "redirect:login";
				}
			} else {
				error = "Les mots de passes ne correspondent pas";
			}
		}
		model.addAttribute("error", error);
		return "inscription";
	}
}
