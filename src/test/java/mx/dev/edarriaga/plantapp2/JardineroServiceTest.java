package mx.dev.edarriaga.plantapp2;

import mx.dev.edarriaga.plantapp2.Service.JardineroService;
import mx.dev.edarriaga.plantapp2.model.Jardinero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JardineroServiceTest {

    @Autowired
    private JardineroService jardineroService;

    private Jardinero jardineroGuardado;

    @BeforeEach
    void Setup () {
        Jardinero jardinero = new Jardinero();
        jardinero.setNombre("Javier");
        jardinero.setEspecialidad("Suculentas");
        jardinero.setEmail("javier@email.com");

        jardineroGuardado = jardineroService.guardarJardinero(jardinero);
    }

    @Test
    void testGuardarJardinero() {
        assertNotNull(jardineroGuardado.getId());
        assertEquals("Suculentas", jardineroGuardado.getEspecialidad());
        assertEquals("javier@email.com", jardineroGuardado.getEmail());
    }


    @Test
    void testListarJardineros() {
        List<Jardinero> jardineros = jardineroService.listarJardineros();
        assertFalse(jardineros.isEmpty());
    }

    @Test
    void testObtenerJardineroPorId() {
        Long idJardinero = 1L;
        Jardinero jardinero = jardineroService.obtenerJardineroPorId(idJardinero);

        assertNotNull(jardinero);
        assertEquals(idJardinero, jardinero.getId());
    }



}
