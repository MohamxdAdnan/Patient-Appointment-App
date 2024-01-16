package com.org.patientMedicineAppointmentSystem.Controller;

import com.org.patientMedicineAppointmentSystem.Dto.DoctorDto;
import com.org.patientMedicineAppointmentSystem.Dto.PatientDto;
import com.org.patientMedicineAppointmentSystem.Service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Doctors")
public class DoctorController {
    DoctorService doctorService;
    @PostMapping("create")
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto createdDoctor = doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable Long doctorId) {
        DoctorDto doctorDto = doctorService.getDoctor(doctorId);
        return new ResponseEntity<>(doctorDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        List<DoctorDto> allDoctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(allDoctors, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDoctor (@PathVariable Long doctorId) {
        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>("Doctor deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto doctorDto, @PathVariable Long doctorId) {
        DoctorDto updatedDoctor = doctorService.updateDoctor(doctorDto, doctorId);
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
    }
}
