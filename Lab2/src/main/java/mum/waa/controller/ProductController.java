package mum.waa.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.waa.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String welcome() {
		
		return "redirect:/products";
	}
	
	
	@RequestMapping(value="/products", method= RequestMethod.GET)
	public String home(Model mode) {
		mode.addAttribute("products", productService.getAllProducts());
		return "index";
	}
	
	
	@RequestMapping(value="getProduct/{productId}", method= RequestMethod.GET)
	public String getProductDetail(Model mode,@PathVariable String productId) {
		
		mode.addAttribute("product", productService.getProductById(productId));
		return "productDetail";
	}
	
	
	@RequestMapping(value="/processOrder", method= RequestMethod.POST)
	public String processOrder(Model mode,@RequestParam String productId,@RequestParam int quantity) {
		productService.processOrder(productId, quantity);
		mode.addAttribute("products", productService.getAllProducts());
		return "index";
	}
	

	

}
