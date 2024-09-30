package mx.dev.edarriaga.plantapp2.Service;

import lombok.AllArgsConstructor;
import mx.dev.edarriaga.plantapp2.Repository.JardineroRepository;
import mx.dev.edarriaga.plantapp2.Repository.PlantaRepository;
import mx.dev.edarriaga.plantapp2.Repository.ProspectoRepository;
import mx.dev.edarriaga.plantapp2.model.Jardinero;
import mx.dev.edarriaga.plantapp2.model.Planta;
import mx.dev.edarriaga.plantapp2.model.Prospecto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlantaService {
    private PlantaRepository plantaRepository;
    private JardineroRepository jardineroRepository;
    private ProspectoRepository prospectoRepository;

    public Planta obtenerPlantaPorId(Long id) {
        return plantaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Planta no encontrada" + id.toString())
        );
    }

    public List<Planta> listarPlantas() {
        return plantaRepository.findAllByOrderEspecieIgnoreCaseAsc();
    }

    public Planta guardarPlanta(Planta planta, Long idJardinero, List<Long> idProspectos) {
        Jardinero jardinero = jardineroRepository.findById(idJardinero).orElseThrow(() -> new RuntimeException("El jardinero no se encontro: " + idJardinero.toString()));
        planta.setJardinero(jardinero);
        if (idProspectos != null) {
            planta.setProspectosAsociados(prospectoRepository.findAllById(idProspectos));
        }
        return plantaRepository.save(planta);
    }

    public void borrarPlanta(Long id) {
        plantaRepository.deleteById(id);
    }

    public void actualizarPlanta(Long idPlanta, Planta plantaActualizada, Long idJardinero, List<Long> idProspectos) {
        Optional<Planta> plantaOptional = plantaRepository.findById(idPlanta);

        Jardinero jardinero = jardineroRepository.findById(idJardinero).orElseThrow(() -> new RuntimeException("El jardinero no se encontro: " + idJardinero.toString()));
        plantaActualizada.setJardinero(jardinero);
        if (idProspectos != null) {
            plantaActualizada.setProspectosAsociados(prospectoRepository.findAllById(idProspectos));
        }
        Planta plantaExistente= construirPlanta(plantaActualizada, plantaOptional);
        plantaRepository.save(plantaExistente);
    }

    private Planta construirPlanta(Planta plantaActualizada, Optional<Planta> plantaOptional) {
        Planta.PlantaBuilder plantaBuilder = Planta.builder();
        plantaOptional.ifPresent(plantaExistente -> {
                    plantaBuilder
                            .id(plantaActualizada.getId())
                            .colorHojas(plantaActualizada.getColorHojas())
                            .especie(plantaActualizada.getEspecie())
                            .fechaPlantacion(plantaActualizada.getFechaPlantacion())
                            .jardinero(plantaActualizada.getJardinero())
                            .prospectosAsociados(plantaActualizada.getProspectosAsociados());
                }
        );
        return plantaBuilder.build();
    }
}

