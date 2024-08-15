package upchiapas.upchiapas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "grado", nullable = false)
    private Integer grado;

    @Column(name = "grupo", nullable = false, length = 3)
    private String grupo;
}
