package cl.israeljasma.portafolios.services;

import cl.israeljasma.portafolios.models.entity.Perfil;

import java.util.List;

public interface IPerfilService {

    public List<Perfil> findAll();

    public void save(Perfil perfil);

    public Perfil finOne(Long id);

    public void delete(Long id);
}
