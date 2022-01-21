package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppControl {
	
	@Autowired
	private UserRepository ur;
	
	@GetMapping("/index")
	public String viewHomePage() {
	return "index";
	
	}
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	model.addAttribute("user", new Users());
	     
	    return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(Users user) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	      ur.save(user);
		  return "register_success";
			
	}
	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		List<Users> listUsers= ur.findAll();
		model.addAttribute("listUsers",listUsers);
		
		return "users";
	}
	@GetMapping("/users")
	public String listUsers(Model model) {
	    List<Users> listUsers = ur.findAll();
	    model.addAttribute("listUsers", listUsers);
	     
	    return "users";
	}
	
	}
