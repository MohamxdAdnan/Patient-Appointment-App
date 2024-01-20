package com.org.patientMedicineAppointmentSystem.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "Role DTO Model Info"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Long id;
    @Schema(
            description = "Role Name"
    )
    private String name;

    public RoleDto(String roleUser) {
        this.name= roleUser;
    }
}
