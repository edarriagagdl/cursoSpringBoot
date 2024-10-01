package mx.dev.edarriaga.plantapp2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Column (name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Nombre es Mandatorio")
    private String nombre;

    @NotBlank(message = "Especialidad es Mandatorio")
    private String especialidad;

    @NotBlank(message = "el email no puede estar vacio")
    @Pattern(regexp = "^[a-zA-Z0-9._%±]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$", message = "el formato del email es invalido")
    private String email;

    @OneToMany(mappedBy = "jardinero", fetch = FetchType.EAGER)
    private List<Planta> plantasAsociadas;



}
