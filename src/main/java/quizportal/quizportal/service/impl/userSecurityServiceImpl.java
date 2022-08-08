package quizportal.quizportal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import quizportal.quizportal.DAO.userloginrepo;
import quizportal.quizportal.SecurityConfig.userdetails;
import quizportal.quizportal.model.role;
import quizportal.quizportal.model.userlogin;
import quizportal.quizportal.model.userrole;


public class userSecurityServiceImpl implements UserDetailsService
{   
    @Autowired
    private userloginrepo userRepo;

    // @Autowired
    // private userlogin ulogin;

    @Override
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
      userlogin user = this.userRepo.findByUsername(username);

            if (user == null) {
                System.out.println("No user found with current credentials!!");
                throw new UsernameNotFoundException("User not found with username: " + user);
            }
            return new userdetails(user);

             
        } 
 
    }
  
        /*userlogin Username = this.userRepo.findByUsername(username);

        if(Username==null){
            System.out.println("No user found with current credentials!!");

            throw new UsernameNotFoundException("No user found!!");
        }user
        return Username;*/
    

    

    



