package com.org.patientMedicineAppointmentSystem.Controller;

import com.org.patientMedicineAppointmentSystem.Dto.DoctorDto;
import com.org.patientMedicineAppointmentSystem.Dto.MedicationDto;
import com.org.patientMedicineAppointmentSystem.Service.MedicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD API's for Medication Resource"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/Medications")
public class MedicationController {

    private MedicationService medicationService;

    @Operation(
            summary = "Create Medication Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("create")
    public ResponseEntity<MedicationDto> createMedication(@RequestBody MedicationDto medicationDto){
        MedicationDto createdMedication = medicationService.createMedication(medicationDto);
        return new ResponseEntity<>(createdMedication, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Medication Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<MedicationDto> getMedication(@PathVariable Long medicationId) {
        MedicationDto medicationDto = medicationService.getMedication(medicationId);
        return new ResponseEntity<>(medicationDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Medication Resources"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<MedicationDto>> getAllMedications() {
        List<MedicationDto> allMedications= medicationService.getAllMedications();
        return new ResponseEntity<>(allMedications, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Medication Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMedication (@PathVariable Long medicationId) {
        medicationService.deleteMedication(medicationId);
        return new ResponseEntity<>("Medication deleted", HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Update Medication Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<MedicationDto> updateMedication(@RequestBody MedicationDto medicationDto, @PathVariable Long medicationId) {
        MedicationDto updatedMedication = medicationService.updateMedication(medicationDto, medicationId);
        return new ResponseEntity<>(updatedMedication, HttpStatus.OK);
    }
}
