package cl.israeljasma.portafolios.services;

import cl.israeljasma.portafolios.models.entity.ExperienciaLaboral;

import java.util.List;

public interface IExperienciaLaboralService {

    public List<ExperienciaLaboral> findAll();

    public void save(ExperienciaLaboral perfil);

    public ExperienciaLaboral finOne(Long id);

    public void delete(Long id);
}
