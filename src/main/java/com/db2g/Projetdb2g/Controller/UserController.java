/**
 * 
 */
package com.db2g.Projetdb2g.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.db2g.Projetdb2g.Repository.UserRepository;
import com.db2g.Projetdb2g.Service.UserService;
import com.db2g.Projetdb2g.model.User;
/**
 * @author ibrahima
 *
 */

@Controller
public class UserController {

 @Autowired
 private UserService userService;
 
	 @RequestMapping(value= {"/login"}, method=RequestMethod.GET)
	 public ModelAndView login() {
	  ModelAndView model = new ModelAndView();
	  
	  model.setViewName("/login");
	  return model;
	 }
	 
	 @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
	 public ModelAndView signup() {
	  ModelAndView model = new ModelAndView();
	  User user = new User();
	  model.addObject("user", user);
	  model.setViewName("/signup");
	  
	  return model;
	 }
	 
	 @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
	 public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
	  ModelAndView model = new ModelAndView();
	  User userExists = userService.findUserByEmail(user.getEmail());
	  
	  if(userExists != null) {
	   bindingResult.rejectValue("email", "error.user", "Ce email existe déjà !");
	  }
	  if(bindingResult.hasErrors()) {
	   model.setViewName("user/signup");
	  } else {
	   userService.saveUser(user);
	   model.addObject("msg", "Utilisateur enregisté avec succès!");
	   model.addObject("user", new User());
	   model.setViewName("/signup");
	  }
	  
	  return model;
	 }
	 
	 @RequestMapping(value= {"/home"}, method=RequestMethod.GET)
	 public ModelAndView home() {
	  ModelAndView model = new ModelAndView();
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  User user = userService.findUserByEmail(auth.getName());
	  
	  model.addObject("userName", user.getPrenom() + " " + user.getNom());
	  model.setViewName("/index");
	  return model;
	 }
	 
	 @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
	 public ModelAndView accessDenied() {
	  ModelAndView model = new ModelAndView();
	  model.setViewName("errors/access_denied");
	  return model;
	 }
}