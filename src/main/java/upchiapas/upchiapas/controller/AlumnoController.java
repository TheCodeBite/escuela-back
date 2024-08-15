package upchiapas.upchiapas.controller;


import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import upchiapas.upchiapas.Service.AlumnoService;
import upchiapas.upchiapas.Service.SalonService;
import upchiapas.upchiapas.models.AlumnoModel;
import upchiapas.upchiapas.models.SalonAlumnoModel;
import upchiapas.upchiapas.models.SalonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import upchiapas.upchiapas.models.dto.AsignarAlumnoSalonDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("api")
public class AlumnoController implements WebMvcConfigurer {
    @Autowired
    private SalonService salonService;

    @Autowired
    private AlumnoService alumnoService;



    @PostMapping("crear-salon")
    public ResponseEntity<SalonModel> crearSalon(@RequestBody SalonModel salonModel) {
        SalonModel salonReponse = salonService.crearSalon(salonModel);
        return new ResponseEntity<>(salonReponse, HttpStatus.CREATED);
    }

    @GetMapping("obtener-salones")
    public ArrayList<SalonModel> obtenerSalones() {
        return salonService.obtenerTodosLosSalones();
    }

    @PostMapping("crear-Alumno")
    public ResponseEntity<AlumnoModel> crearAlumno(@RequestBody  AlumnoModel alumno) {
        AlumnoModel alumnoModel = alumnoService.crearAlumno(alumno);
        return new ResponseEntity<>(alumnoModel, HttpStatus.CREATED);
    }

    @PostMapping("asignarAlumnoSalon")
    public ResponseEntity<SalonAlumnoModel> asignarAlumnoSalon(@RequestBody AsignarAlumnoSalonDTO alumnoAsignar) {
       SalonModel salon = salonService.obtenerSalonPorId(alumnoAsignar.getIdSalon());
       AlumnoModel alumno = crearAlumno(alumnoAsignar.getAlumno()).getBody();

       SalonAlumnoModel salonAlumnoModel = new SalonAlumnoModel();
       salonAlumnoModel.setAlumnoFK(alumno);
       salonAlumnoModel.setSalonFK(salon);

       SalonAlumnoModel response =  alumnoService.asignarAlumnoSalon(salonAlumnoModel);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("obtenerAlumnosActivosPorSalon")
    public ResponseEntity<List<AlumnoModel>> obtenerAlumnosActivosPorSalon(@Valid  @RequestBody Integer idSalon){
        List<AlumnoModel> response = alumnoService.obtenerAlumnosEnSalon(idSalon);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("eliminar-alumno")
    public HttpStatus eliminarAlumno(@Valid @RequestBody AlumnoModel alumnoModel) {
        alumnoService.crearAlumno(alumnoModel);
        return HttpStatus.OK;
    }

    @PutMapping("actualizar-alumno")
    public ResponseEntity<AlumnoModel> actualizarAlumno(@Valid @RequestBody AlumnoModel alumnoModel) {
        AlumnoModel response = alumnoService.crearAlumno(alumnoModel);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
