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

    @RequestMapping(value = {"/dashboard/workexperience"}, method = RequestMethod.GET)
    public String listarExperienciaLaboral(Model model){
        model.addAttribute("titulo", "Listado de experiencias laborales");
        model.addAttribute("usernameSession", getUsernameSession());
        model.addAttribute("workExperiences", experienciaLaboralService.findAll());
        return "workExperience/workExperience";
    }

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

    @RequestMapping(value = {"/dashboard/workexperience/create"}, method = RequestMethod.GET)
    public String createExperienciaLaboral(Model model){
        ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral();
        model.addAttribute("titulo", "Formulario experiencia laboral");
        model.addAttribute("experienciaLaboral", experienciaLaboral);
        model.addAttribute("usernameSession", getUsernameSession());
        return "workExperience/create";
    }

    @RequestMapping(value = {"/dashboard/workexperience/create"}, method = RequestMethod.POST)
    public String saveExperienciaLaboral(@Valid ExperienciaLaboral experienciaLaboral, BindingResult result, Model model, SessionStatus status){
        System.out.println(experienciaLaboral.getCargo());
        experienciaLaboralService.save(experienciaLaboral);
        status.setComplete();
        return "redirect:/dashboard/workexperience";
    }

    @RequestMapping(value = "/dashboard/workexperience/eliminar/{id}")
    public String deleteExperienciaLaboral(@PathVariable(value = "id") Long id){
        if (id>0){
            experienciaLaboralService.delete(id);
        }
        return "redirect:/dashboard/workexperience";
    }
}
