package ssst.healthdiary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssst.healthdiary.models.Patient;
import ssst.healthdiary.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getPatients(){

        List<Patient> allPatients= (List<Patient>) patientRepository.findAll();
        return allPatients;
    }

    public Optional<Patient> getPatientById (int id){
        Optional<Patient> patient = patientRepository.findById(id);
        return patient;
    }

    public void createPatient(Patient patient){
        patientRepository.save(patient);
    }

}
