package quizportal.quizportal.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quizportal.quizportal.DAO.roleRepo;
import quizportal.quizportal.DAO.userloginrepo;
import quizportal.quizportal.model.userlogin;
import quizportal.quizportal.model.userrole;
import quizportal.quizportal.service.userService;

@Service
public class userImpl implements userService
{   
    @Autowired
    private userloginrepo userRepo;

    @Autowired
    private roleRepo roleRepo;

    //Creating USer
    @Override
    public userlogin createUser(userlogin user, Set<userrole> userRoles) throws Exception {
        
        userlogin local=this.userRepo.findByUsername(user.getUsername());

        if(local !=null)
        {
            System.out.println("User already Exist!!");
            throw new Exception("User already Exists!!");
        }else{

            for (userrole ur:userRoles)
            {
                roleRepo.save(ur.getRole());
            }
            
            user.getUserroles().addAll(userRoles);
            local = this.userRepo.save(user);
        }

        return local;
    }
    
}
