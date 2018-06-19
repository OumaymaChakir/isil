package com.project.Isil.Backend.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Isil.Backend.models.Analyse;
import com.project.Isil.Backend.models.Medecin;
import com.project.Isil.Backend.repository.AnalyseRepository;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AnalyseRestService {

	@Autowired
	AnalyseRepository AR ; 
	@RequestMapping(value="analyses" , method=RequestMethod.GET)
	public List<Analyse> getAll(){
		return AR.findAll();
		
	} 
	
	@RequestMapping(value="analyse/{id}" , method=RequestMethod.GET)
	public Analyse getanalyse(@PathVariable Long id){
		return AR.getOne(id);
		
	} 
	
	@RequestMapping(value="analyse" , method=RequestMethod.POST)
	public Analyse save(@RequestBody Analyse m ){
		return AR.save(m);
		
	} 
	@RequestMapping(value="analyse/{id}" , method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id ){
		
	AR.deleteById(id);
	
		
	} 
	@RequestMapping(value="analyse/{id}" , method=RequestMethod.PUT)
	public Analyse update(@PathVariable Long id ,@RequestBody Analyse m){
		m.setId(id);
		return AR.save(m);
		
	} 
	
	@RequestMapping(value="analysesearch/{titre}/{code}" , method=RequestMethod.GET)
	public List<Analyse> searsh(@PathVariable String titre , @PathVariable String code){
		
		return AR.getAnalyseByTitreOrCode(titre, code); 
	} 
	
}
