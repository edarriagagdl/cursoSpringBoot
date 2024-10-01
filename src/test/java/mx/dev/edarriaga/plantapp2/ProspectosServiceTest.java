package mx.dev.edarriaga.plantapp2;

import mx.dev.edarriaga.plantapp2.service.ProspectoService;
import mx.dev.edarriaga.plantapp2.model.Prospecto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProspectosServiceTest {

    @Autowired
    private ProspectoService prospectoService;

    private Prospecto prospectoGuardado;

    @BeforeEach
    void setup() {
        Prospecto prospecto = new Prospecto();
        prospecto.setNombre("Fertilizante");
        prospecto.setCantidad(1.2);
        prospecto.setUnidad("Litros");
        prospectoGuardado = prospectoService.guardarProspecto(prospecto);
    }

    @Test
    void testGuardarProspecto()
    {
        assertNotNull(prospectoGuardado.getId());
    }

    @Test
    void testListarProspectos()
    {
        List<Prospecto> listaProspectos = prospectoService.listarProspectos();
        assertFalse(listaProspectos.isEmpty());
    }

    @Test
    void testObtenerProspectoPorId()
    {
        Long prospectoId = 1L;
        Prospecto prospecto = prospectoService.obtenerProspectoPorId(prospectoId);
        assertEquals(prospectoId, prospecto.getId());
    }

    @Test
    void testEliminarProspecto()
    {
        Long prospectoId = prospectoGuardado.getId();
        assertNotNull(prospectoService.obtenerProspectoPorId(prospectoId));
        prospectoService.eliminarProspecto(prospectoId);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            prospectoService.obtenerProspectoPorId(prospectoId);
        });

        String expectedMessage = "Prospecto no encontrado:" + prospectoId.toString();
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}
