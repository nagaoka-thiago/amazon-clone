package com.nagaoka.amazonclone.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartItemKey implements Serializable{
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "nbr")
	private int nbr;
	
	public CartItemKey() {
		super();
	}

	public CartItemKey(String cpf, int nbr) {
		super();
		this.cpf = cpf;
		this.nbr = nbr;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
}
