package com.example.registration;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository  userRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Override
	public List<Users> listAll() {
		 
		return userRepository.findAll();
	}
	
	public List<UserRole> listAll1() {
		 
		return userRoleRepository.findAll();
	}
	
    public void save(Users user) {
    	userRepository.save(user);
    }
    
    public Users get(long id) {
        return userRepository.findById(id).get();
    }
    
    public void delete(long id) {
    	userRepository.deleteById(id);
    }
}
