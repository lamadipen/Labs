package mum.waa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import mum.waa.model.User;
import mum.waa.service.Userservice;

@Controller
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
	public String authenticate(User user, Model model) {
		if (userService.authenticate(user)) {
			model.addAttribute("user", user);
			return "welcome"; // try page refresh, PRG? the link on url is not changed
		} else {
			model.addAttribute("err_msg", "username and/or passord invlaid.");
			return "login";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "login";
	}

}
