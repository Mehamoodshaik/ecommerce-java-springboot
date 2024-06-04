package com.mehamood.ecommerce.persistence.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mehamood.ecommerce.persistence.model.Product;

@Service
public class CartService {
	private Map<Product, Integer> cart = new HashMap<>();

	public Map<Product, Integer> getCart() {
		return cart;
	}

	public void addProduct(Product product) {
		cart.put(product, cart.getOrDefault(product, 0) + 1);
	}

	public void removeProduct(Product product) {
		if (cart.containsKey(product)) {
			if (cart.get(product) > 1) {
				cart.put(product, cart.get(product) - 1);
			} else {
				cart.remove(product);
			}
		}
	}
}
