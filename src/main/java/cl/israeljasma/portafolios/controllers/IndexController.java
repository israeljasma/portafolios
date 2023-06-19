package cl.israeljasma.portafolios.controllers;

// import cl.israeljasma.portafolios.models.entity.Usuario;
// import cl.israeljasma.portafolios.models.services.IServicio;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.beans.factory.annotation.Value;
import cl.israeljasma.portafolios.services.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// import java.sql.Timestamp;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.List;

@Controller
@RequestMapping("")
public class IndexController {

    // @Value("${texto.indexcontroller.index.titulo}")
    // private String textoIndex;

    // @Value("${texto.indexcontroller.perfil.titulo}")
    // private String textoPerfil;

    // @Value("${texto.indexcontroller.listar.titulo}")
    // private String textoListar;

    // @Autowired
    // @Qualifier("miProcesoComplejo")
    // private IServicio servicio;

    // public IndexController(IServicio servicio) {
    //     this.servicio = servicio;
    // }

    @Autowired
    IPerfilService perfilService;

    /**
     * Controlador que maneja la solicitud GET para la página de inicio ("/", "", "/index").
     *
     * @param model El objeto Model utilizado para pasar atributos a la vista.
     * @return El nombre de la vista a mostrar, en este caso, "index".
     */
    @GetMapping({"/", "", "/index"})
    public String index(Model model){
        model.addAttribute("titulo", "Portafolios");
        model.addAttribute("perfil", perfilService.finOne(1L));
        // model.addAttribute("objeto", servicio.operacion());
        return "index";
    }

    // @GetMapping("/profile")
    // public String profile(Model model){
    //     Usuario user = new Usuario();
    //     user.setUsername("Doravan");
    //     user.setPassword("yeey");
    //     user.setEmail("dsfsda@dasd.com");

    //     model.addAttribute("user", user);
    //     model.addAttribute("titulo", textoPerfil.concat(user.getUsername()));
    //     return "profile";
    // }
}
