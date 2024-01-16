package com.org.patientMedicineAppointmentSystem.Controller;

import com.org.patientMedicineAppointmentSystem.Dto.AppointmentDto;
import com.org.patientMedicineAppointmentSystem.Dto.DoctorDto;
import com.org.patientMedicineAppointmentSystem.Service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Appointments")
public class AppointmentController {
    private AppointmentService appointmentService;

    @PostMapping("create")
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto){
        AppointmentDto createdAppointment = appointmentService.createAppointment(appointmentDto);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AppointmentDto> getAppointment (@PathVariable Long appointmentId) {
        AppointmentDto appointmentDto = appointmentService.getAppointment(appointmentId);
        return new ResponseEntity<>(appointmentDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        List<AppointmentDto> allAppointments = appointmentService.getAllAppointments();
        return new ResponseEntity<>(allAppointments, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppointment (@PathVariable Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return new ResponseEntity<>("Appointment deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<AppointmentDto> updateAppointment (@RequestBody AppointmentDto appointmentDto, @PathVariable Long appointmentId) {
        AppointmentDto updatedAppointment = appointmentService.updateAppointment(appointmentDto, appointmentId);
        return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
    }
}
