package com.org.patientMedicineAppointmentSystem.Controller;


import com.org.patientMedicineAppointmentSystem.Dto.LoginDto;
import com.org.patientMedicineAppointmentSystem.Dto.PatientDto;
import com.org.patientMedicineAppointmentSystem.Service.PatientService;
import com.org.patientMedicineAppointmentSystem.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(
        name = "CRUD API's for Patient Resource"
)
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/patients")
public class PatientController {
    private PatientService patientService;

//    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
//        Optional<PatientDto> patientExist = Optional.ofNullable(patientService
//                .getLoginInfo(loginDto.getUsername(), loginDto.getPassword())
//                .orElseThrow(new ResourceNotFoundException("Email or Password incorrect")));
//
//        return new ResponseEntity<>("OK",HttpStatus.OK);
//    }

    @Operation(
            summary = "Create Patient Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("create")
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto){
        PatientDto createdPatient = patientService.createPatient(patientDto);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Patient Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable Long patientId) {
        PatientDto patientDto = patientService.getPatient(patientId);
        return new ResponseEntity<>(patientDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Patient Resources"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        List<PatientDto> allPatients = patientService.getAllPatients();
        return new ResponseEntity<>(allPatients, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Patient Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient (@PathVariable Long patientId) {
        patientService.deletePatient(patientId);
        return new ResponseEntity<>("Patient deleted", HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Update Patient Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto, @PathVariable Long patientId) {
        PatientDto updatedPatient = patientService.updatePatient(patientDto, patientId);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

}
