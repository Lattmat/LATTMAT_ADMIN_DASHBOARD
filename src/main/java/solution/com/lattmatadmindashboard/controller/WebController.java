package solution.com.lattmatadmindashboard.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class WebController {

    @GetMapping(value = { "/", "/index", "/index.html" })
	public String indexMain(Model model) {
		log.info("web controller class paramaters as model");
        return "index";
    }

	@GetMapping(value = { "/login" })
	public String loginPage(Model model) {
		return "login";
	}

	@GetMapping(value = { "/create-password" })
	public String createPasswordPage(HttpSession session, Model model) {
    	String username = (String) session.getAttribute("username");

		if(username == null){
			return "redirect:login";
		}
    	return "create-password";
	}

}
