package com.project.Isil.Backend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.Isil.Backend.models.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
	
	@Query("SELECT p from Patient p where p.nom =:nom AND p.prenom =:prenom AND p.dateN =:daten")
   public List<Patient> getPatientsByNomPrenomDateN(@Param("nom") String nom,@Param("prenom") String prenom, @Param("daten") Date dateN);

}
