package cl.israeljasma.portafolios.models.dao;

import cl.israeljasma.portafolios.models.entity.Educacion;
import org.springframework.data.repository.CrudRepository;

public interface IEducacionDao extends CrudRepository<Educacion, Long> {
}
