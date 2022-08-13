package quizportal.quizportal.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quizportal.quizportal.DAO.UserRepository;
import quizportal.quizportal.model.Role;
import quizportal.quizportal.model.User;
import quizportal.quizportal.model.UserRole;
import quizportal.quizportal.service.userService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")

public class mainController {

    @Autowired  
    private userService uservice;

    @Autowired
    private UserRepository userrepo; 

    @PostMapping("/")
    public User CreateUser(@RequestBody User user) throws Exception{

       Set<UserRole> uroles=new HashSet<>();
       
      
		Role roles=new Role();
        roles.setRoleId(44L);
		roles.setRoleName("Admin");
        // roles.setRolename("Nonadmin");


		UserRole userrole = new UserRole();

		userrole.setRole(roles);
		userrole.setUser(user);

		uroles.add(userrole);

		
        return this.uservice.createUser(user, uroles);
    }

    @GetMapping("/getall")
    public List<User> getbyuserId(User user){

        List<User> findAlluser = this.userrepo.findAll();
        return findAlluser;
        
    }

    @GetMapping("/getname/{username}")
    public User findbyuser(@PathVariable("username") String username){

        User findByUsername = this.userrepo.findByUsername(username);

        return findByUsername;
    }
    
    @DeleteMapping("/deleteId/{Id}")
    public void deleteuserById(@PathVariable("Id") Long Id) {
    	
		this.userrepo.deleteById(Id);

    }

    @PutMapping("/update/{Id}")
    public User updateById(@PathVariable("Id") Long Id){

        User userFind= this.userrepo.findById(Id).get();

       User userupdate= this.userrepo.save(userFind);
        
        return userupdate;
    }
    
}
