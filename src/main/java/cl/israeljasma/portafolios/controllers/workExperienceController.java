package cl.israeljasma.portafolios.controllers;

import cl.israeljasma.portafolios.models.entity.ExperienciaLaboral;
import cl.israeljasma.portafolios.services.IExperienciaLaboralService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import static cl.israeljasma.portafolios.utils.GeneralUtils.getUsernameSession;

@Controller
@SessionAttributes("experienciaLaboral")
public class workExperienceController {

    @Autowired
    private IExperienciaLaboralService experienciaLaboralService;

    /**
     Método para mostrar el listado de experiencias laborales en el sistema.
     @param model El objeto Model para agregar atributos.
     @return El nombre de la vista que muestra el listado de experiencias laborales.
     */
    @RequestMapping(value = {"/dashboard/workexperience"}, method = RequestMethod.GET)
    public String listarExperienciaLaboral(Model model){
        model.addAttribute("titulo", "Listado de experiencias laborales");
        model.addAttribute("usernameSession", getUsernameSession());
        model.addAttribute("workExperiences", experienciaLaboralService.findAll());
        return "workExperience/workExperience";
    }

    /**
     Método para mostrar el formulario de edición de una experiencia laboral.
     @param id El ID de la experiencia laboral a editar.
     @param model El objeto Model para agregar atributos.
     @return El nombre de la vista que muestra el formulario de edición de experiencia laboral.
     Si el ID es válido, se recupera la experiencia laboral correspondiente y se muestra en el formulario.
     Si el ID es inválido, se redirige a la página de listado de experiencias laborales.
     */
    @RequestMapping(value = "/dashboard/workexperience/edit/{id}")
    public String editExperienciaLaboral(@PathVariable(value = "id") Long id, Model model){
        ExperienciaLaboral experienciaLaboral = null;
        if (id>0){
            experienciaLaboral = experienciaLaboralService.finOne(id);
        }else {
            return "redirect:/dashboard/workexperience";
        }

        model.addAttribute("experienciaLaboral", experienciaLaboral);
        model.addAttribute("usernameSession", getUsernameSession());
        model.addAttribute("titulo", "Modificar experiencia laboral");
        return "workExperience/edit";
    }

    /**
     Método para mostrar el formulario de creación de una experiencia laboral.
     @param model El objeto Model para agregar atributos.
     @return El nombre de la vista que muestra el formulario de creación de experiencia laboral.
     */
    @RequestMapping(value = {"/dashboard/workexperience/create"}, method = RequestMethod.GET)
    public String createExperienciaLaboral(Model model){
        ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral();
        model.addAttribute("titulo", "Formulario experiencia laboral");
        model.addAttribute("experienciaLaboral", experienciaLaboral);
        model.addAttribute("usernameSession", getUsernameSession());
        return "workExperience/create";
    }

    /**
     Método para guardar la información de una experiencia laboral en el sistema.
     @param experienciaLaboral El objeto ExperienciaLaboral a guardar.
     @param result El objeto BindingResult para validar los datos.
     @param model El objeto Model para agregar atributos.
     @param status El objeto SessionStatus para completar la sesión.
     @return El nombre de la vista a la cual redirigir después de guardar la experiencia laboral.
     */
    @RequestMapping(value = {"/dashboard/workexperience/create"}, method = RequestMethod.POST)
    public String saveExperienciaLaboral(@Valid ExperienciaLaboral experienciaLaboral, BindingResult result, Model model, SessionStatus status){
        System.out.println(experienciaLaboral.getCargo());
        experienciaLaboralService.save(experienciaLaboral);
        status.setComplete();
        return "redirect:/dashboard/workexperience";
    }

    /**
     Método para eliminar una experiencia laboral del sistema.
     @param id El ID de la experiencia laboral a eliminar.
     @return El nombre de la vista a la cual redirigir después de eliminar la experiencia laboral.
     */
    @RequestMapping(value = "/dashboard/workexperience/eliminar/{id}")
    public String deleteExperienciaLaboral(@PathVariable(value = "id") Long id){
        if (id>0){
            experienciaLaboralService.delete(id);
        }
        return "redirect:/dashboard/workexperience";
    }
}
