package mx.dev.edarriaga.plantapp2.Service;

import lombok.AllArgsConstructor;
import mx.dev.edarriaga.plantapp2.Repository.JardineroRepository;
import mx.dev.edarriaga.plantapp2.model.Jardinero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JardineroService {
  private JardineroRepository jardineroRepository;

  public Jardinero obtenerJardineroPorId(Long id) {
    return jardineroRepository.findById(id).orElseThrow(() -> new RuntimeException("Jardinero no encontrado" + id.toString()));
  }


  public List<Jardinero> listarJardineros() {
    return jardineroRepository.findAll();
  }

  public Jardinero guardarJardinero(Jardinero jardinero) {
    return jardineroRepository.save(jardinero);
  }

  public void borrarJardinero(Long id) {
     jardineroRepository.deleteById(id);
  }

}
