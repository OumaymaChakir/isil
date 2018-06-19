package com.project.Isil.Backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Analysedemander {
	@Id
	@GeneratedValue
	private Long id;
	private String priorite;
	
	@ManyToOne
    @JoinColumn(name="idDp", referencedColumnName = "id")
    private DossierPatient dossierpatient ;
	
	@ManyToOne
    @JoinColumn(name="idA", referencedColumnName = "id")
    private Analyse analyses ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPriorite() {
		return priorite;
	}

	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}

	public DossierPatient getDossierpatient() {
		return dossierpatient;
	}

	public void setDossierpatient(DossierPatient dossierpatient) {
		this.dossierpatient = dossierpatient;
	}

	public Analyse getAnalyse() {
		return analyses;
	}

	public void setAnalyse(Analyse analyse) {
		this.analyses = analyse;
	}
	
	

}
