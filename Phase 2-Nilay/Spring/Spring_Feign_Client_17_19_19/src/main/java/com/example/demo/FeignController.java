package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pro")
public class FeignController {


	@Autowired
	private ProductServiceClient productServiceClient;
	
	
	@GetMapping("/showForm")
	public String create(Model theModel)
	{
		ProductDto product=new ProductDto();
		theModel.addAttribute("product", product);
		return "add-products";
	}
	@PostMapping("/save")
	public String createUser(@ModelAttribute("product") ProductDto theProductDto)
	{
		productServiceClient.createUser(theProductDto);
		return "redirect:/pro/fetchproducts/";
		
	}
	
	@GetMapping("/fetchproducts")
	public String getAllProducts(Model theModel)
	{
	 List<ProductDto> list=productServiceClient.getAllProducts();
	 theModel.addAttribute("addpro", list);
	return "list-product";
	}
	
	@GetMapping("/updateForm")
		public String getAllById(Model theModel, @RequestParam("id") int id)
		{
			ProductDto pdto=productServiceClient.getProductById(id);
			theModel.addAttribute("product",pdto);
			return "add-products";
		}
	
	@GetMapping("/delete")
	public String deleteById(@RequestParam("id") int id)
	{
		productServiceClient.deleteById(id);
		return "redirect:/pro/fetchproducts/";
	}
	
	
}
