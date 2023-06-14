package cl.israeljasma.portafolios.controllers;

import cl.israeljasma.portafolios.models.entity.Usuario;
import cl.israeljasma.portafolios.models.services.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;
    @RequestMapping(value = "/dashboard/listar", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarioService.findAll());
        return "/usuarios/listar";
    }

    @RequestMapping(value = "/dashboard/form")
    public String crear(Map<String, Object> model){

        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        model.put("titulo", "Formulario de usuario");
        return "/usuarios/form";
    }

    @RequestMapping(value = "/dashboard/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model){
        Usuario usuario = null;
        if (id>0){
            usuario = usuarioService.finOne(id);
        }else {
            return "redirect:/usuarios/listar";
        }
        model.put("usuario", usuario);
        model.put("titulo", "Editar cliente");
        return "/usuarios/form";
    }

    @RequestMapping(value = "/dashboard/form", method = RequestMethod.POST)
    public String guardar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status){

        if (result.hasErrors()){
            System.out.println(result);
            model.addAttribute("titulo", "Formulario de usuario");
            return "/usuarios/form";
        }
        usuarioService.save(usuario);
        status.setComplete();
        return "redirect:/dashboard/listar";
    }

    @RequestMapping(value = "/dashboard/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        if (id>0){
            usuarioService.delete(id);
        }
        return "redirect:/dashboard/listar";
    }
}
