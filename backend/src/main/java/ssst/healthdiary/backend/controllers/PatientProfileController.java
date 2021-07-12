package ssst.healthdiary.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssst.healthdiary.backend.entities.GFitPatient;
import ssst.healthdiary.backend.entities.PatientActivityData;
import ssst.healthdiary.backend.entities.PatientOxygenData;
import ssst.healthdiary.backend.entities.PatientSleepData;
import ssst.healthdiary.backend.services.GFitPatientService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/profile")
public class PatientProfileController {
    @Autowired
    GFitPatientService gFitPatientService;

    @GetMapping
    public Iterable<GFitPatient> getAllPatients(){
        return gFitPatientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Optional<GFitPatient> getPatientById(@PathVariable String patientId){
        return gFitPatientService.getPatient(patientId);
    }


    @GetMapping("/{id}/oxygen")
    public Iterable<PatientOxygenData> getOxygenDetails(@PathVariable String id){
        return gFitPatientService.getPatientOxygen(id);
    }

    @GetMapping("/{id}/steps")
    public Iterable<PatientActivityData> getStepDetails(@PathVariable String id){
        return gFitPatientService.getPatientActivity(id);
    }

    @GetMapping("/{id}/sleep")
    public Iterable<PatientSleepData> getSleepDetails(@PathVariable String id){
        return gFitPatientService.getPatientSleep(id);
    }

    @PostMapping("/oxygen")
    public ResponseEntity addNewOxygenRecord(@RequestBody PatientOxygenData oxygenData){
        gFitPatientService.addOxygen(oxygenData);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/steps")
    public ResponseEntity addNewStepsRecord(@RequestBody PatientActivityData activityData){
        gFitPatientService.addSteps(activityData);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/sleep")
    public ResponseEntity addNewSleepRecord(@RequestBody PatientSleepData sleepData){
        gFitPatientService.addSleep(sleepData);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping("/{id}")
    public ResponseEntity addPatient(@PathVariable String id){
        gFitPatientService.addNewPatient(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
