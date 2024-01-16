package com.org.patientMedicineAppointmentSystem.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Long appointmentId;
    private String doctorName;
    private String patientName;
    private String appointmentTime;

}
