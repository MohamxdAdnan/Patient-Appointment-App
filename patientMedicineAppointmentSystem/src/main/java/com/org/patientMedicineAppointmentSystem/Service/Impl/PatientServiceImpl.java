package com.org.patientMedicineAppointmentSystem.Service.Impl;

import com.org.patientMedicineAppointmentSystem.Dto.PatientDto;
import com.org.patientMedicineAppointmentSystem.Dto.RoleDto;
import com.org.patientMedicineAppointmentSystem.Entity.Patient;
import com.org.patientMedicineAppointmentSystem.Entity.Role;
import com.org.patientMedicineAppointmentSystem.Repository.PatientRepository;
import com.org.patientMedicineAppointmentSystem.Repository.RoleRepository;
import com.org.patientMedicineAppointmentSystem.Service.PatientService;
import com.org.patientMedicineAppointmentSystem.Service.RoleService;
import com.org.patientMedicineAppointmentSystem.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    private RoleService roleService;
    private ModelMapper modelMapper;

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Optional<Patient> existingPatient = patientRepository.findByEmail(patientDto.getEmail());
        if(existingPatient.isPresent()){
            throw new ResourceNotFoundException("Email Already Exists");
        }
        RoleDto roleDto = new RoleDto("ROLE_USER");
        patientDto.setRoles((Set<Role>) roleService.createRole(roleDto));
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

    @Override
    public Optional<PatientDto> getLoginInfo(String username, String password) {
        return Optional.empty();
    }

}
