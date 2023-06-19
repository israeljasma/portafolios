package cl.israeljasma.portafolios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    /**
     * Devuelve la vista de la página de inicio de sesión.
     *
     * @param model El modelo utilizado para pasar datos a la vista.
     * @return La ruta de la vista de la página de inicio de sesión.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model){
        model.addAttribute("titulo", "Listado de usuarios");
        return "/login/login";
    }
}
