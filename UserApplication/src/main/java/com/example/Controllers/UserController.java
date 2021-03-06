package com.example.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import Models.User;
import Services.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping("/")
	public String viewlistusers(Model model) {
		List <User> listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);
		return "index";
	}
	
	@RequestMapping("/new")
	public String adduser(Model model) {
	    User user = new User();
	    model.addAttribute("user",user);
	     
	    return "NewUser";
	}
	
	@RequestMapping(value="/save")
	public String saveuser(@ModelAttribute("user") User user) {
	    service.adduser(user);
	     
	    return "redirect:/";
	}
	
	
	
	
}