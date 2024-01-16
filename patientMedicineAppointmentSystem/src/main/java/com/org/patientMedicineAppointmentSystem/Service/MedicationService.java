package com.org.patientMedicineAppointmentSystem.Service;

import com.org.patientMedicineAppointmentSystem.Dto.MedicationDto;
import com.org.patientMedicineAppointmentSystem.Dto.PatientDto;

import java.util.List;

public interface MedicationService {

    MedicationDto createMedication (MedicationDto medicationDto);
    MedicationDto updateMedication (MedicationDto medicationDto,Long medicationId);
    void deleteMedication (Long medicationId);
    MedicationDto getMedication (Long medicationId);
    List<MedicationDto> getAllMedications ();
}
