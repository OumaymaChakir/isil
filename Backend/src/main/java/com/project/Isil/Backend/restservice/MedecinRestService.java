package com.project.Isil.Backend.restservice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Isil.Backend.models.Medecin;
import com.project.Isil.Backend.models.Patient;
import com.project.Isil.Backend.repository.MedecinRepository;
import com.project.Isil.Backend.repository.PatientRepository;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MedecinRestService {

	
	@Autowired
	MedecinRepository MR ; 
	@RequestMapping(value="medecins" , method=RequestMethod.GET)
	public List<Medecin> getAll(){
		return MR.findAll();
		
	} 
	
	@RequestMapping(value="medecin/{id}" , method=RequestMethod.GET)
	public Medecin getmedecin(@PathVariable Long id){
		return MR.getOne(id);
		
	} 
	
	@RequestMapping(value="medecin" , method=RequestMethod.POST)
	public Medecin save(@RequestBody Medecin m ){
		return MR.save(m);
		
	} 
	@RequestMapping(value="medecin/{id}" , method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id ){
		
	MR.deleteById(id);
	
		
	} 
	@RequestMapping(value="medecin/{id}" , method=RequestMethod.PUT)
	public Medecin update(@PathVariable Long id ,@RequestBody Medecin m){
		m.setId(id);
		return MR.save(m);
		
	} 
	
	@RequestMapping(value="medecinsearch/{nom}/{prenom}/{code}" , method=RequestMethod.GET)
	public List<Medecin> searsh(@PathVariable String nom , @PathVariable String prenom , @PathVariable String code){
		
		return MR.getMedecinByNomPrenomCode(nom, prenom, code);
		
	} 
	
}
