package com.org.patientMedicineAppointmentSystem.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(
        description = "Medication DTO Model Info"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDto {
    private Long medicationId;
    @Schema(
            description = "Medication Name"
    )
    private String medicationName;
    @Schema(
            description = "Doctors List"
    )
    private List<String> doctors;
    @Schema(
            description = "Patients List"
    )
    private List<String> patients;
    @Schema(
            description = "Medication In Stock Status"
    )
    private String inStock;
}
