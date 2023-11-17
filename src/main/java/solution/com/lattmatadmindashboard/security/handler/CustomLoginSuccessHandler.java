package solution.com.lattmatadmindashboard.security.handler;

import solution.com.lattmatadmindashboard.entity.Manager;
import solution.com.lattmatadmindashboard.service.ManagerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    private ManagerService managerService;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public CustomLoginSuccessHandler(ManagerService managerService){
        this.managerService = managerService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        handle(request, response, authentication);
    }

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        String targetUrl = determineTargetUrl(authentication, request);

        if (response.isCommitted()) {
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(final Authentication authentication, HttpServletRequest request) {
        User user = (User) authentication.getPrincipal();

        final Manager manager = managerService.findUsersByLoginId(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User is not found"));

        if(manager.isFirstTimeLogin()){
            request.getSession().setAttribute("username", user.getUsername());
            return  "/create-password";
        }

        return "/index";
    }
}
