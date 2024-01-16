package com.org.patientMedicineAppointmentSystem.Repository;
import com.org.patientMedicineAppointmentSystem.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
