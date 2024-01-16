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
        description = "Doctor DTO Model Info"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {


    private Long doctorId;
    @Schema(
            description = "Doctor Name"
    )
    private String doctorName;
    @Schema(
            description = "Doctor Specialization"
    )
    private String specialisation;
    @Schema(
            description = "Doctor Visiting Hours"
    )
    private String visitingHours;
    @Schema(
            description = "Patient List"
    )
    private List<String> patients;

}
