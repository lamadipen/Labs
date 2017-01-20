package mum.waa.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.waa.customvalidation.UnitsInStrockValidator;
import mum.waa.model.Product;
import mum.waa.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private UnitsInStrockValidator unitsInStockValidator;

	@InitBinder
	public void initializeBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}

	@RequestMapping(value = "/producthome", method = RequestMethod.GET)
	public String welcome() {

		return "redirect:/products";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String home(Model mode) {
		mode.addAttribute("products", productService.getAllProducts());
		return "index";
	}

	@RequestMapping(value = "getProduct/{productId}", method = RequestMethod.GET)
	public String getProductDetail(Model mode, @PathVariable String productId) {

		mode.addAttribute("product", productService.getProductById(productId));
		return "productDetail";
	}

	@RequestMapping(value = "/processOrder", method = RequestMethod.POST)
	public String processOrder(Model mode, @RequestParam String productId, @RequestParam int quantity) {
		productService.processOrder(productId, quantity);
		mode.addAttribute("products", productService.getAllProducts());
		return "index";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String showAddProductForm(Product product) {
		return "addProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProductForm(@ModelAttribute("product") @Valid Product product, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
		throw new RuntimeException("Attempting to bind disallowed fields: "
		+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		unitsInStockValidator.validate(product, result);
		if (result.hasErrors()) {
			return "addProduct";
		}
		
		productService.addProduct(product);
		return "redirect:products";
	}

	@RequestMapping(value = "/deleteProduct/{productId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable String productId) {
		productService.deleteProduct(productId);
		return "redirect:/products";
	}

	@RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.GET)
	public String showEditForm(@PathVariable String productId, Model model) {

		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		return "editProduct";
	}

	@RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.POST)
	public String updateProduct(Product product, Model model) {
		productService.updateProduct(product);
		return "redirect:/products";
	}

}
