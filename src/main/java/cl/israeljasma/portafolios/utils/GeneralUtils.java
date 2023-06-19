package cl.israeljasma.portafolios.utils;

import cl.israeljasma.portafolios.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

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

    /**
     * Devuelve el ID del usuario asociado a la sesión actual.
     *
     * @return El ID del usuario de la sesión actual, o null si no se encuentra el usuario.
     */
    public static Long getIdUserSession(){
        UserDetails userDetails = null;
        Long id;
        Object objSessionUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (objSessionUser instanceof UserDetails) {
            userDetails = (UserDetails) objSessionUser;
        }

        assert userDetails != null;
        if (usuarioService.findByUsername(userDetails.getUsername()).isPresent()){
            return usuarioService.findByUsername(userDetails.getUsername()).get().getId();
        }
        return null;
    }
}
