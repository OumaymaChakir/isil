package com.project.Isil.Backend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.Isil.Backend.models.Medecin;


public interface MedecinRepository extends JpaRepository<Medecin,Long> {

	@Query("SELECT m from Medecin m where m.nom =:nom AND m.prenom =:prenom AND m.code =:code")
	   public List<Medecin> getMedecinByNomPrenomCode(@Param("nom") String nom,@Param("prenom") String prenom, @Param("code") String code);
}
