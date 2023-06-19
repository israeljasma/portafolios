package cl.israeljasma.portafolios.services;

import cl.israeljasma.portafolios.models.dao.IPerfilDao;
import cl.israeljasma.portafolios.models.entity.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PerfilServiceImpl implements IPerfilService {

    @Autowired
    private IPerfilDao perfilDao;

    @Transactional(readOnly = true)
    @Override
    public List<Perfil> findAll() {
        return (List<Perfil>) perfilDao.findAll();
    }

    @Transactional
    @Override
    public void save(Perfil perfil) {
        perfilDao.save(perfil);
    }

    @Transactional(readOnly = true)
    @Override
    public Perfil finOne(Long id) {
        return perfilDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        perfilDao.deleteById(id);
    }
}
