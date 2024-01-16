package com.org.patientMedicineAppointmentSystem.Repository;

import com.org.patientMedicineAppointmentSystem.Entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication,Long> {
}
