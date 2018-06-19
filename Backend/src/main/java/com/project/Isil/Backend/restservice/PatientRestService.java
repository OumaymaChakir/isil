package com.project.Isil.Backend.restservice;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.project.Isil.Backend.models.Patient;
import com.project.Isil.Backend.repository.PatientRepository;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PatientRestService {

	@Autowired
	PatientRepository PR ; 
	@RequestMapping(value="patients" , method=RequestMethod.GET)
	public List<Patient> getAll(){
		return PR.findAll();
		
	} 
	
	@RequestMapping(value="patient/{id}" , method=RequestMethod.GET)
	public Patient getpatient(@PathVariable Long id){
		return PR.getOne(id);
		
	} 
	
	@RequestMapping(value="patient" , method=RequestMethod.POST)
	public Patient save(@RequestBody Patient p ){
		return PR.save(p);
		
	} 
	@RequestMapping(value="patient/{id}" , method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id ){
		
	PR.deleteById(id);
	
		
	} 
	@RequestMapping(value="patient/{id}" , method=RequestMethod.PUT)
	public Patient update(@PathVariable Long id ,@RequestBody Patient p){
		p.setId(id);
		return PR.save(p);
		
	} 
	
	@RequestMapping(value="patientsearch/{nom}/{prenom}/{daten}" , method=RequestMethod.GET)
	public List<Patient> searsh(@PathVariable String nom , @PathVariable String prenom , @PathVariable String daten){
		String d=daten.replace("-", "/");
		return PR.getPatientsByNomPrenomDateN(nom, prenom, new Date(d));
		
	} 
	
	
	
	
}
