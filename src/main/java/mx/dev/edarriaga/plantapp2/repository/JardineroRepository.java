package mx.dev.edarriaga.plantapp2.repository;
import mx.dev.edarriaga.plantapp2.model.Jardinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JardineroRepository extends JpaRepository<Jardinero, Long> {

}
