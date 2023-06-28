package cl.israeljasma.portafolios.services;

import cl.israeljasma.portafolios.models.dao.IExperienciaLaboralDao;
import cl.israeljasma.portafolios.models.entity.ExperienciaLaboral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExperienciaLaboralServiceImpl implements IExperienciaLaboralService {

    @Autowired
    private IExperienciaLaboralDao experienciaLaboralDao;

    @Transactional(readOnly = true)
    @Override
    public List<ExperienciaLaboral> findAll() {
        return (List<ExperienciaLaboral>) experienciaLaboralDao.findAll();
    }

    @Transactional
    @Override
    public void save(ExperienciaLaboral experienciaLaboral) {
        experienciaLaboralDao.save(experienciaLaboral);
    }

    @Transactional(readOnly = true)
    @Override
    public ExperienciaLaboral finOne(Long id) {
        return experienciaLaboralDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        experienciaLaboralDao.deleteById(id);
    }
}
