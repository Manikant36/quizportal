package quizportal.quizportal;



import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import quizportal.quizportal.model.User;
import quizportal.quizportal.model.UserRole;
import quizportal.quizportal.model.Role;
import quizportal.quizportal.service.userService;

@SpringBootApplication
public class QuizportalApplication 
{	
	// @Autowired
	// private userService userService;
	public static void main(String[] args) {
		SpringApplication.run(QuizportalApplication.class, args);
	
	}
	/*
	@Override
	public void run(String... args) throws Exception {
		try{

		System.out.println("main code");

		User u=new User();
		
		u.setFirstName("firstname");
		u.setLastName("lastname");
		u.setUsername("username");
		u.setEmail("email@email.com");
		u.setPassword("password");
		u.setPhone("123645");
		u.setProfile("about");
		

		Role roles=new Role();

		
		roles.setRoleName("Admin");

		Set<UserRole> urole=new HashSet<>();

		UserRole userrole = new UserRole();

		userrole.setRole(roles);
		userrole.setUser(u);

		urole.add(userrole);

		User user1 = this.userService.createUser(u, urole);
		
		System.out.println(user1);
		
	}
	catch (UsernameNotFoundException e) {
		e.printStackTrace();
}*/
	}



