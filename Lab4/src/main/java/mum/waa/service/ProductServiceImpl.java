package mum.waa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.waa.model.Product;
import mum.waa.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	public void processOrder(String productId, int quantity)
	{
		Product orderedProduct =  productRepository.getProductById(productId);
		
		if(orderedProduct !=null)
		{
			if(quantity < orderedProduct.getUnitsInStock())
			{
				orderedProduct.setUnitsInStock(orderedProduct.getUnitsInStock()-quantity);
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
		
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.getAllProducts();
	}

	public Product getProductById(String productId) {
		// TODO Auto-generated method stub
		return productRepository.getProductById(productId);
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.addProduct(product);
	}

	@Override
	public boolean deleteProduct(String productId) {
		// TODO Auto-generated method stub
		return productRepository.deleteProduct(productId);
	}

	@Override
	public boolean updateProduct(Product product) {
		return productRepository.updateProduct(product);
	}
}
