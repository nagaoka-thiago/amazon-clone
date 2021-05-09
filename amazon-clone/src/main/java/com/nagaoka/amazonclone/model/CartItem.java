package com.nagaoka.amazonclone.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.EmbeddedId;

@Entity
public class CartItem {
	
	@EmbeddedId
	private CartItemKey id;
	
	@ManyToOne
	@MapsId("cpf")
	@JoinColumn(name = "cpf")
	private User user;
	
	@ManyToOne
	@MapsId("nbr")
	@JoinColumn(name = "nbr")
	private Product product;
	
	private int quantity;

	public CartItemKey getId() {
		return id;
	}

	public void setId(CartItemKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
