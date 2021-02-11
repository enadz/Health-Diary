package ssst.healthdiary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssst.healthdiary.models.Patient;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
