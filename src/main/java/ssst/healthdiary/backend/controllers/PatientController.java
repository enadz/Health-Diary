package ssst.healthdiary.backend.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.hl7.fhir.dstu3.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ssst.healthdiary.backend.services.PatientService;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
@Validated
@Api(tags = "Patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/{userId}")
    @ApiOperation(value = "${healthdiary.patient.get}")
    public ResponseEntity getPatientsById(@PathVariable String userId){
        return new ResponseEntity(patientService.get(userId), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "${healthdiary.patient.create}")
    public Patient AddPatient(@RequestBody final Patient patient) {

        patientService.save(patient);
        return patient;
    }

}
