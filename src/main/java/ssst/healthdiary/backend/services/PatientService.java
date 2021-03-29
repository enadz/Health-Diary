package ssst.healthdiary.backend.services;

import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.hl7.fhir.dstu3.model.Patient;
import org.springframework.stereotype.Service;
import ssst.healthdiary.backend.clients.PatientHapiClient;

@Service
@RequiredArgsConstructor
public class PatientService implements PatientServiceInterface{

    private PatientHapiClient patientHapiClient;

    @Override
    public Optional<Patient> get(final String resourceId) {
        try {
            return Optional.ofNullable(patientHapiClient.getById(resourceId));
        } catch (ResourceNotFoundException e) {
            System.out.println("No patient with id " + resourceId + " found/n" + e.getMessage());
            throw e;
        }
    }

    @Override
    public Patient save(final Patient resource) {
        return patientHapiClient.save(resource);
    }

    @Override
    public void update(final Patient resource) {
        patientHapiClient.update(resource);
    }

    @Override
    public void delete(final String resourceId) {
        patientHapiClient.deleteById(resourceId);
    }

}
