package com.org.patientMedicineAppointmentSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    @Column(nullable = false)
    private String doctorName;
    @Column(nullable = false)
    private String patientName;
    @Column(nullable = false)
    private String appointmentTime;

}
