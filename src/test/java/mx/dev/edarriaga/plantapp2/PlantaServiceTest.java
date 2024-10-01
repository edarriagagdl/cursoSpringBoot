package mx.dev.edarriaga.plantapp2;

import mx.dev.edarriaga.plantapp2.Service.PlantaService;
import mx.dev.edarriaga.plantapp2.model.Jardinero;
import mx.dev.edarriaga.plantapp2.model.Planta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PlantaServiceTest {
    @Autowired
    private PlantaService plantaService;

    private Planta plantaGuardada;

    @BeforeEach
    void setup ()
    {
        Planta planta  = new Planta();
        planta.setEspecie("Carnivora");
        planta.setColorHojas("Verdes");
        planta.setFechaPlantacion(LocalDate.of(2020, 1, 8));
        plantaGuardada = plantaService.guardarPlanta(planta, 1L, null);
    }

    @Test
    void testPlantaGuardada ()
    {
        assertNotNull (plantaGuardada.getId());
        assertEquals("Carnivora", plantaGuardada.getEspecie());
        assertEquals( 1, plantaGuardada.getJardinero().getId());
    }
}
