/**
 * 
 */
package com.db2g.Projetdb2g.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.db2g.Projetdb2g.Service.impl.PostuleServiceImpl;
import com.db2g.Projetdb2g.model.Postule;


/**
 * @author ibrahima
 *
 */
@Controller
public class PostuleController {

	@Autowired
	private PostuleServiceImpl impl;
	
	@RequestMapping("/postule")
	public String PageAccueilpostule(Model model) 
	
	{
		List<Postule> postules = impl.listePostule();
		model.addAttribute("postules", postules);
		return "postule";
	}
	
	@RequestMapping("/nouveaupostule")
	public String PageNouveaupostule(Model model) {
		Postule postule = new Postule();
		model.addAttribute("postule", postule);
		
		return "nouveau_postule";
	}
	
	@RequestMapping(value = "/enregistrepostule", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute("postule") Postule postule) {
		impl.sauvegardePostule(postule);
		
		return "redirect:/postule";
	}
	
	@RequestMapping("/postule{id}")
	public ModelAndView modifier_post(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("/modifier_postule");
		Postule postule = this.impl.editPost(id);
		mav.addObject("postule", postule);
		
		return mav;
	}
	
	@RequestMapping("/voirpostule{id}")
	public ModelAndView voir_post(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("/voirpost");
		Postule postule = this.impl.editPost(id);
		mav.addObject("postule", postule);
		
		return mav;
	}
	
	@RequestMapping("/deletepost{id}")
	public String supprime(@PathVariable(name = "id")Long id) {
		
		this.impl.supprimerPostule(id);
		
		return "redirect:/postule";
	}
}
