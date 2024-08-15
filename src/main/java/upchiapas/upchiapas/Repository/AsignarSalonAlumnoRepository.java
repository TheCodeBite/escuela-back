package upchiapas.upchiapas.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import upchiapas.upchiapas.models.AlumnoModel;
import upchiapas.upchiapas.models.SalonAlumnoModel;

import java.util.List;

public interface AsignarSalonAlumnoRepository  extends CrudRepository<SalonAlumnoModel, Long> {
    @Query(value = "SELECT entity.alumnoFK FROM SalonAlumnoModel entity WHERE entity.salonFK.id = :idSalon and entity.alumnoFK.estatus = :estatus ")
    List<AlumnoModel> obtenerAlumnoPorSalonYEstatus(@Param("idSalon") Long idSalon, @Param("estatus") Integer estatus);
}
