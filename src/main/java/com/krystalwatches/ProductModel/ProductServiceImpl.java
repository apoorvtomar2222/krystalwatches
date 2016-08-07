package com.krystalwatches.ProductModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    ProductDAO dao;
	
	@Transactional
	public void insertProduct(Product p) {
		dao.insertProduct(p);
	}

	@Transactional
	public void updateProduct(Product p) {
		dao.updateProduct(p);
	}

	@Transactional
	public void deleteProduct(int pid) {
		dao.deleteProduct(pid);
	}

	@Transactional
	public Product getProduct(int pid) {
		return dao.getProduct(pid);
	}

	@Transactional
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}

	@Transactional
	public long getMaxProductId() {
		
		long id = -1;
		
		List<Product> l = dao.getAllProducts();
		
		for( Product prod : l )
		{
			if( prod.getProductId() > id )
				id = prod.getProductId();
		}
		
		return id;
	}
}
