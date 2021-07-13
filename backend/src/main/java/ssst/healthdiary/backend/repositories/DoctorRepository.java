package ssst.healthdiary.backend.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ssst.healthdiary.backend.entities.Doctor;

import javax.print.Doc;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

    @Query(value = "SELECT * FROM doctor WHERE gfitpatient_patient_id = ?1", nativeQuery = true)
    public Iterable<Doctor> findByPatientId(@Param("id") String id);
}
