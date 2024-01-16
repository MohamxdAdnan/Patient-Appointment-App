package com.org.patientMedicineAppointmentSystem.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {


    private Long doctorId;
    private String doctorName;
    private String specialisation;
    private String visitingHours;
    private List<String> patients;

}
