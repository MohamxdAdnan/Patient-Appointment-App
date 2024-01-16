package com.org.patientMedicineAppointmentSystem.Controller;


import com.org.patientMedicineAppointmentSystem.Dto.PatientDto;
import com.org.patientMedicineAppointmentSystem.Service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Patients")
public class PatientController {
    private PatientService patientService;


    @PostMapping("create")
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto){
        PatientDto createdPatient = patientService.createPatient(patientDto);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable Long patientId) {
        PatientDto patientDto = patientService.getPatient(patientId);
        return new ResponseEntity<>(patientDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        List<PatientDto> allPatients = patientService.getAllPatients();
        return new ResponseEntity<>(allPatients, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient (@PathVariable Long patientId) {
        patientService.deletePatient(patientId);
        return new ResponseEntity<>("Patient deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto, @PathVariable Long patientId) {
        PatientDto updatedPatient = patientService.updatePatient(patientDto, patientId);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

}
