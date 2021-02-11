package ssst.healthdiary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import ssst.healthdiary.models.Patient;
import ssst.healthdiary.services.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @CrossOrigin
    @PostMapping("/new")
    public ResponseEntity newPatient(@RequestBody Patient patient) {
        try {
            patientService.createPatient(patient);
            return new ResponseEntity( HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @CrossOrigin
    @GetMapping("patients")
    public ResponseEntity getAllPatients() {
        return new ResponseEntity(patientService.getPatients(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity getPatientsById(@PathVariable int id){
        return new ResponseEntity(patientService.getPatientById(id), HttpStatus.OK);
    }

}
