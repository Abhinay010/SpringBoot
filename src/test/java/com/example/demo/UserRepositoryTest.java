package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void testCreateUser() {
		
		Users user=new Users();
		user.setEmail("Ralf@gmail.com");
		user.setPassword("ralf2021");
		user.setFirstname("Ralf");
		user.setLastname("Depay");
		
		Users savedUser = repo.save(user);
		
		Users existUser = em.find(Users.class,savedUser.getId());
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail())	;
		}
	

}
