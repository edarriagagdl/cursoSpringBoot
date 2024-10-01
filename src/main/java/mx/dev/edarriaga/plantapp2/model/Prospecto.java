package mx.dev.edarriaga.plantapp2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank (message = "el nombre no puede ir en blanco")
    private String nombre; // Por ejemplo tierra, fertilizante, etc.
    @NotNull (message = " La cantiodad no puede ser nula")
    private Double cantidad; // Por ejemplo 10 kg, 5 litros, etc.
    @NotBlank (message = "La unidad no puede ir en blanco")
    private String unidad; // Por ejemplo kg, litros, etc.
    @ManyToMany (mappedBy = "prospectosAsociados", fetch = FetchType.EAGER)
    private List<Planta> plantas; // Por ejemplo, una lista de plantas que requieren tierra, fertilizante, etc.

}
