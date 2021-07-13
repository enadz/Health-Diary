package ssst.healthdiary.backend.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssst.healthdiary.backend.dtos.PatientPayload;
import ssst.healthdiary.backend.entities.*;
import ssst.healthdiary.backend.services.GFitPatientService;
import ssst.healthdiary.backend.services.PatientService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/profile")
public class PatientProfileController {
    @Autowired
    GFitPatientService gFitPatientService;

    @Autowired
    PatientService patientService;

    @GetMapping("/fhir/{patientId}")
    @ApiOperation(value = "${healthdiary.patient.get}")
    public ResponseEntity<PatientPayload> getFhirPatientById(@PathVariable String patientId) {
        PatientPayload result = patientService.getPayload(patientId);
        return ResponseEntity.ok(result);
    }

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

    @GetMapping("/{id}/heart")
    public Iterable<PatientHeartData> getHeartrateDetails(@PathVariable String id){
        return gFitPatientService.getPatientHeart(id);
    }

    @GetMapping("/{id}/steps")
    public Iterable<PatientActivityData> getStepDetails(@PathVariable String id){
        return gFitPatientService.getPatientActivity(id);
    }

    @GetMapping("/{id}/sleep")
    public Iterable<PatientSleepData> getSleepDetails(@PathVariable String id){
        return gFitPatientService.getPatientSleep(id);
    }

    @GetMapping("/{id}/doctors")
    public Iterable<Doctor> getDoctors(@PathVariable String id){
        return gFitPatientService.getPatientDoctors(id);
    }

    @PostMapping("/oxygen")
    public ResponseEntity addNewOxygenRecord(@RequestBody PatientOxygenData oxygenData){
        gFitPatientService.addOxygen(oxygenData);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/heart")
    public ResponseEntity addNewHeartrateRecord(@RequestBody PatientHeartData heart){
        gFitPatientService.addHeartrate(heart);
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

    @PostMapping("/doctor")
    public ResponseEntity addDoctor(@RequestBody Doctor doctor){
        gFitPatientService.addDoctor(doctor);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping("/{id}")
    public ResponseEntity addPatient(@PathVariable String id){
        gFitPatientService.addNewPatient(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
