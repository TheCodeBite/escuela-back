package controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import upchiapas.upchiapas.Repository.AlumnoRepository;
import upchiapas.upchiapas.Repository.SalonRepository;
import upchiapas.upchiapas.Service.impl.AlumnoServiceImpl;
import upchiapas.upchiapas.Service.impl.SalonServiceImpl;
import upchiapas.upchiapas.models.AlumnoModel;
import upchiapas.upchiapas.models.SalonModel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlumnoControllerTest {

    @InjectMocks
    private SalonServiceImpl salonService;
    @Mock
    private SalonRepository salonRepository;

    @InjectMocks
    private AlumnoServiceImpl alumnoService;

    @Mock
    private AlumnoRepository alumnoRepository;


    @Test
    public void crearSalon() {
        SalonModel mockSalon = new SalonModel();
        mockSalon.setGrado(3);
        mockSalon.setGrupo("C");

        when(salonRepository.save(any(SalonModel.class))).thenReturn(mockSalon);

        SalonModel result = salonService.crearSalon(mockSalon);

        assertEquals(3, result.getGrado());
        assertEquals("C", result.getGrupo());
    }

    @Test
    public void obtenerTodosLosSalones(){
        SalonModel mockSalon = new SalonModel();
        mockSalon.setId(1);
        mockSalon.setGrado(1);
        mockSalon.setGrupo("A");

        SalonModel mockSalon2 = new SalonModel();
        mockSalon2.setId(2);
        mockSalon2.setGrado(2);
        mockSalon2.setGrupo("C");


        ArrayList<SalonModel> salones = new ArrayList<>();
        salones.add(mockSalon);
        salones.add(mockSalon2);

        when(salonRepository.findAll()).thenReturn(salones);

        List<SalonModel> result = salonService.obtenerTodosLosSalones();

        assertEquals(2, result.size());
    }


    /*
    Este metodo puede ser utilizado para agregar, actualizar y eliminar(las bajas son logicas)
     */
    @Test
    public void actualizarAlumno() {
        AlumnoModel mockAlumno = new AlumnoModel();
        mockAlumno.setId(1);
        mockAlumno.setNombre("Kevin test");
        mockAlumno.setApellidos("Martinez");
        mockAlumno.setEdad(27);
        mockAlumno.setEstatus(1);
        mockAlumno.setCalificacion(9.0);

        when(alumnoRepository.save(any(AlumnoModel.class))).thenReturn(mockAlumno);

        AlumnoModel result = alumnoService.crearAlumno(mockAlumno);
        assertEquals("Kevin test", result.getNombre());
    }

}
