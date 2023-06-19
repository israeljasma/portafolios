package cl.israeljasma.portafolios.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static cl.israeljasma.portafolios.utils.GeneralUtils.getUsernameSession;

@Controller
public class DashboardController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model){
        model.addAttribute("titulo", "Dashboard");
        model.addAttribute("usernameSession", getUsernameSession());
        return "/dashboard/dashboard";
    }
}
