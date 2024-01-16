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
public class MedicationDto {
    private Long medicationId;
    private String medicationName;
    private List<String> doctors;
    private List<String> patients;
    private String inStock;
}
