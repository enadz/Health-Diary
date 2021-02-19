package ssst.healthdiary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssst.healthdiary.models.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
