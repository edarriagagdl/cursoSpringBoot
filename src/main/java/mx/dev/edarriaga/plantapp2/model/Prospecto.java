package mx.dev.edarriaga.plantapp2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data // toString, equals, hashCode, getters, setters
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prospecto {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre; // Por ejemplo tierra, fertilizante, etc.
    private Double cantidad; // Por ejemplo 10 kg, 5 litros, etc.
    private String unidad; // Por ejemplo kg, litros, etc.
    @ManyToMany (mappedBy = "prospectosAsociados", fetch = FetchType.EAGER)
    private List<Planta> plantas; // Por ejemplo, una lista de plantas que requieren tierra, fertilizante, etc.

}
