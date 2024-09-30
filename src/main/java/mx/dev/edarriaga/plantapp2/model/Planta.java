package mx.dev.edarriaga.plantapp2.model;

import jakarta.persistence.*;
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
    private String especie;
    private String colorHojas;
    private LocalDate fechaPlantacion;


    @ManyToOne
    @JoinColumn (name = "jardinero_id", nullable = false)
    @ToString.Exclude // solucion loop infiniro loombook
    private Jardinero jardinero;

    @ManyToMany
    @JoinTable(name = "Planta_Prospecto",
        joinColumns = @JoinColumn(name = "planta_id"),
        inverseJoinColumns = @JoinColumn(name = "prospecto_id")
    )

    private List<Prospecto> prospectosAsociados;
}
