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

import com.db2g.Projetdb2g.Service.impl.EmployeeServiceImpl;
import com.db2g.Projetdb2g.Service.impl.FormationServiceimpl;
import com.db2g.Projetdb2g.model.Employee;
import com.db2g.Projetdb2g.model.Formation;

@Controller
public class FormationController {
	@Autowired
	private FormationServiceimpl impl;
	
	@Autowired
	private EmployeeServiceImpl emploi;
	
	@RequestMapping("/formation")
	public String PageAccueilformation(Model model) 
	
	{
		List<Formation> listeFormation = impl.listeFormation();
		model.addAttribute("formations", listeFormation);
		return "formation";
	}
	
	@RequestMapping("/detailformation&{id}")
	public ModelAndView PageDetailformation(@PathVariable(name = "id") ObjectId id) 
		
	{
		ModelAndView mav = new ModelAndView("detail_formation");
		Formation formation = impl.get(id);
		mav.addObject("format",formation);
		return mav;
	}
	
	@RequestMapping("/nouvelleformation")
	public String PageNouveauformation(Model model) {
		Formation formation = new Formation();
		List<Employee> listeEmployes = emploi.listeEmployes();
		model.addAttribute("employes", listeEmployes);
		model.addAttribute("formation", formation);
		
		return "nouvelle_formation";
	}
	
	@RequestMapping(value = "/enregistreformation", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute("formation") Formation formation) {
		impl.sauvegardeFormation(formation);;
		
		return "redirect:/formation";
	}
	
	@RequestMapping("/updateformation&{id}")
	public ModelAndView PageEdtitionFormation(@PathVariable(name = "id") ObjectId id) {
		ModelAndView mav = new ModelAndView("update_formation");
		List<Employee> listeEmployes = emploi.listeEmployes();
		Formation formation = impl.get(id);
		mav.addObject("employes", listeEmployes);
		mav.addObject("formation",formation);
		
		return mav;
	}
	
	@RequestMapping("/deleteformation&{id}")
	public String deleteformation(@PathVariable(name = "id") ObjectId id) {
		impl.supprimerFormation(id);
		return "redirect:/formation";		
	}
	
}
