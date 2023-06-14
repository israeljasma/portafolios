package cl.israeljasma.portafolios.models.dao;

import cl.israeljasma.portafolios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
