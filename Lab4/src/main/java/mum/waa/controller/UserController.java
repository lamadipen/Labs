package mum.waa.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.waa.model.Product;
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
	public String getLoingForm(@CookieValue(value = "USERNAME", defaultValue = "") String myCookie, Model model) {
		model.addAttribute("err_msg", myCookie);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticate(User user,@RequestParam(value="remember",defaultValue="false") boolean remember, Model model, HttpSession session, RedirectAttributes redirectAtributes,
			HttpServletResponse response) {
		
		if (userService.authenticate(user)) {

			session.setAttribute("actor", user);
			redirectAtributes.addFlashAttribute("message", "Welcome to the site. Enjoy surfing!");
			
			
			if(!remember)
			{
				Cookie cookie = new Cookie("USERNAME",null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			else
			{

				Cookie cookie =new Cookie("USERNAME", user.getUsername());
				cookie.setMaxAge(30*24*60*60);
				response.addCookie(cookie);
			}
			

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
	public String logout(SessionStatus status, HttpSession session) {
		session.invalidate();

		return "redirect:login";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.GET)
	public String showCreateUserForm(User user)
	{
		return "addUser";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String createUser(User user)
	{
		userService.addUser(user);
		return "redirect:/users";
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String getAllUser(Model model)
	{
		model.addAttribute("users", userService.getAllUsers()) ;
		return "users";
	}
	
	@RequestMapping(value = "/deleteUser/{username}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable String username) {
		userService.deleteUser(username);
		return "redirect:/users";
	}

	@RequestMapping(value = "/editUser/{username}", method = RequestMethod.GET)
	public String showEditForm(@PathVariable String username, Model model) {

		User user = userService.getUserById(username);
		model.addAttribute("user", user);
		return "editUser";
	}

	@RequestMapping(value = "/editUser/{username}", method = RequestMethod.POST)
	public String updateProduct(User user, Model model) {
		userService.updateUser(user);
		return "redirect:/users";
	}
	
	
	
}
