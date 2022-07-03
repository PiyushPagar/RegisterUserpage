package com.example.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	
	   @Query("SELECT u FROM Users u WHERE u.email = ?1")
	   public Users findByEmail(String email);
}
