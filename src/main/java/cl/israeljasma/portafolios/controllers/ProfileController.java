package cl.israeljasma.portafolios.controllers;

import cl.israeljasma.portafolios.models.entity.Usuario;
import cl.israeljasma.portafolios.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;
import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private IUsuarioService usuarioService;

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
        model.addAttribute("userSession", usuarioLog.get().getUsername());

        model.addAttribute("profile", usuario.get().getPerfil());

        return "profile/profile";
    }

    @RequestMapping(value = {"/dashboard/profile/edit"}, method = RequestMethod.GET)
    public String profileEdit(){
        return "profile/edit";
    }
}
