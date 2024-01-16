package com.org.patientMedicineAppointmentSystem.Service;

import com.org.patientMedicineAppointmentSystem.Entity.Patient;
import com.org.patientMedicineAppointmentSystem.Repository.PatientRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;
import java.util.stream.Collectors;

public class PatientUserDetailsService implements UserDetailsService {
    private PatientRepository patientRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Patient patient = patientRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Patient not found with this email"));
       Set<GrantedAuthority> authorities= patient.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
               .collect(Collectors.toSet());

        return new User(email, patient.getPassword(), authorities);
    }

}
