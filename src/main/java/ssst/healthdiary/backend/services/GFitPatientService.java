package ssst.healthdiary.backend.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ssst.healthdiary.backend.entities.GFitPatient;
import ssst.healthdiary.backend.entities.PatientActivityData;
import ssst.healthdiary.backend.entities.PatientOxygenData;
import ssst.healthdiary.backend.entities.PatientSleepData;
import ssst.healthdiary.backend.repositories.PatientActivityDataRepository;
import ssst.healthdiary.backend.repositories.PatientOxygenDataRepository;
import ssst.healthdiary.backend.repositories.PatientRepository;
import ssst.healthdiary.backend.repositories.PatientSleepDataRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GFitPatientService {
    @Autowired
    PatientSleepDataRepository patientSleepDataRepository;
    @Autowired
    PatientOxygenDataRepository patientOxygenDataRepository;
    @Autowired
    PatientActivityDataRepository patientActivityDataRepository;
    @Autowired
    PatientRepository patientRepository;

    public Iterable<GFitPatient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Optional<GFitPatient> getPatient(String patientId){
        return patientRepository.findById(patientId);
    }

    public Iterable<PatientOxygenData> getPatientOxygen (String patientId){
        Iterable<PatientOxygenData> data = patientOxygenDataRepository.findByPatientId(patientId);
        return data;
    }

    public Iterable<PatientActivityData> getPatientActivity (String patientId){
        Iterable<PatientActivityData> data = patientActivityDataRepository.findByPatientId(patientId);
        return data;
    }

    public Iterable<PatientSleepData> getPatientSleep (String patientId){
        Iterable<PatientSleepData> data = patientSleepDataRepository.findByPatientId(patientId);
        return data;
    }

    public void addOxygen(PatientOxygenData oxygen){
        patientOxygenDataRepository.save(new PatientOxygenData(oxygen.getId(), oxygen.getGfitpatient() , oxygen.getStartTime(), oxygen.getEndTime(), oxygen.getOxygenSaturation()));
    }
    public void addSleep(PatientSleepData sleep){
        patientSleepDataRepository.save(new PatientSleepData(sleep.getId(), sleep.getGfitpatient(), sleep.getStartTime(), sleep.getEndTime(), sleep.getStage()));
    }

    public void addSteps(PatientActivityData steps){
        patientActivityDataRepository.save(new PatientActivityData(steps.getId(), steps.getGfitpatient(), steps.getStartTime(), steps.getEndTime(), steps.getSteps()));
    }

    public void addNewPatient(String patientId){
        patientRepository.save(new GFitPatient(patientId));
    }

}
