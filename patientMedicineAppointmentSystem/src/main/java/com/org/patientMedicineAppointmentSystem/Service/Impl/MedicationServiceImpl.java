package com.org.patientMedicineAppointmentSystem.Service.Impl;

import com.org.patientMedicineAppointmentSystem.Dto.AppointmentDto;
import com.org.patientMedicineAppointmentSystem.Dto.MedicationDto;
import com.org.patientMedicineAppointmentSystem.Entity.Appointment;
import com.org.patientMedicineAppointmentSystem.Entity.Medication;
import com.org.patientMedicineAppointmentSystem.Repository.MedicationRepository;
import com.org.patientMedicineAppointmentSystem.Service.MedicationService;
import com.org.patientMedicineAppointmentSystem.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicationServiceImpl implements MedicationService {
    private MedicationRepository medicationRepository;
    private ModelMapper modelMapper;

    @Override
    public MedicationDto createMedication(MedicationDto medicationDto) {
        Medication medication = modelMapper.map(medicationDto, Medication.class);
        Medication newMedication = medicationRepository.save(medication);
        return modelMapper.map(newMedication, MedicationDto.class);
    }

    @Override
    public MedicationDto updateMedication(MedicationDto medicationDto, Long medicationId) {
        Medication medication = medicationRepository.findById(medicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Medication not found with id:" + medicationId));
        medication.setMedicationName(medicationDto.getMedicationName());
        medication.setDoctors(medicationDto.getDoctors());
        medication.setPatients(medicationDto.getPatients());
        medication.setInStock(medicationDto.getInStock());


        Medication newMedication = medicationRepository.save(medication);
        return modelMapper.map(newMedication,MedicationDto.class);
    }

    @Override
    public void deleteMedication(Long medicationId) {
        Medication medication = medicationRepository.findById(medicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Medication not found with id:" + medicationId));
        medicationRepository.delete(medication);
    }

    @Override
    public MedicationDto getMedication(Long medicationId) {
        Medication medication = medicationRepository.findById(medicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Medication not found with id:" + medicationId));

        return modelMapper.map(medication,MedicationDto.class);
    }

    @Override
    public List<MedicationDto> getAllMedications() {
        List<Medication> allMedications = medicationRepository.findAll();
        List<MedicationDto> allMedicationDtos = allMedications.stream()
                .map((medication)->modelMapper.map(medication, MedicationDto.class)).collect(Collectors.toList());
        return allMedicationDtos;
    }
}
