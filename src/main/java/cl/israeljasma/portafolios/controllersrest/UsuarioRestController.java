package cl.israeljasma.portafolios.controllersrest;

import cl.israeljasma.portafolios.models.entity.Usuario;
import cl.israeljasma.portafolios.models.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/v1"})
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("users")
    public List<Usuario> allUSers(){
        return usuarioService.findAll();
    }
}
