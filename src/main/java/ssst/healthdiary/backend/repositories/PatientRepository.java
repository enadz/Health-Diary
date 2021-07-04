package ssst.healthdiary.backend.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ssst.healthdiary.backend.entities.GFitPatient;

public interface PatientRepository extends CrudRepository<GFitPatient, Integer> {

}
