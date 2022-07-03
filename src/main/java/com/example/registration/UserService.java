package com.example.registration;

import java.util.List;

public interface UserService {

	List<Users> listAll();
	
	

	void save(Users user);
	
	public Users get(long id); 
	
	public void delete(long id);

	List<UserRole> listAll1();

	

}