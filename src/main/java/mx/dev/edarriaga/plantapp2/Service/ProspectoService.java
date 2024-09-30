package mx.dev.edarriaga.plantapp2.Service;

import lombok.AllArgsConstructor;
import mx.dev.edarriaga.plantapp2.Repository.ProspectoRepository;
import mx.dev.edarriaga.plantapp2.model.Prospecto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProspectoService {
    ProspectoRepository prospectoRepository;

    public Prospecto obtenerProspectoPorId(Long id) {
        return prospectoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Prospecto no encontrado:" + id.toString())
        );
    }

    public List<Prospecto> listarProspectos() {
        return prospectoRepository.findAll();
    }

    public Prospecto guardarProspecto(Prospecto prospecto) {
        return prospectoRepository.save(prospecto);
    }

    public void eliminarProspecto(Long id) {
        prospectoRepository.deleteById(id);
    }


}
