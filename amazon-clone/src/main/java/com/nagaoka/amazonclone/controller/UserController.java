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

import com.nagaoka.amazonclone.model.User;
import com.nagaoka.amazonclone.repository.UserRepository;

@CrossOrigin("*")
@Controller
@RequestMapping(path="/users")
public class UserController {
	@Autowired
	private UserRepository repository;
	
	@GetMapping(path="/*")
	public @ResponseBody List<User> getUsers() {
		return repository.findAll();
	}
	
	@GetMapping(path="/{cpf}")
	public @ResponseBody User getUserByCpf(@PathVariable("cpf") String cpf) {
		return repository.findById(cpf).orElse(null);
	}
	
	// If its user's e-mail and password are correctly, returns the User object, if not, returns null
	@GetMapping(path="/{email}/{password}")
	public @ResponseBody User Login(@PathVariable("email") String email, @PathVariable("password") String password) {
		User user = repository.findByEmail(email);
		if(user != null)
			if(user.getPassword().equals(password))
				return user;
		return null;
	}
	
	// Saves the user object to the database table User
	// The object that needs to be passed throught api is:
	// { 
	//   cpf: 'only cpf number'
	//   name: 'name of the user'
	//   birthday: 'YYYY-MM-DD'
	//   sex:  'M or F'
	//   address: 'street's name'
	//   nbr:     'address's number'
	//   city:   'user's city'
	//   state: 'user's state'
	//   country: 'user's country'
	//   email: 'user's e-mail'
	//   password: 'user's password'
	// }
	@PostMapping(path="/add")
	public @ResponseBody User saveUser(@RequestBody User user) {
		return repository.save(user);
	}
	
	// Updates the user's instance in the database table User
	// It needs to pass a CPF and an object throught api, and the object needs to be as:
	// { 
	//   cpf: 'only cpf number'
	//   name: 'name of the user'
	//   birthday: 'YYYY-MM-DD'
	//   sex:  'M or F'
	//   address: 'street's name'
	//   nbr:     'address's number'
	//   city:   'user's city'
	//   state: 'user's state'
	//   country: 'user's country'
	//   email: 'user's e-mail'
	//   password: 'user's password'
	// }
	@PutMapping(path="/update/{cpf}")
	public @ResponseBody User updateUser(@PathVariable("cpf") String cpf, @RequestBody User newUser) {
		User user = repository.findById(cpf).orElse(null);
		
		if(user != null) {
			user.setAddress(newUser.getAddress());
			user.setBirthday(newUser.getBirthday());
			user.setCity(newUser.getCity());
			user.setCountry(newUser.getCountry());
			user.setEmail(newUser.getEmail());
			user.setName(newUser.getName());
			user.setNbr(newUser.getNbr());
			user.setPassword(newUser.getPassword());
			user.setSex(newUser.getSex());
			user.setState(newUser.getState());
			
			return repository.save(user);
		}
		
		return null;
	}
	
	// Deletes the user in the database table User throught its cpf
	// The cpf is passed throught api like this:
	// localhost:8080:/users/delete/cpf
	// cpf is only its number
	
	@DeleteMapping(path="/delete/{cpf}")
	public @ResponseBody User deleteUser(@PathVariable("cpf") String cpf) {
		User user = repository.findById(cpf).orElse(null);
		repository.delete(user);
		
		return user;
	}
}
