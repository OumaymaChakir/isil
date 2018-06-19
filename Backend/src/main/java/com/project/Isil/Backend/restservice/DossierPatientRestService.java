package com.project.Isil.Backend.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Isil.Backend.models.DossierPatient;
import com.project.Isil.Backend.repository.DossierPatientRepository;



@RestController
@RequestMapping("/")
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DossierPatientRestService {

	@Autowired
	private DossierPatientRepository DPR;
	
	
	@RequestMapping(value="dossierpatients" , method=RequestMethod.GET)
	public List<DossierPatient> getDossierPatients(){
		return DPR.findAll();
		
	}
	
	@RequestMapping(value="dossierpatient/{id}" , method=RequestMethod.GET)
	public DossierPatient getDossierPatient(@PathVariable Long id){
		return DPR.getOne(id);
		
	}
	
	@RequestMapping(value="dossierpatient" , method=RequestMethod.POST)
	public DossierPatient saveDossierPatient(@RequestBody DossierPatient p) {
		return DPR.save(p);
		
	}
	
	@RequestMapping(value="dossierpatient/{id}" , method=RequestMethod.DELETE)
	public void  deleteDossierPatient(@PathVariable Long id){
			DPR.deleteById(id);
		
	}
	
	@RequestMapping(value="dossierpatient/{id}" , method=RequestMethod.PUT)
	public DossierPatient putDossierPatient(@RequestBody DossierPatient p, @PathVariable Long id) {
		
		p.setId(id);
		return DPR.save(p);
		
	}
	
	
}
