package com.example.registration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long uid;
	String role;
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid =  uid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserRole [uid=" + uid + ", role=" + role + "]";
	}
	
	

}
