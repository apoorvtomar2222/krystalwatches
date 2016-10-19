package com.krystalwatches.UserModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.krystalwatches.UserModel.UserDAO;
import com.krystalwatches.UserModel.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDAO dao;
	
	@Transactional
	public void insertUser(User p) 
	{
		dao.insertUser(p);
		
	}
	@Transactional
	public void deleteUser(long p) {
		dao.deleteUser(p);
	}
	@Transactional
	public void updateUser(User p) {
		dao.updateUser(p);
	}
	@Transactional
	public User getUser(String p) {
		return dao.getUser(p);
	}
	@Transactional
	public List<User> getAllUsers() {
		
		return dao.getAllUsers();
	}


	

	
}
