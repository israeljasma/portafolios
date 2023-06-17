package cl.israeljasma.portafolios.security;

import cl.israeljasma.portafolios.models.entity.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private Authority authority;
    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}
