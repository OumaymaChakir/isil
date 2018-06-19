package com.project.Isil.Backend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.Isil.Backend.models.Analyse;

public interface AnalyseRepository extends JpaRepository<Analyse, Long>{
	
	@Query("SELECT a from analyses a where a.titre LIKE CONCAT('%',:titre,'%') OR a.code LIKE CONCAT('%',:code,'%')")
	   public List<Analyse> getAnalyseByTitreOrCode(@Param("titre") String titre,@Param("code") String code);

}
