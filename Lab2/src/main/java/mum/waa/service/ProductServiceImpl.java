package mum.waa.service;

import org.springframework.beans.factory.annotation.Autowired;

import mum.waa.model.Product;
import mum.waa.repository.ProductRepository;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
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
}
