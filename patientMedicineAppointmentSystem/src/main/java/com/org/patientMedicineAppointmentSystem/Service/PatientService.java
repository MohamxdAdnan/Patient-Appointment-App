package com.org.patientMedicineAppointmentSystem.Service;

import com.org.patientMedicineAppointmentSystem.Dto.PatientDto;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    PatientDto createPatient (PatientDto patientDto);
    PatientDto updatePatient (PatientDto patientDto,Long patientId);
    void deletePatient (Long patientId);
    PatientDto getPatient (Long patientId);
    List<PatientDto> getAllPatients ();

    Optional<PatientDto> getLoginInfo (String username, String password);


}
