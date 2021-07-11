package ssst.healthdiary.backend.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ssst.healthdiary.backend.entities.PatientOxygenData;
import org.springframework.data.repository.query.Param;


public interface PatientOxygenDataRepository extends CrudRepository<PatientOxygenData, Integer> {

    @Query(value = "SELECT * FROM oxygen_saturation_data WHERE gfitpatient_patient_id = ?1", nativeQuery = true)
    public Iterable<PatientOxygenData> findByPatientId(@Param("id") int id);
}
