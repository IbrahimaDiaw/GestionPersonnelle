/**
 * 
 */
package com.db2g.Projetdb2g.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db2g.Projetdb2g.Repository.EmployeeRepository;
import com.db2g.Projetdb2g.Repository.OffreRepository;
import com.db2g.Projetdb2g.Repository.PostuleRepository;
import com.db2g.Projetdb2g.model.Employee;
import com.db2g.Projetdb2g.model.Offre;
import com.db2g.Projetdb2g.model.Postule;

/**
 * @author ibrahima
 *
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController

public class XmlDatabaseController {
	
	@Autowired
	private PostuleRepository postuleRepo;
	@Autowired
	private OffreRepository offreRepository;
	
	@Autowired
	EmployeeRepository employeRepo;
	
	@RequestMapping("/xmldatabase")
	public ResponseEntity<?> getAllOffre(){
		 
		try {
			
			List<Postule> post = postuleRepo.findAll();
			List<Offre> offres = offreRepository.findAll();
			List<Employee> employe = employeRepo.findAll();
			
			Map<String, Object> map = new HashMap<String,Object>();
			
			map.put("offres", offres);
			map.put("post",post);
			map.put("employe", employe);
			
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);	
		 
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);		
		
	}
	}

}
