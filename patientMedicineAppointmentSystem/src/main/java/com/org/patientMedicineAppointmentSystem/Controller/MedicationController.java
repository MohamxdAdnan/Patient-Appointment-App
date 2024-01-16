package com.org.patientMedicineAppointmentSystem.Controller;

import com.org.patientMedicineAppointmentSystem.Dto.DoctorDto;
import com.org.patientMedicineAppointmentSystem.Dto.MedicationDto;
import com.org.patientMedicineAppointmentSystem.Service.MedicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Medications")
public class MedicationController {

    MedicationService medicationService;

    @PostMapping("create")
    public ResponseEntity<MedicationDto> createMedication(@RequestBody MedicationDto medicationDto){
        MedicationDto createdMedication = medicationService.createMedication(medicationDto);
        return new ResponseEntity<>(createdMedication, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MedicationDto> getMedication(@PathVariable Long medicationId) {
        MedicationDto medicationDto = medicationService.getMedication(medicationId);
        return new ResponseEntity<>(medicationDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MedicationDto>> getAllMedications() {
        List<MedicationDto> allMedications= medicationService.getAllMedications();
        return new ResponseEntity<>(allMedications, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMedication (@PathVariable Long medicationId) {
        medicationService.deleteMedication(medicationId);
        return new ResponseEntity<>("Medication deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<MedicationDto> updateMedication(@RequestBody MedicationDto medicationDto, @PathVariable Long medicationId) {
        MedicationDto updatedMedication = medicationService.updateMedication(medicationDto, medicationId);
        return new ResponseEntity<>(updatedMedication, HttpStatus.OK);
    }
}
