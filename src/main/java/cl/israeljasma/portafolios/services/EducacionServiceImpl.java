package cl.israeljasma.portafolios.services;

import cl.israeljasma.portafolios.models.dao.IEducacionDao;
import cl.israeljasma.portafolios.models.entity.Educacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EducacionServiceImpl implements IEducacionService {

    @Autowired
    private IEducacionDao educacionDao;

    @Transactional(readOnly = true)
    @Override
    public List<Educacion> findAll() {
        return (List<Educacion>) educacionDao.findAll();
    }

    @Transactional
    @Override
    public void save(Educacion educacion) {
        educacionDao.save(educacion);
    }

    @Transactional(readOnly = true)
    @Override
    public Educacion finOne(Long id) {
        return educacionDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        educacionDao.deleteById(id);
    }
}
