package com.nagaoka.amazonclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagaoka.amazonclone.model.Product;
import com.nagaoka.amazonclone.repository.ProductRepository;

@CrossOrigin("*")
@Controller
@RequestMapping(path="/products")
public class ProductController {
	@Autowired
	private ProductRepository repository;
	
	@GetMapping(path="/*")
	public @ResponseBody List<Product> getProducts() {
		return repository.findAll();
	}
	
	@GetMapping(path="/{nbr}")
	public @ResponseBody Product getProductByNbr(@PathVariable("nbr") int nbr) {
		return repository.findById(nbr).orElse(null);
	}
	
	// Saves the product object to the database table Product
	// The object that needs to be passed throught api is:
	// { 
	//   title: 'Title that announces the product'
	//   image: 'The image's url of the product'
	//   quantity: It quantifies the amount of objects of its product
	//   rating:  It quantifies the grade that the users give to the product
	//   price: It is a number with float point that quantifies the unit price of the product.
	// }
	// It doesn't need nbr because it is a generated number in database, with AUTO_INCREMENT.
	@PostMapping(path="/add")
	public @ResponseBody Product saveProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	// Updates the product's instance in the database table Product
	// The object that needs to be passed throught api is:
	// {
	//   nbr:   it is a number that identifies the product
	//   title: 'Title that announces the product'
	//   image: 'The image's url of the product'
	//   quantity: It quantifies the amount of objects of its product
	//   rating:  It quantifies the grade that the users give to the product
	//   price: It is a number with float point that quantifies the unit price of the product.
	// }
	@PutMapping(path="/update/{nbr}")
	public @ResponseBody Product updateProduct(@PathVariable("nbr") int nbr, @RequestBody Product newProduct) {
		Product product = repository.findById(nbr).orElse(null);
		if(product != null) {
			product.setImage(newProduct.getImage());
			product.setPrice(newProduct.getPrice());
			product.setQuantity(newProduct.getQuantity());
			product.setRating(newProduct.getRating());
			product.setTitle(newProduct.getTitle());
			
			return repository.save(product);
		}
		else return null;
	}
	
	// Deletes the product in the database table Product throught its nbr
	// The nbr is passed throught api like this:
	// localhost:8080:/products/delete/nbr
	// nbr is only its number
	@DeleteMapping(path="/delete/{nbr}")
	public @ResponseBody Product deleteProduct(@PathVariable("nbr") int nbr) {
		Product product = repository.findById(nbr).orElse(null);
		repository.delete(product);
		return product;
	}
}
