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

    /**
     Este método maneja la solicitud GET para el endpoint "/dashboard".
     @param model el objeto modelo utilizado para pasar datos a la vista
     @return el nombre de la vista para la página del panel de control
     */
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model){
        model.addAttribute("titulo", "Dashboard");
        model.addAttribute("usernameSession", getUsernameSession());
        return "/dashboard/dashboard";
    }
}
