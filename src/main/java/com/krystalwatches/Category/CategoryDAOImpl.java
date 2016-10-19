package com.krystalwatches.Category;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.krystalwatches.ProductModel.Product;


@Repository
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO 


{
		
	@Autowired
	private SessionFactory sessionFactory;

	public void insert(Category c) 
	{
		sessionFactory.getCurrentSession().save(c);
	
	}

	public void update(Category c) {
		
		sessionFactory.getCurrentSession().update(c);

		
	}

	public void delete(int cid) {
		sessionFactory.getCurrentSession().createQuery("delete from Category as c where c.Id = :id")
		.setInteger("id", cid).executeUpdate();

	}

	public Category getCategory(int cid) {
		List<Category> list = sessionFactory.getCurrentSession().createQuery("from Category as c where c.Id = :id")
				.setInteger("id", cid).list();

		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
}

	public List<Category> getAllCategories() {

		return sessionFactory.getCurrentSession().createQuery("from Category c").list();

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	  	

}
