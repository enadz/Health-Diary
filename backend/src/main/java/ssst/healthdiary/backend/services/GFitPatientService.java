package ssst.healthdiary.backend.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ssst.healthdiary.backend.entities.*;
import ssst.healthdiary.backend.repositories.*;

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
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientHeartDataRepository patientHeartDataRepository;

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

    public Iterable<PatientHeartData> getPatientHeart (String patientId){
        Iterable<PatientHeartData> data = patientHeartDataRepository.findByPatientId(patientId);
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

    public Iterable<Doctor> getPatientDoctors (String patientId){
        Iterable<Doctor> data = doctorRepository.findByPatientId(patientId);
        return data;
    }

    public void addOxygen(PatientOxygenData oxygen){
        patientOxygenDataRepository.save(new PatientOxygenData(oxygen.getId(), oxygen.getGfitpatient() , oxygen.getStartTime(), oxygen.getEndTime(), oxygen.getOxygenSaturation()));
    }

    public void addHeartrate(PatientHeartData bpm){
        patientHeartDataRepository.save(new PatientHeartData(bpm.getId(), bpm.getGfitpatient() , bpm.getStartTime(), bpm.getEndTime(), bpm.getBpm()));
    }

    public void addSleep(PatientSleepData sleep){
        patientSleepDataRepository.save(new PatientSleepData(sleep.getId(), sleep.getGfitpatient(), sleep.getStartTime(), sleep.getEndTime(), sleep.getStage()));
    }

    public void addSteps(PatientActivityData steps){
        patientActivityDataRepository.save(new PatientActivityData(steps.getId(), steps.getGfitpatient(), steps.getStartTime(), steps.getEndTime(), steps.getSteps()));
    }

    public void addDoctor(Doctor doctor){
        doctorRepository.save(new Doctor(doctor.getDoctorId(), doctor.getName(), doctor.getEmail(), doctor.getPassword(), doctor.getGfitpatient()));
    }


    public void addNewPatient(String patientId){
        patientRepository.save(new GFitPatient(patientId));
    }

}
