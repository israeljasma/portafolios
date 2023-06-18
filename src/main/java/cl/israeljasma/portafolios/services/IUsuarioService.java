package cl.israeljasma.portafolios.services;

import cl.israeljasma.portafolios.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<Usuario> findAll();

    public void save(Usuario usuario);

    public Usuario finOne(Long id);

    public void delete(Long id);
    Optional<Usuario> findByUsername(String username);
}
