package mx.dev.edarriaga.plantapp2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data // toString, equals, hashCode, getters, setters
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Planta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "especie", nullable = false)
    @NotBlank (message = " La especie no puede ir en blanco")
    private String especie;
    @NotBlank (message = " El color de las hojas no puede ir en blanco")
    private String colorHojas;
    @NotNull (message = "La fecha de plantacion no puede ser nula")
    private LocalDate fechaPlantacion;


    @ManyToOne
    @JoinColumn (name = "jardinero_id", nullable = false)
    @ToString.Exclude // solucion loop infiniro loombook
    @NotNull (message = "El jardinero no puede estar vacio")
    private Jardinero jardinero;

    @ManyToMany
    @JoinTable(name = "Planta_Prospecto",
        joinColumns = @JoinColumn(name = "planta_id"),
        inverseJoinColumns = @JoinColumn(name = "prospecto_id")
    )

    private List<Prospecto> prospectosAsociados;
}
