package com.krystalwatches.UserModel;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.krystalwatches.UserRoleModel.UserRole;

@Repository
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;
 
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void insertUser(User p) {
		//Session session = getSessionFactory().getCurrentSession();
		sessionFactory.getCurrentSession().save(p);
		
		System.out.println("User Inserted");
	}

	public void deleteUser(long p) {
		sessionFactory.getCurrentSession().createQuery("delete from User as p where p.ID = :id").setLong("id", p).executeUpdate();
		System.out.println("User Deleted");
	}

	public void updateUser(User p) {
		sessionFactory.getCurrentSession().update(p);
		System.out.println("User updated");
	}

	public List<User> getAllUsers() {

		List<User> list = (List<User>)sessionFactory.getCurrentSession().createQuery("from User as u").list();
		
		return list;
		
	}

	public User getUser(int p) {
		List l = this.getSessionFactory().getCurrentSession().createQuery("from User as p where p.Username = :username").setInteger("username", p).list();
		if (l.size()>0)
		{
			return (User)l.get(0);
		}
		else
		{
			return null;
		}

	}

	public User getUser(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
		
	}
	
