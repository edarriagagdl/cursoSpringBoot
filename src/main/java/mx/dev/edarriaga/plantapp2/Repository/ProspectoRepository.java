package mx.dev.edarriaga.plantapp2.Repository;
import mx.dev.edarriaga.plantapp2.model.Prospecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProspectoRepository extends JpaRepository<Prospecto, Long> {
}
