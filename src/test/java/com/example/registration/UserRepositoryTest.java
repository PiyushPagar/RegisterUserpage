package com.example.registration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


public class UserRepositoryTest {
	@Autowired
	private UserRepository repo;
	
	@Test
	public void testFindUserByEmail() {
		String email = "pi@gmail.com";
		
		Users user = repo.findByEmail(email);
		
		assertThat(user).isNotNull();
	}
	
}
