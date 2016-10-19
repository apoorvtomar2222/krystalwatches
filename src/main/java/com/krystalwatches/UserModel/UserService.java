package com.krystalwatches.UserModel;

import java.util.List;

public interface UserService 
{
	
	public void insertUser(User p);
	public void deleteUser(long p);
	public void updateUser(User p);
	public User getUser(String p);

    public List<User> getAllUsers();

    
}