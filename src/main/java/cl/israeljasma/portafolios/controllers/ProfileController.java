package cl.israeljasma.portafolios.controllers;

import cl.israeljasma.portafolios.models.entity.Perfil;
import cl.israeljasma.portafolios.models.entity.Usuario;
import cl.israeljasma.portafolios.services.IPerfilService;
import cl.israeljasma.portafolios.services.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Objects;
import java.util.Optional;

import static cl.israeljasma.portafolios.utils.GeneralUtils.getUsernameSession;

@SessionAttributes("perfil")
@Controller
public class ProfileController {

    /**
     * Servicio de usuario utilizado para realizar operaciones relacionadas con usuarios.
     */
    @Autowired
    private IUsuarioService usuarioService;

    /**
     * Servicio de perfil utilizado para realizar operaciones relacionadas con perfiles.
     */
    @Autowired
    private IPerfilService perfilService;

    /**
     * Maneja la solicitud GET para la página de perfil de usuario.
     *
     * @param model El modelo utilizado para pasar datos a la vista.
     * @return La vista "profile/profile" que muestra el perfil de usuario.
     */
    @RequestMapping(value = {"/dashboard/usuarios/{id}/profile", "/dashboard/profile"}, method = RequestMethod.GET)
    public String profile(Model model){
        Object objSessionUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Usuario> usuario = null;
        UserDetails userDetails = null;
        Optional<Usuario> usuarioLog;
        if (objSessionUser instanceof UserDetails) {
            userDetails = (UserDetails) objSessionUser;
        }
        assert userDetails != null;

        usuarioLog = usuarioService.findByUsername(userDetails.getUsername());

        if (usuarioLog.isPresent()){
            usuario = usuarioService.findByUsername(userDetails.getUsername());
        }
        assert Objects.requireNonNull(usuario).isPresent();

        model.addAttribute("titulo", "Perfil");
        model.addAttribute("usernameSession", getUsernameSession());
        model.addAttribute("perfil", usuario.get().getPerfil());

        return "profile/profile";
    }

    /**
     * Maneja la solicitud GET para editar el perfil.
     *
     * @param model El modelo utilizado para almacenar atributos y pasar datos a la vista.
     * @return La vista para editar el perfil.
     */
    @RequestMapping(value = {"/dashboard/profile/edit"}, method = RequestMethod.GET)
    public String profileEdit(Model model){
        Object objSessionUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        Optional<Usuario> usuarioLog;
        if (objSessionUser instanceof UserDetails) {
            userDetails = (UserDetails) objSessionUser;
        }

        assert userDetails != null;

        // Obtiene el perfil del usuario actual utilizando el servicio perfilService y el nombre de usuario
        Perfil perfil = perfilService.finOne(usuarioService.findByUsername(userDetails.getUsername()).get().getPerfil().getId());

        // Agrega atributos al modelo para pasarlos a la vista
        model.addAttribute("titulo", "Modicar perfil");
        model.addAttribute("usernameSession", getUsernameSession());
        model.addAttribute("perfil", perfil);
        return "profile/edit";
    }

    /**
     * Maneja la solicitud POST para guardar el perfil.
     *
     * @param perfil El perfil a guardar.
     * @param model El modelo utilizado para almacenar atributos y pasar datos a la vista.
     * @param status El estado de la sesión.
     * @return La redirección a la página de perfil.
     */
    @RequestMapping(value = {"/dashboard/profile/edit"}, method = RequestMethod.POST)
    public String profileSave(@Valid Perfil perfil, Model model, SessionStatus status){

        perfilService.save(perfil);
        status.setComplete();
        return "redirect:/dashboard/profile";
    }
}
