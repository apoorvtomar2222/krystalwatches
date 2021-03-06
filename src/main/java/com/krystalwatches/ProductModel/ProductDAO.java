package com.krystalwatches.ProductModel;

import java.util.List;


	public interface ProductDAO
	{
		public void insertProduct(Product p);
		public void updateProduct(Product p);
		public void deleteProduct(int pid);
		
		public Product getProduct(int pid);
		
		public List<Product> getAllProducts();
		public Product getProductWithMaxId();
		
		  
		}

