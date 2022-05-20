package com.register.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.register.users.model.Userd;

public interface UserRepository extends JpaRepository<Userd, Long >{
	
	public Userd findByEmail(String email);
	
}
