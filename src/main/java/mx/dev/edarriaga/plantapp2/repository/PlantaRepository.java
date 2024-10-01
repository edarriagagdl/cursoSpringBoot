package mx.dev.edarriaga.plantapp2.repository;
import mx.dev.edarriaga.plantapp2.model.Jardinero;
import mx.dev.edarriaga.plantapp2.model.Planta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {

    Optional<Planta> findByEspecie(String especie);

    @Query("SELECT p FROM Planta p WHERE p.jardinero.id = :idJardinero")
    List<Planta> findByJardinero(Long idJardinero);

    @Query("SELECT p FROM Planta p order by lower(p.especie) asc")
    List<Planta> findAllByOrderEspecieIgnoreCaseAsc();

    void deleteByJardinero(Jardinero jardinero);

    void deleteByColorHojas(String colorHojas);


}
