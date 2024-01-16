package com.org.patientMedicineAppointmentSystem.Service;

import com.org.patientMedicineAppointmentSystem.Dto.AppointmentDto;
import com.org.patientMedicineAppointmentSystem.Dto.DoctorDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment (AppointmentDto appointmentDto);
    AppointmentDto updateAppointment (AppointmentDto appointmentDto,Long appointmentId);
    void deleteAppointment (Long appointmentId);
    AppointmentDto getAppointment (Long appointmentId);
    List<AppointmentDto> getAllAppointments ();
}
