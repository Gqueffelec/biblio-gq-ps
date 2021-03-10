package biblio.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogOutController {

	@GetMapping("/signOut")
	public String signOut( HttpSession session) {
		if (session.getAttribute("connect")!=null) {
			session.invalidate();
		}
		return "index";
	}
	
}
