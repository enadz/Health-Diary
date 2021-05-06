package ssst.healthdiary.backend.services;

import org.hl7.fhir.dstu3.model.Patient;
import ssst.healthdiary.backend.dtos.PatientPayload;

public interface PatientServiceInterface extends BaseResourceService<Patient> {

    PatientPayload getPayload(String id);

    PatientPayload savePayload(PatientPayload payload);

    PatientPayload updatePayload(String id, PatientPayload payload);

    void deletePayload(String id);


}
