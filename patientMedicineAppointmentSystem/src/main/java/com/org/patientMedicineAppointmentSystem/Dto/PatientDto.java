package com.org.patientMedicineAppointmentSystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private Long patientId;
    private String patientName;
    private String email;
    private String password;
    private String contact;
    private String medicalHistory;
}
