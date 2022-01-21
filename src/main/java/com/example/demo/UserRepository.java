package com.example.demo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Users,Long>{
	
	@Query("SELECT u FROM Users u where u.email=?1")
	Users findByEmail(String email);

	

}
