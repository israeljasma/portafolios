package cl.israeljasma.portafolios.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model){

        Object objSessionUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (objSessionUser instanceof UserDetails) {
            userDetails = (UserDetails) objSessionUser;
        }
        assert userDetails != null;

        model.addAttribute("titulo", "Dashboard");
        model.addAttribute("userSession", userDetails.getUsername());
        return "/dashboard/dashboard";
    }
}
