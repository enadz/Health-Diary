package ssst.healthdiary.backend.services;

import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.dstu3.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssst.healthdiary.backend.clients.PatientHapiClient;
import ssst.healthdiary.backend.dtos.PatientPayload;
import ssst.healthdiary.backend.mappers.PatientMapper;

import java.util.Optional;

@Service
@Slf4j
public class PatientService implements PatientServiceInterface {
    @Autowired
    private PatientHapiClient patientHapiClient;

    @Override
    public Optional<Patient> get(final String resourceId) {
        try {
            return Optional.ofNullable(patientHapiClient.getById(resourceId));
        } catch (ResourceNotFoundException e) {
            log.error("No patient with id: {} found ", resourceId, e);
            throw e;
        }
    }

    @Override
    public Patient save(Patient resource) {
        return patientHapiClient.save(resource);
    }

    @Override
    public void update(Patient resource) {
        patientHapiClient.update(resource);
    }

    @Override
    public void delete(String resourceId) {
        patientHapiClient.deleteById(resourceId);
    }


    @Override
    public PatientPayload getPayload(String id) {
        Optional<Patient> optionalPatient = get(id);
        if (optionalPatient.isPresent()) {
            return PatientMapper.INSTANCE.toPayload(optionalPatient.get());
        }
        throw new ResourceNotFoundException("Patient does not exist");
    }

    @Override
    public PatientPayload savePayload(PatientPayload payload) {
        Patient patient = save(PatientMapper.INSTANCE.toEntity(payload));
        return PatientMapper.INSTANCE.toPayload(patient);
    }

    @Override
    public PatientPayload updatePayload(String id, PatientPayload payload) {
        Patient patient=patientHapiClient.updateAndGet(PatientMapper.INSTANCE.toEntity(payload), id);
        return PatientMapper.INSTANCE.toPayload(patient);
    }

    @Override
    public void deletePayload(String id) {
        delete(id);
    }

}
