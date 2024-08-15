package upchiapas.upchiapas.Service;

import upchiapas.upchiapas.models.AlumnoModel;
import upchiapas.upchiapas.models.SalonAlumnoModel;

import java.util.List;

public interface AlumnoService{
    AlumnoModel crearAlumno(AlumnoModel alumnoModel);
    SalonAlumnoModel asignarAlumnoSalon(SalonAlumnoModel salonAlumnoModel);
    List<AlumnoModel> obtenerAlumnosEnSalon(Integer idSalon);
}
