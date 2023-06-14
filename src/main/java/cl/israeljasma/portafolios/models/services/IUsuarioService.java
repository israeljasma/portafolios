package cl.israeljasma.portafolios.models.services;

import cl.israeljasma.portafolios.models.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();

    public void save(Usuario usuario);

    public Usuario finOne(Long id);

    public void delete(Long id);
}
