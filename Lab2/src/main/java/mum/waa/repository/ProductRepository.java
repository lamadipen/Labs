package mum.waa.repository;

import mum.waa.model.Product;

public interface ProductRepository {
	public Product getProductById(String productId);
}