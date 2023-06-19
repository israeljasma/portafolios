package cl.israeljasma.portafolios.utils;

import cl.israeljasma.portafolios.models.entity.Usuario;
import cl.israeljasma.portafolios.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class GeneralUtils {

    @Autowired
    private static IUsuarioService usuarioService;

    /**
     * Devuelve el nombre de usuario asociado a la sesión actual.
     *
     * @return El nombre de usuario de la sesión actual.
     */
    public static String getUsernameSession(){
        UserDetails userDetails = null;
        Object objSessionUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (objSessionUser instanceof UserDetails) {
            userDetails = (UserDetails) objSessionUser;
        }
        assert userDetails != null;
        return userDetails.getUsername();
    }
}
