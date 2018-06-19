package com.project.Isil.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Isil.Backend.models.DossierPatient;



public interface DossierPatientRepository extends JpaRepository<DossierPatient, Long> {

}