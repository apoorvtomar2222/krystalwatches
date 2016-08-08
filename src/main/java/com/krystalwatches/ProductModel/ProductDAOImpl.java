package com.krystalwatches.ProductModel;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Repository
@EnableTransactionManagement
public class ProductDAOImpl implements ProductDAO
{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory.getCurrentSession().getSessionFactory();
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public void insertProduct(Product p) 
	
	{
		sessionFactory.getCurrentSession().save(p);
	}

	public void updateProduct(Product p) 
	{
		sessionFactory.getCurrentSession().update(p);
	}

	public void deleteProduct(int pid) 
	{
		sessionFactory.getCurrentSession().createQuery("delete from Product as p where p.ProductId = :id").setInteger("id", pid).executeUpdate();
	}

	public Product getProduct(int pid) 
	{
		List<Product> list = sessionFactory.getCurrentSession().createQuery("from Product as p where p.ProductId = :id").setInteger("id", pid).list();
		
		
	if (list.size()>0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}

	public List<Product> getAllProducts() 
	{
		
		return sessionFactory.getCurrentSession().createQuery("from Product as p").list();
	}

	

	public Product getProductWithMaxId() {
	
List<Product> l = sessionFactory.getCurrentSession().createQuery("from Product as p where p.ProductId = ( select max(a.ProductId) from Product as a )").list();
		
		if (l.size()>0)
		{
			return l.get(0);
		}
		else
		{
			return null;
		}
	}


}
