package cl.israeljasma.portafolios.services;

import cl.israeljasma.portafolios.models.entity.Educacion;

import java.util.List;

public interface IEducacionService {

    public List<Educacion> findAll();

    public void save(Educacion perfil);

    public Educacion finOne(Long id);

    public void delete(Long id);
}
