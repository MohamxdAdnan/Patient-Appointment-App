package com.org.patientMedicineAppointmentSystem.Repository;

import com.org.patientMedicineAppointmentSystem.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
Optional<Patient> findByEmail(String email);
}
