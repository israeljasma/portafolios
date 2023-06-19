package cl.israeljasma.portafolios.security;

import cl.israeljasma.portafolios.models.entity.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private Authority authority;

    /**
     * Devuelve la autoridad asociada a este objeto.
     *
     * @return La representación en forma de cadena de la autoridad.
     */
    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}
