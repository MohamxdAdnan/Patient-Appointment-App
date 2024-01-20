package com.org.patientMedicineAppointmentSystem.Dto;

import com.org.patientMedicineAppointmentSystem.Entity.Appointment;
import com.org.patientMedicineAppointmentSystem.Entity.Patient;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


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
            description = "Doctor Visiting Hours From"
    )
    private Date visitingHoursFrom;
    @Schema(
            description = "Doctor Visiting Hours To"
    )
    private Date visitingHoursTo;
    @Schema(
            description = "Patient Info"
    )
    private Patient patient;



}
