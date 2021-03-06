package mum.waa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import mum.waa.model.User;
import mum.waa.service.Userservice;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private Userservice userService;  
	
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String welcome() {
		return "redirect:login";
	}

	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String getLoingForm() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticate(User user, Model model,HttpSession session) {
		if (userService.authenticate(user)) {
			 
			model.addAttribute("user", user);
			session.setAttribute("actor", user);
			
			return "redirect:welcome"; 
		} else {
			model.addAttribute("err_msg", "username and/or passord invlaid.");
			return "login";
		}
	}
	
	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String loginSuccess() {
		return "welcome";
	}
	

	@RequestMapping(value = "/logout")
	public String logout(SessionStatus status,HttpSession session) {
		status.setComplete();
		//session.invalidate();
		
		return "redirect:login";
	}

}
