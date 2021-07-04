package ssst.healthdiary.backend.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ssst.healthdiary.backend.entities.PatientSleepData;

public interface PatientSleepDataRepository extends CrudRepository<PatientSleepData, Integer> {

    @Query(value = "SELECT * FROM sleep_data WHERE patient_id = ?1", nativeQuery = true)
    public Iterable<PatientSleepData> findByPatientId(@Param("patientId") int patientId);
}
