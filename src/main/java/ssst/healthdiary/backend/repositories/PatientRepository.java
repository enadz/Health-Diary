package ssst.healthdiary.backend.repositories;

import org.springframework.stereotype.Repository;
import ssst.healthdiary.backend.models.Patient;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
