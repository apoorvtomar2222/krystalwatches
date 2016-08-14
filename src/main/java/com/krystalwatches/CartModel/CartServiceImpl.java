package com.krystalwatches.CartModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service("CartService")
@EnableTransactionManagement
public class CartServiceImpl implements CartService {
	@Autowired
	CartDAO dao;

	@Transactional
	public Cart getCartById(int cartId) {
		// TODO Auto-generated method stub
		return dao.getCartById(cartId);
	}

	@Transactional
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		dao.update(cart);
	}

	@Transactional
	public void add(Cart cart) {
		dao.add(cart);
	}

	@Transactional
	public void delete(int i) {
		// TODO Auto-generated method stub
		dao.delete(i);
	}

	@Transactional
	public List<Cart> getAllProduct() {
		// TODO Auto-generated method stub
		return dao.getAllProduct();
	}

	@Transactional
	public Cart getCartByUsername(String Username) {
		return dao.getCartByUsername(Username);
	}

	@Transactional
	public String checkUsername(String Username) {
		// TODO Auto-generated method stub
		return dao.checkUsername(Username);
	}

}
