package com.org.patientMedicineAppointmentSystem.Service;

import com.org.patientMedicineAppointmentSystem.Dto.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto createPatient (PatientDto patientDto);
    PatientDto updatePatient (PatientDto patientDto,Long patientId);
    void deletePatient (Long patientId);
    PatientDto getPatient (Long patientId);
    List<PatientDto> getAllPatients ();
}
