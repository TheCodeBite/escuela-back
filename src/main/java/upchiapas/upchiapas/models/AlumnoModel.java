package upchiapas.upchiapas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "alumno")
@Data
public class AlumnoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Este dato no puede ser vacion")
    private String nombre;

    @NotBlank(message = "Este dato no puede ser vacion")
    private String apellidos;

    @NotNull(message = "Dato requerido")
    private Integer edad;

    @NotNull(message = "Dato requerido")
    @Min(value = 0, message = "La calificación debe ser mayor o igual a 0")
    @Max(value = 10, message = "La calificación debe ser menor o igual a 10")
    private Double calificacion;

    @NotNull(message = "Dato requerido")
    @Column(columnDefinition = "int default 1")
    private Integer estatus = 1;
}
