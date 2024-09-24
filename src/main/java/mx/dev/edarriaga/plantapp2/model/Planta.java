package mx.dev.edarriaga.plantapp2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data // toString, equals, hashCode, getters, setters
@NoArgsConstructor
@AllArgsConstructor
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
    @ToString.Exclude
    private Jardinero jardinero;

    @ManyToMany
    @JoinTable(name = "planta_prospecto",
        joinColumns = @JoinColumn(name = "planta_id"),
        inverseJoinColumns = @JoinColumn(name = "prospecto_id")
    )
    private List<Prospecto> prospectosAsociados;
}
