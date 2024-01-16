package com.org.patientMedicineAppointmentSystem.Repository;

import com.org.patientMedicineAppointmentSystem.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor findByDoctorName(String doctorName);
}
