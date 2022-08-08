package quizportal.quizportal;



// import java.util.*;
// import java.util.Set;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import quizportal.quizportal.model.role;
// import quizportal.quizportal.model.userlogin;
// import quizportal.quizportal.model.userrole;
// import quizportal.quizportal.service.userService;

@SpringBootApplication
public class QuizportalApplication 
{	
	// @Autowired
	// private userService userService;
	public static void main(String[] args) {
		SpringApplication.run(QuizportalApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
		
	// 	System.out.println("main code");

	// 	userlogin u=new userlogin();
	// 	ArrayList<String> sm=new ArrayList<String>();
	// 	sm.add("LinkedIn");
	// 	// sm.add("Facebook");
	// 	// sm.add("Twitter");
	// 	u.setId(001);
	// 	u.setFirstname("firstname");
	// 	u.setLastname("lastname");
	// 	u.setUsername("username");
	// 	u.setEmail("email@email.com");
	// 	u.setPassword("password");
	// 	u.setContact("123645");
	// 	u.setAbout("about");
	// 	u.setSmprofile(sm);

	// 	role roles=new role();

	// 	roles.setId(44);
	// 	roles.setRolename("Admin");

	// 	Set<userrole> urole=new HashSet<>();

	// 	userrole userrole = new userrole();

	// 	userrole.setRole(roles);
	// 	userrole.setUser(u);

	// 	urole.add(userrole);

	// 	userlogin user1 = this.userService.createUser(u, urole);
		
	// 	System.out.println(user1);
		
	// }

}
