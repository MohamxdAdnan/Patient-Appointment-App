package com.org.patientMedicineAppointmentSystem.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "Appointment DTO Model Info"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {

    private Long appointmentId;
    @Schema(
            description = "Doctor Name"
    )
    private String doctorName;
    @Schema(
            description = "Patient Name"
    )
    private String patientName;
    @Schema(
            description = "Appointment Time"
    )
    private String appointmentTime;

}
