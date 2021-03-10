/**
 * 
 */
package com.db2g.Projetdb2g.Controller;


import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.db2g.Projetdb2g.Service.impl.CongesServiceImpl;
import com.db2g.Projetdb2g.Service.impl.EmployeeServiceImpl;
import com.db2g.Projetdb2g.model.Conges;
import com.db2g.Projetdb2g.model.Employee;


/**
 * @author ibrahima
 *
 */
@Controller
public class CongesController {

	@Autowired
	private CongesServiceImpl impl;
	@Autowired
	private EmployeeServiceImpl serImpl;
	
	@RequestMapping("/conge")
	public String PageAccueilconge(Model model) 
	{
		model.addAttribute("conges", impl.listeConges());
		return "conge";
	}
	
	@RequestMapping("/detailconge&{id}")
	public ModelAndView PageDetailConge(@PathVariable(name = "id") ObjectId id) 
	
	{
		ModelAndView mav = new ModelAndView("detail_conge");
		Conges conge = impl.get(id);
		mav.addObject("conge",conge);
		return mav;
	}
	
	@RequestMapping("/nouveauconge")
	public String PageNouveauConge(Model model) {
		Conges conge = new Conges();
		List<Employee> employes =serImpl.listeEmployes();
		if(employes.isEmpty()) {
			employes = new ArrayList<Employee>();
		}
		model.addAttribute("conge", conge);
		model.addAttribute("employes", employes);
		
		return "nouveau_conge";
	}
	
	@RequestMapping(value = "/enregistreconge", method = RequestMethod.POST)
	public String saveConges(@ModelAttribute("conge") Conges conge) {
		impl.sauvegardeConges(conge);;
		
		return "redirect:/conge";
	}
	
	@RequestMapping("/updateconge&{id}")
	public ModelAndView PageEdtitionConges(@PathVariable(name = "id") ObjectId id) {
		ModelAndView mav = new ModelAndView("update_conge");
		Conges conge = impl.get(id);
		List<Employee> employes =serImpl.listeEmployes();
		
		mav.addObject("conge",conge);
		mav.addObject("employes", employes);
		
		return mav;
	}
	
	@RequestMapping("/deleteconge&{id}")
	public String deleteConges(@PathVariable(name = "id") ObjectId id) {
		impl.supprimerConges(id);
		return "redirect:/conge";		
	}
	
}
