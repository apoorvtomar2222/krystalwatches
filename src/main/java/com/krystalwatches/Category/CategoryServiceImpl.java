package com.krystalwatches.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
	CategoryDAO cdao;
	@Transactional
	public void insert(Category c) {
	
		cdao.insert(c);
		
	}
	@Transactional
	public void update(Category c) {
		cdao.update(c);
		
	}
	@Transactional
	public void delete(int cid) {
		cdao.delete(cid);
	}
	@Transactional
	public Category getCategory(int cid) {
		return cdao.getCategory(cid);
	}
	@Transactional
	public List<Category> getAllCategories() {
		return cdao.getAllCategories();
	}

}
