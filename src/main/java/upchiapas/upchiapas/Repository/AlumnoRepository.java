package upchiapas.upchiapas.Repository;

import upchiapas.upchiapas.models.AlumnoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<AlumnoModel, Long> {
}
