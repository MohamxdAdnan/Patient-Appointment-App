package com.org.patientMedicineAppointmentSystem.Service.Impl;

import com.org.patientMedicineAppointmentSystem.Dto.PatientDto;
import com.org.patientMedicineAppointmentSystem.Entity.Patient;
import com.org.patientMedicineAppointmentSystem.Repository.PatientRepository;
import com.org.patientMedicineAppointmentSystem.Service.PatientService;
import com.org.patientMedicineAppointmentSystem.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    PatientRepository patientRepository;
    ModelMapper modelMapper;

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        Patient newPatient = patientRepository.save(patient);
        return modelMapper.map(newPatient,PatientDto.class);
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id:" + patientId));
        patient.setPatientName(patientDto.getPatientName());
        patient.setEmail(patientDto.getEmail());
        patient.setPassword(patientDto.getPassword());
        patient.setContact(patientDto.getContact());
        patient.setMedicalHistory(patientDto.getMedicalHistory());

        Patient newPatient = patientRepository.save(patient);
        return modelMapper.map(newPatient,PatientDto.class);
    }

    @Override
    public void deletePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id:" + patientId));
        patientRepository.delete(patient);
    }

    @Override
    public PatientDto getPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id:" + patientId));

        return modelMapper.map(patient,PatientDto.class);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> allPatients = patientRepository.findAll();
        List<PatientDto> allPatientDtos = allPatients.stream()
                .map((patient)->modelMapper.map(patient, PatientDto.class)).collect(Collectors.toList());
        return allPatientDtos;
    }
}
