package mum.waa.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import mum.waa.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	
	private List<Product> products= new ArrayList<Product>();
	
	public ProductRepositoryImpl() {
		Product iPhone = new Product();
		iPhone.setProductId("I-100");
		iPhone.setName("Iphone");
		iPhone.setUnitPrice(BigDecimal.valueOf(106));
		iPhone.setUnitsInStock(100);
		
		Product s7 = new Product();
		s7.setProductId("S-100");
		s7.setName("s7");
		s7.setUnitPrice(BigDecimal.valueOf(165));
		s7.setUnitsInStock(100);
		
		products.add(iPhone);
		products.add(s7);
	}
	
	public Product getProductById(String productId) {
		// TODO Auto-generated method stub
		for (Product product : products) {
			if(product.getProductId().equals(productId))
			{
				return product;
			}
		}
	
		return null;
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public boolean addProduct(Product product) {
		products.add(product);
		return true;
	}

	@Override
	public boolean deleteProduct(String productId) {
		products.removeIf(p->p.getProductId().equals(productId));
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		int index = products.indexOf(product);
		products.set(index, product);
		return true;
	}

}
