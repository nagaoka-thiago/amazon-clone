package com.nagaoka.amazonclone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagaoka.amazonclone.model.CartItem;
import com.nagaoka.amazonclone.model.CartItemKey;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, CartItemKey> {
	@Query("FROM CartItem WHERE cpf = :cpf")
	public List<CartItem> findAllByCpf(@Param("cpf") String cpf);
}
