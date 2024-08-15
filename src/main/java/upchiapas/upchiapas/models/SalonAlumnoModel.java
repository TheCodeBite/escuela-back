package upchiapas.upchiapas.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salonAlumno")
@Data
@NoArgsConstructor
public class SalonAlumnoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "salon_fk")
    private SalonModel salonFK;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "alumno_fk")
    private AlumnoModel alumnoFK;
}
