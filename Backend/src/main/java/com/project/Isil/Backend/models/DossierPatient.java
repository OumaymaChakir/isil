package com.project.Isil.Backend.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class DossierPatient {
	@Id @GeneratedValue
	private Long id; 
	private String numP;
	private int priorite;
	private String com ; 
	private String renseignement;
	@Temporal(TemporalType.DATE)
	private Date datecreation ;
	@Temporal(TemporalType.DATE)
	private Date datemodif;
	
	@ManyToOne
    @JoinColumn(name="idP", referencedColumnName = "id")
    private Patient patient;
	@ManyToMany(mappedBy = "dps")
    private List<Medecin> medecins = new ArrayList<>();
	
	@OneToMany(mappedBy = "dossierpatient")
	  private List<Analysedemander> analysesd;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumP() {
		return numP;
	}

	public void setNumP(String numP) {
		this.numP = numP;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getRenseignement() {
		return renseignement;
	}

	public void setRenseignement(String renseignement) {
		this.renseignement = renseignement;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public Date getDatemodif() {
		return datemodif;
	}

	public void setDatemodif(Date datemodif) {
		this.datemodif = datemodif;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
