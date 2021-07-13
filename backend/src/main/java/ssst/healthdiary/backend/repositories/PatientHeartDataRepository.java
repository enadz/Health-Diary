package ssst.healthdiary.backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ssst.healthdiary.backend.entities.PatientHeartData;


public interface PatientHeartDataRepository extends CrudRepository<PatientHeartData, Integer> {

    @Query(value = "SELECT * FROM heartrate_data WHERE gfitpatient_patient_id = ?1", nativeQuery = true)
    public Iterable<PatientHeartData> findByPatientId(@Param("id") String id);
}
