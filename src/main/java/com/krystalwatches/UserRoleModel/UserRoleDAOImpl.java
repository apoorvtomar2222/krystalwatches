package com.krystalwatches.UserRoleModel;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
@EnableTransactionManagement
public class UserRoleDAOImpl implements UserRoleDAO
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

	public void insertUserRole(UserRole p) {
		sessionFactory.getCurrentSession().save(p);
		
	}

	public void deleteUserRole(long p) {
		// TODO Auto-generated method stub
		
	}

	public void updateUserRole(UserRole p) {
		// TODO Auto-generated method stub
		
	}

	public List<UserRole> getAllUsersRole() 
	{
		return sessionFactory.getCurrentSession().createQuery("from UserRole").list();
		
	}

	public void generateUserRoles() {
		
		//
		
		try
		{
			UserRole ur ;//= new UserRole("USER" , 1);
			
			ur = this.getUserRole(1);
			
			if( ur == null )
			{
				ur = new UserRole("USER" , 1);
				
				this.insertUserRole(ur);
			}
			
			ur = this.getUserRole(2);
			
			if( ur == null )
			{
				ur = new UserRole("ADMIN" , 2);
				
				this.insertUserRole(ur);
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		//
		
			}

	public UserRole getUserRole(int p) {
		@SuppressWarnings("unchecked")
		List<UserRole> l = sessionFactory.getCurrentSession().createQuery("from UserRole as p where p.Role = :id").setInteger("id", p).list();
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

	
	

	
	

