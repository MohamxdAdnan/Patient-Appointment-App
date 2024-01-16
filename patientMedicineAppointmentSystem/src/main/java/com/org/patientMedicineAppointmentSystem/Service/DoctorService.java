package com.org.patientMedicineAppointmentSystem.Service;

import com.org.patientMedicineAppointmentSystem.Dto.DoctorDto;
import com.org.patientMedicineAppointmentSystem.Dto.PatientDto;

import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor (DoctorDto doctorDto);
    DoctorDto updateDoctor (DoctorDto doctorDto,Long doctorId);
    void deleteDoctor (Long doctorId);
    DoctorDto getDoctor (Long doctorId);
    DoctorDto getDoctorByName (String doctorName);
    List<DoctorDto> getAllDoctors ();
}
