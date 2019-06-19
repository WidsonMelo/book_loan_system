package com.mert.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mert.model.Task;
import com.mert.model.User;
import com.mert.model.UserTask;
import com.mert.service.RoleService;
import com.mert.service.TaskService;
import com.mert.service.UserService;
import com.mert.service.UserTaskService;

@Controller
@RequestMapping("/ajuda")

public class AjudaController {
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private UserTaskService userTaskService;
	
	@RequestMapping(value="/sobre", method = RequestMethod.GET)
	public ModelAndView sobre(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users", userService.findAllFriends());
		modelAndView.addObject("mode", "MODE_ALL");		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User loginUser = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("control", loginUser.getRole().getRole());//Authentication for NavBar
		modelAndView.addObject("auth", loginUser);
		List<UserTask> userTasks = new ArrayList<>();
		userTasks = userTaskService.findByUser(loginUser);
		
		modelAndView.addObject("userTaskSize", userTasks.size());
		modelAndView.setViewName("sobre");
		
		List<UserTask> emprestimos = new ArrayList<>();
		List<Task> tasks = new ArrayList<>();
		List<User> users = new ArrayList<>();
		
		emprestimos = userTaskService.findByUserId(loginUser.getId());
		users = userService.findByUserId(loginUser.getId());
		tasks = taskService.findByUserId(loginUser.getId());
		
		int taskCount = tasks.size();
		int adminCount = emprestimos.size();
		int userCount = users.size();
		
		modelAndView.addObject("adminCount", adminCount);//Authentication for NavBar
		modelAndView.addObject("userCount", userCount);//Authentication for NavBar
		modelAndView.addObject("taskCount", taskCount);//Authentication for NavBar
		
		return modelAndView;
	}
	
	@RequestMapping(value="/manual", method = RequestMethod.GET)
	public ModelAndView manual(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users", userService.findAllFriends());
		modelAndView.addObject("mode", "MODE_ALL");		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User loginUser = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("control", loginUser.getRole().getRole());//Authentication for NavBar
		modelAndView.addObject("auth", loginUser);
		List<UserTask> userTasks = new ArrayList<>();
		userTasks = userTaskService.findByUser(loginUser);
		
		modelAndView.addObject("userTaskSize", userTasks.size());
		modelAndView.setViewName("manual");
		
		List<UserTask> emprestimos = new ArrayList<>();
		List<Task> tasks = new ArrayList<>();
		List<User> users = new ArrayList<>();
		
		emprestimos = userTaskService.findByUserId(loginUser.getId());
		users = userService.findByUserId(loginUser.getId());
		tasks = taskService.findByUserId(loginUser.getId());
		
		int taskCount = tasks.size();
		int adminCount = emprestimos.size();
		int userCount = users.size();
		
		modelAndView.addObject("adminCount", adminCount);//Authentication for NavBar
		modelAndView.addObject("userCount", userCount);//Authentication for NavBar
		modelAndView.addObject("taskCount", taskCount);//Authentication for NavBar
		
		return modelAndView;
	}

}
