package com.project.Isil.Backend.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity(name="analyses")
public class Analyse {
	
	@Id
	@GeneratedValue
	private Long id;
	private String titre;
	private String soustitre;
	private String code;
	private Long prix ; 
	private Long ordre; 
	 
	 @OneToMany(mappedBy = "analyses")
	  private List<Analysedemander> analysesd;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getSoustitre() {
		return soustitre;
	}

	public void setSoustitre(String soustitre) {
		this.soustitre = soustitre;
	}

	public Long getPrix() {
		return prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}

	public Long getOrdre() {
		return ordre;
	}

	public void setOrdre(Long ordre) {
		this.ordre = ordre;
	}

	public List<Analysedemander> getAnalysesd() {
		return analysesd;
	}

	public void setAnalysesd(List<Analysedemander> analysesd) {
		this.analysesd = analysesd;
	}
	 

}
