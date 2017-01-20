package mum.waa.service;

import java.util.List;

import mum.waa.model.Product;

public interface ProductService {
	public void processOrder(String productId, int quantity);
	public List<Product> getAllProducts();
	public Product getProductById(String productId);
	public boolean addProduct(Product product);
	public boolean deleteProduct(String productId);
	public boolean updateProduct(Product product);
}
