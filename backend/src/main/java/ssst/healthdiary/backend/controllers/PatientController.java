package ssst.healthdiary.backend.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssst.healthdiary.backend.dtos.PatientPayload;
import ssst.healthdiary.backend.services.PatientService;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
@Api(tags = "Patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/{patientId}")
    @ApiOperation(value = "${healthdiary.patient.get}")
    public ResponseEntity<PatientPayload> getPatientById(@PathVariable String patientId) {
        PatientPayload result = patientService.getPayload(patientId);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ApiOperation(value = "${healthdiary.patient.create}")
    public ResponseEntity<PatientPayload> createPatient(@RequestBody final PatientPayload patientPayload) {
        PatientPayload result = patientService.savePayload(patientPayload);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{patientId}")
    @ApiOperation(value = "${healthdiary.patient.update}")
    public ResponseEntity<PatientPayload> updatePatient(@PathVariable String patientId,
                                                        @RequestBody final PatientPayload patientPayload) {
        PatientPayload result = patientService.updatePayload(patientId, patientPayload);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{patientId}")
    @ApiOperation(value = "${healthdiary.patient.delete}")
    public ResponseEntity<Object> deletePatientById(@PathVariable String patientId) {
        patientService.deletePayload(patientId);
        return ResponseEntity.noContent().build();
    }

}
