package com.mert.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mert.model.Amigo;
import com.mert.model.Task;
import com.mert.model.User;
import com.mert.service.AmigoService;
import com.mert.service.UserService;

@Controller
@RequestMapping("/admin/amigos")
public class AmigoController {

	@Autowired
	private AmigoService amigoService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newAmigo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("amigo", new Amigo());
		modelAndView.addObject("amigos", amigoService.findAll());
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		modelAndView.addObject("mode", "MODE_NEW");
		modelAndView.setViewName("amigo");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveAmigo(@Valid Amigo amigo, BindingResult bindingResult) {
		amigoService.save(amigo);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/amigos/all");
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		return modelAndView;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView allAmigos() {
		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("rule", new Amigo());
		modelAndView.addObject("amigos", amigoService.findAll());
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("amigo");
		return modelAndView;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateTask(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rule", new Amigo());
		modelAndView.addObject("amigo", amigoService.findAmigo(id));
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control",getUser().getRole().getRole());
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("amigo");
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteTask(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/amigos/all");
		modelAndView.addObject("rule", new Task());
		modelAndView.addObject("auth", getUser());
		modelAndView.addObject("control", getUser().getRole().getRole());
		amigoService.delete(id);
		return modelAndView;
	}
	

	private User getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}
}
