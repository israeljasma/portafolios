package cl.israeljasma.portafolios.services;

import cl.israeljasma.portafolios.models.dao.IUsuarioDao;
import cl.israeljasma.portafolios.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsServiceImpl implements UserDetailsService {

    private final IUsuarioDao usuarioDao;

    public SecurityUserDetailsServiceImpl(IUsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }


    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optUser = this.usuarioDao.findByUsername(username);

        if (optUser.isPresent()){
            return new SecurityUser(optUser.get());
        }
        throw new UsernameNotFoundException("Usuario no encontrado: " + username);
    }
}
