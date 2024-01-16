package com.org.patientMedicineAppointmentSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicationId;
    @Column(nullable = false)
    private String medicationName;
    @Column(nullable = false)
    private List<String> doctors;
    @Column(nullable = false)
    private List<String> patients;
    @Column(nullable = false)
    private String inStock;
}
