package com.org.patientMedicineAppointmentSystem.Service.Impl;

import com.org.patientMedicineAppointmentSystem.Dto.AppointmentDto;
import com.org.patientMedicineAppointmentSystem.Dto.DoctorDto;
import com.org.patientMedicineAppointmentSystem.Entity.Appointment;
import com.org.patientMedicineAppointmentSystem.Entity.Doctor;
import com.org.patientMedicineAppointmentSystem.Repository.AppointmentRepository;
import com.org.patientMedicineAppointmentSystem.Service.AppointmentService;
import com.org.patientMedicineAppointmentSystem.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    private ModelMapper modelMapper;

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
        Appointment newAppointment = appointmentRepository.save(appointment);
        return modelMapper.map(newAppointment, AppointmentDto.class);
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto, Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id:" + appointmentId));
        appointment.setAppointmentTime(appointmentDto.getAppointmentTime());
        appointment.setDoctorName(appointmentDto.getDoctorName());
        appointment.setPatientName(appointmentDto.getPatientName());


        Appointment newAppointment = appointmentRepository.save(appointment);
        return modelMapper.map(newAppointment,AppointmentDto.class);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id:" + appointmentId));
        appointmentRepository.delete(appointment);
    }

    @Override
    public AppointmentDto getAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id:" + appointmentId));
        return modelMapper.map(appointment,AppointmentDto.class);
    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> allAppointments = appointmentRepository.findAll();
        List<AppointmentDto> allAppointmentDtos = allAppointments.stream()
                .map((appointment)->modelMapper.map(appointment, AppointmentDto.class)).collect(Collectors.toList());
        return allAppointmentDtos;
    }
}
