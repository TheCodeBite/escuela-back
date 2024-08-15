package upchiapas.upchiapas.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import upchiapas.upchiapas.models.AlumnoModel;
import upchiapas.upchiapas.models.SalonModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignarAlumnoSalonDTO {
    long idSalon;
    AlumnoModel alumno;
}
