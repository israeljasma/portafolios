package cl.israeljasma.portafolios.services;

import cl.israeljasma.portafolios.models.dao.IUsuarioDao;
import cl.israeljasma.portafolios.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioDao usuarioDao;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Transactional
    @Override
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario finOne(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        usuarioDao.deleteById(id);
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioDao.findByUsername(username);
    }
}
