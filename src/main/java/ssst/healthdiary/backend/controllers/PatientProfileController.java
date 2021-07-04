package ssst.healthdiary.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssst.healthdiary.backend.entities.PatientActivityData;
import ssst.healthdiary.backend.entities.PatientOxygenData;
import ssst.healthdiary.backend.entities.PatientSleepData;
import ssst.healthdiary.backend.services.GFitPatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/profile")
public class PatientProfileController {
    @Autowired
    GFitPatientService gFitPatientService;

    @GetMapping
    public ResponseEntity getAllPatients(){
        return new ResponseEntity(gFitPatientService.getAllPatients(), HttpStatus.OK);
    }


    @GetMapping("/{id}/oxygen")
    public ResponseEntity getOxygenDetails(@PathVariable int id){
        return new ResponseEntity(gFitPatientService.getPatientOxygen(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/steps")
    public ResponseEntity getStepDetails(@PathVariable int id){
        return new ResponseEntity(gFitPatientService.getPatientActivity(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/sleep")
    public ResponseEntity getSleepDetails(@PathVariable int id){
        return new ResponseEntity(gFitPatientService.getPatientSleep(id), HttpStatus.OK);
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
    public ResponseEntity addPatient(@PathVariable int id){
        gFitPatientService.addNewPatient(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
