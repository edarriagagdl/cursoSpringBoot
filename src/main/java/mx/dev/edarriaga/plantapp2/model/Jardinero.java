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
public class Jardinero {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String especialidad;
    private String email;

    @OneToMany(mappedBy = "jardinero", fetch = FetchType.EAGER)
    private List<Planta> plantasAsociadas;



}
