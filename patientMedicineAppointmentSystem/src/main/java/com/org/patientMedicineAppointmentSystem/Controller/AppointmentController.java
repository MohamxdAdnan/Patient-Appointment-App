package com.org.patientMedicineAppointmentSystem.Controller;

import com.org.patientMedicineAppointmentSystem.Dto.AppointmentDto;
import com.org.patientMedicineAppointmentSystem.Dto.DoctorDto;
import com.org.patientMedicineAppointmentSystem.Service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD API's for Appointment Resource"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/Appointments")
public class AppointmentController {
    private AppointmentService appointmentService;

    @Operation(
            summary = "Create Appointment Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("create")
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto){
        AppointmentDto createdAppointment = appointmentService.createAppointment(appointmentDto);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Appointment Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<AppointmentDto> getAppointment (@PathVariable Long appointmentId) {
        AppointmentDto appointmentDto = appointmentService.getAppointment(appointmentId);
        return new ResponseEntity<>(appointmentDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Appointment Resources"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        List<AppointmentDto> allAppointments = appointmentService.getAllAppointments();
        return new ResponseEntity<>(allAppointments, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Appointment Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppointment (@PathVariable Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return new ResponseEntity<>("Appointment deleted", HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Update Appointment Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<AppointmentDto> updateAppointment (@RequestBody AppointmentDto appointmentDto, @PathVariable Long appointmentId) {
        AppointmentDto updatedAppointment = appointmentService.updateAppointment(appointmentDto, appointmentId);
        return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
    }
}
