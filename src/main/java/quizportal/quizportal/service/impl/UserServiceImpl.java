package quizportal.quizportal.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import quizportal.quizportal.DAO.UserRepository;
import quizportal.quizportal.DAO.roleRepository;
import quizportal.quizportal.Helper.UserFoundException;
import quizportal.quizportal.model.User;
import quizportal.quizportal.model.UserRole;
import quizportal.quizportal.service.userService;

@Service
public class UserServiceImpl implements userService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private roleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {


        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException("User is already there !!"); 
        } else {
            //user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);

        }

        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }


}
