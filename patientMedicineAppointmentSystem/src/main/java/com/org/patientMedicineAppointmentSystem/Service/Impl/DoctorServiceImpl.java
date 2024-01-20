package com.org.patientMedicineAppointmentSystem.Service.Impl;

import com.org.patientMedicineAppointmentSystem.Dto.DoctorDto;
import com.org.patientMedicineAppointmentSystem.Dto.PatientDto;
import com.org.patientMedicineAppointmentSystem.Entity.Doctor;
import com.org.patientMedicineAppointmentSystem.Entity.Patient;
import com.org.patientMedicineAppointmentSystem.Repository.DoctorRepository;
import com.org.patientMedicineAppointmentSystem.Service.DoctorService;
import com.org.patientMedicineAppointmentSystem.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;
    private ModelMapper modelMapper;


    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {

        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        Doctor newDoctor = doctorRepository.save(doctor);
        return modelMapper.map(newDoctor, DoctorDto.class);
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id:" + doctorId));
        doctor.setDoctorName(doctorDto.getDoctorName());
        doctor.setSpecialisation(doctorDto.getSpecialisation());
        doctor.setVisitingHoursFrom(doctorDto.getVisitingHoursFrom());
        doctor.setVisitingHoursTo(doctorDto.getVisitingHoursTo());


        Doctor newDoctor = doctorRepository.save(doctor);
        return modelMapper.map(newDoctor,DoctorDto.class);
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id:" + doctorId));
        doctorRepository.delete(doctor);
    }

    @Override
    public DoctorDto getDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id:" + doctorId));
        return modelMapper.map(doctor,DoctorDto.class);
    }

    @Override
    public DoctorDto getDoctorByName(String doctorName) {
        return null;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> allDoctors = doctorRepository.findAll();
        List<DoctorDto> allDoctorDtos = allDoctors.stream()
                .map((doctor)->modelMapper.map(doctor, DoctorDto.class)).collect(Collectors.toList());
        return allDoctorDtos;
    }
}
