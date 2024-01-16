package com.org.patientMedicineAppointmentSystem.Controller;

import com.org.patientMedicineAppointmentSystem.Dto.DoctorDto;
import com.org.patientMedicineAppointmentSystem.Dto.PatientDto;
import com.org.patientMedicineAppointmentSystem.Service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD API's for Doctor Resource"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/Doctors")
public class DoctorController {
    private DoctorService doctorService;

    @Operation(
            summary = "Create Doctor Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("create")
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto createdDoctor = doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Doctor Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable Long doctorId) {
        DoctorDto doctorDto = doctorService.getDoctor(doctorId);
        return new ResponseEntity<>(doctorDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Doctor Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        List<DoctorDto> allDoctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(allDoctors, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Doctor Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDoctor (@PathVariable Long doctorId) {
        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>("Doctor deleted", HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Update Doctor Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto doctorDto, @PathVariable Long doctorId) {
        DoctorDto updatedDoctor = doctorService.updateDoctor(doctorDto, doctorId);
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
    }
}
