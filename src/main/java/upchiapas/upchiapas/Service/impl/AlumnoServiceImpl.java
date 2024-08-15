package upchiapas.upchiapas.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upchiapas.upchiapas.Repository.AlumnoRepository;
import upchiapas.upchiapas.Repository.AsignarSalonAlumnoRepository;
import upchiapas.upchiapas.Service.AlumnoService;
import upchiapas.upchiapas.exceptions.ValidationException;
import upchiapas.upchiapas.models.AlumnoModel;
import upchiapas.upchiapas.models.SalonAlumnoModel;
import upchiapas.upchiapas.utils.ResponseConstantes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    AsignarSalonAlumnoRepository asignarSalonAlumnoRepository;


    @Override
    public AlumnoModel crearAlumno(AlumnoModel alumnoModel) {
        if(alumnoModel == null) {
            throw new ValidationException(ResponseConstantes.MSG_NULL_ALUMNO, ResponseConstantes.ERROR_NULL_ALUMNO);
        }

        if(alumnoModel.getNombre() == null || alumnoModel.getNombre().trim().isBlank()) {
            throw new ValidationException(ResponseConstantes.MSG_NULL_NOMBRE, ResponseConstantes.ERROR_NULL_NOMBRE);
        }

        if(alumnoModel.getApellidos() == null || alumnoModel.getApellidos().trim().isBlank()){
            throw new ValidationException(ResponseConstantes.MSG_NULL_APELLIDO, ResponseConstantes.ERROR_NULL_APELLIDO);
        }

        if(alumnoModel.getEdad() == null || alumnoModel.getEdad() == 0) {
            throw new ValidationException(ResponseConstantes.MSG_NULL_EDAD, ResponseConstantes.ERROR_NULL_EDAD);
        }

        if(alumnoModel.getCalificacion() == null || alumnoModel.getCalificacion() == 0) {
            throw new ValidationException(ResponseConstantes.MSG_NULL_CALIFICACION, ResponseConstantes.ERROR_NULL_CALIFICACION);
        }

        return alumnoRepository.save(alumnoModel);
    }

    @Override
    public SalonAlumnoModel asignarAlumnoSalon(SalonAlumnoModel salonAlumnoModel) {
        return asignarSalonAlumnoRepository.save(salonAlumnoModel);
    }

    @Override
    public List<AlumnoModel> obtenerAlumnosEnSalon(Integer idSalon) {

        if(idSalon == null || idSalon == 0) {
            throw new ValidationException(ResponseConstantes.MSG_ID_NULL ,ResponseConstantes.ERROR_ID_NULL);
        }
        List<AlumnoModel> alumnos = asignarSalonAlumnoRepository.obtenerAlumnoPorSalonYEstatus(Long.valueOf(idSalon), 1);

        return alumnos.stream()
                .sorted(Comparator.comparing(AlumnoModel::getCalificacion).reversed())
                .toList();
    }
}
