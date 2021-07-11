package ssst.healthdiary.backend.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ssst.healthdiary.backend.entities.PatientActivityData;

public interface PatientActivityDataRepository extends CrudRepository<PatientActivityData, Integer> {
    @Query(value = "SELECT * FROM step_data WHERE gfitpatient_patient_id = ?1", nativeQuery = true)
    public Iterable<PatientActivityData> findByPatientId(@Param("id") String id);
}