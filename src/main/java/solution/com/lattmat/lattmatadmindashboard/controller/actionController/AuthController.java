package solution.com.lattmat.lattmatadmindashboard.controller.actionController;

import solution.com.lattmat.lattmatadmindashboard.entity.Manager;
import solution.com.lattmat.lattmatadmindashboard.repo.ManagerRepository;
import solution.com.lattmat.lattmatadmindashboard.service.ManagerService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class AuthController {

    private final ManagerService managerService;
    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/create-password")
    public String viewLoginPage(Model model, HttpSession session, @RequestParam(name = "password") String password) {
        final String username = (String) session.getAttribute("username");

        Manager manager = managerService.findUsersByLoginId(username)
                .orElseThrow(() -> new UsernameNotFoundException("Manager is not found."));
        manager.setPassword(passwordEncoder.encode(password));
        manager.setFirstTimeLogin(false);
        managerRepository.save(manager);

        session.removeAttribute("username");
        return "redirect:index";
    }

}