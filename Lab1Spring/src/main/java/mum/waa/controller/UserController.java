package mum.waa.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.waa.model.User;
import mum.waa.service.UserService;

@Controller
public class UserController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage()
	{
		return "index";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,@RequestParam("password") String password, Model model)
	{
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		UserService userService = new UserService();
		
		if(userService.validateUser(user))
		{
			model.addAttribute("message", username);
			return "success";
		}
		model.addAttribute("error", "Invalid username or password!");

		return "index";
		
	}


}
