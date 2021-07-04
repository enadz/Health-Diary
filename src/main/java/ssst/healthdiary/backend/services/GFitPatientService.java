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

    public ResponseEntity getAllPatients(){
        return new ResponseEntity(patientRepository.findAll(), HttpStatus.OK);
    }

    public Iterable<PatientOxygenData> getPatientOxygen (int patientId){
        Iterable<PatientOxygenData> data = patientOxygenDataRepository.findByPatientId(patientId);
        return data;
    }

    public Iterable<PatientActivityData> getPatientActivity (int patientId){
        Iterable<PatientActivityData> data = patientActivityDataRepository.findByPatientId(patientId);
        return data;
    }

    public Iterable<PatientSleepData> getPatientSleep (int patientId){
        Iterable<PatientSleepData> data = patientSleepDataRepository.findByPatientId(patientId);
        return data;
    }

    public void addOxygen(PatientOxygenData oxygen){
        patientOxygenDataRepository.save(new PatientOxygenData(oxygen.getId(), oxygen.getPatientId(), oxygen.getStartTime(), oxygen.getEndTime(), oxygen.getOxygenSaturation()));
    }
    public void addSleep(PatientSleepData sleep){
        patientSleepDataRepository.save(new PatientSleepData(sleep.getId(), sleep.getPatientId(), sleep.getStartTime(), sleep.getEndTime(), sleep.getStage()));
    }

    public void addSteps(PatientActivityData steps){
        patientActivityDataRepository.save(new PatientActivityData(steps.getId(), steps.getPatientId(), steps.getStartTime(), steps.getEndTime(), steps.getSteps()));
    }

    public void addNewPatient(int patientId){
        patientRepository.save(new GFitPatient(patientId));
    }

}
