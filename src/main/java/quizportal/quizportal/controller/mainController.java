package quizportal.quizportal.controller;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import quizportal.quizportal.DAO.userloginrepo;
import quizportal.quizportal.model.role;
import quizportal.quizportal.model.userlogin;
import quizportal.quizportal.model.userrole;
import quizportal.quizportal.service.userService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class mainController {

    @Autowired  
    private userService uservice;

    @Autowired
    private userloginrepo userrepo; 


    @PostMapping("/")
    public userlogin CreateUser(@RequestBody userlogin user) throws Exception{

       Set<userrole> uroles=new HashSet<>();
       
      
		role roles=new role();
        
		roles.setRolename("Admin");
        // roles.setRolename("Nonadmin");


		userrole userrole = new userrole();

		userrole.setRole(roles);
		userrole.setUser(user);

		uroles.add(userrole);

		
        return this.uservice.createUser(user, uroles);
    }

    @GetMapping("/getall")
    public List<userlogin> getbyuserId(userlogin user){

        List<userlogin> findAlluser = this.userrepo.findAll();
        return findAlluser;
        
    }

    @GetMapping("/getname/{username}")
    public userlogin findbyuser(@PathVariable("username") String username){

        userlogin findByUsername = this.userrepo.findByUsername(username);

        return findByUsername;
    }
    
    @DeleteMapping("/deleteId/{Id}")
    public void deleteuserById(@PathVariable("Id") Long Id) {
    	
		this.userrepo.deleteById(Id);

    }

    @PutMapping("/update/{Id}")
    public userlogin updateById(@PathVariable("Id") Long Id){

        userlogin userFind= this.userrepo.findById(Id).get();

       userlogin userupdate= this.userrepo.save(userFind);
        
        return userupdate;
    }
    
}
