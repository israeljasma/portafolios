package cl.israeljasma.portafolios.controllers;

import cl.israeljasma.portafolios.logs.CreateLog;
import cl.israeljasma.portafolios.models.entity.Usuario;
import cl.israeljasma.portafolios.services.IUsuarioService;
import cl.israeljasma.portafolios.utils.GeneralUtils;
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

import static cl.israeljasma.portafolios.utils.GeneralUtils.getUsernameSession;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    /**
     * Método para listar usuarios en el dashboard.
     *
     * @param model El objeto Model para agregar los atributos necesarios.
     * @return La vista "/usuarios/listar" que muestra el listado de usuarios.
     */
    @RequestMapping(value = "/dashboard/listar", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usernameSession", getUsernameSession());
        model.addAttribute("usuarios", usuarioService.findAll());
        return "/usuarios/listar";
    }

    /**
     * Método para mostrar el formulario de creación de usuarios en el dashboard.
     *
     * @param model El objeto Map para agregar los atributos necesarios.
     * @return La vista "/usuarios/form" que muestra el formulario de usuario.
     */
    @RequestMapping(value = "/dashboard/form")
    public String crear(Map<String, Object> model){

        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        model.put("titulo", "Formulario de usuario");
        model.put("usernameSession", getUsernameSession());
        return "/usuarios/form";
    }

    /**
     * Método para mostrar el formulario de edición de un usuario en el dashboard.
     *
     * @param id    El ID del usuario a editar.
     * @param model El objeto Map para agregar los atributos necesarios.
     * @return La vista "/usuarios/form" que muestra el formulario de usuario.
     */
    @RequestMapping(value = "/dashboard/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model){
        Usuario usuario = null;
        if (id>0){
            usuario = usuarioService.finOne(id);
        }else {
            return "redirect:/usuarios/listar";
        }
        model.put("usuario", usuario);
        model.put("usernameSession", getUsernameSession());
        model.put("titulo", "Editar cliente");
        return "/usuarios/form";
    }

    /**
     * Método para guardar un usuario en el formulario de creación o edición.
     *
     * @param usuario El objeto Usuario a guardar.
     * @param result  El objeto BindingResult para validar los errores de validación.
     * @param model   El objeto Model para agregar los atributos necesarios.
     * @param status  El objeto SessionStatus para indicar que la sesión está completa.
     * @return Una redirección a la vista "/dashboard/listar" después de guardar el usuario.
     */
    @RequestMapping(value = "/dashboard/form", method = RequestMethod.POST)
    public String guardar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status){

        if (result.hasErrors()){
            System.out.println(result);
            model.addAttribute("titulo", "Formulario de usuario");
            return "/usuarios/form";
        }

        try{
            usuarioService.save(usuario);
            status.setComplete();
        }catch (Exception e){
            CreateLog.errorLog("Error createUser: " +e.getMessage());
        }

        //usuarioService.save(usuario);
        //status.setComplete();
        return "redirect:/dashboard/listar";
    }

    /**
     * Método para eliminar un usuario en el dashboard.
     *
     * @param id El ID del usuario a eliminar.
     * @return Una redirección a la vista "/dashboard/listar" después de eliminar el usuario.
     */
    @RequestMapping(value = "/dashboard/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        if (id>0){
            usuarioService.delete(id);
        }
        return "redirect:/dashboard/listar";
    }
}
