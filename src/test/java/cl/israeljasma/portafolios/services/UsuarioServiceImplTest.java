package cl.israeljasma.portafolios.services;

import cl.israeljasma.portafolios.models.dao.IUsuarioDao;
import cl.israeljasma.portafolios.models.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Controller
class UsuarioServiceImplTest {


    @Autowired
    private IUsuarioDao usuarioDao;

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void finOne() {
        System.out.println("finOne");
        Long id = 3L;
        usuarioDao.findById(id);
    }

    @Test
    void delete() {
        System.out.println("delete");
        Long id = 2L;
        usuarioDao.deleteById(id);
    }

    @Test
    void findByUsername() {
        System.out.println("findByUsername");
        String username = "doravan";
        Optional<Usuario> usuario = usuarioDao.findByUsername(username);
        assertNotNull(usuario.get());
    }
}