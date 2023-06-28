package cl.israeljasma.portafolios.models.dao;

import cl.israeljasma.portafolios.models.entity.Perfil;
import org.springframework.data.repository.CrudRepository;

public interface IPerfilDao extends CrudRepository<Perfil, Long> {
}
