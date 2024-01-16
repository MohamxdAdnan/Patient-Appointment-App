package com.org.patientMedicineAppointmentSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    @Column(nullable = false)
    private String doctorName;
    @Column(nullable = false)
    private String specialisation;
    @Column(nullable = false)
    private String visitingHours;
    @Column(nullable = false)
    private List<String> patients;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "doctor_roles",
            joinColumns = @JoinColumn(name = "doctor_id",referencedColumnName = "doctorId"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Set<Role> roles;


}
