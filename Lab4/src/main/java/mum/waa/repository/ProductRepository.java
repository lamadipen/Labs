package mum.waa.repository;

import java.util.List;

import mum.waa.model.Product;

public interface ProductRepository {
	public Product getProductById(String productId);
	public List<Product> getAllProducts();
	public boolean addProduct(Product product);
	public boolean deleteProduct(String productId);
	public boolean updateProduct(Product product);
	
}
