/**
 * 
 */
package com.db2g.Projetdb2g.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.db2g.Projetdb2g.Service.impl.OffreServiceImpl;
import com.db2g.Projetdb2g.model.Offre;


/**
 * @author ibrahima
 *
 */
@Controller
public class OffreController {

	@Autowired
	private OffreServiceImpl impl;
	
	
	@RequestMapping("/offre")
	public String PageAccueilOffre(Model model) 
	{
		model.addAttribute("offres", impl.listeOffre());
		return "offre";
	}
	
	@RequestMapping("/detailoffre&{id}")
	public ModelAndView PageDetailOffre(@PathVariable(name = "id") Long id) 
	
	{
		ModelAndView mav = new ModelAndView("detail_offre");
		Offre offre = impl.get(id);
		mav.addObject("offre",offre);
		return mav;
	}
	
	@RequestMapping("/nouveauoffre")
	public String PageNouveauOffre(Model model) {
		Offre offre = new Offre();
		model.addAttribute("offre", offre);
		return "nouveau_offre";
	}
	
	@RequestMapping(value = "/enregistreoffre", method = RequestMethod.POST)
	public String saveOffres(@ModelAttribute("offre") Offre offre) {
		impl.sauvegardeOffre(offre);;
		
		return "redirect:/offre";
	}
	
	@RequestMapping("/updateoffre&{id}")
	public ModelAndView PageEdtitionOffres(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("update_offre");
		Offre offre = impl.get(id);
		mav.addObject("offre",offre);
		
		return mav;
	}
	
	@RequestMapping("/deleteoffre&{id}")
	public String deleteOffres(@PathVariable(name = "id") Long id) {
		impl.supprimerOffre(id);
		return "redirect:/offre";		
	}
	
}
