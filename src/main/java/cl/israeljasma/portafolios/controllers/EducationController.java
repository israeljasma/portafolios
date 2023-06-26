package cl.israeljasma.portafolios.controllers;

import cl.israeljasma.portafolios.models.entity.Educacion;
import cl.israeljasma.portafolios.models.entity.ExperienciaLaboral;
import cl.israeljasma.portafolios.services.IEducacionService;
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
@SessionAttributes("educacion")
public class EducationController {

    @Autowired
    private IEducacionService educacionService;

    @RequestMapping(value = {"/dashboard/education"}, method = RequestMethod.GET)
    public String listarEducacion(Model model){
        model.addAttribute("titulo", "Listado de educaciones");
        model.addAttribute("usernameSession", getUsernameSession());
        model.addAttribute("educations", educacionService.findAll());
        return "education/education";
    }

    @RequestMapping(value = "/dashboard/education/edit/{id}")
    public String editEducacion(@PathVariable(value = "id") Long id, Model model){
        Educacion educacion = null;
        if (id>0){
            educacion = educacionService.finOne(id);
        }else {
            return "redirect:/dashboard/education";
        }

        model.addAttribute("educacion", educacion);
        model.addAttribute("usernameSession", getUsernameSession());
        model.addAttribute("titulo", "Modificar educacion");
        return "education/edit";
    }

    @RequestMapping(value = {"/dashboard/education/create"}, method = RequestMethod.GET)
    public String createEducacion(Model model){
        Educacion educacion = new Educacion();
        model.addAttribute("titulo", "Formulario educación");
        model.addAttribute("educacion", educacion);
        model.addAttribute("usernameSession", getUsernameSession());
        return "education/create";
    }

    @RequestMapping(value = {"/dashboard/education/create"}, method = RequestMethod.POST)
    public String saveEducacion(@Valid Educacion educacion, BindingResult result, Model model, SessionStatus status){
        educacionService.save(educacion);
        status.setComplete();
        return "redirect:/dashboard/education";
    }

    @RequestMapping(value = "/dashboard/education/eliminar/{id}")
    public String deleteEducation(@PathVariable(value = "id") Long id){
        if (id>0){
            educacionService.delete(id);
        }
        return "redirect:/dashboard/education";
    }
}
