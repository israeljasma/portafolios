package cl.israeljasma.portafolios.models.dao;

import cl.israeljasma.portafolios.models.entity.Authority;
import cl.israeljasma.portafolios.utils.AuthorityName;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IAuthorityDao extends CrudRepository<Authority, Long> {
    Optional<Authority> findByName(AuthorityName name);
}
