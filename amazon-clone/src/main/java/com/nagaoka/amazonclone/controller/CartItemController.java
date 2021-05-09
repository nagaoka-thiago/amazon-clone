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

import com.nagaoka.amazonclone.model.CartItem;
import com.nagaoka.amazonclone.model.CartItemKey;
import com.nagaoka.amazonclone.model.Product;
import com.nagaoka.amazonclone.model.User;
import com.nagaoka.amazonclone.repository.CartItemRepository;
import com.nagaoka.amazonclone.repository.ProductRepository;
import com.nagaoka.amazonclone.repository.UserRepository;

@CrossOrigin("*")
@Controller
@RequestMapping(path="/cartitems")
public class CartItemController {
	@Autowired
	private CartItemRepository repository;
	@Autowired
	private ProductRepository prepository;
	@Autowired
	private UserRepository urepository;
	
	@GetMapping("/{cpf}")
	public @ResponseBody List<CartItem> getCartItemsByCpf(@PathVariable("cpf") String cpf) {
		return repository.findAllByCpf(cpf);
	}
	
	// Saves the cartitem object to the database table CartItem throught user's cpf and product's nbr
	// The user's cpf and product's nbr are passed to api like this:
	// localhost:8080:/cartitems/add/cpf/nbr
	// cpf and nbr are respectively the user's cpf and product's nbr.
	// It returns a cartitem's object when it finds the passed user's cpf and the product's nbr.
	// It returns null when one of them is not found.
	@PostMapping(path="/add/{cpf}/{nbr}")
	public @ResponseBody CartItem add(@PathVariable("cpf") String cpf, @PathVariable int nbr) {
		User u = urepository.findById(cpf).orElse(null);
		Product p = null;
		CartItem newCartItem = null;
		if(u != null) {
			p = prepository.findById(nbr).orElse(null);
			if(p != null) {
				newCartItem = new CartItem();
				newCartItem.setId(new CartItemKey(u.getCpf(), p.getNbr()));
				newCartItem.setProduct(p);
				newCartItem.setUser(u);
				newCartItem.setQuantity(p.getQuantity());
				return repository.save(newCartItem);
			}
		}
		
		return null;
	}
	
	// Updates the cartitem object to the database table CartItem
	// The object that needs to be passed throught api is:
	// {
	//   id:{
	//         cpf: 'user's cpf',
	//         nbr: it is a number that identifies the product
	//      },
	//   product: {
	//              nbr:   it is a number that identifies the product,
	//              title: 'Title that announces the product',
	//              image: 'The image's url of the product',
	//              quantity: It quantifies the amount of objects of its product,
	//              rating:  It quantifies the grade that the users give to the product,
	//              price: It is a number with float point that quantifies the unit price of the product.
	//            },
	//   user: {
    //           cpf: 'only cpf number',
	//           name: 'name of the user',
	//           birthday: 'YYYY-MM-DD',
	//           sex:  'M or F',
	//           address: 'street's name',
	//           nbr:     'address's number',
	//           city:   'user's city',
	//           state: 'user's state',
	//           country: 'user's country',
	//           email: 'user's e-mail',
	//           password: 'user's password'
	//         },
	//   quantity: Amount of items of the same product that is going to be bought modified.
	// }
	// It returns the cartitem's object that was modified.
	// It returns null when it is not found.
	@PutMapping(path="/update")
	public @ResponseBody CartItem updateCart(@RequestBody CartItem cartUpdated) {
		CartItem cart = repository.findById(new CartItemKey(cartUpdated.getUser().getCpf(), cartUpdated.getProduct().getNbr())).orElse(null);
		if(cart != null) {
			cart.setQuantity(cartUpdated.getQuantity());
			return repository.save(cart);
		}
		
		return null;
	}
	
	// Deletes the cartitem in the database table CartItem throught its cpf and nbr
	// The cpf and nbr are passed throught api like this:
	// localhost:8080:/cartitems/delete/cpf/nbr
	// cpf and nbr are only its number
	@DeleteMapping(path="/delete/{cpf}/{nbr}")
	public @ResponseBody CartItem removeCart(@PathVariable("cpf") String cpf, @PathVariable Integer nbr) {
		CartItem itemCart = repository.findById(new CartItemKey(cpf, nbr)).orElse(null);
		if(itemCart != null) {
			repository.delete(itemCart);
		}
		
		return itemCart;
	}
}
