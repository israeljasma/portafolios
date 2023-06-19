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

@SessionAttributes("perfil")
@Controller
public class ProfileController {

    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IPerfilService perfilService;

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

        model.addAttribute("perfil", usuario.get().getPerfil());

        return "profile/profile";
    }

    @RequestMapping(value = {"/dashboard/profile/edit"}, method = RequestMethod.GET)
    public String profileEdit(Model model){
        Object objSessionUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        Optional<Usuario> usuarioLog;
        if (objSessionUser instanceof UserDetails) {
            userDetails = (UserDetails) objSessionUser;
        }

        assert userDetails != null;

        Perfil perfil = perfilService.finOne(usuarioService.findByUsername(userDetails.getUsername()).get().getPerfil().getId());
        model.addAttribute("titulo", "Modicar perfil");
        model.addAttribute("perfil", perfil);
        return "profile/edit";
    }

    @RequestMapping(value = {"/dashboard/profile/edit"}, method = RequestMethod.POST)
    public String profileSave(@Valid Perfil perfil, Model model, SessionStatus status){

        perfilService.save(perfil);
        status.setComplete();
        return "redirect:/dashboard/profile";
    }
}
