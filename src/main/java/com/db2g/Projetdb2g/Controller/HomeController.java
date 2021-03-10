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

import com.db2g.Projetdb2g.Service.impl.OffreServiceImpl;
import com.db2g.Projetdb2g.Service.impl.PostuleServiceImpl;
import com.db2g.Projetdb2g.model.Offre;
import com.db2g.Projetdb2g.model.Postule;

@Controller
public class HomeController {

	@Autowired
	OffreServiceImpl offre;
	
	@Autowired
	private PostuleServiceImpl impl;
	
	@Autowired
	private OffreServiceImpl imple;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Offre> listoffres = offre.listeOffre();
		model.addAttribute("offres", listoffres);
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/voiroffres")
	public String voiroffe(Model model){
		List<Offre> listoffres = offre.listeOffre();
		model.addAttribute("offres", listoffres);
		return "voiroffres";
	}
	
	@RequestMapping("/template")
	public String template() {
		return "template";
	}
	
	@RequestMapping("/candidature")
	public String candidature(Model model) {
		Postule postule = new Postule();
//		List<Offre> offres = imple.listeOffre();
		model.addAttribute("postule", postule);
//		model.addAttribute("offre", offres);
		return "candidature";
	}
	@RequestMapping(value = "/enregistrecandidat", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute("postule") Postule postule) {
		impl.sauvegardePostule(postule);
		return "redirect:/";
	}
	
	@RequestMapping("/detoffres{id}")
	public ModelAndView detoffres(@PathVariable(name = "id") Long id) 
	
	{
		ModelAndView mav = new ModelAndView("detoffres");
		Offre offre = imple.get(id);
		mav.addObject("offres",offre);
		return mav;
	}
}

