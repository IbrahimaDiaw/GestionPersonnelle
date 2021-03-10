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

import com.db2g.Projetdb2g.Service.EmployeeService;
import com.db2g.Projetdb2g.Service.impl.AbsenceServiceImpl;
import com.db2g.Projetdb2g.Service.impl.EmployeeServiceImpl;
import com.db2g.Projetdb2g.model.Absence;
import com.db2g.Projetdb2g.model.Employee;


/**
 * @author ibrahima
 *
 */
@Controller
public class AbsenceController {

	@Autowired
	private AbsenceServiceImpl impl;
	@Autowired
	private EmployeeServiceImpl serImpl;
	
	@RequestMapping("/absence")
	public String PageAccueilconge(Model model) 
	{
		model.addAttribute("absences", impl.listeAbsences());
		return "absence";
	}
	
	@RequestMapping("/detailabsence&{id}")
	public ModelAndView PageDetailabsence(@PathVariable(name = "id") ObjectId id) 
	
	{
		ModelAndView mav = new ModelAndView("detail_absence");
		Absence absence = impl.get(id);
		mav.addObject("absence",absence);
		return mav;
	}
	
	@RequestMapping("/nouveauabsence")
	public String PageNouveauabsence(Model model) {
		Absence absence = new Absence();
		List<Employee> employes =serImpl.listeEmployes();
		if(employes.isEmpty()) {
			employes = new ArrayList<Employee>();
		}
		model.addAttribute("absence", absence);
		model.addAttribute("employes", employes);
		
		return "nouveau_absence";
	}
	
	@RequestMapping(value = "/enregistreabsence", method = RequestMethod.POST)
	public String saveAbsence(@ModelAttribute("absence") Absence absence) {
		impl.sauvegardeAbsence(absence);;
		
		return "redirect:/absence";
	}
	
	@RequestMapping("/updateabsence&{id}")
	public ModelAndView PageEdtitionabsence(@PathVariable(name = "id") ObjectId id) {
		ModelAndView mav = new ModelAndView("update_absence");
		Absence absence = impl.get(id);
		List<Employee> employes =serImpl.listeEmployes();
		
		mav.addObject("absence",absence);
		mav.addObject("employes", employes);
		
		return mav;
	}
	
	@RequestMapping("/deleteabsence&{id}")
	public String deleteAbsence(@PathVariable(name = "id") ObjectId id) {
		impl.supprimerAbsence(id);
		return "redirect:/absence";		
	}
	
}
