package com.org.patientMedicineAppointmentSystem.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "Patient DTO Model Info"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private Long patientId;
    @Schema(
            description = "Patient Name"
    )
    private String patientName;
    @Schema(
            description = "Email"
    )
    private String email;
    @Schema(
            description = "Password"
    )
    private String password;
    @Schema(
            description = "Contact Number"
    )
    private String contact;
    @Schema(
            description = "Medical History"
    )
    private String medicalHistory;
}
