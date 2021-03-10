/**
 * 
 */
package com.db2g.Projetdb2g.Controller;


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
import com.db2g.Projetdb2g.model.Employee;


/**
 * @author ibrahima
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl impl;
	
	@RequestMapping("/employe")
	public String PageAccueilEmploye(Model model) 
	
	{
		model.addAttribute("employes", impl.listeEmployes());
		return "employe";
	}
	
	@RequestMapping("/detailemploye&{id}")
	public ModelAndView PageDetailEmploye(@PathVariable(name = "id") ObjectId id) 
	
	{
		ModelAndView mav = new ModelAndView("detail_employe");
		Employee employe = impl.get(id);
		mav.addObject("emp",employe);
		return mav;
	}
	
	@RequestMapping("/nouveauemploye")
	public String PageNouveauEmploye(Model model) {
		Employee employe = new Employee();
		model.addAttribute("employe", employe);
		
		return "nouveau_employe";
	}
	
	@RequestMapping(value = "/enregistreemploye", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute("employe") Employee employe) {
		impl.sauvegardeEmployee(employe);;
		
		return "redirect:/employe";
	}
	
	@RequestMapping("/updateemploye&{id}")
	public ModelAndView PageEdtitionEmployee(@PathVariable(name = "id") ObjectId id) {
		ModelAndView mav = new ModelAndView("update_employe");
		Employee employe = impl.get(id);
		mav.addObject("employe",employe);
		
		return mav;
	}
	
	@RequestMapping("/deleteemploye&{id}")
	public String deleteemploye(@PathVariable(name = "id") ObjectId id) {
		impl.supprimerEmployee(id);
		return "redirect:/employe";		
	}
	
}
