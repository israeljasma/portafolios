package cl.israeljasma.portafolios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model){
        model.addAttribute("titulo", "Listado de usuarios");
        return "/login/login";
    }
}
